package components;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;

import mysql.operations.DynamicSQL;
import variables.TextLabels;

public class Table extends JPanel implements TextLabels {
	
	DynamicSQL dyn = new DynamicSQL();
		
	private JScrollPane scrollPane;
	
	private TableModel model;
	private DefaultTableModel mod;
	public JTable table;
	private TableColumnModel tcm;
	
	public int id;
	public String patId;


	/**
	 * Create the panel.
	 */
	public Table() {
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
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel(new Object[0][0], new Object[0]) {
			public boolean isCellEditable(int row, int column) {
		        return false;
		      }
		};
								
	}
	
	public void fillTable(String sql, Object[] colheads) {
        mod = (DefaultTableModel) model;
        mod.setDataVector(dyn.getData(sql), colheads);
        mod = null;
        table.setModel(model);
        table.updateUI();
	}
	
	public void selectRow() {
		int selctedRow = table.getSelectedRow();
		if (selctedRow != -1) {
			id = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
		}
	}
	
	public void removeIdColumn(int column) {
		tcm = table.getColumnModel();
		tcm.removeColumn(tcm.getColumn(column) );
	}
	
	public String getBackId(int column) {
		patId = (String) table.getModel().getValueAt(table.getSelectedRow(), column);
		return patId;
	}
	
}
