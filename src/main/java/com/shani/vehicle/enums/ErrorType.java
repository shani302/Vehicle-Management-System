package com.shani.vehicle.enums;

public enum ErrorType {
	
	GENERAL_ERROR(601, "GENERAL_ERROR", "General Error", true),
	MUST_ENTER_VALUES(602, "MUST_ENTER_VALUES", "must enter values", false),
	MUST_ENTER_LICENSE_NUMBER(603, "MUST_ENTER_LICENSE_NUMBER", "the license number is null or empty", false),
	MUST_ENTER_MODEL(604, "MUST_ENTER_MODEL","the model is null or empty", false),
	MUST_ENTER_YEAR(605, "MUST_ENTER_YEAR","the year is null or empty", false),
	INVALID_LICENSE_NUMBER(606, "INVALID_LICENSE_NUMBER","the license number is invalid", false),
	INVALID_YEAR(607, "INVALID_YEAR","the year is invalid", false),
	LICENSE_NUMBER_ALREADY_EXISTS(608, "LICENSE_NUMBER_ALREADY_EXISTS","the license numbere is already exist", false);
	
	private int errorCode;
	private String errorType;
	private String errorMessage;
	private boolean isCritcal;

	
	private ErrorType(int errorCode, String errorType, String errorMessage, boolean isCritcal) {
		this.errorCode = errorCode;
		this.errorType = errorType;
		this.errorMessage = errorMessage;
		this.isCritcal = isCritcal;
	}
	

	private ErrorType(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}


	public int getErrorCode() {
		return errorCode;
	}


	public String getErrorType() {
		return errorType;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public boolean isCritcal() {
		return isCritcal;
	}
	
	
	

	

}
