package com.moviescraper.koal24;

import java.util.Date;
import java.util.List;

import com.moviescraper.koal24.api.MovieData;
import com.moviescraper.koal24.api.review.RogerEbert.RogerEbertReviewAPI;
import com.moviescraper.koal24.api.torrent.GenericTorrentInterface;
import com.moviescraper.koal24.api.torrent.TorrentMovieData;
import com.moviescraper.koal24.api.torrent.TPB.ThePirateBaysAPI;
import com.moviescraper.koal24.api.video.GenericVideoInterface;
import com.moviescraper.koal24.api.video.youtube.YouTubeAPI;

public class Test {
	
	static long ytTime = 0;
	static long tpbTime = 0;
	static long rgtime = 0;
	
	static int count = 0;
	
	public static void work() {
		
		RogerEbertReviewAPI re = new RogerEbertReviewAPI();
		YouTubeAPI yt = new YouTubeAPI();
		ThePirateBaysAPI tpb = new ThePirateBaysAPI();
		
		Date d = new Date();
		List<MovieData> movies = re.getBestRecentMovies();
		rgtime = new Date().getTime() - d.getTime();
		
		movies.stream().map(x -> completeData(x,tpb,yt)).forEach(System.out::println);
		
		System.out.println("done");
		System.out.println("Youtube     = "+ytTime+" | "+ytTime/count);
		System.out.println("Pirate Bays = "+tpbTime+" | "+tpbTime/count);
		System.out.println("Review      = "+rgtime+" | "+rgtime/count);

	}
	
	public static MovieData completeData(MovieData md, GenericTorrentInterface torrent, GenericVideoInterface video) {
		++count;
		Date d = new Date();
		md.youtubeId = video.getLinksByTitle(md.title).get(0);
		ytTime += new Date().getTime() - d.getTime();
		
		d = new Date();
		TorrentMovieData torrentData = torrent.getListOfMovies(md.title).get(0);
		md.magnetLink = torrent.getMagnetLink(torrentData);
		tpbTime += new Date().getTime() - d.getTime();
		return md;
	}
	
}
