package com.shani.vehicle.enums;

public enum EuroEmissionsStandard {
	
	Euro1("Euro1"),
	Euro2("Euro2"),
	Euro3("Euro3"),
	Euro4("Euro4"),
	Euro5("Euro5"),
	Euro6("Euro6");
	
	private final String euroEmissionsStandard;

	private EuroEmissionsStandard(String euroEmissionsStandard) {
		this.euroEmissionsStandard = euroEmissionsStandard;
    }
   

	public String getEuroEmissionsStandard() {
		return euroEmissionsStandard;
	}
	

}
