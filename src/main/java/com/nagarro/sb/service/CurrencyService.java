package com.nagarro.sb.service;

import java.util.Collection;

import com.nagarro.sb.pojo.Currency;

public interface CurrencyService {

	Collection<Currency> getAvailableCurrencies();
	
}
