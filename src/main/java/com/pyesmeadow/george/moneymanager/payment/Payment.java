package com.pyesmeadow.george.moneymanager.payment;

import java.util.Calendar;
import java.util.List;

@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class Payment {

	private double paymentAmount;
	private String recipient;

	public Payment(double paymentAmount, String recipient)
	{
		this.paymentAmount = paymentAmount;
		this.recipient = recipient;
	}

	public abstract List<Calendar> getPaymentDates();

	public String getRecipient()
	{
		return recipient;
	}

	public void setRecipient(String recipient)
	{
		this.recipient = recipient;
	}

	public double getPaymentAmount()
	{
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount)
	{
		this.paymentAmount = paymentAmount;
	}
}
