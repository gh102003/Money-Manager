package com.pyesmeadow.george.moneymanager.ui;

import com.pyesmeadow.george.moneymanager.MoneyManager;
import com.pyesmeadow.george.moneymanager.payment.Payment;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.util.Calendar;

/**
 * A frame for a single transaction
 */
public class TransactionListEntryPanel extends JPanel {

	private final Payment payment;
	private final Calendar transactionDate;

	private final JLabel labelAmount;
	private final JLabel labelRecipient;
	private final JLabel labelDate;

	public TransactionListEntryPanel(Payment payment, Calendar transactionDate)
	{
		super();

		this.payment = payment;
		this.transactionDate = transactionDate;

		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
		Font font = new Font("SansSerif", Font.PLAIN, 18);

		labelAmount = new JLabel(MoneyManager.getInstance().getCurrency().formatAndConvertAmount(payment.getAmount()));
		labelRecipient = new JLabel(payment.getRecipient());
		labelDate = new JLabel(dateFormat.format(transactionDate.getTime()));

		labelAmount.setFont(font);
		labelRecipient.setFont(font);
		labelDate.setFont(font);

		this.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		c.weightx = 0.5;
		c.weighty = 1;
		c.gridx = GridBagConstraints.RELATIVE;
		c.insets = new Insets(3, 3, 3, 3);

		add(labelAmount, c);
		add(labelRecipient, c);
		add(labelDate, c);

		setMinimumSize(new Dimension(50, 20));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
	}

	public Payment getPayment()
	{
		return payment;
	}

	public Calendar getTransactionDate()
	{
		return transactionDate;
	}
}
