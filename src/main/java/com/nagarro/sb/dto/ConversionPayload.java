package com.nagarro.sb.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class ConversionPayload {

	@Pattern(regexp = "^[a-zA-Z]*$", message = "From currency is invalid")
	@NotBlank(message = "From currency is not defined")
	@NonNull
	private String from;
	
	@Pattern(regexp = "^[a-zA-Z]*$", message = "To currency is invalid")
	@NotBlank(message = "To currency is not defined")
	@NonNull
	private String to;
	
	private double amount;
	
	@Setter
	private double convertedToAmount;
	
	@Setter
	private String message;
	
}
