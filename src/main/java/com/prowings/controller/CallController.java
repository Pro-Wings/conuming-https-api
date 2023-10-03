package com.prowings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/consume")
	public String consumeAnotherApi() {
		
		System.out.println("request received to trigger https api...");

		String response = restTemplate.getForObject("https://localhost:8080/hello", String.class);

		System.out.println("response received from https api..." + response);
		return response;
	}

}
