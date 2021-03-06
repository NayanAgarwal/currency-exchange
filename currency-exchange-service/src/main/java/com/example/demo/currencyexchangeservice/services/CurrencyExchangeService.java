package com.example.demo.currencyexchangeservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.currencyexchangeservice.entities.CurrencyExchange;
import com.example.demo.currencyexchangeservice.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository curRepo;
	
	public CurrencyExchange getByFromAndTo(String from,String to)
	{
		return curRepo.findByFromAndTo(from,to);
	}
}
