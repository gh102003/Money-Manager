package com.pyesmeadow.george.moneymanager.payment;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@SuppressWarnings("unused")
public class RepeatingPayment extends Payment {

	private Repetition repetition;

	public RepeatingPayment(BigDecimal paymentAmount, String recipient, Repetition repetition)
	{
		super(paymentAmount, recipient);

		this.repetition = repetition;
	}

	@Override
	public List<Calendar> getPaymentDatesBetween(Calendar bound1, Calendar bound2)
	{
		return repetition.getDatesBetween(bound1, bound2);
	}
}