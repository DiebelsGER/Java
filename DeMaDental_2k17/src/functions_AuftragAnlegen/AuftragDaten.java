package functions_AuftragAnlegen;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import functions_AuftragAnlegen.AuftragNummer.ButtonListener;
import main_Dashboard.PatientenHistorie;
import main_Dashboard.Zahnschema;
import panels_Zahnschema.Quadranten;
import variables.Auftrag;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class AuftragDaten extends JPanel {
	
	private Auftrag auftrag;
	
	private Navigation pnlNavigation;
	
	private JTextField txtAuftragDatum;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtLegierung;
	
	private JComboBox cmbAuftragTyp;
	
	private JButton btnWeiter;
	
	/**
	 * Create the panel.
	 */
	
	
	public AuftragDaten(Auftrag auftrag) {
		setBackground(Color.WHITE);
		
		this.auftrag = auftrag;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0};
		setLayout(gridBagLayout);
		
		pnlNavigation = new Navigation();
		GridBagConstraints gbc_pnl_navigation = new GridBagConstraints();
		gbc_pnl_navigation.insets = new Insets(10, 10, 10, 10);
		gbc_pnl_navigation.fill = GridBagConstraints.BOTH;
		gbc_pnl_navigation.gridx = 0;
		gbc_pnl_navigation.gridy = 0;
		add(pnlNavigation, gbc_pnl_navigation);
		
		if (auftrag.nummer != null) {
			pnlNavigation.btnAuftragNummer.setIcon(new ImageIcon(Navigation.class.getResource("/pics/button_icons/iconfinder_Tick_Mark.png")));
		}
		if (auftrag.kunde_id == 0) {
			pnlNavigation.btnKundenAuswhlen.setEnabled(false);
		}
		else {
			pnlNavigation.btnKundenAuswhlen.addActionListener(new ButtonListener());
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
		
		JLabel lblAuftragdatenAngeben = new JLabel("4. Auftrag-Daten angeben");
		lblAuftragdatenAngeben.setFont(new Font("Verdana", Font.BOLD, 16));
		lblAuftragdatenAngeben.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblAuftragdatenAngeben = new GridBagConstraints();
		gbc_lblAuftragdatenAngeben.insets = new Insets(10, 10, 10, 10);
		gbc_lblAuftragdatenAngeben.gridx = 0;
		gbc_lblAuftragdatenAngeben.gridy = 0;
		pnlTitle.add(lblAuftragdatenAngeben, gbc_lblAuftragdatenAngeben);
		
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
		gbl_pnlBody.rowHeights = new int[]{0, 0};
		gbl_pnlBody.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlBody.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlBody.setLayout(gbl_pnlBody);
		
		JPanel pnlAuftrag = new JPanel();
		pnlAuftrag.setBorder(new LineBorder(Color.GRAY));
		pnlAuftrag.setBackground(Color.WHITE);
		GridBagConstraints gbc_pnlAuftrag = new GridBagConstraints();
		gbc_pnlAuftrag.anchor = GridBagConstraints.WEST;
		gbc_pnlAuftrag.insets = new Insets(10, 10, 10, 10);
		gbc_pnlAuftrag.fill = GridBagConstraints.VERTICAL;
		gbc_pnlAuftrag.gridx = 0;
		gbc_pnlAuftrag.gridy = 0;
		pnlBody.add(pnlAuftrag, gbc_pnlAuftrag);
		GridBagLayout gbl_pnlAuftrag = new GridBagLayout();
		gbl_pnlAuftrag.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlAuftrag.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlAuftrag.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlAuftrag.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlAuftrag.setLayout(gbl_pnlAuftrag);
		
		JLabel lblAuftragDatum = new JLabel("Auftrag-Datum");
		lblAuftragDatum.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAuftragDatum = new GridBagConstraints();
		gbc_lblAuftragDatum.insets = new Insets(10, 10, 10, 10);
		gbc_lblAuftragDatum.anchor = GridBagConstraints.EAST;
		gbc_lblAuftragDatum.gridx = 0;
		gbc_lblAuftragDatum.gridy = 0;
		pnlAuftrag.add(lblAuftragDatum, gbc_lblAuftragDatum);
		
		txtAuftragDatum = new JTextField();
		txtAuftragDatum.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_txtAuftragDatum = new GridBagConstraints();
		gbc_txtAuftragDatum.insets = new Insets(10, 0, 10, 10);
		gbc_txtAuftragDatum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAuftragDatum.gridx = 1;
		gbc_txtAuftragDatum.gridy = 0;
		pnlAuftrag.add(txtAuftragDatum, gbc_txtAuftragDatum);
		txtAuftragDatum.setColumns(10);
		
		JLabel lblAuftragTyp = new JLabel("Auftrag-Typ");
		lblAuftragTyp.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAuftragTyp = new GridBagConstraints();
		gbc_lblAuftragTyp.anchor = GridBagConstraints.EAST;
		gbc_lblAuftragTyp.insets = new Insets(10, 10, 10, 10);
		gbc_lblAuftragTyp.gridx = 2;
		gbc_lblAuftragTyp.gridy = 0;
		pnlAuftrag.add(lblAuftragTyp, gbc_lblAuftragTyp);
		
		cmbAuftragTyp = new JComboBox();
		cmbAuftragTyp.setModel(new DefaultComboBoxModel(new String[] {"Neuer Auftrag", "Reparatur", "Kulanz"}));
		cmbAuftragTyp.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_cmbAuftragTyp = new GridBagConstraints();
		gbc_cmbAuftragTyp.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbAuftragTyp.insets = new Insets(10, 0, 10, 10);
		gbc_cmbAuftragTyp.gridx = 3;
		gbc_cmbAuftragTyp.gridy = 0;
		pnlAuftrag.add(cmbAuftragTyp, gbc_cmbAuftragTyp);
		
		JLabel lblArtDerArbeit = new JLabel("Art der Arbeit");
		lblArtDerArbeit.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblArtDerArbeit = new GridBagConstraints();
		gbc_lblArtDerArbeit.anchor = GridBagConstraints.EAST;
		gbc_lblArtDerArbeit.insets = new Insets(0, 10, 10, 10);
		gbc_lblArtDerArbeit.gridx = 0;
		gbc_lblArtDerArbeit.gridy = 1;
		pnlAuftrag.add(lblArtDerArbeit, gbc_lblArtDerArbeit);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 10, 10);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		pnlAuftrag.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblZahnfarbe = new JLabel("Zahnfarbe");
		lblZahnfarbe.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblZahnfarbe = new GridBagConstraints();
		gbc_lblZahnfarbe.anchor = GridBagConstraints.EAST;
		gbc_lblZahnfarbe.insets = new Insets(0, 10, 10, 10);
		gbc_lblZahnfarbe.gridx = 0;
		gbc_lblZahnfarbe.gridy = 2;
		pnlAuftrag.add(lblZahnfarbe, gbc_lblZahnfarbe);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 10, 10);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		pnlAuftrag.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLegierung = new JLabel("Legierung");
		lblLegierung.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLegierung = new GridBagConstraints();
		gbc_lblLegierung.anchor = GridBagConstraints.EAST;
		gbc_lblLegierung.insets = new Insets(0, 0, 10, 10);
		gbc_lblLegierung.gridx = 2;
		gbc_lblLegierung.gridy = 2;
		pnlAuftrag.add(lblLegierung, gbc_lblLegierung);
		
		txtLegierung = new JTextField();
		txtLegierung.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_txtLegierung = new GridBagConstraints();
		gbc_txtLegierung.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLegierung.insets = new Insets(0, 0, 10, 10);
		gbc_txtLegierung.gridx = 3;
		gbc_txtLegierung.gridy = 2;
		pnlAuftrag.add(txtLegierung, gbc_txtLegierung);
		txtLegierung.setColumns(10);
		
		btnWeiter = new JButton("Weiter");
		btnWeiter.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnWeiter.setIcon(new ImageIcon(AuftragDaten.class.getResource("/pics/button_icons/iconfinder_Checkmark_24.png")));
		btnWeiter.addActionListener(new ButtonListener());
		GridBagConstraints gbc_btnWeiter = new GridBagConstraints();
		gbc_btnWeiter.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnWeiter.insets = new Insets(10, 10, 10, 10);
		gbc_btnWeiter.gridx = 1;
		gbc_btnWeiter.gridy = 0;
		pnlBody.add(btnWeiter, gbc_btnWeiter);

	}
	
