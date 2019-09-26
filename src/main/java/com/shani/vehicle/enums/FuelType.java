package com.shani.vehicle.enums;

public enum FuelType {
	
	LPG("LPG"),
	DIESEL("Diesel"),
	GASOLINE95("Gasoline95"),
	GASOLINE96("Gasoline96"),
	GASOLINE98("Gasoline98");
	
	private final String fuelType;
	
	private FuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getFuelType() {
		return fuelType;
	}
	
	
	

}
