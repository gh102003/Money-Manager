package com.pyesmeadow.george.moneymanager.currency;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LocaleCurrencyLookup {

	public static final CurrencyWithValue US_DOLLAR = new CurrencyWithValue("US Dollar",
																			Locale.US,
																			new BigDecimal("1.0"));
	public static final CurrencyWithValue UK_POUND = new CurrencyWithValue("UK Pound",
																		   Locale.UK,
																		   new BigDecimal("1.0"));
	public static final CurrencyWithValue EURO = new CurrencyWithValue("Euro", Locale.GERMANY, new BigDecimal("1.0"));
	public static final CurrencyWithValue CANADIAN_DOLLAR = new CurrencyWithValue("Canadian Dollar",
																				  Locale.CANADA,
																				  new BigDecimal("1.0"));
	public static final CurrencyWithValue AUSTRALIAN_DOLLAR = new CurrencyWithValue("Australian Dollar",
																					new Locale("en", "AU"),
																					new BigDecimal("1.0"));
	public static Map<Locale, CurrencyWithValue> localeCurrencyMap = new HashMap<>();

	static
	{
		localeCurrencyMap.put(Locale.US, US_DOLLAR);
		localeCurrencyMap.put(Locale.UK, UK_POUND);
		localeCurrencyMap.put(Locale.GERMANY, EURO); // TODO Setup other locales
		localeCurrencyMap.put(Locale.FRANCE, EURO);
		localeCurrencyMap.put(Locale.ITALY, EURO);
		localeCurrencyMap.put(new Locale("nl", "NL"), EURO);
		localeCurrencyMap.put(new Locale("es", "ES"), EURO);
		localeCurrencyMap.put(Locale.CANADA, CANADIAN_DOLLAR);
		localeCurrencyMap.put(new Locale("en", "AU"), AUSTRALIAN_DOLLAR);
	}
}
