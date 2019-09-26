package com.shani.vehicle.beans;

import java.util.Date;

public class Log {

	private long LogId;
	private Date timeStamp;
	private String httpMethod;
	private String path;
	private String clientIP;
	private long vehicleId;

	
	// CTOR
	public Log() {
	}

	// CTOR without id  (for testing)
	public Log(Date timeStamp, String httpMethod, String path, String clientIP, long vehicleId) {
		this.timeStamp = timeStamp;
		this.httpMethod = httpMethod;
		this.path = path;
		this.clientIP = clientIP;
		this.vehicleId = vehicleId;
	}

	// CTOR full  (for testing)
	public Log(long logId, Date timeStamp, String httpMethod, String path, String clientIP, long vehicleId) {
		LogId = logId;
		this.timeStamp = timeStamp;
		this.httpMethod = httpMethod;
		this.path = path;
		this.clientIP = clientIP;
		this.vehicleId = vehicleId;
	}

	public long getLogId() {
		return LogId;
	}

	public void setLogId(long logId) {
		LogId = logId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Override
	public String toString() {
		return "Log [LogId=" + LogId + ", timeStamp=" + timeStamp + ", httpMethod=" + httpMethod + ", path=" + path
				+ ", clientIP=" + clientIP + ", vehicleId=" + vehicleId + "]";
	}

}