package com.nagarro.sb.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.sb.dao.CurrencyRatesRepository;
import com.nagarro.sb.pojo.CurrencyRates;
import com.nagarro.sb.service.CurrencyRatesService;

@Service
public class CurrencyRatesServiceImpl implements CurrencyRatesService {

	@Autowired
	private CurrencyRatesRepository currencyRatesRepository;
	
	
	@Override
	public Collection<CurrencyRates> getAvailableConversionRates() {
		return (Collection<CurrencyRates>) currencyRatesRepository.findAll();
	}

}
