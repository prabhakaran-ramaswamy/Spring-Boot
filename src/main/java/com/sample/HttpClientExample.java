package com.sample;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import org.springframework.stereotype.Component;


@Component
public class HttpClientExample {

	private final String USER_AGENT = "Mozilla/5.0";
	
	// HTTP GET request
	public String sendGet(String getUrl) throws Exception {

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(getUrl);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);

		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + getUrl);
		System.out.println("Response Code : " + 
                       response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		return result.toString();

	}

	// HTTP POST request
	public void sendPost() throws Exception {

		String url = "http://www.bseindia.com/markets/equity/EQReports/StockPrcHistori.aspx";

		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("User-Agent", USER_AGENT);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("scripcode", "512289"));
		urlParameters.add(new BasicNameValuePair("flag", "sp"));
		urlParameters.add(new BasicNameValuePair("Submit", "G"));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("Response Code : " + 
                                    response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

			writeToFile(rd);
		}
	
	public void writeToFile(BufferedReader in)
	{
		try {
		
		    BufferedWriter bw = new BufferedWriter(new FileWriter(new File("test.csv")));
			String line=null;
			while ((line = in.readLine()) != null) {
				        bw.write(line);
						// must do this: .readLine() will have stripped line endings
						bw.newLine();
			}
			System.out.println("Done!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}