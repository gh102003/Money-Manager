package com.pyesmeadow.george.moneymanager.util;

import java.util.Calendar;

public class DateUtils {

	public static boolean isDateInRange(Calendar date, Calendar bound1, Calendar bound2)
	{
		return !(date.after(bound2) || date.before(bound1));
	}
}
