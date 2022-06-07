package com.microservices.limitsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitsservice.entities.Limits;
import com.microservices.limitsservice.services.Configuration;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration config;

	@GetMapping("/limits")
	public Limits retrieveLimits()
	{
		return new Limits(config.getMinimum(),config.getMaximum());
	}
	
}
