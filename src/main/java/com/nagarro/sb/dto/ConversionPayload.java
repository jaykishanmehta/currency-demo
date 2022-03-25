package com.nagarro.sb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class ConversionPayload {

	@NonNull
	private String from;
	@NonNull
	private String to;
	
	private double amount;
	
	@Setter
	private double convertedToAmount;
	
}
