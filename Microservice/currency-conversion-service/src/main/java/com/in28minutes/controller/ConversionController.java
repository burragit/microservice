package com.in28minutes.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.entity.CurrencyConversion;
import com.in28minutes.feign.CurrencyExchangeProxy;

@RestController
public class ConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		CurrencyConversion conversion = proxy.retrieveExchnageValue(from, to);
		conversion.setQuantity(quantity);
		conversion.setTotalCalculatedAmount(quantity.multiply(conversion.getConversionMultiple()));
		return conversion;
	}

}
