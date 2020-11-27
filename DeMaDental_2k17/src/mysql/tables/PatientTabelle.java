package mysql.tables;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import mysql.connection.MySQLConnect;

public class PatientTabelle {
	
	MySQLConnect con = new MySQLConnect();
	
	private ResultSet rs = null;
	
	private int result;
	private String name;
	
	public String getPatientName(int patient_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT name FROM patient WHERE patient_id = '" + patient_id + "'");
			rs.last();
			name = rs.getString("name");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getPatientName: "+ sqlEx.toString());
		}
		con.disconnect();
		return name;
	}

}
