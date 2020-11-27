package main_Dashboard;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import panels_Zahnschema.Quadranten;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class Zahnschema extends JDialog {

	private JPanel contentPanel = new JPanel();
	
	private Quadranten pnlZahnschemaQ1;
	private Quadranten pnlZahnschemaQ2;
	private Quadranten pnlZahnschemaQ3;
	private Quadranten pnlZahnschemaQ4;
	private JPanel pnlButtons;
	private JLabel lblTest;

	/**
	 * Create the dialog.
	 */
	public Zahnschema() {
		setTitle("Zahnschema angeben");
		
		setAlwaysOnTop(true);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0};
		gbl_contentPanel.rowHeights = new int[]{0};
		gbl_contentPanel.columnWeights = new double[]{0.0};
		gbl_contentPanel.rowWeights = new double[]{0.0};
		contentPanel.setLayout(gbl_contentPanel);
		
		JPanel pnlTitle = new JPanel();
		pnlTitle.setBorder(new LineBorder(Color.GRAY));
		pnlTitle.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		GridBagConstraints gbc_pnlTitle = new GridBagConstraints();
		gbc_pnlTitle.insets = new Insets(10, 10, 10, 10);
		gbc_pnlTitle.fill = GridBagConstraints.BOTH;
		gbc_pnlTitle.gridx = 0;
		gbc_pnlTitle.gridy = 0;
		contentPanel.add(pnlTitle, gbc_pnlTitle);
		GridBagLayout gbl_pnlTitle = new GridBagLayout();
		gbl_pnlTitle.columnWidths = new int[]{0, 0};
		gbl_pnlTitle.rowHeights = new int[]{0, 0};
		gbl_pnlTitle.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlTitle.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlTitle.setLayout(gbl_pnlTitle);
		
		JLabel lblZahnschemaAngeben = new JLabel("4.a Zahnschema angeben");
		lblZahnschemaAngeben.setFont(new Font("Verdana", Font.BOLD, 16));
		lblZahnschemaAngeben.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblZahnschemaAngeben = new GridBagConstraints();
		gbc_lblZahnschemaAngeben.insets = new Insets(10, 10, 10, 10);
		gbc_lblZahnschemaAngeben.gridx = 0;
		gbc_lblZahnschemaAngeben.gridy = 0;
		pnlTitle.add(lblZahnschemaAngeben, gbc_lblZahnschemaAngeben);
		
		JPanel pnlBody = new JPanel();
		pnlBody.setBorder(new LineBorder(Color.GRAY));
		GridBagConstraints gbc_pnlBody = new GridBagConstraints();
		gbc_pnlBody.insets = new Insets(0, 10, 10, 10);
		gbc_pnlBody.fill = GridBagConstraints.BOTH;
		gbc_pnlBody.gridx = 0;
		gbc_pnlBody.gridy = 1;
		contentPanel.add(pnlBody, gbc_pnlBody);
		GridBagLayout gbl_pnlBody = new GridBagLayout();
		gbl_pnlBody.columnWidths = new int[]{0, 0};
		gbl_pnlBody.rowHeights = new int[]{0, 0, 0};
		gbl_pnlBody.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlBody.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		pnlBody.setLayout(gbl_pnlBody);
		
		JPanel pnlZahnschema = new JPanel();
		pnlZahnschema.setBorder(new LineBorder(Color.GRAY));
		pnlZahnschema.setBackground(Color.WHITE);
		GridBagConstraints gbc_pnlZahnschema = new GridBagConstraints();
		gbc_pnlZahnschema.anchor = GridBagConstraints.WEST;
		gbc_pnlZahnschema.fill = GridBagConstraints.VERTICAL;
		gbc_pnlZahnschema.insets = new Insets(10, 10, 10, 10);
		gbc_pnlZahnschema.gridx = 0;
		gbc_pnlZahnschema.gridy = 0;
		pnlBody.add(pnlZahnschema, gbc_pnlZahnschema);
		GridBagLayout gbl_pnlZahnschema = new GridBagLayout();
		gbl_pnlZahnschema.columnWidths = new int[]{0};
		gbl_pnlZahnschema.rowHeights = new int[]{0};
		gbl_pnlZahnschema.columnWeights = new double[]{0.0};
		gbl_pnlZahnschema.rowWeights = new double[]{0.0};
		pnlZahnschema.setLayout(gbl_pnlZahnschema);
		
		pnlZahnschemaQ1 = new Quadranten(-18);
		GridBagConstraints gbc_pnlZahnschemaQ1 = new GridBagConstraints();
		gbc_pnlZahnschemaQ1.anchor = GridBagConstraints.WEST;
		gbc_pnlZahnschemaQ1.insets = new Insets(10, 10, 10, 10);
		gbc_pnlZahnschemaQ1.fill = GridBagConstraints.VERTICAL;
		gbc_pnlZahnschemaQ1.gridx = 0;
		gbc_pnlZahnschemaQ1.gridy = 0;
		pnlZahnschema.add(pnlZahnschemaQ1, gbc_pnlZahnschemaQ1);
		
		pnlZahnschemaQ2 = new Quadranten(21);
		GridBagConstraints gbc_pnlZahnschemaQ2 = new GridBagConstraints();
		gbc_pnlZahnschemaQ2.anchor = GridBagConstraints.WEST;
		gbc_pnlZahnschemaQ2.insets = new Insets(10, 10, 10, 10);
		gbc_pnlZahnschemaQ2.fill = GridBagConstraints.VERTICAL;
		gbc_pnlZahnschemaQ2.gridx = 1;
		gbc_pnlZahnschemaQ2.gridy = 0;
		pnlZahnschema.add(pnlZahnschemaQ2, gbc_pnlZahnschemaQ2);
		
		pnlZahnschemaQ3 = new Quadranten(-48);
		GridBagConstraints gbc_pnlZahnschemaQ3 = new GridBagConstraints();
		gbc_pnlZahnschemaQ3.anchor = GridBagConstraints.WEST;
		gbc_pnlZahnschemaQ3.insets = new Insets(10, 10, 10, 10);
		gbc_pnlZahnschemaQ3.fill = GridBagConstraints.VERTICAL;
		gbc_pnlZahnschemaQ3.gridx = 0;
		gbc_pnlZahnschemaQ3.gridy = 1;
		pnlZahnschema.add(pnlZahnschemaQ3, gbc_pnlZahnschemaQ3);
		
		pnlZahnschemaQ4 = new Quadranten(31);
		GridBagConstraints gbc_pnlZahnschemaQ4 = new GridBagConstraints();
		gbc_pnlZahnschemaQ4.anchor = GridBagConstraints.WEST;
		gbc_pnlZahnschemaQ4.insets = new Insets(10, 10, 10, 10);
		gbc_pnlZahnschemaQ4.fill = GridBagConstraints.VERTICAL;
		gbc_pnlZahnschemaQ4.gridx = 1;
		gbc_pnlZahnschemaQ4.gridy = 1;
		pnlZahnschema.add(pnlZahnschemaQ4, gbc_pnlZahnschemaQ4);
		
		pnlButtons = new JPanel();
		pnlButtons.setBorder(new LineBorder(Color.GRAY));
		pnlButtons.setBackground(Color.WHITE);
		GridBagConstraints gbc_pnlButtons = new GridBagConstraints();
		gbc_pnlButtons.fill = GridBagConstraints.BOTH;
		gbc_pnlButtons.insets = new Insets(0, 10, 10, 10);
		gbc_pnlButtons.gridx = 0;
		gbc_pnlButtons.gridy = 1;
		pnlBody.add(pnlButtons, gbc_pnlButtons);
		GridBagLayout gbl_pnlButtons = new GridBagLayout();
		gbl_pnlButtons.columnWidths = new int[]{0, 0};
		gbl_pnlButtons.rowHeights = new int[]{0, 0};
		gbl_pnlButtons.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlButtons.setLayout(gbl_pnlButtons);
		
		lblTest = new JLabel("Test");
		GridBagConstraints gbc_lblTest = new GridBagConstraints();
		gbc_lblTest.gridx = 0;
		gbc_lblTest.gridy = 0;
		pnlButtons.add(lblTest, gbc_lblTest);
		
		pack();
		setLocationRelativeTo(null);
	}

}
