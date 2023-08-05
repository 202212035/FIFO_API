package com.http;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HttpApplication {

	public static void main(String[] args) throws IOException 
	{
		SpringApplication.run(HttpApplication.class, args);
		gtrqst gt = new gtrqst();
		String response = gt.getrqst();
		System.out.println("\n\t"+response+"\n\n");
		
//		String rspns = gt.getrqst("https://dummyjson.com/products");
//		System.out.println("\n\t"+rspns+"\n\n");
//		
		String responses = gt.getbody();
		System.out.println("\n\t "+responses);
		
		gt.postbody();
		
	}
}