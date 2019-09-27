package com.shani.vehicle.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shani.vehicle.beans.Log;
import com.shani.vehicle.beans.Vehicle;
import com.shani.vehicle.exceptions.ApplicationException;
import com.shani.vehicle.logic.LogController;

@RestController
@RequestMapping("/logs")
public class LogAPI {

	@Autowired
	private LogController logController;
	
	
	@GetMapping
	public List<Log> getAllLogs() throws ApplicationException {
		return logController.getAllLogs();
	}
	
	@GetMapping
	@RequestMapping("/byDate")
	public List<Log> getAllLogsByDate(@RequestParam("date") String date) throws ApplicationException {
		return logController.getAllLogsByDate(date);
	}
	
	@GetMapping
	@RequestMapping("/mostActive")
	public List<Vehicle> getMostActiveVehicles() throws ApplicationException {
		return logController.getMostActiveVehicles();
	}
}
