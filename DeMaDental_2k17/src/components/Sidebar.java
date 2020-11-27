package components;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import main_Dashboard.Main;
import variables.Auftrag;

import java.awt.Color;

public class Sidebar extends JPanel {
	
	private Auftrag auftrag;
	private int benutzer_id;
	
	private JButton btnAuftragAnlegen;

	/**
	 * Create the panel.
	 */
	public Sidebar() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnDashboard = new JButton("");
		btnDashboard.setIcon(new ImageIcon(Sidebar.class.getResource("/pics/button_icons/show-dashboard.png")));
		btnDashboard.setBorder(null);
		GridBagConstraints gbc_btnDashboard = new GridBagConstraints();
		gbc_btnDashboard.insets = new Insets(10, 10, 5, 10);
		gbc_btnDashboard.gridx = 0;
		gbc_btnDashboard.gridy = 0;
		add(btnDashboard, gbc_btnDashboard);
		
		btnAuftragAnlegen = new JButton("");
		btnAuftragAnlegen.setIcon(new ImageIcon(Sidebar.class.getResource("/pics/button_icons/new-order.png")));
		btnAuftragAnlegen.setBorder(null);
		btnAuftragAnlegen.addActionListener(new ButtonListener());
		GridBagConstraints gbc_btnAuftragAnlegen = new GridBagConstraints();
		gbc_btnAuftragAnlegen.insets = new Insets(0, 10, 5, 10);
		gbc_btnAuftragAnlegen.gridx = 0;
		gbc_btnAuftragAnlegen.gridy = 1;
		add(btnAuftragAnlegen, gbc_btnAuftragAnlegen);
		
		JButton btnFindOrder = new JButton("");
		btnFindOrder.setIcon(new ImageIcon(Sidebar.class.getResource("/pics/button_icons/find_order.png")));
		btnFindOrder.setBorder(null);
		GridBagConstraints gbc_btnFindOrder = new GridBagConstraints();
		gbc_btnFindOrder.insets = new Insets(0, 10, 5, 10);
		gbc_btnFindOrder.gridx = 0;
		gbc_btnFindOrder.gridy = 2;
		add(btnFindOrder, gbc_btnFindOrder);
		
		JButton btnLaborzettel = new JButton("");
		btnLaborzettel.setIcon(new ImageIcon(Sidebar.class.getResource("/pics/button_icons/ordersheet.png")));
		btnLaborzettel.setBorder(null);
		GridBagConstraints gbc_btnLaborzettel = new GridBagConstraints();
		gbc_btnLaborzettel.insets = new Insets(0, 10, 5, 10);
		gbc_btnLaborzettel.gridx = 0;
		gbc_btnLaborzettel.gridy = 3;
		add(btnLaborzettel, gbc_btnLaborzettel);
		
		JButton btnKundenVerwaltung = new JButton("");
		btnKundenVerwaltung.setIcon(new ImageIcon(Sidebar.class.getResource("/pics/button_icons/customers.png")));
		btnKundenVerwaltung.setBorder(null);
		GridBagConstraints gbc_btnKundenVerwaltung = new GridBagConstraints();
		gbc_btnKundenVerwaltung.insets = new Insets(0, 10, 5, 10);
		gbc_btnKundenVerwaltung.gridx = 0;
		gbc_btnKundenVerwaltung.gridy = 4;
		add(btnKundenVerwaltung, gbc_btnKundenVerwaltung);

	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource().equals(btnAuftragAnlegen)) {
				//	dispose();				
					Auftrag auftrag = new Auftrag();
					auftrag.benutzer_id = benutzer_id;
					Main.tbp_Main.add(new functions_AuftragAnlegen.AuftragNummer(auftrag));
					int i = Main.tbp_Main.getTabCount();
					Main.tbp_Main.setSelectedIndex(i-1);
					Main.tbp_Main.setTabComponentAt(i-1, new components.tabCloser("Neuen Auftrag anlegen"));
				}
			
		/*	if (e.getSource().equals(btnAuftragAnlegen)) {
				var_Orders auftrag = new var_Orders();
				auftrag.benutzer_id = benutzer_id;
				String[][] zahnschema = new String[32][2];
				String[][] bearbeitungsstand = new String[11][2];
				String[][] arbeitsmaterial = new String[30][2];
				int schritt = 1;
				int max = 9;
				int fertig = 0;
				new AuftragNummer(auftrag, zahnschema, bearbeitungsstand, arbeitsmaterial, schritt, max, fertig).setVisible(true);
			}
			
			else if (e.getSource().equals(btnAuftragSuchen)) {
				new AuftragSuchen(benutzer_id).setVisible(true);
			}
			
			else if (e.getSource().equals(btnBenutzerVerwaltung)) {
				new BenutzerVerwaltung().setVisible(true);
			}
			
			else if (e.getSource().equals(btnMaterialVerwaltung)) {
				new MaterialSuchen().setVisible(true);
			}
			
			else if (e.getSource().equals(btnStandortVerwaltung)) {
			//	String[] standort = new String[16];
				var_Orders auftrag = new var_Orders();
				auftrag.benutzer_id = benutzer_id;
				Standort standort = new Standort();
				String[][] bearbeitungsstand = new String[11][2];
				String[][] arbeitsmaterial = new String[30][2];
				int schritt = 1;
				int max = 9;
				new forms_StandortVerwaltung.AuftragNummer(auftrag, standort, bearbeitungsstand, arbeitsmaterial, schritt, max).setVisible(true);
			}
			
			else if (e.getSource().equals(btnKundenVerwaltung)) {
				new KundeSuchen().setVisible(true);
			}
			
			else if (e.getSource().equals(btnTermine)) {
				new TerminFunktionen().setVisible(true);
			}
			
			else if (e.getSource().equals(btnExit)) {
				System.exit(0);
			}  */
			
		/*	if (e.getSource().equals(btnDashboard)) {
				headerText = "Dashboard";
				iconImage = "dashboard";
				
				tbp_Main.setSelectedIndex(0);
			}
			
			else if (e.getSource().equals(btnAuftragAnlegen)) {
				Auftrag auftrag = new Auftrag();
				auftrag.benutzer_id = benutzer_id;
				headerText = "Neuen Auftrag erfassen";
				iconImage = "new-file";
				if (desk.countComponents() == 1) {
					an = new AuftragNummer(auftrag);
					desk.add(an);
					an.setVisible(true);
				}  
			}
			
			else if (e.getSource().equals(btnAuftragSuchen)) {
				tbp_Main.add("Auftrag suchen", new panels.Dashboard(benutzer_id));
			}
			
			lblTitle.setText(headerText);
			lblTitle.setIcon(new ImageIcon(Main.class.getResource("/pics/title_icons/" + iconImage + ".png")));
			*/
		}

	}

}
