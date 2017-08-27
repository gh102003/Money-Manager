package com.pyesmeadow.george.moneymanager.payment;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@SuppressWarnings({"WeakerAccess", "unused", "MagicConstant", "UnusedReturnValue"})
public class Repetition {

	private Calendar startDate;
	@Nullable
	private Calendar endDate;
	private RepetitionType type;
	private int interval;

	/**
	 * Creates a new repetition
	 * <p>
	 * For example, use a type of {@link RepetitionType}{@code .DAILY} and an interval of
	 * {@code 3} for once every three days.
	 *
	 * @param type      base repetition type
	 * @param interval  interval between repetitions
	 * @param startDate start date of repetition
	 * @param endDate   end date of repetition
	 */
	public Repetition(RepetitionType type, int interval, Calendar startDate, @Nullable Calendar endDate)
	{
		this.type = type;
		this.interval = interval;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public List<Calendar> getDatesBetween(Calendar bound1, Calendar bound2)
	{
		Calendar date = startDate;
		Calendar latestDate;

		// If the repetition has an end date and it isn't out of bounds, use it as the last repetition
		if (endDate != null && !endDate.after(bound2))
		{
			latestDate = endDate;
		}
		else
		// Otherwise, use the second bound
		{
			latestDate = bound2;
		}

		List<Calendar> dateList = new ArrayList<>();

		// While date is before end date
		while (!date.after(latestDate))
		{
			if (!date.before(bound1))
			{
				dateList.add(date);
			}

			getNextDate(date);
		}

		return dateList;
	}

	private Calendar getNextDate(Calendar currentDate)
	{
		currentDate.add(this.type.getInterval(), interval);
		return currentDate;
	}

	public RepetitionType getType()
	{
		return type;
	}

	public int getInterval()
	{
		return interval;
	}

	public Calendar getStartDate()
	{
		return startDate;
	}

	public Calendar getEndDate()
	{
		return endDate;
	}

	public enum RepetitionType {

		EVERY_MINUTE(Calendar.MINUTE),
		HOURLY(Calendar.HOUR_OF_DAY),
		DAILY(Calendar.DAY_OF_MONTH),
		WEEKLY(Calendar.WEEK_OF_MONTH),
		MONTHLY(Calendar.MONTH),
		ANNUALLY(Calendar.YEAR);

		private int interval;

		/**
		 * @param interval A field of {@link Calendar} between each repetition
		 */
		RepetitionType(int interval)
		{
			this.interval = interval;
		}

		@Contract(pure = true)
		public int getInterval()
		{
			return interval;
		}
	}
}

