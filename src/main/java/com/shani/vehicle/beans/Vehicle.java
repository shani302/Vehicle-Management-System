package com.shani.vehicle.beans;

import com.shani.vehicle.enums.EuroEmissionsStandard;
import com.shani.vehicle.enums.FuelType;
import com.shani.vehicle.enums.GearboxType;

public class Vehicle {
	
	private long vehicleId;
	private long licenseNumber;
	private String model;
	private String year;
	private int power;
	private int topSpeed;
	private int co2Emissions;
	private EuroEmissionsStandard euroEmissionsStandard;
	private float fuelConsumption;
	private FuelType fuelType;
	private int displacment;
	private GearboxType gearbox;
	private int height;
	private int length;
	private int wheelBase;
	
	// CTOR
	public Vehicle() {
	}

	// CTOR without id  (for testing)
	public Vehicle(long licenseNumber, String model, String year, int power, int topSpeed, int co2Emissions,
			EuroEmissionsStandard euroEmissionsStandard, float fuelConsumption, FuelType fuelType, int displacment,
			GearboxType gearbox, int height, int length, int wheelBase) {
		this.licenseNumber = licenseNumber;
		this.model = model;
		this.year = year;
		this.power = power;
		this.topSpeed = topSpeed;
		this.co2Emissions = co2Emissions;
		this.euroEmissionsStandard = euroEmissionsStandard;
		this.fuelConsumption = fuelConsumption;
		this.fuelType = fuelType;
		this.displacment = displacment;
		this.gearbox = gearbox;
		this.height = height;
		this.length = length;
		this.wheelBase = wheelBase;
	}
	
	// CTOR full  (for testing)
	public Vehicle(long vehicleId, long licenseNumber, String model, String year, int power, int topSpeed,
			int co2Emissions, EuroEmissionsStandard euroEmissionsStandard, float fuelConsumption, FuelType fuelType,
			int displacment, GearboxType gearbox, int height, int length, int wheelBase) {
		this.vehicleId = vehicleId;
		this.licenseNumber = licenseNumber;
		this.model = model;
		this.year = year;
		this.power = power;
		this.topSpeed = topSpeed;
		this.co2Emissions = co2Emissions;
		this.euroEmissionsStandard = euroEmissionsStandard;
		this.fuelConsumption = fuelConsumption;
		this.fuelType = fuelType;
		this.displacment = displacment;
		this.gearbox = gearbox;
		this.height = height;
		this.length = length;
		this.wheelBase = wheelBase;
	}

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public long getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(long licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}

	public int getCo2Emissions() {
		return co2Emissions;
	}

	public void setCo2Emissions(int co2Emissions) {
		this.co2Emissions = co2Emissions;
	}

	public EuroEmissionsStandard getEuroEmissionsStandard() {
		return euroEmissionsStandard;
	}

	public void setEuroEmissionsStandard(EuroEmissionsStandard euroEmissionsStandard) {
		this.euroEmissionsStandard = euroEmissionsStandard;
	}

	public float getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(float fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public int getDisplacment() {
		return displacment;
	}

	public void setDisplacment(int displacment) {
		this.displacment = displacment;
	}

	public GearboxType getGearbox() {
		return gearbox;
	}

	public void setGearbox(GearboxType gearbox) {
		this.gearbox = gearbox;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWheelBase() {
		return wheelBase;
	}

	public void setWheelBase(int wheelBase) {
		this.wheelBase = wheelBase;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", licenseNumber=" + licenseNumber + ", model=" + model + ", year="
				+ year + ", power=" + power + ", topSpeed=" + topSpeed + ", co2Emissions=" + co2Emissions
				+ ", euroEmissionsStandard=" + euroEmissionsStandard + ", fuelConsumption=" + fuelConsumption
				+ ", fuelType=" + fuelType + ", displacment=" + displacment + ", gearbox=" + gearbox + ", height="
				+ height + ", length=" + length + ", wheelBase=" + wheelBase + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
