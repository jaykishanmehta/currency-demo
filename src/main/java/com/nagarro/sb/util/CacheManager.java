package com.nagarro.sb.util;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.sb.pojo.Currency;
import com.nagarro.sb.service.CurrencyService;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class CacheManager {

	@Getter
	private Set<Currency> availableCurrencies;
	
	@Autowired
	private CurrencyService currencyService;
	
	@PostConstruct
	public void init() {
		availableCurrencies = new HashSet<>();
		
		currencyService.findAll().forEach(t -> {
			availableCurrencies.add(t);
		});
		
		log.info("Currencies loaded: {} ", availableCurrencies);
		
	}
	
}
