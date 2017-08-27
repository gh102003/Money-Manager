package com.pyesmeadow.george.moneymanager;

import com.pyesmeadow.george.moneymanager.currency.CurrencyWithValue;
import com.pyesmeadow.george.moneymanager.currency.LocaleCurrencyLookup;
import com.pyesmeadow.george.moneymanager.payment.Payment;
import com.pyesmeadow.george.moneymanager.ui.MoneyManagerFrame;
import com.pyesmeadow.george.moneymanager.util.ObjectManagerWithListeners;

import java.util.Locale;

@SuppressWarnings("WeakerAccess")
public class MoneyManager {

	private static MoneyManager instance;

	public MoneyManagerFrame frame;
	public ObjectManagerWithListeners<Payment> paymentManager;
	private CurrencyWithValue currency;

	public MoneyManager()
	{
		// Set default currency
		Locale locale = Locale.getDefault();
		CurrencyWithValue currencyFromLocale = LocaleCurrencyLookup.localeCurrencyMap.get(locale);
		if (currencyFromLocale != null)
		{
			currency = currencyFromLocale;
		}
		else
		{
			currency = LocaleCurrencyLookup.US_DOLLAR;
		}

		this.paymentManager = new ObjectManagerWithListeners<>();
	}

	public static void main(String[] args)
	{
		instance = new MoneyManager();
		instance.frame = new MoneyManagerFrame();
	}

	@SuppressWarnings("WeakerAccess")
	public static MoneyManager getInstance()
	{
		return instance;
	}

	public CurrencyWithValue getCurrency()
	{
		return currency;
	}

	public void setCurrency(CurrencyWithValue currency)
	{
		this.currency = currency;
	}
}