package com.in28minutes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.request.CurrencyExchange;

public interface ExchangeRepository extends JpaRepository<CurrencyExchange, Long>{

	CurrencyExchange findByFromAndTo(String from, String to);

}
