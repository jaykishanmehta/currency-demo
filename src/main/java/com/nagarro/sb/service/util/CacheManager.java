package com.nagarro.sb.service.util;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.sb.dto.ConversionPayload;
import com.nagarro.sb.pojo.Currency;
import com.nagarro.sb.pojo.CurrencyRates;
import com.nagarro.sb.service.CurrencyRatesService;
import com.nagarro.sb.service.CurrencyService;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CacheManager {

	@Getter
	private Collection<Currency> availableCurrencies;
	
	@Getter
	private Collection<CurrencyRates> availableCurrencyRates;
	
	@Autowired
	private CurrencyService currencyService;
	
	@Autowired
	private CurrencyRatesService currencyRatesService;
	
	@PostConstruct
	public void init() {
		availableCurrencies = currencyService.getAvailableCurrencies();
		
//		currencyService.getAvailableCurrencies().forEach(t -> {
//			availableCurrencies.add(t);
//		});
		
		log.info("Currencies loaded: {} ", availableCurrencies);
		
		availableCurrencyRates = currencyRatesService.getAvailableConversionRates();
		
//		currencyRatesService.findAll().forEach(t -> {
//			availableCurrencyRates.add(t);
//		});
		
		log.info("Available conversions: {}", availableCurrencyRates);
		
		log.info("Loaded currencies {} and available rates {}", availableCurrencies.size(), availableCurrencyRates.size());
		
	}

	/**
	 * Finds available rate from the cached data
	 * 
	 * @param data contains from and to field
	 * @return
	 */
	public Optional<CurrencyRates> findRates(ConversionPayload data) {
		return availableCurrencyRates.stream().filter(t-> t.getFromCurrency().getCode().equals(data.getFrom()) && t.getToCurrency().getCode().equals(data.getTo())).findAny();
	}
	
}
