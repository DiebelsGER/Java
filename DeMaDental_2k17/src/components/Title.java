package components;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Title extends JPanel {

	/**
	 * Create the panel.
	 */
	public Title(String schritt, String hinweis) {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblSchritt = new JLabel(schritt);
		lblSchritt.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchritt.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSchritt = new GridBagConstraints();
		gbc_lblSchritt.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSchritt.insets = new Insets(10, 10, 10, 10);
		gbc_lblSchritt.gridx = 0;
		gbc_lblSchritt.gridy = 0;
		add(lblSchritt, gbc_lblSchritt);
		
		JLabel lblHinweis = new JLabel(hinweis);
		lblHinweis.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinweis.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_lblHinweis = new GridBagConstraints();
		gbc_lblHinweis.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblHinweis.insets = new Insets(0, 10, 10, 10);
		gbc_lblHinweis.gridx = 0;
		gbc_lblHinweis.gridy = 1;
		add(lblHinweis, gbc_lblHinweis);

	}

}
