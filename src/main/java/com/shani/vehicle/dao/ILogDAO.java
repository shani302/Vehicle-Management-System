package com.shani.vehicle.dao;

import java.util.List;

import com.shani.vehicle.beans.Log;
import com.shani.vehicle.beans.Vehicle;
import com.shani.vehicle.exceptions.ApplicationException;

public interface ILogDAO {
	
	long createLog(Log log) throws ApplicationException;
	
	List<Log> getAllLogs() throws ApplicationException;
	
	List<Log> getAllLogsByDate(String date) throws ApplicationException;
	
	List<Vehicle> getMostActiveVehicles() throws ApplicationException;

}
