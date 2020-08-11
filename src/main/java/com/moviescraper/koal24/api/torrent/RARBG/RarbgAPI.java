package com.moviescraper.koal24.api.torrent.RARBG;

import java.util.List;

import com.moviescraper.koal24.api.torrent.GenericTorrentInterface;
import com.moviescraper.koal24.api.torrent.TorrentMovieData;

public class RarbgAPI implements GenericTorrentInterface {

	//"/threat_defence.php?defence=2&sk="+value_sk+"&cid="+value_c+"&i="+value_i+"&ref_cookie="+ref_cookie+"&r=68981171"
	
	/*
	 load thread domain lvl 1
	 	- get cookie
		- get thread lvl 2 link
			 - get value_sk
			 - get value_c
			 - get value_i
			 - get ref_cookie
	 */
	@SuppressWarnings("unused")
	private static final String threatDomain = "https://rarbgproxy.org/threat_defence.php?defence=1";
	//<img src="/threat_captcha.php?cid=35137994_x3rt4_1916654544&r=29040757" lazyload="off" />
	@SuppressWarnings("unused")
	private static final String captchaSrc = "/threat_captcha.php?cid=";
	//<input type="text" name="solve_string" id="solve_string" value="" autocomplete="off" maxlength="5" placeholder="Enter Captcha" style="width:160px !important;" />
	@SuppressWarnings("unused")
	private static final String captchaInputSelector = "#solve_string";
	
	
	static {
		
	}
	
	
	@Override
	public List<TorrentMovieData> getListOfMovies(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMagnetLink(TorrentMovieData movie) {
		// TODO Auto-generated method stub
		return null;
	}

}
