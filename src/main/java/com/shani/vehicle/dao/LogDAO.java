package com.shani.vehicle.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shani.vehicle.beans.Log;
import com.shani.vehicle.beans.Vehicle;
import com.shani.vehicle.enums.ErrorType;
import com.shani.vehicle.exceptions.ApplicationException;
import com.shani.vehicle.model.QueryFactory;
import com.shani.vehicle.utils.DateUtils;
import com.shani.vehicle.utils.JdbcUtils;

@Repository
public class LogDAO implements ILogDAO {

	@Override
	public long createLog(Log log) throws ApplicationException {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = JdbcUtils.getConnection();
			String sql = "INSERT INTO logs (time_stamp, http_method, path, client_IP, vehicle_id) VALUES(?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			System.out.println(log.getTimeStamp());
			
			java.sql.Timestamp sqlTime=new java.sql.Timestamp(log.getTimeStamp().getTime());
	
			System.out.println(sqlTime);
			
			pstmt.setTimestamp(1, sqlTime);
			pstmt.setString(2, log.getHttpMethod());
			pstmt.setString(3, log.getPath());
			pstmt.setString(4, log.getClientIP());
			pstmt.setLong(5, log.getVehicleId());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (!rs.next()) {
				throw new ApplicationException(ErrorType.GENERAL_ERROR, DateUtils.getTimeStamp()
						+ " | Error in LogDAO.createLog | getGeneratedKeys of createLog failed");
			}
			long logId = rs.getLong(1);
			return logId;

		} catch (SQLException e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,
					DateUtils.getTimeStamp() + " | Error in LogDAO.createLog", e);
		} finally {
			JdbcUtils.closeResources(connection, pstmt, rs);
		}

	}

	@Override
	public List<Log> getAllLogs() throws ApplicationException {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = JdbcUtils.getConnection();
			String sql = "SELECT * FROM logs";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Log> logs = new ArrayList<>();
			while (rs.next()) {
				Log log = executeLog(rs);
				logs.add(log);
			}
			return logs;

		} catch (SQLException e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,
					DateUtils.getTimeStamp() + " | Error in LogDAO.getAllLogs");
		} finally {
			JdbcUtils.closeResources(connection, pstmt, rs);
		}
	}

	@Override
	public List<Log> getAllLogsByDate(String date) throws ApplicationException {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = JdbcUtils.getConnection();
			String sql = QueryFactory.getQuerydate(date);
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Log> logs = new ArrayList<>();
			while (rs.next()) {
				Log log = executeLog(rs);
				logs.add(log);
			}
			return logs;

		} catch (SQLException e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,
					DateUtils.getTimeStamp() + " | Error in LogDAO.getAllLogsByDate");
		} finally {
			JdbcUtils.closeResources(connection, pstmt, rs);
		}
	}

	@Override
	public List<Vehicle> getMostActiveVehicles() throws ApplicationException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = JdbcUtils.getConnection();
			String sql = "SELECT v1.* FROM vehicles v1 inner join (SELECT vehicle_id, COUNT(*) FROM logs WHERE vehicle_id > 0 GROUP BY vehicle_id ORDER BY 2 DESC LIMIT 3) v2 ON v1.vehicle_id = v2.vehicle_id";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Vehicle> vehicles = new ArrayList<>();
			while (rs.next()) {
				Vehicle vehicle = VehicleDAO.extractVehicle(rs);
				vehicles.add(vehicle);
			}
			return vehicles;

		} catch (SQLException e) {
			throw new ApplicationException(ErrorType.GENERAL_ERROR,
					DateUtils.getTimeStamp() + " | Error in LogDAO.getMostActiveVehicles");
		} finally {
			JdbcUtils.closeResources(connection, pstmt, rs);
		}
	}

	private Log executeLog(ResultSet rs) throws SQLException {
		Log log = new Log();
		log.setLogId(rs.getLong("log_id"));
		log.setTimeStamp(rs.getDate("time_stamp"));
		log.setHttpMethod(rs.getString("http_method"));
		log.setPath(rs.getString("path"));
		log.setClientIP(rs.getString("client_IP"));
		log.setVehicleId(rs.getLong("vehicle_id"));
		return log;
	}
}
