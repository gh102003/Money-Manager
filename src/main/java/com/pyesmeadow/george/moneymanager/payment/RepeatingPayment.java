package com.pyesmeadow.george.moneymanager.payment;

import java.util.Calendar;
import java.util.List;

@SuppressWarnings("unused")
public class RepeatingPayment extends Payment {

	private Repetition repetition;

	public RepeatingPayment(double paymentAmount, String recipient, Repetition repetition)
	{
		super(paymentAmount, recipient);

		this.repetition = repetition;
	}

	@Override
	public List<Calendar> getPaymentDates()
	{
		return repetition.getDates();
	}
}