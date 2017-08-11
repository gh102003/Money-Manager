package com.pyesmeadow.george.moneymanager;

import com.pyesmeadow.george.moneymanager.payment.SinglePayment;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("WeakerAccess")
public class MoneyManagerFrame extends JFrame {

	private static final JScrollPane scrollPane = new JScrollPane();
	private static final JButton btnAdd = new JButton("New payment...");
	private static final JButton btnClose = new JButton("Close");

	public MoneyManagerFrame()
	{
		setLayout(new GridBagLayout());

		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		btnAdd.addActionListener(e ->
		{
			Calendar date = new GregorianCalendar();
			date.set(2017, Calendar.AUGUST, 6, 14, 228);

			MoneyManager.getInstance().paymentManager.addPayment(new SinglePayment(20, "John", date));
		});

		btnClose.addActionListener(e ->
		{
			MoneyManager.getInstance().paymentManager.getPayments().forEach(payment ->
			{
				System.out.println("" + payment.getPaymentAmount());
				System.out.println(payment.getRecipient());

				payment.getPaymentDates().forEach(date -> System.out.println(date.getTime().toString()));
			});

			dispose();
		});

		GridBagConstraints c = new GridBagConstraints();
		c.ipadx = 5;
		c.ipady = 5;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;

		c.gridy = 0;
		c.gridwidth = 2;
		add(scrollPane);

		c.gridy = 1;
		c.gridx = GridBagConstraints.RELATIVE;
		c.gridwidth = 1;
		add(btnAdd);
		add(btnClose);

		setSize(new Dimension(300, 200));
		setTitle("Money Manager");
		setVisible(true);
	}
}
