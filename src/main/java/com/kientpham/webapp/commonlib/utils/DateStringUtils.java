package com.kientpham.webapp.commonlib.utils;

import java.text.SimpleDateFormat;import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateStringUtils {

	public static final String DISPLAY_DATE_PATTERN="dd MMM yyyy";

	public static String convertDateToString(Date date, String outputPattern) {
		return (new SimpleDateFormat(outputPattern)).format(date);
	}

	public static String getRandomString(int n) {
		String AlphaNumericString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			// generate a random number between 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public static LocalDateTime getCurentTimeUTC() {		
		return (new Date()).toInstant().atZone(ZoneId.of("UTC")).toLocalDateTime();
	}
}