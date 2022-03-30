package com.nagarro.sb.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.sb.dto.ConversionPayload;
import com.nagarro.sb.pojo.CurrencyRates;
import com.nagarro.sb.service.util.CacheManager;

@Service
public class RateConvertor {
	
	@Autowired
	private CacheManager cacheManager;
	
	public void convert(ConversionPayload data) throws RatesNotAvailableException {
		Optional<CurrencyRates> rate = cacheManager.findRates(data);
		
		if(rate.isEmpty()) {
			throw new RatesNotAvailableException("Rate not found for " + data.getFrom() + " to " + data.getTo());
		}
		
		rate.ifPresent(t -> {
			double convertedAmount = data.getAmount() * rate.get().getRate();
			data.setConvertedToAmount(convertedAmount);
		});
	}
}
