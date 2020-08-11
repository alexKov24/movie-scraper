package com.moviescraper.koal24.api.torrent.TPB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moviescraper.koal24.api.torrent.GenericTorrentInterface;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ControllerThePiratebay {

	GenericTorrentInterface tpb;
	Gson gson;
	
	@Autowired
	public void getTorrent(ThePirateBaysAPI tpb, Gson gson) {
		this.tpb = tpb;
	}
	
	@GetMapping()
	public String getMagnetLink(@RequestParam String encodedTitle) {
		return "Move It to Front Already";
	}
	
}
