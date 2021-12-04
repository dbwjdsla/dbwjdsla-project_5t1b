package com.otlb.semi.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateFormatUtils {
	public static String formatDate(Timestamp date) {
		if(date != null) {
			SimpleDateFormat formatedDate = new SimpleDateFormat("yy-MM-dd [HH:mm]");
			String result = formatedDate.format(date);
			
			return result;
		} else {
			return null;
		}
	}
}
