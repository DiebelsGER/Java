package components;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import main_Dashboard.Main;

import javax.swing.JLabel;
import java.awt.Font;

public class tabCloser extends JPanel {
	
	private JButton btnCloseTab;
	private JLabel lblTabHeader;
	
	private String Header;

	/**
	 * Create the panel.
	 */
	public tabCloser(String Header) {
		
		this.Header = Header;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnCloseTab = new JButton("");
//		btnCloseTab.addActionListener(new ButtonListener());
		btnCloseTab.setIcon(new ImageIcon(tabCloser.class.getResource("/pics/close.png")));
		btnCloseTab.setBorderPainted(false);
		btnCloseTab.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnCloseTab = new GridBagConstraints();
		gbc_btnCloseTab.insets = new Insets(0, 0, 5, 0);
		gbc_btnCloseTab.gridx = 1;
		gbc_btnCloseTab.gridy = 0;
		add(btnCloseTab, gbc_btnCloseTab);
		
		lblTabHeader = new JLabel(Header);
		lblTabHeader.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTabHeader = new GridBagConstraints();
		gbc_lblTabHeader.insets = new Insets(0, 0, 5, 5);
		gbc_lblTabHeader.gridx = 0;
		gbc_lblTabHeader.gridy = 0;
		add(lblTabHeader, gbc_lblTabHeader);
		
	}
	
/*	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			int i = Main.tbpMain.getSelectedIndex();
			/*	 if (i != -1) {
					 Main.tbp_Main.remove(i-1);
			} */
/*			Main.tbpMain.remove(i);
			
		}
	} */

}
