package com.in28minutes.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.dao.ExchangeRepository;
import com.in28minutes.request.CurrencyExchange;

@RestController
public class ConcurrencyExchangeController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeRepository exchnageRepo;
	
	@GetMapping("/currency-exchnage/from/{from}/to/{to}")
	public  CurrencyExchange retrieveExchnageValue(@PathVariable String from, @PathVariable String to) {
		
		CurrencyExchange exchange =exchnageRepo.findByFromAndTo(from,to);
		//CurrencyExchange exchange = new CurrencyExchange(1000L,from,to,BigDecimal.valueOf(50));
		exchange.setEnvironment(env.getProperty("local.server.port"));
		return exchange;
		
	}

}
