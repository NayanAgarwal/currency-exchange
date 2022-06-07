package com.example.demo.currencyexchangeservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.currencyexchangeservice.entities.CurrencyExchange;

public interface CurrencyExchangeRepository extends CrudRepository<CurrencyExchange,Long> {
	
	CurrencyExchange findByFromAndTo(String from,String to);

}
