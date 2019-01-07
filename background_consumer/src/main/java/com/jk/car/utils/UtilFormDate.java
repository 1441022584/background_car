package com.jk.car.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilFormDate {
	
	/**
	 * 时间格式转换
	 * @param format eg:yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String formatDate(String format, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateStr = sdf.format(date);
		return dateStr;
	}

	/**
	 * 时间格式转换
	 * @param format eg:yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date parseString(String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date parse = sdf.parse(format);
        return parse;
	}




}
