package com.example.demo.currencyexchangeservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.currencyexchangeservice.entities.CurrencyExchange;
import com.example.demo.currencyexchangeservice.services.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired 
	private CurrencyExchangeService curSvc;

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable(value="from",required=true) String fromCurrency,@PathVariable(value="to",required=true) String toCurrency)
	{
		logger.info("retrieveExchangeValue called with {} to {}",fromCurrency,toCurrency);
		//CurrencyExchange currencyExchange= new CurrencyExchange(1000L,fromCurrency,toCurrency,BigDecimal.valueOf(50));
		CurrencyExchange currencyExchange = curSvc.getByFromAndTo(fromCurrency, toCurrency);
		if(currencyExchange == null)
			throw new RuntimeException("Unable to find data from "+fromCurrency+" to "+toCurrency);
		String port = environment.getProperty("local.server.port");
		String hostname = environment.getProperty("HOSTNAME");
		String version="v1";
		currencyExchange.setEnvironment(port + " " + version+" "+hostname);
		return currencyExchange;
	}
}
