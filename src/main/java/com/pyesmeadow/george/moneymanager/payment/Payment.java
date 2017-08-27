package com.pyesmeadow.george.moneymanager.payment;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class Payment {

	private BigDecimal amount;
	private String recipient;

	public Payment(BigDecimal amount, String recipient)
	{
		this.amount = amount;
		this.recipient = recipient;
	}

	public abstract List<Calendar> getPaymentDatesBetween(Calendar bound1, Calendar bound2);

	public String getRecipient()
	{
		return recipient;
	}

	public void setRecipient(String recipient)
	{
		this.recipient = recipient;
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}
}
