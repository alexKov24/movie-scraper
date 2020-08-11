package com.moviescraper.koal24.api.review.RogerEbert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moviescraper.koal24.api.review.GenericReviewInterface;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ControllerRogerEbert {
	
	
	GenericReviewInterface roger;
	Gson gson;
	
	@Autowired
	public void getReviewer(RogerEbertReviewAPI roger, Gson gson) {
		this.roger = roger;
		this.gson = gson;
	}
	
	@GetMapping(value = "/")
	public String getMovieArray() {
		return gson.toJson(roger.getBestRecentMovies());
	}
	
}
