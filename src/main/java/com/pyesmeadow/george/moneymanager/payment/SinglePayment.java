package com.pyesmeadow.george.moneymanager.payment;

import com.pyesmeadow.george.moneymanager.util.DateUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SinglePayment extends Payment {

	private Calendar paymentDate;

	public SinglePayment(BigDecimal paymentAmount, String recipient, Calendar paymentDate)
	{
		super(paymentAmount, recipient);

		this.paymentDate = paymentDate;
	}

	@Override
	public List<Calendar> getPaymentDatesBetween(Calendar bound1, Calendar bound2)
	{
		List<Calendar> paymentDateList = new ArrayList<>();

		if (DateUtils.isDateInRange(paymentDate, bound1, bound2))
		{
			paymentDateList.add(paymentDate);
		}

		return paymentDateList;
	}
}
