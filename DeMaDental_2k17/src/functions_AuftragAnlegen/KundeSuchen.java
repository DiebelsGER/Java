package functions_AuftragAnlegen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import components.Table;
import functions_AuftragAnlegen.AuftragNummer.ButtonListener;
import interfaces.TextLabels;
import mysql.tables.KundeTabelle;
import variables.Auftrag;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.UIManager;

public class KundeSuchen extends JPanel implements TextLabels {
	
	private Navigation pnlNavigation;
	
	private KundeTabelle kt = new KundeTabelle();
	
	private String kundeName;
	
	private String suchtext;
	private Auftrag auftrag;
	private Table table;
	private JTextField txtKundenSuchen;
	private JButton btnWeiter;

	/**
	 * Create the panel.
	 */
	public KundeSuchen(Auftrag auftrag) {
		
		this.auftrag = auftrag;
		
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		pnlNavigation = new Navigation();
		GridBagConstraints gbc_pnl_navigation = new GridBagConstraints();
		gbc_pnl_navigation.insets = new Insets(10, 10, 10, 10);
		gbc_pnl_navigation.fill = GridBagConstraints.BOTH;
		gbc_pnl_navigation.gridx = 0;
		gbc_pnl_navigation.gridy = 0;
		add(pnlNavigation, gbc_pnl_navigation);
		
		pnlNavigation.btnAuftragNummer.addActionListener(new ButtonListener());
		pnlNavigation.btnAuftragNummer.setIcon(new ImageIcon(Navigation.class.getResource("/pics/button_icons/iconfinder_Tick_Mark.png")));
		pnlNavigation.btnKundenAuswhlen.setEnabled(false);
		if (auftrag.kunde_id != 0) {
			pnlNavigation.btnKundenAuswhlen.setIcon(new ImageIcon(Navigation.class.getResource("/pics/button_icons/iconfinder_Tick_Mark.png")));
		}
		if (auftrag.patient_id == 0) {
			pnlNavigation.btnPatientenDaten.setEnabled(false);
		}
		else {
			pnlNavigation.btnPatientenDaten.addActionListener(new ButtonListener());
			pnlNavigation.btnPatientenDaten.setIcon(new ImageIcon(Navigation.class.getResource("/pics/button_icons/iconfinder_Tick_Mark.png")));
		}
		
		JPanel pnlTitle = new JPanel();
		pnlTitle.setBorder(new LineBorder(Color.GRAY));
		pnlTitle.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		GridBagConstraints gbc_pnlTitle = new GridBagConstraints();
		gbc_pnlTitle.insets = new Insets(0, 10, 10, 10);
		gbc_pnlTitle.fill = GridBagConstraints.BOTH;
		gbc_pnlTitle.gridx = 0;
		gbc_pnlTitle.gridy = 1;
		add(pnlTitle, gbc_pnlTitle);
		GridBagLayout gbl_pnlTitle = new GridBagLayout();
		gbl_pnlTitle.columnWidths = new int[]{0, 0};
		gbl_pnlTitle.rowHeights = new int[]{0, 0};
		gbl_pnlTitle.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlTitle.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlTitle.setLayout(gbl_pnlTitle);
		
		JLabel lblKundeName = new JLabel("2. Kunden auswählen");
		lblKundeName.setFont(new Font("Verdana", Font.BOLD, 16));
		lblKundeName.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblKundeName = new GridBagConstraints();
		gbc_lblKundeName.insets = new Insets(10, 10, 10, 10);
		gbc_lblKundeName.gridx = 0;
		gbc_lblKundeName.gridy = 0;
		pnlTitle.add(lblKundeName, gbc_lblKundeName);
		
		JPanel pnlBody = new JPanel();
		pnlBody.setBorder(new LineBorder(Color.GRAY));
		GridBagConstraints gbc_pnlBody = new GridBagConstraints();
		gbc_pnlBody.insets = new Insets(0, 10, 10, 10);
		gbc_pnlBody.fill = GridBagConstraints.BOTH;
		gbc_pnlBody.gridx = 0;
		gbc_pnlBody.gridy = 2;
		add(pnlBody, gbc_pnlBody);
		GridBagLayout gbl_pnlBody = new GridBagLayout();
		gbl_pnlBody.columnWidths = new int[]{0, 0};
		gbl_pnlBody.rowHeights = new int[]{0, 0, 0};
		gbl_pnlBody.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlBody.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlBody.setLayout(gbl_pnlBody);
		
		JPanel pnlKundenSuchen = new JPanel();
		pnlKundenSuchen.setBorder(new LineBorder(Color.GRAY));
		pnlKundenSuchen.setBackground(Color.WHITE);
		GridBagConstraints gbc_pnlKundenSuchen = new GridBagConstraints();
		gbc_pnlKundenSuchen.insets = new Insets(10, 10, 10, 10);
		gbc_pnlKundenSuchen.fill = GridBagConstraints.BOTH;
		gbc_pnlKundenSuchen.gridx = 0;
		gbc_pnlKundenSuchen.gridy = 0;
		pnlBody.add(pnlKundenSuchen, gbc_pnlKundenSuchen);
		GridBagLayout gbl_pnlKundenSuchen = new GridBagLayout();
		gbl_pnlKundenSuchen.columnWidths = new int[]{0, 0, 0};
		gbl_pnlKundenSuchen.rowHeights = new int[]{0, 0, 0};
		gbl_pnlKundenSuchen.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlKundenSuchen.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlKundenSuchen.setLayout(gbl_pnlKundenSuchen);
		
		JLabel lblKundenSuchen = new JLabel("Nach Namen des Kunden suchen");
		lblKundenSuchen.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblKundenSuchen = new GridBagConstraints();
		gbc_lblKundenSuchen.anchor = GridBagConstraints.WEST;
		gbc_lblKundenSuchen.insets = new Insets(10, 10, 10, 10);
		gbc_lblKundenSuchen.gridx = 0;
		gbc_lblKundenSuchen.gridy = 0;
		pnlKundenSuchen.add(lblKundenSuchen, gbc_lblKundenSuchen);
		
		if (auftrag.kunde_id != 0) {
			kundeName = kt.getKundeName(auftrag.kunde_id);
		}
		txtKundenSuchen = new JTextField(kundeName);
	//	txtKundenSuchen.setText(kt.getKundeName(auftrag.kunde_id));
		txtKundenSuchen.getDocument().addDocumentListener((new TextChangedListener()));
		txtKundenSuchen.addKeyListener(new KeyPressedListener());
		txtKundenSuchen.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_txtKundenSuchen = new GridBagConstraints();
		gbc_txtKundenSuchen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKundenSuchen.insets = new Insets(0, 10, 10, 10);
		gbc_txtKundenSuchen.gridx = 0;
		gbc_txtKundenSuchen.gridy = 1;
		pnlKundenSuchen.add(txtKundenSuchen, gbc_txtKundenSuchen);
		txtKundenSuchen.setColumns(20);
		
		JButton btnKundenSuchen = new JButton("Kunden suchen");
		btnKundenSuchen.setIcon(new ImageIcon(KundeSuchen.class.getResource("/pics/button_icons/zoom.png")));
		btnKundenSuchen.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_btnKundenSuchen = new GridBagConstraints();
		gbc_btnKundenSuchen.anchor = GridBagConstraints.NORTH;
		gbc_btnKundenSuchen.insets = new Insets(0, 10, 10, 10);
		gbc_btnKundenSuchen.gridx = 1;
		gbc_btnKundenSuchen.gridy = 1;
		pnlKundenSuchen.add(btnKundenSuchen, gbc_btnKundenSuchen);
		
		btnWeiter = new JButton("Ausw\u00E4hlen und Weiter");
		btnWeiter.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnWeiter.setIcon(new ImageIcon(KundeSuchen.class.getResource("/pics/button_icons/iconfinder_Checkmark_24.png")));
		btnWeiter.addActionListener(new ButtonListener());
		GridBagConstraints gbc_btnWeiter = new GridBagConstraints();
		gbc_btnWeiter.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnWeiter.insets = new Insets(10, 10, 10, 10);
		gbc_btnWeiter.gridx = 1;
		gbc_btnWeiter.gridy = 0;
		pnlBody.add(btnWeiter, gbc_btnWeiter);
		
		JPanel panelTable = new JPanel();
		GridBagConstraints gbc_panelTable = new GridBagConstraints();
		gbc_panelTable.insets = new Insets(0, 10, 10, 10);
		gbc_panelTable.fill = GridBagConstraints.BOTH;
		gbc_panelTable.gridx = 0;
		gbc_panelTable.gridy = 1;
		gbc_panelTable.gridwidth = 2;
		pnlBody.add(panelTable, gbc_panelTable);
		GridBagLayout gbl_panelTable = new GridBagLayout();
		gbl_panelTable.columnWidths = new int[]{0};
		gbl_panelTable.rowHeights = new int[]{0};
		gbl_panelTable.columnWeights = new double[]{1.0};
		gbl_panelTable.rowWeights = new double[]{0.0};
		panelTable.setLayout(gbl_panelTable);
		
		table = new Table();
		table.table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setBackground(Color.WHITE);
		table.setBorder(null);
		table.fillTable("SELECT kunde_id, vorname, name, strasse, plz, ort FROM kunde", colheadsKunde);
		if (auftrag.kunde_id != 0) {
			table.table.changeSelection(auftrag.kunde_id-1, 1, false, false);
		}
		table.table.addKeyListener(new KeyPressedListener());
        table.table.addMouseListener(new MouseClickedListener());
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		panelTable.add(table, gbc_table);
	
	}

