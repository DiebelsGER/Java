package functions_AuftragAnlegen;

import javax.swing.JPanel;

import main_Dashboard.Main;

import java.awt.GridBagLayout;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import variables.Auftrag;

public class Navigation extends JPanel {
		
	private Auftrag auftrag;
	
	public JButton btnAuftragNummer;
	public JButton btnKundenAuswhlen;
	public JButton btnPatientenDaten;
	public JButton btnAuftragDaten;
	
	/**
	 * Create the panel.
	 */
	public Navigation() {
						
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnAuftragNummer = new JButton("1. Auftrag-Nummer vergeben");
		GridBagConstraints gbc_btnAuftragNummer = new GridBagConstraints();
		gbc_btnAuftragNummer.insets = new Insets(0, 0, 0, 5);
		gbc_btnAuftragNummer.gridx = 0;
		gbc_btnAuftragNummer.gridy = 0;
		add(btnAuftragNummer, gbc_btnAuftragNummer);
		btnAuftragNummer.addActionListener(new ButtonListener());
		btnAuftragNummer.setForeground(new Color(51, 51, 51));
		btnAuftragNummer.setBackground(new Color(222, 222, 222));
		btnAuftragNummer.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnAuftragNummer.setPreferredSize(new Dimension(250, 50));
		
		btnKundenAuswhlen = new JButton("2. Kunden auswählen");
		GridBagConstraints gbc_btnKundenAuswhlen = new GridBagConstraints();
		gbc_btnKundenAuswhlen.insets = new Insets(0, 0, 0, 5);
		gbc_btnKundenAuswhlen.gridx = 1;
		gbc_btnKundenAuswhlen.gridy = 0;
		add(btnKundenAuswhlen, gbc_btnKundenAuswhlen);
		btnKundenAuswhlen.addActionListener(new ButtonListener());
		btnKundenAuswhlen.setForeground(new Color(51, 51, 51));
		btnKundenAuswhlen.setBackground(new Color(222, 222, 222));
		btnKundenAuswhlen.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnKundenAuswhlen.setPreferredSize(new Dimension(250, 50));
		
		btnPatientenDaten = new JButton("3. Patienten-Daten erfassen");
		GridBagConstraints gbc_btnPatientenDaten = new GridBagConstraints();
		gbc_btnPatientenDaten.insets = new Insets(0, 0, 0, 5);
		gbc_btnPatientenDaten.gridx = 2;
		gbc_btnPatientenDaten.gridy = 0;
		add(btnPatientenDaten, gbc_btnPatientenDaten);
		btnPatientenDaten.addActionListener(new ButtonListener());
		btnPatientenDaten.setForeground(new Color(51, 51, 51));
		btnPatientenDaten.setBackground(new Color(222, 222, 222));
		btnPatientenDaten.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnPatientenDaten.setPreferredSize(new Dimension(250, 50));
		
		btnAuftragDaten = new JButton("4. Auftrag-Daten erfassen");
		GridBagConstraints gbc_btnAuftragDaten = new GridBagConstraints();
		gbc_btnAuftragDaten.gridx = 3;
		gbc_btnAuftragDaten.gridy = 0;
		add(btnAuftragDaten, gbc_btnAuftragDaten);
		btnAuftragDaten.addActionListener(new ButtonListener());
		btnAuftragDaten.setForeground(new Color(51, 51, 51));
		btnAuftragDaten.setBackground(new Color(222, 222, 222));
		btnAuftragDaten.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnAuftragDaten.setPreferredSize(new Dimension(250, 50));

	}
	
class ButtonListener implements ActionListener { 
		
        public void actionPerformed(ActionEvent e) {
        	
       // 	removeAll();
        	        	
        	
        	
        /*	remove(pnl_Main);
        	
        	if (e.getSource().equals(btn_Number)) {

        		text = "1. Auftrag-Nummer vergeben";
        		pnl_Main = new pnl_no1_Number(order);
        		btn_Number.setEnabled(false); 
			}
			
			else if (e.getSource().equals(btn_Customer)) {

				text = "2. Kunden auswählen";
				pnl_Main = new pnl_no2_Customer();
				btn_Customer.setEnabled(false);

			}
        	
			else if (e.getSource().equals(btn_Patient)) {
				text = "3. Patienten-Daten hinzufügen";
				pnl_Main = new pnl_Dashboard();
				btn_Patient.setEnabled(false);
			}
        	
    		lbl_Title.setText(text);
    		add(pnl_Main, gbc_pnl_Main); 
    		revalidate();
    		repaint(); */
        	
        }
    }

}
