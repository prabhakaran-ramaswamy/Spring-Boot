package com.sample;

import java.util.Arrays;

import java.io.*;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application {

	 @Autowired
	 JdbcTemplate  jdbcTemplate;
	 
    public static void main(String[] args)  throws Exception{
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
		InputStream input = new URL("http://real-chart.finance.yahoo.com/table.csv?s=ATLASCYCLE.NS&a=00&b=5&c=2000&d=02&e=10&f=2016&g=d&ignore=.csv").openStream();
		
		 BufferedReader bReader = new BufferedReader(new InputStreamReader(input));
         StringBuffer sbfFileContents = new StringBuffer();
         String line = null;
        
         //read file line by line
         while( (line = bReader.readLine()) != null){
                 sbfFileContents.append(line);
                 sbfFileContents.append(System.getProperty("line.separator"));
         }
        
		 FileWriter writer = new FileWriter("sample.csv");
		 writer.write(sbfFileContents.toString());
		//HttpClientExample http = new HttpClientExample();
		//http.sendPost();
		//System.out.println("Testing 1 - Send Http GET request");
		//writeToFile("TestFile", http.sendGet("http://www.bseindia.com/markets/equity/EQReports/StockPrcHistori.aspx?scripcode=512289&flag=sp&Submit=G"));
		//writeToFile("TestFile", "http://www.bseindia.com/markets/equity/EQReports/StockPrcHistori.aspx?scripcode=512289&flag=sp&Submit=G");
		System.out.println("\nCompleted");

    }
}