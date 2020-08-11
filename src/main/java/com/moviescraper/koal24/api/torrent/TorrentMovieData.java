package com.moviescraper.koal24.api.torrent;

public class TorrentMovieData {

	//josn projection no need for encapsulation
	
	public long id;
	public String name;
	public String info_hash;
	public int leechers;
	public int seeders;
	public int num_files;
	public long size;//bytes
	public String username;
	public int added;
	public String status;
	public int category;
	public String imdb;
	
}
