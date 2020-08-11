package com.moviescraper.koal24.api.video.youtube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviescraper.koal24.api.video.GenericVideoInterface;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class YoutubeController {

	GenericVideoInterface yt;
	
	@Autowired
	public void getYT(YouTubeAPI yt) {
		this.yt = yt;
	}
	
	@GetMapping(value = "/youtube")
	public String getVideoID(@RequestParam String title) {
		return yt.getLinksByTitle(title).get(0);
	}
	
}
