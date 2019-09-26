package com.shani.vehicle.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shani.vehicle.beans.Log;
import com.shani.vehicle.beans.Vehicle;
import com.shani.vehicle.dao.LogDAO;
import com.shani.vehicle.exceptions.ApplicationException;

@Controller
public class LogController {
	
	@Autowired
	LogDAO logDAO;
	
	public void createLog(Log log) throws ApplicationException {
		long logId = logDAO.createLog(log);
		log.setLogId(logId);
	}
	
	public List<Log> getAllLogs() throws ApplicationException {
		return logDAO.getAllLogs();
	}
	
	public List<Log> getAllLogsByDate(String date) throws ApplicationException {
		return logDAO.getAllLogsByDate(date);
	}
	
	public List<Vehicle> getMostActiveVehicles() throws ApplicationException {
		return logDAO.getMostActiveVehicles();
	}

}
