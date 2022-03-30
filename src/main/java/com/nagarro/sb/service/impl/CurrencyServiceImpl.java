package com.nagarro.sb.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.sb.dao.CurrencyRepository;
import com.nagarro.sb.pojo.Currency;
import com.nagarro.sb.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService {
	
	@Autowired
	private CurrencyRepository currencyRepository;

	@Override
	public Collection<Currency> getAvailableCurrencies() {
		return (Collection<Currency>) currencyRepository.findAll();
	}
	
	
}
