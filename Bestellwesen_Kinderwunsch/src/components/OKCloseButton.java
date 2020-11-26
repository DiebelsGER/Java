package components;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Font;

public class OkCloseButtons extends JPanel {
	
	public JButton btnOk;
	public JButton btnClose;

	/**
	 * Create the panel.
	 */
	public OkCloseButtons(String ok) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnOk = new JButton(ok);
		btnOk.setFont(new Font("Arial", Font.PLAIN, 12));
		btnOk.setIcon(new ImageIcon(OkCloseButtons.class.getResource("/pics/ok.png")));
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.insets = new Insets(10, 10, 10, 10);
		gbc_btnOk.gridx = 0;
		gbc_btnOk.gridy = 0;
		add(btnOk, gbc_btnOk);
		
		btnClose = new JButton("Abbrechen");
		btnClose.setFont(new Font("Arial", Font.PLAIN, 12));
		btnClose.setIcon(new ImageIcon(OkCloseButtons.class.getResource("/pics/close.png")));
		GridBagConstraints gbc_btnClose = new GridBagConstraints();
		gbc_btnClose.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClose.insets = new Insets(0, 10, 10, 10);
		gbc_btnClose.gridx = 0;
		gbc_btnClose.gridy = 1;
		add(btnClose, gbc_btnClose);
		
		

	}

}
