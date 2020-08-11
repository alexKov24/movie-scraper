package com.moviescraper.koal24.api.torrent.TPB;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.moviescraper.koal24.api.torrent.GenericTorrentInterface;
import com.moviescraper.koal24.api.torrent.TorrentMovieData;

@Component
public class ThePirateBaysAPI implements GenericTorrentInterface {
	
	private static final String getJsonTorrents = "https://apibay.org/q.php?q=";
	//private static final String jsonAssignCategory = "&cat=";
	private static Gson gson = new Gson();
	
	@Override
	public List<TorrentMovieData> getListOfMovies(String name) {
		
		String url = getJsonTorrents+encode(name);
		String json = null;
		
		try {
			json = Jsoup.connect(url).ignoreContentType(true).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return gson.fromJson(json, new TypeToken<List<TorrentMovieData>>(){}.getType());
	}
	
	private String encode(String name) {
		try {
			name = URLEncoder.encode(name, "ASCII");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Encoding failed for string : "+name);
			e.printStackTrace();
		}
		return name.replace("+", "%20");
	}

	@Override
	public String getMagnetLink(TorrentMovieData movie) {
		return "magnet:?xt=urn:btih:"+ movie.info_hash + "&dn=" + encode(movie.name) + printTrackers();
	}
	
	private String printTrackers() {

		StringBuilder ending = new StringBuilder("&tr=");
		ending.append(encode("udp://tracker.coppersurfer.tk:6969/announce")+"&tr=");
		ending.append(encode("udp://9.rarbg.to:2920/announce")+"&tr=");
		ending.append(encode("udp://tracker.opentrackr.org:1337")+"&tr=");
		ending.append(encode("udp://tracker.internetwarriors.net:1337/announce")+"&tr=");
		ending.append(encode("udp://tracker.leechers-paradise.org:6969/announce")+"&tr=");
		ending.append(encode("udp://tracker.coppersurfer.tk:6969/announce")+"&tr=");
		ending.append(encode("udp://tracker.pirateparty.gr:6969/announce")+"&tr=");
		ending.append(encode("udp://tracker.cyberia.is:6969/announce"));
		
		return ending.toString();
	}

}
