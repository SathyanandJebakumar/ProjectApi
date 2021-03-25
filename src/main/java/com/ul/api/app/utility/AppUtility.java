package com.ul.api.app.utility;

import java.time.LocalDateTime;

import java.time.ZoneId;
import java.util.Date;

/**
 * Utility Class 
 * Primarily Intended For Cross App Usage
 * @author Sathyanand.Jebakumar
 *
 */
public class AppUtility {

	/**
	 * Converts Java Util Date To LocalDateTime Format
	 * @param date
	 * @return
	 */
	public static LocalDateTime convertDateToLocalDate(Date date) {
		LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		return ldt;
	}

}
