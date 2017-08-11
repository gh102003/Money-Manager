package com.pyesmeadow.george.moneymanager.payment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SinglePayment extends Payment {

	private Calendar paymentDate;

	public SinglePayment(double paymentAmount, String recipient, Calendar paymentDate)
	{
		super(paymentAmount, recipient);

		this.paymentDate = paymentDate;
	}

	@Override
	public List<Calendar> getPaymentDates()
	{
		List<Calendar> paymentDateList = new ArrayList<>();
		paymentDateList.add(paymentDate);
		return paymentDateList;
	}
}
