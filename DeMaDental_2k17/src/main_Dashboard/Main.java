package main_Dashboard;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.GridBagConstraints;

import javax.swing.DefaultDesktopManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

//import variables.Auftrag;

import panels.Dashboard;
import variables.Auftrag;
import components.Sidebar;

/*
import forms_AuftragAnlegen.AuftragNummer;
import forms_AuftragSuchen.AuftragSuchen;
import forms_BenutzerVerwaltung.BenutzerSuchen;
import forms_BenutzerVerwaltung.BenutzerVerwaltung;
import forms_KundenVerwaltung.KundeSuchen;
import forms_MaterialVerwaltung.MaterialSuchen;
import forms_TerminVerwaltung.TerminFunktionen;

import variables.var_Orders;
import variables.Standort;

import mySQL_Tabellen.BenutzerTabelle; */
import javax.swing.border.LineBorder;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.Box;
import java.awt.SystemColor;

public class Main extends JFrame {
	
//	private BenutzerTabelle bt = new BenutzerTabelle();
	
	public static JDesktopPane desk;
	
	private Sidebar pnlSidebar;
	
	private JButton btnKundenVerwaltung;
	private JButton btnMaterialVerwaltung;
	private JButton btnStandortVerwaltung;
	private JButton btnTermine;
	private JButton btnBenutzerVerwaltung;
	private JButton btnEinstellungen;
	
	private int benutzer_id;
		
	private String headerText = "Dashboard";
	private String iconImage = "dashboard";
	
//	private Auftrag auftrag;
			
//	GridBagConstraints gbc_pnl_Main = new GridBagConstraints();
	private JPanel contentPane;
	private JPanel pnlHeader;
	private JLabel lblHeader;
	private JButton btnExitTop;
	private JButton btnNewButton;
	private JPanel pnlTitle;
	private JLabel lblTitle;
	public static JTabbedPane tbp_Main;
	private JPanel panel;
	
	public Main(int benutzer_id) {
		
//		this.auftrag = auftrag;
		this.benutzer_id = benutzer_id;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1265, 1056);
		setExtendedState(MAXIMIZED_BOTH);
				
		setTitle("DeMaDental Professional");
		
		this.desk = new JDesktopPane();
		desk.setBackground(new Color(255, 255, 255));
		desk.setDesktopManager(new DefaultDesktopManager());
		setContentPane(desk);
		GridBagLayout gbl_desk = new GridBagLayout();
		gbl_desk.columnWidths = new int[]{0, 0};
		gbl_desk.rowHeights = new int[]{0, 0};
		gbl_desk.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_desk.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		desk.setLayout(gbl_desk);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_contentPane = new GridBagConstraints();
		gbc_contentPane.fill = GridBagConstraints.BOTH;
		gbc_contentPane.gridx = 0;
		gbc_contentPane.gridy = 0;
		desk.add(contentPane, gbc_contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(44, 55, 66));
		GridBagConstraints gbc_pnlHeader = new GridBagConstraints();
		gbc_pnlHeader.insets = new Insets(0, 0, 5, 0);
		gbc_pnlHeader.gridwidth = 2;
		gbc_pnlHeader.fill = GridBagConstraints.BOTH;
		gbc_pnlHeader.gridx = 0;
		gbc_pnlHeader.gridy = 0;
		contentPane.add(pnlHeader, gbc_pnlHeader);
		GridBagLayout gbl_pnlHeader = new GridBagLayout();
		gbl_pnlHeader.columnWidths = new int[]{0, 0, 0};
		gbl_pnlHeader.rowHeights = new int[]{0, 0};
		gbl_pnlHeader.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlHeader.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlHeader.setLayout(gbl_pnlHeader);
		
		lblHeader = new JLabel("DeMa Dental Professional");
		lblHeader.setFont(new Font("Verdana", Font.BOLD, 16));
		lblHeader.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblHeader = new GridBagConstraints();
		gbc_lblHeader.insets = new Insets(10,10,10,10);
		gbc_lblHeader.gridx = 0;
		gbc_lblHeader.gridy = 0;
		pnlHeader.add(lblHeader, gbc_lblHeader);
		
		btnExitTop = new JButton("");
		btnExitTop.addActionListener(new ButtonListener());
		btnExitTop.setIcon(new ImageIcon(Main.class.getResource("/pics/button_icons/exit_small.png")));
		btnExitTop.setBorder(null);
		GridBagConstraints gbc_btnExitTop = new GridBagConstraints();
		gbc_btnExitTop.insets = new Insets(10,10,10,10);
		gbc_btnExitTop.anchor = GridBagConstraints.EAST;
		gbc_btnExitTop.gridx = 1;
		gbc_btnExitTop.gridy = 0;
		pnlHeader.add(btnExitTop, gbc_btnExitTop);
		
		pnlSidebar = new Sidebar();
		GridBagConstraints gbc_sidebar = new GridBagConstraints();
		gbc_sidebar.insets = new Insets(0, 0, 5, 5);
		gbc_sidebar.fill = GridBagConstraints.BOTH;
		gbc_sidebar.gridx = 0;
		gbc_sidebar.gridy = 1;
		
		gbc_sidebar.gridheight = 2;
		contentPane.add(pnlSidebar, gbc_sidebar);
		
		pnlTitle = new JPanel();
		pnlTitle.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_pnlTitle = new GridBagConstraints();
		gbc_pnlTitle.insets = new Insets(0, 0, 5, 0);
		gbc_pnlTitle.fill = GridBagConstraints.BOTH;
		gbc_pnlTitle.gridx = 1;
		gbc_pnlTitle.gridy = 1;
		contentPane.add(pnlTitle, gbc_pnlTitle);
		GridBagLayout gbl_pnlTitle = new GridBagLayout();
		gbl_pnlTitle.columnWidths = new int[]{0, 0};
		gbl_pnlTitle.rowHeights = new int[]{0, 0};
		gbl_pnlTitle.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlTitle.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlTitle.setLayout(gbl_pnlTitle);
		
		lblTitle = new JLabel(headerText);
		lblTitle.setIcon(new ImageIcon(Main.class.getResource("/pics/title_icons/" + iconImage + ".png")));
		lblTitle.setForeground(new Color(51, 51, 51));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		pnlTitle.add(lblTitle, gbc_lblTitle);
				
		tbp_Main = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tbp_Main = new GridBagConstraints();
		gbc_tbp_Main.fill = GridBagConstraints.BOTH;
		gbc_tbp_Main.gridx = 1;
		gbc_tbp_Main.gridy = 2;
		contentPane.add(tbp_Main, gbc_tbp_Main);
		tbp_Main.add("Dashbaord", new panels.Dashboard(benutzer_id));
					
	}
	
class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
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
