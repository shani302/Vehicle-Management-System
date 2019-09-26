package com.shani.vehicle.utils;

import com.shani.vehicle.exceptions.ApplicationException;

public class Validation {

	
	// year contains 4 digits, between 1900-2099
	public static boolean isYearValid(String year) throws ApplicationException{
		String regex = "/(?:(?:19|20)[0-9]{2})/";
		return year.matches(regex);
	}
	// license number contains between 5 - 8 numbers
	public static boolean isLicenseNumberValid(long licenseNumber) throws ApplicationException{
		String licenseString = licenseNumber+"";
		String regex = "^[0-9]{5,8}$";
		return licenseString.matches(regex);
	}
	

}