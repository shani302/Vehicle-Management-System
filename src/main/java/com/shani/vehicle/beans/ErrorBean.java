package com.shani.vehicle.beans;

public class ErrorBean {

	private int errorCode;
	private String internalErrorMessage;
	private String externalErrorMessage;

	
	// CTOR
	public ErrorBean() {
	}

	// CTOR for testing
	public ErrorBean(int errorCode, String internalErrorMessage, String externalErrorMessage) {
		this.errorCode = errorCode;
		this.internalErrorMessage = internalErrorMessage;
		this.externalErrorMessage = externalErrorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getInternalErrorMessage() {
		return internalErrorMessage;
	}

	public void setInternalErrorMessage(String internalErrorMessage) {
		this.internalErrorMessage = internalErrorMessage;
	}

	public String getExternalErrorMessage() {
		return externalErrorMessage;
	}

	public void setExternalErrorMessage(String externalErrorMessage) {
		this.externalErrorMessage = externalErrorMessage;
	}

	@Override
	public String toString() {
		return "ErrorBean [errorCode=" + errorCode + ", internalErrorMessage=" + internalErrorMessage
				+ ", externalErrorMessage=" + externalErrorMessage + "]";
	}

}