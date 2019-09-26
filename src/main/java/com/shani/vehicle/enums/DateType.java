package com.shani.vehicle.enums;

public enum DateType {
	
	DAY("day"),
	HOUR("hour"),
	WEEK("week"),
	MONTH("month"),
	YEAR("year");
	
	private final String dateType;
	
	private DateType(String dateType) {
		this.dateType = dateType;
	}
	
	public String getDateType() {
		return dateType;
	}

}
