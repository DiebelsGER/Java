package functions_AuftragAnlegen;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.border.LineBorder;

import components.OkCloseButtons;
import interfaces.TextLabels;
import variables.Auftrag;
import mysql.tables.AuftragTabelle;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class AuftragNummer extends JPanel implements TextLabels {
	
	private AuftragTabelle at = new AuftragTabelle();
	
	private Auftrag auftrag;
	
	private Navigation pnlNavigation;
	private JTextField txtAuftragNummer;
	private JButton btnWeiter;
	private JButton btnNummerSuchen;
	
	/**
	 * Create the panel.
	 */
	public AuftragNummer(Auftrag auftrag) {
		
		this.auftrag = auftrag;
		
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		setLayout(gridBagLayout);
		
		pnlNavigation = new Navigation();
		GridBagConstraints gbc_pnl_navigation = new GridBagConstraints();
		gbc_pnl_navigation.insets = new Insets(10, 10, 10, 10);
		gbc_pnl_navigation.fill = GridBagConstraints.BOTH;
		gbc_pnl_navigation.gridx = 0;
		gbc_pnl_navigation.gridy = 0;
		add(pnlNavigation, gbc_pnl_navigation);
		
	//	pnlNavigation.btnAuftragNummer.addActionListener(new ButtonListener());
		pnlNavigation.btnAuftragNummer.setEnabled(false);
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
		pnlTitle.setBackground(SystemColor.textHighlight);
		GridBagConstraints gbc_pnlTitle = new GridBagConstraints();
		gbc_pnlTitle.fill = GridBagConstraints.BOTH;
		gbc_pnlTitle.insets = new Insets(0,10,10,10);
		gbc_pnlTitle.gridx = 0;
		gbc_pnlTitle.gridy = 1;
		add(pnlTitle, gbc_pnlTitle);
		GridBagLayout gbl_pnlTitle = new GridBagLayout();
		gbl_pnlTitle.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlTitle.rowHeights = new int[]{0, 0};
		gbl_pnlTitle.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlTitle.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlTitle.setLayout(gbl_pnlTitle);
		
		JLabel lblTitle = new JLabel("1. Auftrag-Nummer vergeben");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitle.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(15,15,15,15);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		pnlTitle.add(lblTitle, gbc_lblTitle);
		
		JPanel pnlBody = new JPanel();
		pnlBody.setBorder(new LineBorder(Color.GRAY));
		GridBagConstraints gbc_pnlBody = new GridBagConstraints();
		gbc_pnlBody.fill = GridBagConstraints.BOTH;
		gbc_pnlBody.insets = new Insets(0, 10, 10, 10);
		gbc_pnlBody.gridx = 0;
		gbc_pnlBody.gridy = 2;
		add(pnlBody, gbc_pnlBody);
		GridBagLayout gbl_pnlBody = new GridBagLayout();
		gbl_pnlBody.columnWidths = new int[]{0, 0, 0};
		gbl_pnlBody.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlBody.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlBody.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlBody.setLayout(gbl_pnlBody);
		
		JLabel lblAuftragnummer = new JLabel("Auftrag-Nummer");
		lblAuftragnummer.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAuftragnummer = new GridBagConstraints();
		gbc_lblAuftragnummer.anchor = GridBagConstraints.WEST;
		gbc_lblAuftragnummer.insets = new Insets(10, 10, 10, 10);
		gbc_lblAuftragnummer.gridx = 0;
		gbc_lblAuftragnummer.gridy = 0;
		pnlBody.add(lblAuftragnummer, gbc_lblAuftragnummer);
		
		txtAuftragNummer = new JTextField(auftrag.nummer);
		txtAuftragNummer.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtAuftragNummer.addKeyListener(new TextFieldListener());
		GridBagConstraints gbc_txtAuftragNummer = new GridBagConstraints();
		gbc_txtAuftragNummer.fill = GridBagConstraints.BOTH;
		gbc_txtAuftragNummer.insets = new Insets(0, 10, 15, 10);
		gbc_txtAuftragNummer.gridx = 0;
		gbc_txtAuftragNummer.gridy = 1;
		pnlBody.add(txtAuftragNummer, gbc_txtAuftragNummer);
		txtAuftragNummer.setColumns(20);
		
		//Focus ins Textfield "Auftrag Nummer"
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				txtAuftragNummer.requestFocus();
			}
		}); 
		
		btnWeiter = new JButton("Auftrag-Nummer vergeben");
		btnWeiter.setIcon(new ImageIcon(AuftragNummer.class.getResource("/pics/button_icons/iconfinder_Checkmark_24.png")));
		btnWeiter.addActionListener(new ButtonListener());
		btnWeiter.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_btnWeiter = new GridBagConstraints();
		gbc_btnWeiter.fill = GridBagConstraints.VERTICAL;
		gbc_btnWeiter.insets = new Insets(0, 10, 15, 10);
		gbc_btnWeiter.anchor = GridBagConstraints.WEST;
		gbc_btnWeiter.gridx = 1;
		gbc_btnWeiter.gridy = 1;
		pnlBody.add(btnWeiter, gbc_btnWeiter);
		
		btnNummerSuchen = new JButton("Nächste freie Auftrag-Nummer ermitteln");
		btnNummerSuchen.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnNummerSuchen.setIcon(new ImageIcon(AuftragNummer.class.getResource("/pics/button_icons/zoom.png")));
		btnNummerSuchen.addActionListener(new ButtonListener());
		GridBagConstraints gbc_btnNummerSuchen = new GridBagConstraints();
		gbc_btnNummerSuchen.anchor = GridBagConstraints.EAST;
		gbc_btnNummerSuchen.insets = new Insets(0, 10, 10, 10);
		gbc_btnNummerSuchen.gridx = 0;
		gbc_btnNummerSuchen.gridy = 2;
		pnlBody.add(btnNummerSuchen, gbc_btnNummerSuchen);

	}
	
	private void next() {
		
		if (!(txtAuftragNummer.getText().trim().equals(""))) {
			
			if (at.checkAuftragNummer(txtAuftragNummer.getText()) == 0) {
				
				auftrag.nummer = txtAuftragNummer.getText();
				removeAll();				
				add(new functions_AuftragAnlegen.KundeSuchen(auftrag));
				revalidate();
		    	repaint();
		    	
		    	
			/*	if (fertig == 0) {
					schritt++;
					new KundeSuchen(auftrag, zahnschema, bearbeitungsstand, arbeitsmaterial, schritt, max, fertig).setVisible(true);
				}
				else if (fertig == 1) {
				//	new AuftragBearbeiten(auftrag, zahnschema, bearbeitungsstand, arbeitsmaterial, fertig).setVisible(true);
				} */
			}
			else {		
				JOptionPane.showMessageDialog(null, "Die eingegebene Auftrags-Nummer ist bereits vergeben!");
			}
		}			
		else {	
			JOptionPane.showMessageDialog(null, "Bitte geben Sie eine Auftrags-Nummer ein!");
		}
	} 
	
	class ButtonListener implements ActionListener {
		
	
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource().equals(btnWeiter)) {
				next();
			}
			else if (e.getSource().equals(btnNummerSuchen)) {
				txtAuftragNummer.setText(at.freieAuftragNummerSuchen());
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
			else if (e.getSource().equals(pnlNavigation.btnPatientenDaten)) {
				removeAll();				
				add(new functions_AuftragAnlegen.PatientenDaten(auftrag));
				revalidate();
				repaint();
			}
			
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
	
	class TextFieldListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent ev) {
			// TODO Auto-generated method stub
			if (ev.getKeyCode() == KeyEvent.VK_ENTER){
				next();		
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}


}
