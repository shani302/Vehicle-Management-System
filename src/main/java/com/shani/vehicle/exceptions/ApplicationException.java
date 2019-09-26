package com.shani.vehicle.exceptions;

import org.springframework.stereotype.Controller;

import com.shani.vehicle.enums.ErrorType;

@Controller
public class ApplicationException extends RuntimeException{
	
	private static final long serialVersionUID = 7738896125456521931L;
	
	private ErrorType errorType;

	public ApplicationException() {
	}

	public ApplicationException(ErrorType errorType, String message) {
		super(message);
		this.errorType = errorType;
	}

	public ApplicationException(ErrorType errorType, String message,  Exception e) {
		super(message, e);
		this.errorType = errorType;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

	
	

}
