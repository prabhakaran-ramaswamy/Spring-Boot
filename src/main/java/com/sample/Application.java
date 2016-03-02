package com.sample;

import java.util.Arrays;

import java.io.*;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args)  throws Exception{
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		HttpClientExample http = new HttpClientExample();
		http.sendPost();
		System.out.println("Testing 1 - Send Http GET request");
		//writeToFile("TestFile", http.sendGet("http://www.bseindia.com/markets/equity/EQReports/StockPrcHistori.aspx?scripcode=512289&flag=sp&Submit=G"));
		//writeToFile("TestFile", "http://www.bseindia.com/markets/equity/EQReports/StockPrcHistori.aspx?scripcode=512289&flag=sp&Submit=G");
		System.out.println("\nCompleted");

    }
}