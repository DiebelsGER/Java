package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SQLConnection {
	
	private static String url = "jdbc:mysql://127.0.0.1:3306/bestellwesen?useTimezone=true&serverTimezone=UTC";
	private static String username = "root";
	private static String password = "12345"; 
	
/*	private static String url = "jdbc:mysql://192.168.0.230:3306/bestellwesen?useTimezone=true&serverTimezone=UTC";
	private static String username = "bestellwesen";
	private static String password = "Bestellen2020"; */
	
	private Connection con = null;
	public Statement stmt = null;
    
 
	public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            
        } catch (SQLException sqlEx) {
            System.out.println("SQL Exception: "+ sqlEx.toString());
            JOptionPane.showMessageDialog(null, "Fehler 001 bei der Datenbank-Verbindung\nEs kann keine Verbindung zur Datenbank hergestellt werden.");
        } catch (ClassNotFoundException classEx) {
            System.out.println("Class Not Found Exception: "+ classEx.toString());
            JOptionPane.showMessageDialog(null, "Fehler 001 bei der Datenbank-Verbindung\nEs kann keine Verbindung zur Datenbank hergestellt werden.");        }
    }
    
    
    public void disconnect() {
    	try {
    		stmt.close();
    		con.close();
    	}
    	catch (SQLException sqlEx) {
    		System.out.println("SQL Exception: "+ sqlEx.toString());
    	}
    }

}
