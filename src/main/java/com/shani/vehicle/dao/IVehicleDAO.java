package com.shani.vehicle.dao;

import java.util.HashSet;
import java.util.List;

import com.shani.vehicle.beans.Vehicle;
import com.shani.vehicle.beans.VehicleFilters;
import com.shani.vehicle.exceptions.ApplicationException;

public interface IVehicleDAO {
	
	long createVehicle(Vehicle vehicle) throws ApplicationException;
	
	void updateVehicle(Vehicle vehicle) throws ApplicationException;
	
	void updateManyVehicles(HashSet<Vehicle> vehicles) throws ApplicationException;
	
	void deleteVehicle(long vehicleId) throws ApplicationException;
	
	void deleteManyVehicles(int[] vehiclesIds) throws ApplicationException;
	
	Vehicle getVehicle(long vehicleId) throws ApplicationException;
	
	List<Vehicle> getAllVehicles() throws ApplicationException;
	
	List<Vehicle> getAllVehiclesByFilters(VehicleFilters filters) throws ApplicationException;


}