	private void next() {
		table.selectRow();
		if (table.id != 0) {
			auftrag.kunde_id = table.id;
			removeAll();				
			add(new functions_AuftragAnlegen.PatientenDaten(auftrag));
			revalidate();
	    	repaint();

			/*if (fertig == 0) {
				schritt++;
				new PatientInfo(auftrag, zahnschema, bearbeitungsstand, arbeitsmaterial, schritt, max, fertig).setVisible(true);
			}
			else if (fertig == 1) {
			//	new AuftragBearbeiten(auftrag, zahnschema, bearbeitungsstand, arbeitsmaterial, fertig).setVisible(true);
			}*/
		}
		else {
			JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen Kunden aus!");
		}		
	} 
	
	
	private class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource().equals(btnWeiter)) {
				next();
			}
			
			else if (e.getSource().equals(pnlNavigation.btnAuftragNummer)) {
			//	if (auftrag.nummer != null) {
					removeAll();				
					add(new functions_AuftragAnlegen.AuftragNummer(auftrag));
					revalidate();
					repaint();	
			/*	}
				else {
					JOptionPane.showMessageDialog(null, "Bitte verwenden Sie den Weiter-Button!");
				}*/
			}
			else if (e.getSource().equals(pnlNavigation.btnPatientenDaten)) {
				if (auftrag.patient_id != 0) {
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Bitte verwenden Sie den Weiter-Button!");
				}
			}
			
		/*	else if (e.getSource().equals(panelButtons.btnClose)) {
				if (fertig == 0) {
					String[] Optionen = {"Ja","Nein"};
					int Auswahl = JOptionPane.showOptionDialog(null,"Wollen Sie wirklich abbrechen? Alle bisherigen Angaben gehen verloren!","Abbruch bestätigen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, Optionen,Optionen[0]);
					if(Auswahl==JOptionPane.YES_OPTION) setVisible(false);
				}
				if (fertig == 1) {
					setVisible(false);
				//	new AuftragBearbeiten(auftrag, zahnschema, bearbeitungsstand, arbeitsmaterial, fertig).setVisible(true);
				}
			}
			
			else if (e.getSource().equals(panelBack.btnBack)) {
				schritt--;
				setVisible(false);
				new AuftragNummer(auftrag, zahnschema, bearbeitungsstand, arbeitsmaterial, schritt, max, fertig).setVisible(true);
			}
			
			else if (e.getSource().equals(btnKundenSuchen)) {
				table.fillTable("SELECT kunde_id, vorname, name, strasse, plz, ort FROM kunde WHERE name LIKE '%" + txtKundenSuchen.getText() + "%'", colheadsKunde);
			}*/
		} 
	}
	
	private class KeyPressedListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent ev) {
			// TODO Auto-generated method stub
			if (ev.getKeyCode() == KeyEvent.VK_ENTER){
			//	next();
			}
			
			if (ev.getSource().equals(txtKundenSuchen)) {
				
				char key = ev.getKeyChar();
				if (ev.getKeyCode() == KeyEvent.VK_BACK_SPACE){
					suchtext = txtKundenSuchen.getText().substring(0, txtKundenSuchen.getText().length()-1);
				}
				else {
					suchtext = txtKundenSuchen.getText() + key;
				}
				table.fillTable("SELECT kunde_id, vorname, name, strasse, plz, ort FROM kunde WHERE name LIKE '" + suchtext + "%'", colheadsKunde);
			//	System.out.println("SELECT kunde_id, vorname, name, strasse, plz, ort FROM kunde WHERE name LIKE '" + suchtext + "%'");
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent ev) {
			// TODO Auto-generated method stub		
		}
		
	}

	
	
	private class MouseClickedListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent ev) {
			// TODO Auto-generated method stub
			if (ev.getClickCount() == 2){
			//	next();
				txtKundenSuchen.setText(table.table.getValueAt(table.table.getSelectedRow(), 1).toString() + " " + table.table.getValueAt(table.table.getSelectedRow(), 2).toString());
	        }
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class TextChangedListener implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent ev) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			suchtext = "";
		//	System.out.println("Hier");
		}
		
	}
	
}


