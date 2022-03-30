package com.nagarro.sb.controller;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.sb.dto.ConversionPayload;
import com.nagarro.sb.pojo.Currency;
import com.nagarro.sb.pojo.CurrencyRates;
import com.nagarro.sb.service.util.CacheManager;
import com.nagarro.sb.util.RateConvertor;
import com.nagarro.sb.util.RatesNotAvailableException;

@RestController(value = "/")
public class CurrencyConverterController {

	@Autowired
	private CacheManager cacheManager;
	
	@Autowired
	private RateConvertor convertor;
	
	/**
	 * 
	 * @return List of available currencies
	 */
	@GetMapping(value = "/available-currencies")
	public ResponseEntity<Collection<Currency>> getCurrencies() {
		return ResponseEntity.of(Optional.of(cacheManager.getAvailableCurrencies()));
	}
	
	/**
	 * 
	 * @return List of available currencies
	 */
	@GetMapping(value = "/available-conversions")
	public ResponseEntity<Collection<CurrencyRates>> getAvailableConversion() {
		return ResponseEntity.of(Optional.of(cacheManager.getAvailableCurrencyRates()));
	}
	
	/**
	 * 
	 * @param input User inputs
	 * @return Payload with converted value or error message
	 * @throws RatesNotAvailableException When rate is not available in application
	 */
	@PostMapping(value = "/convert-currency")
	public ResponseEntity<ConversionPayload> convertCurrency(@Valid @RequestBody ConversionPayload input) throws RatesNotAvailableException {
		convertor.convert(input);
		return ResponseEntity.ok(input);
	}
	
}
