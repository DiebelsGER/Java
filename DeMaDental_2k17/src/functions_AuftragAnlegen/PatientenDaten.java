package functions_AuftragAnlegen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import variables.Auftrag;
import interfaces.TextLabels;
import main_Dashboard.Main;
import main_Dashboard.PatientenHistorie;
import components.Table;
import components.TableList;
import components.List;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTable;

public class PatientenDaten extends JPanel implements TextLabels  {
	
	private Auftrag auftrag;
		
	private Navigation pnlNavigation;
	private Table table;
	
	private JTextField txtPatientName;
	private JTextField txtImpexPlus;
	private JLabel lblTablePatient;
	private JButton btnAuftragHistorie;
	private JButton btnWeiter;
	
	private JRadioButton rdbtnGkv;
	private JRadioButton rdbtnPkv;
	private ButtonGroup group;
	
	private String suchtext;

	public PatientenDaten(Auftrag auftrag) {
		
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
		pnlNavigation.btnKundenAuswhlen.addActionListener(new ButtonListener());
		pnlNavigation.btnKundenAuswhlen.setIcon(new ImageIcon(Navigation.class.getResource("/pics/button_icons/iconfinder_Tick_Mark.png")));
		pnlNavigation.btnPatientenDaten.setEnabled(false);
		if (auftrag.patient_id != 0) {
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
		
		JLabel lblPatientDaten = new JLabel("3. Patienten-Daten erfassen");
		lblPatientDaten.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPatientDaten.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPatientDaten = new GridBagConstraints();
		gbc_lblPatientDaten.insets = new Insets(10, 10, 10, 10);
		gbc_lblPatientDaten.gridx = 0;
		gbc_lblPatientDaten.gridy = 0;
		pnlTitle.add(lblPatientDaten, gbc_lblPatientDaten);
		
		JPanel pnlBody = new JPanel();
		pnlBody.setBorder(new LineBorder(Color.GRAY));
		GridBagConstraints gbc_pnlBody = new GridBagConstraints();
		gbc_pnlBody.insets = new Insets(0, 10, 10, 10);
		gbc_pnlBody.fill = GridBagConstraints.BOTH;
		gbc_pnlBody.gridx = 0;
		gbc_pnlBody.gridy = 2;
		add(pnlBody, gbc_pnlBody);
		GridBagLayout gbl_pnlBody = new GridBagLayout();
		gbl_pnlBody.columnWidths = new int[]{0, 0, 0};
		gbl_pnlBody.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlBody.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlBody.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		pnlBody.setLayout(gbl_pnlBody);
		
		JPanel pnlPatientDaten = new JPanel();
		pnlPatientDaten.setBorder(new LineBorder(Color.GRAY));
		pnlPatientDaten.setBackground(Color.WHITE);
		GridBagConstraints gbc_pnlPatientDaten = new GridBagConstraints();
		gbc_pnlPatientDaten.insets = new Insets(10, 10, 10, 10);
		gbc_pnlPatientDaten.fill = GridBagConstraints.BOTH;
		gbc_pnlPatientDaten.gridx = 0;
		gbc_pnlPatientDaten.gridy = 0;
		pnlBody.add(pnlPatientDaten, gbc_pnlPatientDaten);
		GridBagLayout gbl_pnlPatientDaten = new GridBagLayout();
		gbl_pnlPatientDaten.columnWidths = new int[]{0, 0, 0};
		gbl_pnlPatientDaten.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlPatientDaten.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlPatientDaten.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlPatientDaten.setLayout(gbl_pnlPatientDaten);
		
		JLabel lblPatientName = new JLabel("Name des Patienten");
		lblPatientName.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPatientName = new GridBagConstraints();
		gbc_lblPatientName.anchor = GridBagConstraints.EAST;
		gbc_lblPatientName.insets = new Insets(10, 10, 10, 10);
		gbc_lblPatientName.gridx = 0;
		gbc_lblPatientName.gridy = 0;
		pnlPatientDaten.add(lblPatientName, gbc_lblPatientName);
		
		txtPatientName = new JTextField();
		txtPatientName.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtPatientName.addKeyListener(new KeyPressedListener());
		GridBagConstraints gbc_txtPatientName = new GridBagConstraints();
		gbc_txtPatientName.anchor = GridBagConstraints.NORTH;
		gbc_txtPatientName.insets = new Insets(10, 0, 10, 10);
		gbc_txtPatientName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPatientName.gridx = 1;
		gbc_txtPatientName.gridy = 0;
		pnlPatientDaten.add(txtPatientName, gbc_txtPatientName);
		txtPatientName.setColumns(20);
		
		JButton btnPatientSuchen = new JButton("Patienten suchen");
		btnPatientSuchen.setIcon(new ImageIcon(PatientenDaten.class.getResource("/pics/button_icons/zoom.png")));
		btnPatientSuchen.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_btnPatientSuchen = new GridBagConstraints();
		gbc_btnPatientSuchen.anchor = GridBagConstraints.EAST;
		gbc_btnPatientSuchen.insets = new Insets(0, 10, 10, 10);
		gbc_btnPatientSuchen.gridx = 1;
		gbc_btnPatientSuchen.gridy = 1;
		pnlPatientDaten.add(btnPatientSuchen, gbc_btnPatientSuchen);
		
		JLabel lblVersicherung = new JLabel("Versicherung");
		lblVersicherung.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblVersicherung = new GridBagConstraints();
		gbc_lblVersicherung.anchor = GridBagConstraints.EAST;
		gbc_lblVersicherung.insets = new Insets(5, 10, 10, 10);
		gbc_lblVersicherung.gridx = 0;
		gbc_lblVersicherung.gridy = 2;
		pnlPatientDaten.add(lblVersicherung, gbc_lblVersicherung);
		
		JPanel pnlVersicherung = new JPanel();
		pnlVersicherung.setBackground(Color.WHITE);
		GridBagConstraints gbc_pnlVersicherung = new GridBagConstraints();
		gbc_pnlVersicherung.insets = new Insets(10, 0, 10, 10);
		gbc_pnlVersicherung.fill = GridBagConstraints.BOTH;
		gbc_pnlVersicherung.gridx = 1;
		gbc_pnlVersicherung.gridy = 2;
		pnlPatientDaten.add(pnlVersicherung, gbc_pnlVersicherung);
		GridBagLayout gbl_pnlVersicherung = new GridBagLayout();
		gbl_pnlVersicherung.columnWidths = new int[]{0, 0, 0};
		gbl_pnlVersicherung.rowHeights = new int[]{0, 0};
		gbl_pnlVersicherung.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlVersicherung.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlVersicherung.setLayout(gbl_pnlVersicherung);
		
		rdbtnGkv = new JRadioButton("GKV");
		rdbtnGkv.setFont(new Font("Verdana", Font.PLAIN, 12));
		rdbtnGkv.setBackground(Color.WHITE);
		rdbtnGkv.setSelected(true);
		GridBagConstraints gbc_rdbtnGkv = new GridBagConstraints();
		gbc_rdbtnGkv.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnGkv.gridx = 0;
		gbc_rdbtnGkv.gridy = 0;
		pnlVersicherung.add(rdbtnGkv, gbc_rdbtnGkv);
		
		rdbtnPkv = new JRadioButton("PKV");
		rdbtnPkv.setFont(new Font("Verdana", Font.PLAIN, 12));
		rdbtnPkv.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnPkv = new GridBagConstraints();
		gbc_rdbtnPkv.gridx = 1;
		gbc_rdbtnPkv.gridy = 0;
		pnlVersicherung.add(rdbtnPkv, gbc_rdbtnPkv);
		
		group = new ButtonGroup();
		group.add(rdbtnGkv);
		group.add(rdbtnPkv);
		
		JLabel lblImpexPlus = new JLabel("IMPEX plus-Nr.");
		lblImpexPlus.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblImpexPlus = new GridBagConstraints();
		gbc_lblImpexPlus.anchor = GridBagConstraints.EAST;
		gbc_lblImpexPlus.insets = new Insets(0, 10, 10, 10);
		gbc_lblImpexPlus.gridx = 0;
		gbc_lblImpexPlus.gridy = 3;
		pnlPatientDaten.add(lblImpexPlus, gbc_lblImpexPlus);
		
		txtImpexPlus = new JTextField();
		txtImpexPlus.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_txtImpexPlus = new GridBagConstraints();
		gbc_txtImpexPlus.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtImpexPlus.insets = new Insets(0, 0, 10, 10);
		gbc_txtImpexPlus.gridx = 1;
		gbc_txtImpexPlus.gridy = 3;
		pnlPatientDaten.add(txtImpexPlus, gbc_txtImpexPlus);
		txtImpexPlus.setColumns(20);
		
		btnWeiter = new JButton("Ausw\u00E4hen und Weiter");
		btnWeiter.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnWeiter.setIcon(new ImageIcon(PatientenDaten.class.getResource("/pics/button_icons/iconfinder_Checkmark_24.png")));
		btnWeiter.addActionListener(new ButtonListener());
		GridBagConstraints gbc_btnWeiter = new GridBagConstraints();
		gbc_btnWeiter.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnWeiter.insets = new Insets(10, 10, 10, 10);
		gbc_btnWeiter.gridx = 1;
		gbc_btnWeiter.gridy = 0;
		pnlBody.add(btnWeiter, gbc_btnWeiter);
		
		JPanel pnlTableTitle = new JPanel();
		pnlTableTitle.setBorder(new LineBorder(Color.GRAY));
		pnlTableTitle.setBackground(Color.WHITE);
		GridBagConstraints gbc_pnlTableTitle = new GridBagConstraints();
		gbc_pnlTableTitle.anchor = GridBagConstraints.WEST;
		gbc_pnlTableTitle.insets = new Insets(0, 10, 10, 10);
		gbc_pnlTableTitle.fill = GridBagConstraints.VERTICAL;
		gbc_pnlTableTitle.gridx = 0;
		gbc_pnlTableTitle.gridy = 1;
		pnlBody.add(pnlTableTitle, gbc_pnlTableTitle);
		GridBagLayout gbl_pnlTableTitle = new GridBagLayout();
		gbl_pnlTableTitle.columnWidths = new int[]{0, 0, 0};
		gbl_pnlTableTitle.rowHeights = new int[]{0, 0};
		gbl_pnlTableTitle.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlTableTitle.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlTableTitle.setLayout(gbl_pnlTableTitle);
		
		JLabel lblAuftragPatient = new JLabel("Alle Aufträge von ");
		lblAuftragPatient.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblAuftragPatient = new GridBagConstraints();
		gbc_lblAuftragPatient.insets = new Insets(10, 10, 10, 0);
		gbc_lblAuftragPatient.gridx = 0;
		gbc_lblAuftragPatient.gridy = 0;
		pnlTableTitle.add(lblAuftragPatient, gbc_lblAuftragPatient);
		
		lblTablePatient = new JLabel("(kein Patient ausgewählt)");
		lblTablePatient.setFont(new Font("Verdana", Font.ITALIC, 12));
		GridBagConstraints gbc_lblTablePatient = new GridBagConstraints();
		gbc_lblTablePatient.insets = new Insets(10, 0, 10, 10);
		gbc_lblTablePatient.gridx = 1;
		gbc_lblTablePatient.gridy = 0;
		pnlTableTitle.add(lblTablePatient, gbc_lblTablePatient);
		
		JPanel panelTable = new JPanel();
		GridBagConstraints gbc_panelTable = new GridBagConstraints();
		gbc_panelTable.gridwidth = 2;
		gbc_panelTable.insets = new Insets(0, 10, 10, 10);
		gbc_panelTable.fill = GridBagConstraints.BOTH;
		gbc_panelTable.gridx = 0;
		gbc_panelTable.gridy = 2;
		pnlBody.add(panelTable, gbc_panelTable);
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
		table.fillTable("SELECT p.patient_id, p.name, v.name, p.impex_plus FROM patient p, versicherung v WHERE p.versicherung_id = v.versicherung_id ORDER BY p.name ASC", colheadsPatienten);
		table.removeIdColumn(0);
//		table.table.addKeyListener(new KeyPressedListener());
        table.table.addMouseListener(new MouseClickedListener());
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		panelTable.add(table, gbc_table);
		
		btnAuftragHistorie = new JButton("Auftrag-Historie von ausgew\u00E4hltem Patienten anzeigen");
		btnAuftragHistorie.setIcon(new ImageIcon(PatientenDaten.class.getResource("/pics/button_icons/iconfinder_file_search_48764.png")));
		btnAuftragHistorie.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnAuftragHistorie.addActionListener(new ButtonListener());
		GridBagConstraints gbc_btnAuftragHistorie = new GridBagConstraints();
		gbc_btnAuftragHistorie.insets = new Insets(0,10,10,10);
		gbc_btnAuftragHistorie.gridwidth = 2;
		gbc_btnAuftragHistorie.anchor = GridBagConstraints.EAST;
		gbc_btnAuftragHistorie.gridx = 0;
		gbc_btnAuftragHistorie.gridy = 3;
		pnlBody.add(btnAuftragHistorie, gbc_btnAuftragHistorie);
		
	}
	
	private class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource().equals(btnWeiter)) {
				if (table.table.getSelectedRow() != -1) {
					String patId = table.getBackId(0);
					auftrag.patient_id = Integer.parseInt(patId);
					removeAll();				
					add(new functions_AuftragAnlegen.AuftragDaten(auftrag));
					revalidate();
					repaint();
				}
				else {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen Patienten aus!");
				}
				//next();
			}
			else if (e.getSource().equals(btnAuftragHistorie)) {
				if (table.table.getSelectedRow() != -1) {
					String patId = table.getBackId(0);
					auftrag.patient_id = Integer.parseInt(patId);
					new PatientenHistorie(auftrag).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen Patienten aus!");
				}
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
			else if (e.getSource().equals(pnlNavigation.btnKundenAuswhlen)) {
				if (auftrag.nummer != null) {
					removeAll();				
					add(new functions_AuftragAnlegen.KundeSuchen(auftrag));
					revalidate();
					repaint();	
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
	
	private class MouseClickedListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent ev) {
			// TODO Auto-generated method stub
			if (ev.getClickCount() == 2){
				txtPatientName.setText(table.table.getValueAt(table.table.getSelectedRow(), 0).toString());
				if (table.table.getValueAt(table.table.getSelectedRow(), 2) != null) {
					txtImpexPlus.setText(table.table.getValueAt(table.table.getSelectedRow(), 2).toString());
				}
				else {
					txtImpexPlus.setText("");
				}
				if (table.table.getValueAt(table.table.getSelectedRow(), 1).toString().equals("Kasse")) {
					rdbtnGkv.setSelected(true);
				}
				else if (table.table.getValueAt(table.table.getSelectedRow(), 1).toString().equals("Privat")) {
					rdbtnPkv.setSelected(true);
				}
			}
				//	String patientName = (String) tableList.table.getValueAt(tableList.table.getSelectedRow(),1);
				//	System.out.println(patientName);
				//	txtPatientName.setText(patientName);
				//	txtImpexPlus.setText("SELECT id, impex-plus FROM patient WHERE name = '" + patientName + "'");
				//	lblTablePatient.setText(patientName);
				//	table.fillTable("SELECT DATE_FORMAT(a.datum, '%d.%m.%Y'), a.nummer, a.arbeitsart, k.name, at.name, REPLACE(a.erledigt,'0','Offen'), REPLACE(a.erledigt,'1','Abgeschlossen') FROM auftrag a, auftrag_typ at, " +
				//			"kieferbereich k, patient p WHERE p.patient_id = '" + id + "' AND at.auftrag_typ_id = a.auftrag_typ_id AND " +
				//			"k.kieferbereich_id = a.kieferbereich_id AND p.patient_id = a.patient_id ORDER BY a.datum DESC", colheadsPatientAuftrag); 
				
	        
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
	
	private class KeyPressedListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent ev) {
			// TODO Auto-generated method stub
			if (ev.getKeyCode() == KeyEvent.VK_ENTER){
			//	next();
			}
			
			if (ev.getSource().equals(txtPatientName)) {
				
				char key = ev.getKeyChar();
				if (ev.getKeyCode() == KeyEvent.VK_BACK_SPACE){
					suchtext = txtPatientName.getText().substring(0, txtPatientName.getText().length()-1);
				}
				else {
					suchtext = txtPatientName.getText() + key;
				}
				table.fillTable("SELECT p.patient_id, p.name, v.name, p.impex_plus FROM patient p, versicherung v WHERE p.versicherung_id = v.versicherung_id AND p.name LIKE '" + suchtext + "%' ORDER BY p.name ASC", colheadsPatienten);
				table.removeIdColumn(0);
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


}