private void next() {
	
	if (cmbAuftragTyp.getSelectedIndex() == 0) {
		new Zahnschema().setVisible(true);
	}
		
	/*	if (!(txtAuftragNummer.getText().trim().equals(""))) {
			
			if (at.checkAuftragNummer(txtAuftragNummer.getText()) == 0) {
				
				auftrag.nummer = txtAuftragNummer.getText();
				removeAll();				
				add(new panels_AuftragAnlegen.KundeSuchen(auftrag));
				revalidate();
		    	repaint(); */
		    	
		    	
			/*	if (fertig == 0) {
					schritt++;
					new KundeSuchen(auftrag, zahnschema, bearbeitungsstand, arbeitsmaterial, schritt, max, fertig).setVisible(true);
				}
				else if (fertig == 1) {
				//	new AuftragBearbeiten(auftrag, zahnschema, bearbeitungsstand, arbeitsmaterial, fertig).setVisible(true);
				} 
			}
			else {		
				JOptionPane.showMessageDialog(null, "Die eingegebene Auftrags-Nummer ist bereits vergeben!");
			}
		}			
		else {	
			JOptionPane.showMessageDialog(null, "Bitte geben Sie eine Auftrags-Nummer ein!");
		} */
	} 
	
	class ButtonListener implements ActionListener {
		
	
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource().equals(btnWeiter)) {
				next();
			}
		/*	else if (e.getSource().equals(btnNummerSuchen)) {
				txtAuftragNummer.setText(at.freieAuftragNummerSuchen());
			}
			else if (e.getSource().equals(pnlNavigation.btnKundenAuswhlen)) {
				if (auftrag.nummer != null) {
					removeAll();				
					add(new panels_AuftragAnlegen.KundeSuchen(auftrag));
					revalidate();
					repaint();	
				}
				else {
					JOptionPane.showMessageDialog(null, "Bitte verwenden Sie den Weiter-Button!");
				}
			}
			else if (e.getSource().equals(pnlNavigation.btnPatientenDaten)) {
				removeAll();				
				add(new panels_AuftragAnlegen.PatientenDaten(auftrag));
				revalidate();
				repaint();
			} */
			
		}
		
				
			//	AuftragNummer an = new AuftragNummer(auftrag);
			//	headerText = "Neuen Auftrag erfassen";
			//	iconImage = "plus";
			//	System.out.println("HHier");
			/*	if (Main.desk.countComponents() == 1) {
					Auftrag auftrag = new Auftrag();
					auftrag.benutzer_id = benutzer_id;
					an = new AuftragNummer(auftrag);
					Main.desk.add(an);
					an.setVisible(true);
				}  *
				
			//	Main.desk.add(an);
			//	an.setVisible(true);
				
			//	System.out.println(auftrag.benutzer_id);
			//	pnl_Main = new AuftragAnlegen(auftrag);

			}
			
			else if (e.getSource().equals(btnAuftragSuchen)) {
				if (Main.desk.countComponents() == 1) {
					Auftrag auftrag = new Auftrag();
					auftrag.benutzer_id = benutzer_id;
					as = new AuftragSuchen(auftrag.benutzer_id);
					Main.desk.add(as);
					as.setVisible(true);
				} 
			}
			
		//	lbl_Header.setText(headerText);
		//	lbl_Header.setIcon(new ImageIcon(Main.class.getResource("/pics/title_icons/" + iconImage + ".png")));
		/*	contentPane.add(pnl_Main, gbc_pnl_Main);
			revalidate();
    		repaint(); */

			
		

	}

}
