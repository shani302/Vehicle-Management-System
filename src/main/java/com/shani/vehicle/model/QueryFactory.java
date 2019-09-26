package com.shani.vehicle.model;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.shani.vehicle.beans.VehicleFilters;
import com.shani.vehicle.enums.DateType;

@Component
public final class QueryFactory {

	private static HashMap<String, String> mapa;

	public QueryFactory() {
		mapa = new HashMap<>();
		mapa.put(DateType.HOUR.getDateType(),
				"SELECT * FROM Logs l WHERE l.time_stamp > DATE_ADD(CURDATE( ),INTERVAL -1 HOUR)");
		mapa.put(DateType.DAY.getDateType(),
				"SELECT * FROM Logs l WHERE l.time_stamp > DATE_ADD(CURDATE( ),INTERVAL -1 DAY)");
		mapa.put(DateType.WEEK.getDateType(),
				"SELECT * FROM Logs l WHERE l.time_stamp > DATE_ADD(CURDATE( ),INTERVAL -1 WEEK)");
		mapa.put(DateType.MONTH.getDateType(),
				"SELECT * FROM Logs l WHERE l.time_stamp > DATE_ADD(CURDATE( ),INTERVAL -1 MONTH)");
		mapa.put(DateType.YEAR.getDateType(),
				"SELECT * FROM Logs l WHERE l.time_stamp > DATE_ADD(CURDATE( ),INTERVAL -1 YEAR)");
	}

	public static String getQuerydate(String date) {

		if (mapa.containsKey(date) && mapa.get(date) != null) {
			return mapa.get(date);
		}
		return "error";
	}

	// Assumption
	// all filters have default values sent from client-side
	// for int/float/long -> -1
	// for String -> ""
	// for Enum -> null
	public static String getQueryfilter(VehicleFilters filters) {

		String sql = "SELECT * FROM vehicles WHERE ";
		if (filters.getVehicleId() > -1) {
			sql += "vehicle_id = " + filters.getVehicleId() + " AND ";
		}
		if (!filters.getModel().isEmpty()) {
			sql += "model LIKE '%" + filters.getModel() + "%' AND ";
		}
		if (!filters.getFromYear().isEmpty()) {
			sql += "year >= " + filters.getFromYear() + " AND ";
		}
		if (!filters.getUpToYear().isEmpty()) {
			sql += "year <= " + filters.getUpToYear() + " AND ";
		}
		if (filters.getFromPower() > -1) {
			sql += "power >= " + filters.getFromPower() + " AND ";
		}
		if (filters.getUpToPower() > -1) {
			sql += "power <= " + filters.getUpToPower() + " AND ";
		}
		if (filters.getFromTopSpeed() > -1) {
			sql += "power >= " + filters.getFromTopSpeed() + " AND ";
		}
		if (filters.getUpToTopSpeed() > -1) {
			sql += "power <= " + filters.getUpToTopSpeed() + " AND ";
		}
		if (filters.getFromCo2Emissions() > -1) {
			sql += "power >= " + filters.getFromCo2Emissions() + " AND ";
		}
		if (filters.getUpToCo2Emissions() > -1) {
			sql += "power <= " + filters.getUpToCo2Emissions() + " AND ";
		}
		if (filters.getEuroEmissionsStandard() != null) {
			sql += "euro_emissions_standard = '" + filters.getEuroEmissionsStandard() + "' AND ";
		}
		if (filters.getFromFuelConsumption() > -1) {
			sql += "power >= " + filters.getFromFuelConsumption() + " AND ";
		}
		if (filters.getUpToFuelConsumption() > -1) {
			sql += "power <= " + filters.getUpToFuelConsumption() + " AND ";
		}
		if (filters.getFuelType() != null) {
			sql += "euro_emissions_standard = '" + filters.getFuelType() + "' AND ";
		}
		if (filters.getFromDisplacment() > -1) {
			sql += "power >= " + filters.getFromDisplacment() + " AND ";
		}
		if (filters.getUpToDisplacment() > -1) {
			sql += "power <= " + filters.getUpToDisplacment() + " AND ";
		}
		if (filters.getGearbox() != null) {
			sql += "euro_emissions_standard = '" + filters.getGearbox() + "' AND ";
		}

		if (sql.endsWith(" AND ")) {
			sql = sql.substring(0, sql.length() - 5);
		}
		if (sql.endsWith(" WHERE ")) {
			sql = sql.substring(0, sql.length() - 7);
		}

		return sql;
	}

}
