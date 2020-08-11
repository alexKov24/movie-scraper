package com.moviescraper.koal24.api.video.youtube;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import com.moviescraper.koal24.api.video.GenericVideoInterface;

@Component
public class YouTubeAPI implements GenericVideoInterface {

	private static final String url = "https://www.youtube.com/results?search_query=";
	
	@Override
	public List<String> getLinksByTitle(String title) {

		return Arrays.asList(
			cutDOM(
				getDOMFromTitle(title)
			).split("\"watchEndpoint\"")
		).stream().map(YouTubeAPI::cutId)
		.skip(1)
		.collect(Collectors.toList());
	}
	
	private static String cutId(String x) {
		return x.substring(13, 24);
	}
	
	private String cutDOM(String docString) {
		
		int start = docString.indexOf("window[\"ytInitialData\"]");
		int end = docString.indexOf("window[\"ytInitialPlayerResponse\"]");

		return docString.substring(start, end);
	}
	
	private String getDOMFromTitle(String title) {
		
		@SuppressWarnings("deprecation")
		Connection connection = Jsoup.connect(url+URLEncoder.encode(title));
		connection.userAgent("Mozilla");
		connection.timeout(5000);

		try {
			return connection.post().toString();
		} catch (IOException e) {
			connection.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36");
			connection.timeout(5000);
			try {
				return connection.post().toString();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

}
