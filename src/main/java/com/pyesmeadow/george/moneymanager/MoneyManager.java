package com.pyesmeadow.george.moneymanager;

import com.pyesmeadow.george.moneymanager.payment.PaymentManager;

@SuppressWarnings("WeakerAccess")
public class MoneyManager {

	private static MoneyManager instance;

	public MoneyManagerFrame frame;
	public PaymentManager paymentManager;

	public static void main(String[] args)
	{
		instance = new MoneyManager();

		instance.paymentManager = new PaymentManager();
		instance.frame = new MoneyManagerFrame();
	}

	@SuppressWarnings("WeakerAccess")
	public static MoneyManager getInstance()
	{
		return instance;
	}
}