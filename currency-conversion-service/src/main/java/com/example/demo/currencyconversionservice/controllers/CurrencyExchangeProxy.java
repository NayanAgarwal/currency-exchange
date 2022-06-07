package com.example.demo.currencyconversionservice.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.currencyconversionservice.entities.CurrencyConversion;

//@FeignClient(name="currency-exchange",url="localhost:8000")
@FeignClient(name="currency-exchange", url = "${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8000")
public interface CurrencyExchangeProxy {
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable(value="from",required=true) String fromCurrency,@PathVariable(value="to",required=true) String toCurrency);
	


}
