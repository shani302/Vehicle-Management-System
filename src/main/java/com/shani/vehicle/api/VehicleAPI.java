package com.shani.vehicle.api;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shani.vehicle.beans.Vehicle;
import com.shani.vehicle.beans.VehicleFilters;
import com.shani.vehicle.exceptions.ApplicationException;
import com.shani.vehicle.logic.VehicleController;

@RestController
@RequestMapping("/vehicles")
public class VehicleAPI {
	
	@Autowired
	private VehicleController vehicleController;
	
	
	@PostMapping
	public void createVehicle(@RequestBody Vehicle vehicle) throws ApplicationException{
		vehicleController.createVehicle(vehicle);
	}
	
	@PutMapping
	public void updateVehicle(@RequestBody Vehicle vehicle) throws ApplicationException{
		vehicleController.updateVehicle(vehicle);
	}
	
	@PutMapping
	@RequestMapping("/manyUpdates")
	public void updateManyVehicles(@RequestBody HashSet<Vehicle> vehicles) throws ApplicationException{
		vehicleController.updateManyVehicles(vehicles);
	}
	
	@DeleteMapping
	@RequestMapping(value = "/{vehicleId}", method = RequestMethod.DELETE)
	public void deleteVehicle(@PathVariable("vehicleId") long vehicleId) throws ApplicationException{
		vehicleController.deleteVehicle(vehicleId);
	}
	
	@DeleteMapping
	@RequestMapping("/manyDeletes/{vehiclesIds}")
	public void deleteManyVehicles(@PathVariable("vehiclesIds") int[] vehiclesIds) throws ApplicationException{
		vehicleController.deleteManyVehicles(vehiclesIds);
	}
	
	@GetMapping
	@RequestMapping(value = "/{vehicleId}", method = RequestMethod.GET)
	public Vehicle getVehicle(@PathVariable("vehicleId") long vehicleId) throws ApplicationException{
		return vehicleController.getVehicle(vehicleId);
	}
	
	@GetMapping
	public List<Vehicle> getAllVehicles() throws ApplicationException{
		return vehicleController.getAllVehicles();
	}
	
	@GetMapping
	@RequestMapping("/vehiclesFilters")
	public List<Vehicle> getAllVehiclesByFilters(@RequestBody VehicleFilters filters) throws ApplicationException{
		return vehicleController.getAllVehiclesByFilters(filters);
	}
	
	
	
	
	
	
	
	
	
	
	

}
