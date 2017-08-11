package com.pyesmeadow.george.moneymanager.payment;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class PaymentManager {

	private List<Payment> payments;

	public PaymentManager()
	{
		payments = new ArrayList<>();
	}

	public void addPayment(Payment payment)
	{
		payments.add(payment);
	}

	public void deletePayment(Payment payment)
	{
		payments.remove(payment);
	}

	public List<Payment> getPayments()
	{
		return payments;
	}
}