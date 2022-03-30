package com.nagarro.sb.service;

import java.util.Collection;

import com.nagarro.sb.pojo.CurrencyRates;

public interface CurrencyRatesService {
	Collection<CurrencyRates> getAvailableConversionRates();
}
