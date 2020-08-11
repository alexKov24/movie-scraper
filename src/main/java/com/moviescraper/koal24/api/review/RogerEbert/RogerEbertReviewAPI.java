package com.moviescraper.koal24.api.review.RogerEbert;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import com.moviescraper.koal24.api.MovieData;
import com.moviescraper.koal24.api.review.GenericReviewInterface;

@Component
public class RogerEbertReviewAPI implements GenericReviewInterface{

	private static final String domain = "https://www.rogerebert.com/";
	private static final String movieArraySelector  = "body > div > div:nth-child(2) > div > section > div > div > div > div";
	private static final String movieTitleSelector  = "div > a > figure > figcaption > h6";
	private static final String movieRatingSelector = "div > a > figure > figcaption > div > div > span > i";
	private static final String movieImageSelector  = "div > a > figure > img";
	
	@Override
	public List<MovieData> getBestRecentMovies() {
		
		List<Element> elements = getDocument().select(movieArraySelector);
		return elements.stream().map(RogerEbertReviewAPI::getMovieDataFromElement)
				.collect(Collectors.toList());

	}
	
	private Document getDocument() {
		Document doc = null;
		
		try {
			doc = Jsoup.connect(domain).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return doc;
		
	}
	
	private static MovieData getMovieDataFromElement(Element e) {
		return new MovieData(
				e.select(movieTitleSelector).text(),
				e.select(movieRatingSelector).stream().mapToDouble(RogerEbertReviewAPI::mapRatingToDouble).sum(),
				e.select(movieImageSelector).attr("src"));
		
	}
	
	private static Double mapRatingToDouble(Element rating) {
		switch (rating.attr("title")) {
			case "star-full": return 1.0;
			case"star-half": return 0.5;
			default: return 0.0;
		}
		
	}
	
	
	
}
