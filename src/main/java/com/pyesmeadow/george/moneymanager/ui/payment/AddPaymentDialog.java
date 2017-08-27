package com.pyesmeadow.george.moneymanager.ui.payment;

import com.pyesmeadow.george.moneymanager.MoneyManager;
import com.pyesmeadow.george.moneymanager.payment.Payment;
import com.pyesmeadow.george.moneymanager.util.ObjectManagerWithListeners;

import javax.swing.*;
import java.awt.*;

public class AddPaymentDialog extends JDialog {

	// Payment type
	private static final JPanel panelPaymentTypeSelection = new JPanel();
	private static final ButtonGroup buttonGroupPayment = new ButtonGroup();
	private static final JLabel labelPaymentType = new JLabel("Payment type:");
	private static final JRadioButton radioSinglePayment = new JRadioButton("Single");
	private static final JRadioButton radioRepeatingPayment = new JRadioButton("Repeating");

	// Payment information panels
	private static final CardLayout cardLayoutPaymentInformation = new CardLayout();
	private static final JPanel panelPaymentInformation = new JPanel(cardLayoutPaymentInformation);
	private static final JPanel panelSinglePayment = new JPanel(new GridBagLayout());
	private static final JPanel panelRepeatingPayment = new JPanel(new GridBagLayout());

	// Payment information
	private static final JLabel labelAmount = new JLabel("Amount (" + MoneyManager.getInstance().getCurrency().getName() + "):");
	private static final JFormattedTextField fieldAmount = new JFormattedTextField(MoneyManager.getInstance().getCurrency().getFormatting());

	public AddPaymentDialog(ObjectManagerWithListeners<Payment> paymentManager)
	{
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		// Add panels
		add(panelPaymentTypeSelection);
		add(panelPaymentInformation);

		// Add payment type radio buttons to a button group
		buttonGroupPayment.add(radioSinglePayment);
		buttonGroupPayment.add(radioRepeatingPayment);
		radioSinglePayment.setSelected(true);

		// Add payment type components to a panel
		panelPaymentTypeSelection.add(labelPaymentType);
		panelPaymentTypeSelection.add(radioSinglePayment);
		panelPaymentTypeSelection.add(radioRepeatingPayment);

		// Setup payment information panel
		panelPaymentInformation.add(panelSinglePayment, "singlePayment");
		panelPaymentInformation.add(panelRepeatingPayment, "repeatingPayment");

		// Setup single payment panel
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = GridBagConstraints.RELATIVE;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.1;
		panelSinglePayment.add(labelAmount, c);
		c.weightx = 0.9;
		panelSinglePayment.add(fieldAmount, c);

		// Setup action listeners for payment type selection
		radioSinglePayment.addActionListener(e ->
		{
			cardLayoutPaymentInformation.show(panelPaymentInformation, "singlePayment");
		});

		radioRepeatingPayment.addActionListener(e ->
		{
			cardLayoutPaymentInformation.show(panelPaymentInformation, "repeatingPayment");
		});

		setTitle("Add payment");
		setMinimumSize(new Dimension(200, 200));
		setSize(new Dimension(200, 300));
		pack();
		setVisible(true);
	}
}
