package com.nagarro.sb.pojo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "CC_CURRENCY_RATES_MASTER")
public class CurrencyRates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "from_currency", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Currency fromCurrency;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_currency", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Currency toCurrency;
	
	private double rate;
}
