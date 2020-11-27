package components;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JList;

import mysql.operations.DynamicSQL;

import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class List extends JPanel {
	
	DynamicSQL dyn = new DynamicSQL();
	
	private JScrollPane scrollPane;
	
	private DefaultListModel mod = new DefaultListModel();
	public JList list;

	/**
	 * Create the panel.
	 */
	public List() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;

		add(scrollPane, gbc_scrollPane);
		
		list = new JList(mod);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(list);
	}
	
	public void fillList(String sql) {
		if (dyn.getData(sql) != null) {
			Object[][] results = dyn.getData(sql);
			for (int i = 0; i < results.length; i++) {
				mod.addElement(results[i][0]);
			}
		}
	}
	
	public void clearList() {
		mod.clear();
	}

}
