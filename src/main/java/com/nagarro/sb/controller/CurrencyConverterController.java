package com.nagarro.sb.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.sb.dto.ConversionPayload;
import com.nagarro.sb.pojo.Currency;
import com.nagarro.sb.util.CacheManager;

@RestController(value = "/")
public class CurrencyConverterController {

	@Autowired
	private CacheManager cacheManager;
	
	/**
	 * 
	 * @return List of available currencies
	 */
	@GetMapping(value = "/available-currencies")
	public ResponseEntity<Set<Currency>> getCurrencies() {
		return ResponseEntity.of(Optional.of(cacheManager.getAvailableCurrencies()));
	}
	
	@PostMapping(value = "/convert-currency")
	public ResponseEntity<ConversionPayload> convertCurrency(@RequestBody ConversionPayload input) {
		input.setConvertedToAmount(50d);
		return ResponseEntity.of(Optional.of(input));
	}
}
