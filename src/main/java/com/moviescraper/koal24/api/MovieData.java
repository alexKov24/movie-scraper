package com.moviescraper.koal24.api;

public class MovieData {
	
	public String title;
	public double score;
	public String imgUrl;
	public String youtubeId;
	public String magnetLink;
	
	public MovieData(String title, double score, String imgUrl) {
		super();
		this.title = title;
		this.score = score;
		this.imgUrl = imgUrl;
	}

	public MovieData() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return title + ", \n" + score + " / 5, \nimgUrl = " + imgUrl + ", \nyoutubeId = " + youtubeId
				+ ", \nmagnetLink = " + magnetLink+" \n=============================\n";
	}
	
	
	
	
}
