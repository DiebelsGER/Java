package mysql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnect {
	
private static String connectionUrl = "jdbc:mysql://127.0.0.1:3306/dema_dental?user=root&password=12345";
	
	private Connection con = null;
	public Statement stmt = null;
    
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();
            
        } catch (SQLException sqlEx) {
            System.out.println("SQL Exception: "+ sqlEx.toString());
        } catch (ClassNotFoundException classEx) {
            System.out.println("Class Not Found Exception: "+ classEx.toString());
        }
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