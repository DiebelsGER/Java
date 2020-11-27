package tabs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main_Dashboard.Main;

public class Dashboard extends JPanel {
		
	public Dashboard() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblDashboard = new JLabel();
		GridBagConstraints gbc_lblDashboard = new GridBagConstraints();
		gbc_lblDashboard.gridx = 0;
		gbc_lblDashboard.gridy = 0;
		add(lblDashboard, gbc_lblDashboard);

	}

}
