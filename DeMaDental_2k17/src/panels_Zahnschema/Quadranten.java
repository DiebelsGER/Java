package panels_Zahnschema;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JLabel;

public class Quadranten extends JPanel {
		
	public JTextField[] txtZahn;
	private JLabel[] lblZahn;
	
	private int zeile;
	private int spalte;
		
	/**
	 * Create the panel.
	 */
	public Quadranten(int zahn) {
		
		txtZahn = new JTextField[8];
		lblZahn = new JLabel[8];
		
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		for (int i = 0; i < 8; i++) {
				
				txtZahn[i] = new JTextField();
				txtZahn[i].setFont(new Font("Verdana", Font.PLAIN, 14));
				txtZahn[i].setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_txtZahn = new GridBagConstraints();
				gbc_txtZahn.insets = new Insets(0, 5, 0, 5);
				gbc_txtZahn.fill = GridBagConstraints.HORIZONTAL;
				
				if (Math.abs(zahn) < 29) {
					gbc_txtZahn.gridx = i;
					gbc_txtZahn.gridy = 0;
				}
				else if (Math.abs(zahn) > 30) {
					gbc_txtZahn.gridx = i;
					gbc_txtZahn.gridy = 1;
				}
				
				add(txtZahn[i], gbc_txtZahn);
				txtZahn[i].setColumns(4);	
				
				lblZahn[i] = new JLabel(Integer.toString(Math.abs(zahn)));	
				lblZahn[i].setFont(new Font("Verdana", Font.PLAIN, 14));
				GridBagConstraints gbc_lblZahn = new GridBagConstraints();
				
				if (Math.abs(zahn) < 29) {
					gbc_lblZahn.gridx = i;
					gbc_lblZahn.gridy = 1;
				}
				else if (Math.abs(zahn) > 30) {
					gbc_lblZahn.gridy = i;
					gbc_lblZahn.gridy = 0;
				} 

				add(lblZahn[i], gbc_lblZahn);
								
				zahn++;
			
		}		

	}

}
