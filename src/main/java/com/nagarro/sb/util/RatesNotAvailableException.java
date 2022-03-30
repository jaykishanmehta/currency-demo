package com.nagarro.sb.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RatesNotAvailableException extends Exception {

	public RatesNotAvailableException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 7063296666664983964L;

}
