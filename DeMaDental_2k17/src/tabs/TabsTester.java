package tabs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class TabsTester extends JFrame {
	// -------------------------------------------
	// Programm starten
	// -------------------------------------------
	public static void main(String[] args) {
		new TabsTester();
	}

	// -------------------------------------------
	// Dialogelemente erzeugen
	// -------------------------------------------
	private JTabbedPane mypane= new JTabbedPane();
	private JButton btnNew = new JButton("add Tab!");
	
	// -------------------------------------------
	// Konstruktor (baut GUI auf)
	// -------------------------------------------
	public TabsTester() {
		// ------------------------------
		// Event Listener
		// ------------------------------
		btnNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JPanel newTab = new JPanel();
				newTab.add(new JLabel("xxx"+Math.random()));
				
				String title = "Tab "+(int)(Math.random()*100);
				MyTabHeader header = new MyTabHeader(title, mypane);
				int i = mypane.getTabCount();
				mypane.addTab("", newTab);
				mypane.setTabComponentAt(i, header);
			}
		});
		// ------------------------------
		// Dialogelemente plazieren
		// ------------------------------
		JPanel mainPanel = new JPanel(new BorderLayout(20,20));
		mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		mainPanel.add(mypane, BorderLayout.CENTER);
		mainPanel.add(btnNew, BorderLayout.SOUTH);
		
		btnNew.doClick();
		btnNew.doClick();
		btnNew.doClick();
		// ------------------------------
		// Fenster konfigurieren
		// ------------------------------
		add(mainPanel);
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("TabsTester");
		setVisible(true);
	}

	// -------------------------------------------
	// Klasse MyTabHeader
	// -------------------------------------------
	private class MyTabHeader extends JPanel{
		private JLabel label = new JLabel("");
		private JButton button = new JButton("x");
		private JTabbedPane tabpane;
		private JPanel thispanel = this;
		public MyTabHeader(String title,JTabbedPane pane){
			super();
			label.setText(title);
			tabpane=pane;
			add(label);
			add(button);
			
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int i = tabpane.indexOfTabComponent(thispanel);
					 if (i != -1) {
	                tabpane.remove(i);
	            }
				}
			});
		}
		
	}
	
}// class
