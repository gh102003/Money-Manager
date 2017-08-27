package com.pyesmeadow.george.moneymanager.currency;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyWithValue {

	private final String name;
	private final Locale locale;
	private final BigDecimal valueInUSD;

	public CurrencyWithValue(String name, Locale locale, BigDecimal valueInUSD)
	{
		this.name = name;

		this.locale = locale;
		this.valueInUSD = valueInUSD;
	}

	public String formatAndConvertAmount(BigDecimal amountInUSD)
	{
		BigDecimal amountInCurrency = amountInUSD.divide(getValueInUSD(), BigDecimal.ROUND_HALF_UP);
		return NumberFormat.getCurrencyInstance(locale).format(amountInCurrency);
	}

	public NumberFormat getFormatting()
	{
		return NumberFormat.getCurrencyInstance(locale);
	}

	public String getName()
	{
		return name;
	}

	public final Locale getLocale()
	{
		return locale;
	}

	public BigDecimal getValueInUSD()
	{
		return valueInUSD;
	}
}

