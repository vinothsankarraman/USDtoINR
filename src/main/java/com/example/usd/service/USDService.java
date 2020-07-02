package com.example.usd.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class USDService {
	

	@Value("${url}")
	private String url;
	
	
	public String getINRfromUSD() {
		
		String inr=null;
		
		System.out.println("getting into service");
		
		System.out.println(url);
		
		RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(url, String.class);
		System.out.println(result);
		System.out.println("----------- Result printed -----------------");
		
		org.json.JSONObject object =  new org.json.JSONObject(result);
		System.out.println(object);
		
		System.out.println("----------- JSONOBJECT printed -----------------");
		org.json.JSONObject rates = object.getJSONObject("rates");
		System.out.println(rates);
		
		
		System.out.println("----------- Rates printed -----------------");
		
		double value = rates.getDouble("INR");
		
		System.out.println("----INR full value--- " + value);
		inr=String.format("%.2f", value);
		System.out.println("------Final INR Rate---- "+ inr);
		return inr;
	}

}
