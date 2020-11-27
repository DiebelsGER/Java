package main_Dashboard;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import components.Header;
import components.OkCloseButtons;
import components.Title;
import main_Dashboard.Main;
import mysql.tables.LoginTabelle;

import javax.swing.border.LineBorder;

public class Login extends JFrame {
	
	private LoginTabelle login = new LoginTabelle();
	
	private Title panelTitle;
	private Header panelHeader;
	private OkCloseButtons panelButtons;
	
	private int benutzer_id;

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPswd;

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("Herzlich Willkommen im DeMa Dental");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panelHeader = new Header("Herzlich Willkommen im DeMa Dental");
		GridBagConstraints gbc_panelHeader = new GridBagConstraints();
		gbc_panelHeader.gridwidth = 2;
		gbc_panelHeader.insets = new Insets(15, 15, 15, 15);
		gbc_panelHeader.fill = GridBagConstraints.BOTH;
		gbc_panelHeader.gridx = 0;
		gbc_panelHeader.gridy = 0;
		contentPane.add(panelHeader, gbc_panelHeader);
		
		panelTitle = new Title("Login zum DeMa Dental", "Bitte geben Sie Ihre Benutzerdaten an");
		GridBagConstraints gbc_panelTitle = new GridBagConstraints();
		gbc_panelTitle.gridwidth = 2;
		gbc_panelTitle.fill = GridBagConstraints.BOTH;
		gbc_panelTitle.insets = new Insets(0, 15, 15, 15);
		gbc_panelTitle.gridx = 0;
		gbc_panelTitle.gridy = 1;
		contentPane.add(panelTitle, gbc_panelTitle);
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panelMain = new GridBagConstraints();
		gbc_panelMain.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelMain.insets = new Insets(5, 15, 15, 15);
		gbc_panelMain.gridx = 0;
		gbc_panelMain.gridy = 2;
		contentPane.add(panelMain, gbc_panelMain);
		GridBagLayout gbl_panelMain = new GridBagLayout();
		gbl_panelMain.columnWidths = new int[]{0, 0, 0};
		gbl_panelMain.rowHeights = new int[]{0, 0, 0};
		gbl_panelMain.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelMain.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelMain.setLayout(gbl_panelMain);
		
		JLabel lblUser = new JLabel("Benutzername");
		lblUser.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.EAST;
		gbc_lblUser.insets = new Insets(15, 15, 15, 15);
		gbc_lblUser.gridx = 0;
		gbc_lblUser.gridy = 0;
		panelMain.add(lblUser, gbc_lblUser);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUser.insets = new Insets(15, 5, 15, 15);
		gbc_txtUser.gridx = 1;
		gbc_txtUser.gridy = 0;
		panelMain.add(txtUser, gbc_txtUser);
		txtUser.setColumns(15);
		
		JLabel lblPswd = new JLabel("Passwort");
		lblPswd.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblPswd = new GridBagConstraints();
		gbc_lblPswd.anchor = GridBagConstraints.EAST;
		gbc_lblPswd.insets = new Insets(5, 15, 15, 15);
		gbc_lblPswd.gridx = 0;
		gbc_lblPswd.gridy = 1;
		panelMain.add(lblPswd, gbc_lblPswd);
		
		txtPswd = new JPasswordField();
		txtPswd.setFont(new Font("Arial", Font.PLAIN, 16));
		txtPswd.addKeyListener(new TextFieldListener());
		GridBagConstraints gbc_txtPswd = new GridBagConstraints();
		gbc_txtPswd.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPswd.insets = new Insets(5, 5, 15, 15);
		gbc_txtPswd.gridx = 1;
		gbc_txtPswd.gridy = 1;
		panelMain.add(txtPswd, gbc_txtPswd);
		txtPswd.setColumns(15);
		
		panelButtons = new OkCloseButtons("Login");
		GridBagConstraints gbc_panelButtons = new GridBagConstraints();
		gbc_panelButtons.anchor = GridBagConstraints.NORTH;
		gbc_panelButtons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelButtons.insets = new Insets(5, 0, 15, 15);
		gbc_panelButtons.gridx = 1;
		gbc_panelButtons.gridy = 2;
		contentPane.add(panelButtons, gbc_panelButtons);
		
		panelButtons.btnOk.addActionListener(new ButtonListener());
		panelButtons.btnClose.addActionListener(new ButtonListener());
	
		pack();
		setLocationRelativeTo(null);
	}
	
	private void next() {
		if (login.checkLogin(txtUser.getText(), txtPswd.getText()) == 1) {
			benutzer_id = login.getBenutzerID();
			setVisible(false);
		//	Auftrag auftrag = new Auftrag();
			new Main(benutzer_id).setVisible(true);
		}
		else {
			
			JOptionPane.showMessageDialog(null, "Benutzername und/oder Passwort falsch!");
		}
	}

	
	class ButtonListener implements ActionListener {
		
		ButtonListener() {
		}

		public void actionPerformed(ActionEvent e) {
			
			if (e.getActionCommand().equals("Login")) {
				next();
			}
			
			else if (e.getActionCommand().equals("Abbrechen")) {
				System.exit(0);
			}
		}
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
