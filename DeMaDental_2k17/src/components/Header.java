package components;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

public class Header extends JPanel {

	/**
	 * Create the panel.
	 */
	public Header(String header) {
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(65, 105, 225));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{208, 0};
		gridBagLayout.rowHeights = new int[]{19, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblHeader = new JLabel(header);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lblHeader = new GridBagConstraints();
		gbc_lblHeader.insets = new Insets(10, 10, 10, 10);
		gbc_lblHeader.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblHeader.anchor = GridBagConstraints.NORTH;
		gbc_lblHeader.gridx = 0;
		gbc_lblHeader.gridy = 0;
		add(lblHeader, gbc_lblHeader);

	}

}
