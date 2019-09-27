package com.shani.vehicle.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static Date getCurrentTime() {

		LocalDateTime localDateTime = LocalDateTime.now();
		return java.util.Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

	}


	public static String getTimeStamp() {

		Calendar cal = Calendar.getInstance();
		Date currentDateTime = cal.getTime();
		String timeStamp = formatDateAndTime(currentDateTime);
		return timeStamp;
	}

	public static String getFormatedCurrentDay() {

		Calendar cal = Calendar.getInstance();
		Date currentDay = cal.getTime();
		String formatedDate = formatDate(currentDay);
		return formatedDate;
	}

	public static String formatDate(Date date) {

		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		String formatedDate = myFormat.format(date);
		return formatedDate;

	}

	public static String formatDateAndTime(Date date) {

		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String formatedDate = myFormat.format(date);
		return formatedDate;

	}

}