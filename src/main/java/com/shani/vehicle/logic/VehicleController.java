package com.shani.vehicle.logic;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shani.vehicle.beans.Vehicle;
import com.shani.vehicle.beans.VehicleFilters;
import com.shani.vehicle.dao.VehicleDAO;
import com.shani.vehicle.enums.ErrorType;
import com.shani.vehicle.exceptions.ApplicationException;
import com.shani.vehicle.utils.DateUtils;
import com.shani.vehicle.utils.Validation;

@Controller
public class VehicleController {

	@Autowired
	VehicleDAO vehicleDAO;

	public void createVehicle(Vehicle vehicle) throws ApplicationException{
		if (isVehicleExistByLicenseNumber(vehicle.getLicenseNumber())) {
			throw new ApplicationException(ErrorType.LICENSE_NUMBER_ALREADY_EXISTS, DateUtils.getTimeStamp()
					+ " | Error in VehicleController.createVehicle | The vehicle license number is already in exist");
		}
		validateVehicle(vehicle);
		long vehicleId = vehicleDAO.createVehicle(vehicle);
		vehicle.setVehicleId(vehicleId);
	}
	
	public void updateVehicle(Vehicle vehicle) throws ApplicationException{
		Long origionLicenseNumber = getVehicle(vehicle.getVehicleId()).getLicenseNumber();
		Long thisLicenseNumber = vehicle.getLicenseNumber();
		if(thisLicenseNumber.equals(origionLicenseNumber)) {
			if(isVehicleExistByLicenseNumber(thisLicenseNumber)) {
				throw new ApplicationException(ErrorType.LICENSE_NUMBER_ALREADY_EXISTS, DateUtils.getTimeStamp()
						+ " | Error in VehicleController.updateVehicle | The vehicle license number is already in exist");
			}
		}
		validateVehicle(vehicle);
		vehicleDAO.updateVehicle(vehicle);
	}
	
	public void updateManyVehicles(HashSet<Vehicle> vehicles) throws ApplicationException{
		for (Vehicle vehicle : vehicles) {
			Long origionLicenseNumber = getVehicle(vehicle.getVehicleId()).getLicenseNumber();
			Long thisLicenseNumber = vehicle.getLicenseNumber();
			if(thisLicenseNumber.equals(origionLicenseNumber)) {
				if(isVehicleExistByLicenseNumber(thisLicenseNumber)) {
					throw new ApplicationException(ErrorType.LICENSE_NUMBER_ALREADY_EXISTS, DateUtils.getTimeStamp()
							+ " | Error in VehicleController.updateManyVehicles | The vehicle license number is already in exist");
				}
			}
			validateVehicle(vehicle);
		}
		vehicleDAO.updateManyVehicles(vehicles);
	}
	
	public void deleteVehicle(long vehicleId) throws ApplicationException{
		vehicleDAO.deleteVehicle(vehicleId);
	}
	
	public void deleteManyVehicles(int[] vehiclesIds) throws ApplicationException{
		vehicleDAO.deleteManyVehicles(vehiclesIds);
	}
	
	public Vehicle getVehicle(long vehicleId) throws ApplicationException{
		return vehicleDAO.getVehicle(vehicleId);
	}

	public List<Vehicle> getAllVehicles() throws ApplicationException{
		return vehicleDAO.getAllVehicles();
	}
	
	public List<Vehicle> getAllVehiclesByFilters(VehicleFilters filters) throws ApplicationException{
		return vehicleDAO.getAllVehiclesByFilters(filters);
	}
	
	public boolean isVehicleExistByLicenseNumber(long licenseNumber) throws ApplicationException{
		return vehicleDAO.isVehicleExistByLicenseNumber(licenseNumber);
	}

	private void validateVehicle(Vehicle vehicle) throws ApplicationException{

		if (vehicle == null) {
			throw new ApplicationException(ErrorType.MUST_ENTER_VALUES, DateUtils.getTimeStamp()
					+ "| Error in VehicleController.validateVehicle | values must be entered for vehicle");
		}
		if(vehicle.getLicenseNumber() > 0) {
			throw new ApplicationException(ErrorType.MUST_ENTER_LICENSE_NUMBER, DateUtils.getTimeStamp()
			+ "| Error in VehicleController.validateVehicle | the vehicle license number is null");
		}
		if(Validation.isLicenseNumberValid(vehicle.getLicenseNumber())) {
			throw new ApplicationException(ErrorType.INVALID_LICENSE_NUMBER, DateUtils.getTimeStamp()
			+ "| Error in VehicleController.validateVehicle | the vehicle license number is invalid");
		}
		if(vehicle.getModel() == null) {
			throw new ApplicationException(ErrorType.MUST_ENTER_MODEL, DateUtils.getTimeStamp()
			+ "| Error in VehicleController.validateVehicle | the vehicle model is null");
		}
		if(vehicle.getModel().isEmpty()) {
			throw new ApplicationException(ErrorType.MUST_ENTER_MODEL, DateUtils.getTimeStamp()
			+ "| Error in VehicleController.validateVehicle | the vehicle model is null");
		}
		if(vehicle.getYear() == null) {
			throw new ApplicationException(ErrorType.MUST_ENTER_YEAR, DateUtils.getTimeStamp()
			+ "| Error in VehicleController.validateVehicle | the vehicle year is null");
		}
		if(vehicle.getYear().isEmpty()) {
			throw new ApplicationException(ErrorType.MUST_ENTER_YEAR, DateUtils.getTimeStamp()
			+ "| Error in VehicleController.validateVehicle | the vehicle year is null");
		}
		if(Validation.isYearValid(vehicle.getYear())) {
			throw new ApplicationException(ErrorType.INVALID_YEAR, DateUtils.getTimeStamp()
			+ "| Error in VehicleController.validateVehicle | the vehicle year is invalid");
		}
	

	}

}
