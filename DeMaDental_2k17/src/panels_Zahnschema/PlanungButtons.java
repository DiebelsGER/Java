package panels_Zahnschema;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PlanungButtons extends JPanel {
	
	public JButton[] btnTp;

	/**
	 * Create the panel.
	 */
	public PlanungButtons(String title, String[] name) {
		
		btnTp = new JButton[3];
		
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), title, TitledBorder.CENTER, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{90, 0};
		gridBagLayout.rowHeights = new int[]{50, 50, 50, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
//		int i = 0;
		
//		do {
		for (int i = 0; i < 3; i++) {
			btnTp[i] = new JButton(name[i]);
			btnTp[i].setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_btnTp = new GridBagConstraints();
			gbc_btnTp.fill = GridBagConstraints.BOTH;
			gbc_btnTp.insets = new Insets(10, 15, 10, 15);
			gbc_btnTp.gridx = 0;
			gbc_btnTp.gridy = i;
			add(btnTp[i], gbc_btnTp);
		}

	}

}
