package com.pyesmeadow.george.moneymanager.ui;

import com.pyesmeadow.george.moneymanager.MoneyManager;
import com.pyesmeadow.george.moneymanager.payment.Payment;
import com.pyesmeadow.george.moneymanager.ui.payment.AddPaymentDialog;
import com.pyesmeadow.george.moneymanager.util.ObjectManagerWithListeners;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class MoneyManagerFrame extends JFrame {

	private final JButton btnAdd = new JButton("New payment...");
	private final JButton btnClose = new JButton("Close");
	private final JTextArea textStatus = new JTextArea();
	private final JScrollPane scrollPane = new JScrollPane(textStatus,
			ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	private final JPanel panelTransactions = new JPanel(new GridBagLayout());
	private final JScrollPane scrollPaneTransactions = new JScrollPane(panelTransactions,
			ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	public MoneyManagerFrame()
	{
		setLayout(new GridBagLayout());

		ObjectManagerWithListeners<Payment> paymentManager = MoneyManager
				.getInstance()
				.paymentManager;

		btnAdd.addActionListener(e ->
		{
			/*Calendar date = new GregorianCalendar();
			date.set(2017, Calendar.AUGUST, 28, 14, 28);

			Payment payment;

			switch (new Random().nextInt(3))
			{
				case 0:
					payment = new SinglePayment(new BigDecimal("20"), "John", date);
					break;
				case 1:
					payment = new SinglePayment(new BigDecimal("70"), "Fred", date);
					break;
				case 2:
					payment = new SinglePayment(new BigDecimal("25"), "Bob", date);
					break;
				default:
					payment = new SinglePayment(new BigDecimal("20"), "John", date);
					break;
			}

			paymentManager.add(payment);

			*/

			new AddPaymentDialog(paymentManager);
		});

		btnClose.addActionListener(e ->
		{
			dispose();
		});

		paymentManager.registerListEventHandler(new ObjectManagerWithListeners.ListEventHandler<Payment>() {
			@Override
			public void onObjectListChange()
			{
				textStatus.setText("");
				paymentManager.forEach(payment ->
				{
					Calendar firstBound = new GregorianCalendar(2016, Calendar.AUGUST, 28, 14, 228);
					Calendar secondBound = new GregorianCalendar(2018, Calendar.AUGUST, 28, 14, 228);
					List<Calendar> dates = payment.getPaymentDatesBetween(firstBound, secondBound);

					textStatus.append(payment.getRecipient() + " | " + payment.getAmount() + " | " + dates.get(0).getTime() + " and " + Integer.toString(
							dates.size() - 1) + " more\n");
				});
			}

			@Override
			public void onAddObject(Payment payment)
			{
				GridBagConstraints c = new GridBagConstraints();
				c.gridx = 0;
				c.gridy = GridBagConstraints.RELATIVE;
				c.fill = GridBagConstraints.HORIZONTAL;
				c.weightx = 0.8;
				c.insets = new Insets(5, 5, 5, 5);

				Calendar date1 = new GregorianCalendar();
				date1.set(2016, Calendar.AUGUST, 28, 14, 228);
				Calendar date2 = new GregorianCalendar();
				date2.set(2018, Calendar.AUGUST, 28, 14, 228);

				panelTransactions.add(new TransactionListEntryPanel(payment,
						payment.getPaymentDatesBetween(date1, date2).get(0)), c);
				scrollPaneTransactions.validate();
			}
		});

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.gridheight = 1;

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.weighty = 1;
		add(scrollPane, c);

		c.gridy = 1;
		add(scrollPaneTransactions, c);

		c.gridy = 2;
		c.gridx = GridBagConstraints.RELATIVE;
		c.gridwidth = 1;
		c.weighty = 0;
		add(btnAdd, c);
		add(btnClose, c);

		setTitle("Money Manager");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setSize(new Dimension(500, 400));
		setVisible(true);
	}
}
