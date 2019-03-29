package com.limon.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat yyyy_Formatter = new SimpleDateFormat("yyyy");
	private static SimpleDateFormat MM_Formatter = new SimpleDateFormat("MM");
	private static SimpleDateFormat dd_Formatter = new SimpleDateFormat("dd");
	private static SimpleDateFormat yyyy_MM_dd_Formatter = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat HH_Formatter = new SimpleDateFormat("HH");
	private static SimpleDateFormat mm_Formatter = new SimpleDateFormat("mm");
	private static SimpleDateFormat ss_Formatter = new SimpleDateFormat("ss");
	private static SimpleDateFormat yyyy_MM_dd_HH_mm_ss_Formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String getStringYearByDate(Date date) {
		String datestr = null;

		try {
			datestr = yyyy_Formatter.format(date);
		} catch (Exception e) {
			System.out.println("error --StringUtil.getDateByString   ");
		}
		return datestr;
	}

	public static String getStringMonthByDate(Date date) {
		String datestr = null;

		try {
			datestr = MM_Formatter.format(date);
		} catch (Exception e) {
			System.out.println("error --StringUtil.getDateByString   ");
		}
		return datestr;
	}

	public static String getStringDDByDate(Date date) {
		String datestr = null;

		try {
			datestr = dd_Formatter.format(date);
		} catch (Exception e) {
			System.out.println("error --StringUtil.getDateByString   ");
		}
		return datestr;
	}

	public static String getStringHourByDate(Date date) {
		String datestr = null;

		try {
			datestr = HH_Formatter.format(date);
		} catch (Exception e) {
			System.out.println("error --StringUtil.getDateByString   ");
		}
		return datestr;
	}

	public static String getStringMinuteByDate(Date date) {
		String datestr = null;

		try {
			datestr = mm_Formatter.format(date);
		} catch (Exception e) {
			System.out.println("error --StringUtil.getDateByString   ");
		}
		return datestr;
	}

	public static String getStringSecondByDate(Date date) {
		String datestr = null;

		try {
			datestr = ss_Formatter.format(date);
		} catch (Exception e) {
			System.out.println("error --StringUtil.getDateByString   ");
		}
		return datestr;
	}

	public static String getStringDateByDate(Date date) {
		String datestr = null;
		
		try {
			datestr = yyyy_MM_dd_HH_mm_ss_Formatter.format(date);
		} catch (Exception e) {
			System.out.println("error --StringUtil.getDateByString   ");
		}
		return datestr;
	}
	
	public static String getStringDayByDate(Date date) {
		String datestr = null;
		
		try {
			datestr = yyyy_MM_dd_Formatter.format(date);
		} catch (Exception e) {
			System.out.println("error --StringUtil.getStringDayByDate   ");
		}
		return datestr;
	}
	
	public static String getStringDateByStringDate(String time) {
		Date date = getDateByString(time);
		String datestr = null;
		try {
			datestr = yyyy_MM_dd_HH_mm_ss_Formatter.format(date);
		} catch (Exception e) {
			System.out.println("error --StringUtil.getDateByString   ");
		}
		return datestr;
	}
	
	public static Date getDateByString(String time) {
		Date date = null;
		try {
			date = yyyy_MM_dd_HH_mm_ss_Formatter.parse(time);
		} catch (Exception e) {
			System.out.println("error --StringUtil.getDateByString   ");
		}
		return date;
	}

}
