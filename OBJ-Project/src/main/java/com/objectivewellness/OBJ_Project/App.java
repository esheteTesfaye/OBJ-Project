package com.objectivewellness.OBJ_Project;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println(urlValidator2("https://www.omnihotels.com/hotels/washington-dc-shoreham"));

		verifyURLStatus("https://wild:grapes@stage-obj.nxtdtc.com/journal/posts/dangers-of-blue-light-and-screen-time");
		// urlValidator2("htts://www.omnihotels.com/hotels/washington-dc-shoreham");
	}

	public static boolean urlValidator2(String urlStr) {
		try {
			URL url = new URL(urlStr);
			return true;
		} catch (MalformedURLException e) {
			// the URL is not in a valid form
			System.out.println(e);
			return false;
		}
	}

	public static int verifyURLStatus(String urlString) {

		int status = 0;
		try {
			URL link = new URL(urlString);
			HttpURLConnection hConn = null;
			hConn = (HttpURLConnection) link.openConnection();
			hConn.setRequestMethod("GET");
			hConn.connect();
			status = hConn.getResponseCode();
			System.out.println(status);
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		return status;
	}
}
