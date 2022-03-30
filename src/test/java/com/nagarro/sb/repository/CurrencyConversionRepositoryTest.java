package com.nagarro.sb.repository;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nagarro.sb.dao.CurrencyRatesRepository;
import com.nagarro.sb.dao.CurrencyRepository;
import com.nagarro.sb.pojo.Currency;
import com.nagarro.sb.pojo.CurrencyRates;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CurrencyConversionRepositoryTest {

  @Autowired 
  private CurrencyRepository currencyService;

  @Autowired
  private CurrencyRatesRepository currencyRatesService;
  
  @Test
  public void validateCurrencyServiceIsWorkingAsExpected(){
	  
	  Currency c = new Currency();
	  c.setCode("usd");
	  c.setName("Dollar");
	  
	  currencyService.save(c);
	  Assert.assertNotNull(c.getId());
	  
  }
  
  @Test
  public void validateCurrencyRateServiceIsWorkingAsExpected(){
	  
	  Collection<CurrencyRates> rates = (Collection<CurrencyRates>) currencyRatesService.findAll();
	  Assert.assertEquals(8, rates.size());
	  
  }
}