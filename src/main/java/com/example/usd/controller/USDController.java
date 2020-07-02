package com.example.usd.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usd.service.USDService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping(value="/usd")
@Api(value="USDtoINRConversion", description="Convert the Current day Dollar rate to INR")
public class USDController {
	
		
	@Autowired
	private USDService service;
	
	@GetMapping(value="/inr")
	public String getINRfromUSD() {
		System.out.println("getting into controller");
		
		String inr =  service.getINRfromUSD();				
		return "INR Rate Today: " + inr;
	}

}
