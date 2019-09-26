package com.shani.vehicle.beans;

import com.shani.vehicle.enums.EuroEmissionsStandard;
import com.shani.vehicle.enums.FuelType;
import com.shani.vehicle.enums.GearboxType;

public class VehicleFilters {
	
	private long vehicleId;
	private long licenseNumber;
	private String model;
	private String fromYear;
	private String upToYear;
	private int fromPower;
	private int upToPower;
	private int fromTopSpeed;
	private int upToTopSpeed;
	private int fromCo2Emissions;
	private int upToCo2Emissions;
	private EuroEmissionsStandard euroEmissionsStandard;
	private float fromFuelConsumption;
	private float upToFuelConsumption;
	private FuelType fuelType;
	private int fromDisplacment;
	private int upToDisplacment;
	private GearboxType gearbox;
	

	// CTOR
	public VehicleFilters() {
	}

	// CTOR full (for testing)
	public VehicleFilters(long vehicleId, long licenseNumber, String model, String fromYear, String upToYear, int fromPower,
			int upToPower, int fromTopSpeed, int upToTopSpeed, int fromCo2Emissions, int upToCo2Emissions,
			EuroEmissionsStandard euroEmissionsStandard, float fromFuelConsumption, float upToFuelConsumption,
			FuelType fuelType, int fromDisplacment, int upToDisplacment, GearboxType gearbox) {
		this.vehicleId = vehicleId;
		this.licenseNumber = licenseNumber;
		this.model = model;
		this.fromYear = fromYear;
		this.upToYear = upToYear;
		this.fromPower = fromPower;
		this.upToPower = upToPower;
		this.fromTopSpeed = fromTopSpeed;
		this.upToTopSpeed = upToTopSpeed;
		this.fromCo2Emissions = fromCo2Emissions;
		this.upToCo2Emissions = upToCo2Emissions;
		this.euroEmissionsStandard = euroEmissionsStandard;
		this.fromFuelConsumption = fromFuelConsumption;
		this.upToFuelConsumption = upToFuelConsumption;
		this.fuelType = fuelType;
		this.fromDisplacment = fromDisplacment;
		this.upToDisplacment = upToDisplacment;
		this.gearbox = gearbox;
	}


	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}


	public void setLicenseNumber(long licenseNumber) {
		this.licenseNumber = licenseNumber;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public void setFromYear(String fromYear) {
		this.fromYear = fromYear;
	}


	public void setUpToYear(String upToYear) {
		this.upToYear = upToYear;
	}


	public void setFromPower(int fromPower) {
		this.fromPower = fromPower;
	}


	public void setUpToPower(int upToPower) {
		this.upToPower = upToPower;
	}


	public void setFromTopSpeed(int fromTopSpeed) {
		this.fromTopSpeed = fromTopSpeed;
	}


	public void setUpToTopSpeed(int upToTopSpeed) {
		this.upToTopSpeed = upToTopSpeed;
	}


	public void setFromCo2Emissions(int fromCo2Emissions) {
		this.fromCo2Emissions = fromCo2Emissions;
	}


	public void setUpToCo2Emissions(int upToCo2Emissions) {
		this.upToCo2Emissions = upToCo2Emissions;
	}


	public void setEuroEmissionsStandard(EuroEmissionsStandard euroEmissionsStandard) {
		this.euroEmissionsStandard = euroEmissionsStandard;
	}


	public void setFromFuelConsumption(float fromFuelConsumption) {
		this.fromFuelConsumption = fromFuelConsumption;
	}


	public void setUpToFuelConsumption(float upToFuelConsumption) {
		this.upToFuelConsumption = upToFuelConsumption;
	}


	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}


	public void setFromDisplacment(int fromDisplacment) {
		this.fromDisplacment = fromDisplacment;
	}


	public void setUpToDisplacment(int upToDisplacment) {
		this.upToDisplacment = upToDisplacment;
	}


	public void setGearbox(GearboxType gearbox) {
		this.gearbox = gearbox;
	}


	public long getVehicleId() {
		return vehicleId;
	}


	public long getLicenseNumber() {
		return licenseNumber;
	}


	public String getModel() {
		return model;
	}


	public String getFromYear() {
		return fromYear;
	}


	public String getUpToYear() {
		return upToYear;
	}


	public int getFromPower() {
		return fromPower;
	}


	public int getUpToPower() {
		return upToPower;
	}


	public int getFromTopSpeed() {
		return fromTopSpeed;
	}


	public int getUpToTopSpeed() {
		return upToTopSpeed;
	}


	public int getFromCo2Emissions() {
		return fromCo2Emissions;
	}


	public int getUpToCo2Emissions() {
		return upToCo2Emissions;
	}


	public EuroEmissionsStandard getEuroEmissionsStandard() {
		return euroEmissionsStandard;
	}


	public float getFromFuelConsumption() {
		return fromFuelConsumption;
	}


	public float getUpToFuelConsumption() {
		return upToFuelConsumption;
	}


	public FuelType getFuelType() {
		return fuelType;
	}


	public int getFromDisplacment() {
		return fromDisplacment;
	}


	public int getUpToDisplacment() {
		return upToDisplacment;
	}


	public GearboxType getGearbox() {
		return gearbox;
	}
	
	

	
	
}
