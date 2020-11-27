package panels;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import main_Dashboard.Main;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import variables.Auftrag;

public class Dashboard extends JPanel {
	
	private Auftrag auftrag;
	
	private int benutzer_id;
	
	private JButton btnAuftragAnlegen;
	private JButton btnAuftragSuchen;
	private JButton btnLaborzettel;

	public Dashboard(int benutzer_id) {
		
		this.benutzer_id = benutzer_id;
		
		setBackground(new Color(255, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel pnlAuftragVerwaltung = new JPanel();
		pnlAuftragVerwaltung.setBackground(new Color(160, 160, 160));
		GridBagConstraints gbc_pnlAuftragVerwaltung = new GridBagConstraints();
		gbc_pnlAuftragVerwaltung.insets = new Insets(10, 10, 5, 10);
		gbc_pnlAuftragVerwaltung.fill = GridBagConstraints.BOTH;
		gbc_pnlAuftragVerwaltung.gridx = 0;
		gbc_pnlAuftragVerwaltung.gridy = 0;
		add(pnlAuftragVerwaltung, gbc_pnlAuftragVerwaltung);
		GridBagLayout gbl_pnlAuftragVerwaltung = new GridBagLayout();
		gbl_pnlAuftragVerwaltung.columnWidths = new int[]{0, 0};
		gbl_pnlAuftragVerwaltung.rowHeights = new int[]{0, 0};
		gbl_pnlAuftragVerwaltung.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlAuftragVerwaltung.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlAuftragVerwaltung.setLayout(gbl_pnlAuftragVerwaltung);
		
		JLabel lblAuftragVerwaltung = new JLabel("Auftrag-Verwaltung");
		lblAuftragVerwaltung.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAuftragVerwaltung.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblAuftragVerwaltung = new GridBagConstraints();
		gbc_lblAuftragVerwaltung.insets = new Insets(10,10,10,10);
		gbc_lblAuftragVerwaltung.gridx = 0;
		gbc_lblAuftragVerwaltung.gridy = 0;
		pnlAuftragVerwaltung.add(lblAuftragVerwaltung, gbc_lblAuftragVerwaltung);
		
		JPanel pnlAVButtons = new JPanel();
		pnlAVButtons.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_pnlAVButtons = new GridBagConstraints();
		gbc_pnlAVButtons.insets = new Insets(10, 10, 5, 10);
		gbc_pnlAVButtons.fill = GridBagConstraints.BOTH;
		gbc_pnlAVButtons.gridx = 0;
		gbc_pnlAVButtons.gridy = 1;
		add(pnlAVButtons, gbc_pnlAVButtons);
		GridBagLayout gbl_pnlAVButtons = new GridBagLayout();
		gbl_pnlAVButtons.columnWidths = new int[]{0, 0, 0};
		gbl_pnlAVButtons.rowHeights = new int[]{0, 0};
		gbl_pnlAVButtons.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlAVButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlAVButtons.setLayout(gbl_pnlAVButtons);
		
		btnAuftragAnlegen = new JButton("");
		btnAuftragAnlegen.setFont(new Font("Avenir", Font.PLAIN, 12));
		btnAuftragAnlegen.setBackground(Color.WHITE);
		btnAuftragAnlegen.addActionListener(new ButtonListener());
		btnAuftragAnlegen.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/dashboard/neuer_auftrag.png")));
		btnAuftragAnlegen.setBorder(null);
		btnAuftragAnlegen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		GridBagConstraints gbc_btnAuftragAnlegen = new GridBagConstraints();
		gbc_btnAuftragAnlegen.insets = new Insets(10,10,10,10);
		gbc_btnAuftragAnlegen.gridx = 0;
		gbc_btnAuftragAnlegen.gridy = 0;
		pnlAVButtons.add(btnAuftragAnlegen, gbc_btnAuftragAnlegen);
		
		btnAuftragSuchen = new JButton("");
		btnAuftragSuchen.setBackground(Color.WHITE);
		btnAuftragSuchen.addActionListener(new ButtonListener());
		btnAuftragSuchen.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/dashboard/auftrag_suchen.png")));
		btnAuftragSuchen.setBorder(null);
		btnAuftragSuchen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		GridBagConstraints gbc_btnAuftragSuchen = new GridBagConstraints();
		gbc_btnAuftragSuchen.insets = new Insets(10,10,10,10);
		gbc_btnAuftragSuchen.gridx = 1;
		gbc_btnAuftragSuchen.gridy = 0;
		pnlAVButtons.add(btnAuftragSuchen, gbc_btnAuftragSuchen);
		
		JPanel pnlAuftragBearbeitung = new JPanel();
		pnlAuftragBearbeitung.setBackground(new Color(160, 160, 160));
		GridBagConstraints gbc_pnlAuftragBearbeitung = new GridBagConstraints();
		gbc_pnlAuftragBearbeitung.insets = new Insets(10, 10, 5, 10);
		gbc_pnlAuftragBearbeitung.fill = GridBagConstraints.BOTH;
		gbc_pnlAuftragBearbeitung.gridx = 0;
		gbc_pnlAuftragBearbeitung.gridy = 2;
		add(pnlAuftragBearbeitung, gbc_pnlAuftragBearbeitung);
		GridBagLayout gbl_pnlAuftragBearbeitung = new GridBagLayout();
		gbl_pnlAuftragBearbeitung.columnWidths = new int[]{0, 0};
		gbl_pnlAuftragBearbeitung.rowHeights = new int[]{0, 0};
		gbl_pnlAuftragBearbeitung.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlAuftragBearbeitung.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlAuftragBearbeitung.setLayout(gbl_pnlAuftragBearbeitung);
		
		JLabel lblAuftragBearbeitung = new JLabel("Auftrag-Bearbeitung");
		lblAuftragBearbeitung.setForeground(new Color(255, 255, 255));
		lblAuftragBearbeitung.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblAuftragBearbeitung = new GridBagConstraints();
		gbc_lblAuftragBearbeitung.insets = new Insets(10,10,10,10);
		gbc_lblAuftragBearbeitung.gridx = 0;
		gbc_lblAuftragBearbeitung.gridy = 0;
		pnlAuftragBearbeitung.add(lblAuftragBearbeitung, gbc_lblAuftragBearbeitung);
		
		JPanel pnlABButtons = new JPanel();
		pnlABButtons.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_pnlABButtons = new GridBagConstraints();
		gbc_pnlABButtons.insets = new Insets(10, 10, 5, 10);
		gbc_pnlABButtons.fill = GridBagConstraints.BOTH;
		gbc_pnlABButtons.gridx = 0;
		gbc_pnlABButtons.gridy = 3;
		add(pnlABButtons, gbc_pnlABButtons);
		GridBagLayout gbl_pnlABButtons = new GridBagLayout();
		gbl_pnlABButtons.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlABButtons.rowHeights = new int[]{0, 0};
		gbl_pnlABButtons.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlABButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlABButtons.setLayout(gbl_pnlABButtons);
		
		btnLaborzettel = new JButton("");
		btnLaborzettel.setBackground(Color.WHITE);
		btnLaborzettel.addActionListener(new ButtonListener());
		btnLaborzettel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));		
		btnLaborzettel.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/dashboard/auftragzettel_neu.png")));
		btnLaborzettel.setBorder(null);
		GridBagConstraints gbc_btnLaborzettel = new GridBagConstraints();
		gbc_btnLaborzettel.insets = new Insets(10, 10, 10, 10);
		gbc_btnLaborzettel.anchor = GridBagConstraints.NORTH;
		gbc_btnLaborzettel.gridx = 0;
		gbc_btnLaborzettel.gridy = 0;
		pnlABButtons.add(btnLaborzettel, gbc_btnLaborzettel);
		
		JButton btnStatusBuchen = new JButton("");
		btnStatusBuchen.addActionListener(new ButtonListener());
		btnStatusBuchen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnStatusBuchen.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/dashboard/statusneu.png")));
		btnStatusBuchen.setBorder(null);
		GridBagConstraints gbc_btnStatusBuchen = new GridBagConstraints();
		gbc_btnStatusBuchen.insets = new Insets(10,10,10,10);
		gbc_btnStatusBuchen.gridx = 2;
		gbc_btnStatusBuchen.gridy = 0;
		pnlABButtons.add(btnStatusBuchen, gbc_btnStatusBuchen);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(160, 160, 160));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(10, 10, 5, 10);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblAuftragbersichten = new JLabel("Auftrag-\u00DCbersichten");
		lblAuftragbersichten.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAuftragbersichten.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblAuftragbersichten = new GridBagConstraints();
		gbc_lblAuftragbersichten.insets = new Insets(10, 10, 10, 10);
		gbc_lblAuftragbersichten.gridx = 0;
		gbc_lblAuftragbersichten.gridy = 0;
		panel.add(lblAuftragbersichten, gbc_lblAuftragbersichten);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 5;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnTermine = new JButton("");
		btnTermine.addActionListener(new ButtonListener());
		btnTermine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnTermine.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/dashboard/termine.png")));
		btnTermine.setBorder(null);
		GridBagConstraints gbc_btnTermine = new GridBagConstraints();
		gbc_btnTermine.insets = new Insets(10,10,10,10);
		gbc_btnTermine.gridx = 0;
		gbc_btnTermine.gridy = 0;
		panel_1.add(btnTermine, gbc_btnTermine);
		
	//	System.out.println("AuftragNr Dash" + auftrag.nummer);

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

}
