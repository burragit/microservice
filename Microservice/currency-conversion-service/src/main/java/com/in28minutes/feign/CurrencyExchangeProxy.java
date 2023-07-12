package com.in28minutes.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.entity.CurrencyConversion;



@FeignClient(name="CURRENCY-EXCHANGE",url="localhost:8000")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchnage/from/{from}/to/{to}")
	public  CurrencyConversion retrieveExchnageValue(@PathVariable String from, @PathVariable String to);
		
		
}
