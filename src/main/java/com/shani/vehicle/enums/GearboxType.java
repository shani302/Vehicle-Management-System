package com.shani.vehicle.enums;

public enum GearboxType {
	
	MANUAL("MANUAL"),
	AUTOMATIC("AUTOMATIC"),
	SEMI_AUTOMATIC("SEMI AUTOMATIC");
	
	private final String gearbox;
	
	private GearboxType(String gearbox) {
		this.gearbox = gearbox;
	}

	public String getGearbox() {
		return gearbox;
	}
	
	
	

}
