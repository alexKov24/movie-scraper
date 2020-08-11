package com.moviescraper.koal24.api.torrent;

import java.util.List;

public interface GenericTorrentInterface {
	
	public List<TorrentMovieData> getListOfMovies(String name);
	public String getMagnetLink(TorrentMovieData movie);
	
}
