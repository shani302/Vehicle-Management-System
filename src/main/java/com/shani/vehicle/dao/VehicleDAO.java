package com.shani.vehicle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shani.vehicle.beans.Vehicle;
import com.shani.vehicle.beans.VehicleFilters;
import com.shani.vehicle.enums.ErrorType;
import com.shani.vehicle.enums.EuroEmissionsStandard;
import com.shani.vehicle.enums.FuelType;
import com.shani.vehicle.enums.GearboxType;
import com.shani.vehicle.exceptions.ApplicationException;
import com.shani.vehicle.model.QueryFactory;
import com.shani.vehicle.utils.DateUtils;
import com.shani.vehicle.utils.JdbcUtils;

@Repository
public class VehicleDAO implements IVehicleDAO {

	@Override
	public long createVehicle(Vehicle vehicle) throws ApplicationException {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = JdbcUtils.getConnection();
			String sql = "INSERT INTO vehicles (license_number, model, year, power, top_speed, co2_emissions, euro_emissions_standard, fuel_consumption, fuel_type, displacment, gearbox, height, length, wheel_base) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setLong(1, vehicle.getLicenseNumber());
			pstmt.setString(2, vehicle.getModel());
			pstmt.setString(3, vehicle.getYear());
			pstmt.setInt(4, vehicle.getPower());
			pstmt.setInt(5, vehicle.getTopSpeed());
			pstmt.setInt(6, vehicle.getCo2Emissions());
			if (vehicle.getEuroEmissionsStandard() != null) {
				pstmt.setString(7, vehicle.getEuroEmissionsStandard().toString());
			}
			pstmt.setString(7, null);
			pstmt.setFloat(8, vehicle.getFuelConsumption());
			if (vehicle.getFuelType() != null) {
				pstmt.setString(9, vehicle.getFuelType().toString());
			}
			pstmt.setString(9, null);
			pstmt.setInt(10, vehicle.getDisplacment());
			if (vehicle.getGearbox() != null) {
				pstmt.setString(11, vehicle.getGearbox().toString());
			}
			pstmt.setString(11, null);
			pstmt.setInt(12, vehicle.getHeight());
			pstmt.setInt(13, vehicle.getLength());
			pstmt.setInt(14, vehicle.getWheelBase());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (!rs.next()) {
				throw new ApplicationException(ErrorType.GENERAL_ERROR, DateUtils.getTimeStamp()
						+ " | Error in VehicleDAO.createVehicle | getGeneratedKeys of createVehicle failed");
			}
			long vehicleId = rs.getLong(1);
			return vehicleId;

		} catch (SQLException e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,
					DateUtils.getTimeStamp() + " | Error in VehicleDAO.createVehicle");
		} finally {
			JdbcUtils.closeResources(connection, pstmt, rs);
		}

	}

	@Override
	public void updateVehicle(Vehicle vehicle) throws ApplicationException {

		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = JdbcUtils.getConnection();
			String sql = "UPDATE vehicles SET license_number=?, model=?, year=?, power=?, top_speed=?, co2_emissions=?, euro_emissions_standard=?, fuel_consumption=?, fuel_type=?, displacment=?, gearbox=?, height=?, length=?, wheel_base=? WHERE vehicle_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, vehicle.getLicenseNumber());
			pstmt.setString(2, vehicle.getModel());
			pstmt.setString(3, vehicle.getYear());
			pstmt.setInt(4, vehicle.getPower());
			pstmt.setInt(5, vehicle.getTopSpeed());
			pstmt.setInt(6, vehicle.getCo2Emissions());
			pstmt.setString(7, vehicle.getEuroEmissionsStandard().toString());
			pstmt.setFloat(8, vehicle.getFuelConsumption());
			pstmt.setString(9, vehicle.getFuelType().toString());
			pstmt.setInt(10, vehicle.getDisplacment());
			pstmt.setString(11, vehicle.getGearbox().toString());
			pstmt.setInt(12, vehicle.getHeight());
			pstmt.setInt(13, vehicle.getLength());
			pstmt.setInt(14, vehicle.getWheelBase());
			pstmt.setLong(15, vehicle.getVehicleId());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,
					DateUtils.getTimeStamp() + " | Error in VehicleDAO.updateVehicle");
		} finally {
			JdbcUtils.closeResources(connection, pstmt);
		}
	}

	@Override
	public void updateManyVehicles(HashSet<Vehicle> vehicles) throws ApplicationException {

		Connection connection = null;
		PreparedStatement pstmt = null;
		Iterator<Vehicle> vehiclesIt = vehicles.iterator();

		try {
			connection = JdbcUtils.getConnection();
			String sql = "UPDATE vehicles SET license_number=?, model=?, year=?, power=?, top_speed=?, co2_emissions=?, euro_emissions_standard=?, fuel_consumption=?, fuel_type=?, displacment=?, gearbox=?, height=?, length=?, wheel_base=? WHERE vehicle_id=?";
			pstmt = connection.prepareStatement(sql);
			while (vehiclesIt.hasNext()) {
				Vehicle vehicle = (Vehicle) vehiclesIt.next();
				pstmt.setLong(1, vehicle.getLicenseNumber());
				pstmt.setString(2, vehicle.getModel());
				pstmt.setString(3, vehicle.getYear());
				pstmt.setInt(4, vehicle.getPower());
				pstmt.setInt(5, vehicle.getTopSpeed());
				pstmt.setInt(6, vehicle.getCo2Emissions());
				pstmt.setString(7, vehicle.getEuroEmissionsStandard().toString());
				pstmt.setFloat(8, vehicle.getFuelConsumption());
				pstmt.setString(9, vehicle.getFuelType().toString());
				pstmt.setInt(10, vehicle.getDisplacment());
				pstmt.setString(11, vehicle.getGearbox().toString());
				pstmt.setInt(12, vehicle.getHeight());
				pstmt.setInt(13, vehicle.getLength());
				pstmt.setInt(14, vehicle.getWheelBase());
				pstmt.setLong(15, vehicle.getVehicleId());
				pstmt.addBatch();
				vehiclesIt.remove();
			}
			pstmt.executeBatch();

		} catch (SQLException e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,
					DateUtils.getTimeStamp() + " | Error in VehicleDAO.updateManyVehicle");
		} finally {
			JdbcUtils.closeResources(connection, pstmt);
		}

	}

	@Override
	public void deleteVehicle(long vehicleId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = JdbcUtils.getConnection();
			String sql = "DELETE FROM vehicles WHERE vehicle_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, vehicleId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,
					DateUtils.getTimeStamp() + " | Error in VehicleDAO.deleteVehicle");
		} finally {
			JdbcUtils.closeResources(connection, pstmt);
		}

	}

	@Override
	public void deleteManyVehicles(int[] vehiclesIds) throws ApplicationException {

		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = JdbcUtils.getConnection();
			String sql = "DELETE FROM vehicles WHERE vehicle_id=?";
			pstmt = connection.prepareStatement(sql);
			for (int i = 0; i < vehiclesIds.length; i++) {
				pstmt.setLong(1, vehiclesIds[i]);
				pstmt.addBatch();
			}
			pstmt.executeBatch();

		} catch (SQLException e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,
					DateUtils.getTimeStamp() + " | Error in VehicleDAO.deleteManyVehicle");
		} finally {
			JdbcUtils.closeResources(connection, pstmt);
		}

	}

	@Override
	public Vehicle getVehicle(long vehicleId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = JdbcUtils.getConnection();
			String sql = "SELECT * FROM vehicles WHERE vehicle_id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, vehicleId);
			rs = pstmt.executeQuery();
			Vehicle vehicle = null;
			if (rs.next()) {
				vehicle = extractVehicle(rs);
			}
			return vehicle;

		} catch (SQLException e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,
					DateUtils.getTimeStamp() + " | Error in VehicleDAO.getVehicle");
		} finally {
			JdbcUtils.closeResources(connection, pstmt, rs);
		}
	}

	@Override
	public List<Vehicle> getAllVehicles() throws ApplicationException {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = JdbcUtils.getConnection();
			String sql = "SELECT * FROM vehicles";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Vehicle> vehicles = new ArrayList<>();
			while (rs.next()) {
				Vehicle vehicle = extractVehicle(rs);
				vehicles.add(vehicle);
			}
			return vehicles;

		} catch (SQLException e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,
					DateUtils.getTimeStamp() + " | Error in VehicleDAO.getAllVehicles");
		} finally {
			JdbcUtils.closeResources(connection, pstmt, rs);
		}
	}

	@Override
	public List<Vehicle> getAllVehiclesByFilters(VehicleFilters filters) throws ApplicationException {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = JdbcUtils.getConnection();
			String sql = QueryFactory.getQueryfilter(filters);
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Vehicle> vehicles = new ArrayList<>();
			while (rs.next()) {
				Vehicle vehicle = extractVehicle(rs);
				vehicles.add(vehicle);
			}
			return vehicles;

		} catch (SQLException e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,
					DateUtils.getTimeStamp() + " | Error in VehicleDAO.getAllVehiclesByFilters");
		} finally {
			JdbcUtils.closeResources(connection, pstmt, rs);
		}
	}
	
	public boolean isVehicleExistByLicenseNumber(long licenseNumber) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = JdbcUtils.getConnection();
			String sql = "SELECT license_number FROM vehicles WHERE license_number=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, licenseNumber);;
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;

		} catch (SQLException e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,
					DateUtils.getTimeStamp() + " | Error in VehicleDAO.isVehicleExistByLicenseNumber");
		} finally {
			JdbcUtils.closeResources(connection, pstmt, rs);
		}
	}

	public static Vehicle extractVehicle(ResultSet rs) throws SQLException {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(rs.getLong("vehicle_id"));
		vehicle.setLicenseNumber(rs.getLong("license_number"));
		vehicle.setModel(rs.getString("model"));
		vehicle.setYear(rs.getString("year"));
		vehicle.setPower(rs.getInt("power"));
		vehicle.setTopSpeed(rs.getInt("top_speed"));
		vehicle.setCo2Emissions(rs.getInt("co2_emissions"));
		if (rs.getString("euro_emissions_standard") != null) {
			vehicle.setEuroEmissionsStandard(EuroEmissionsStandard.valueOf(rs.getString("euro_emissions_standard")));
		}
		vehicle.setFuelConsumption(rs.getFloat("fuel_consumption"));
		if (rs.getString("fuel_type") != null) {
			vehicle.setFuelType(FuelType.valueOf(rs.getString("fuel_type")));
		}
		vehicle.setDisplacment(rs.getInt("displacment"));
		if (rs.getString("gearbox") != null) {
			vehicle.setGearbox(GearboxType.valueOf(rs.getString("gearbox")));
		}
		vehicle.setHeight(rs.getInt("height"));
		vehicle.setLength(rs.getInt("length"));
		vehicle.setWheelBase(rs.getInt("wheel_base"));
		return vehicle;
	}

}
