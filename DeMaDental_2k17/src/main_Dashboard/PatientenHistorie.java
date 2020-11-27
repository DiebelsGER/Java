package main_Dashboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import components.Table;
import interfaces.TextLabels;
import variables.Auftrag;
import mysql.tables.PatientTabelle;

import java.awt.GridBagLayout;
import java.awt.Insets;

public class PatientenHistorie extends JDialog implements TextLabels {

	private JPanel contentPanel = new JPanel();
	
	private PatientTabelle patient = new PatientTabelle();
	
	private Auftrag auftrag;
	private Table table;

	public PatientenHistorie(Auftrag auftrag) {
		
		this.auftrag = auftrag;
		
		setAlwaysOnTop(true);
					
		setTitle("Auftrag-Historie von Patient " + patient.getPatientName(auftrag.patient_id));
		setBounds(100, 100, 900, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0};
		gbl_contentPanel.rowHeights = new int[]{0};
		gbl_contentPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JPanel panelTable = new JPanel();
		GridBagConstraints gbc_panelTable = new GridBagConstraints();
		gbc_panelTable.insets = new Insets(0, 10, 10, 10);
		gbc_panelTable.fill = GridBagConstraints.BOTH;
		gbc_panelTable.gridx = 0;
		gbc_panelTable.gridy = 0;
		contentPanel.add(panelTable, gbc_panelTable);
		GridBagLayout gbl_panelTable = new GridBagLayout();
		gbl_panelTable.columnWidths = new int[]{0};
		gbl_panelTable.rowHeights = new int[]{0};
		gbl_panelTable.columnWeights = new double[]{1.0};
		gbl_panelTable.rowWeights = new double[]{1.0};
		panelTable.setLayout(gbl_panelTable);
		
		table = new Table();
		table.table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setBackground(Color.WHITE);
		table.setBorder(null);
		table.fillTable("SELECT DATE_FORMAT(a.datum, '%d.%m.%Y'), a.nummer, at.name, k.name, kb.name, a.arbeitsart, a.zahnfarbe, a.legierung, e.name FROM auftrag a, auftrag_typ at, kunde k, kieferbereich kb, erledigt_typ e WHERE '" + auftrag.patient_id + "' = a.patient_id AND at.auftrag_typ_id = a.auftrag_typ_id AND k.kunde_id = a.kunde_id AND kb.kieferbereich_id = a.kieferbereich_id AND e.erledigt_typ_id = a.erledigt_typ_id ORDER BY a.datum DESC", colheadsPatientAuftrag);
//		table.table.addKeyListener(new KeyPressedListener());
//        table.table.addMouseListener(new MouseClickedListener());
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		panelTable.add(table, gbc_table);
		
	//	pack();
		setLocationRelativeTo(null);

	}

}
