package mysql.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import security.Md5;

import mysql.connection.MySQLConnect;

public class LoginTabelle {
	
	MySQLConnect con = new MySQLConnect();
	
	Md5 md5 = new Md5();
	
	private ResultSet rs = null;
	
	private int result;
	private int benutzer_id;
	private String password;
	private String[] login = new String[2];
		
	public int checkLogin(String user, String pswd) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT benutzer_id FROM login WHERE username = '" + user + "' AND password = '" + md5.getMd5(pswd) + "'");
			rs.last();
			result = rs.getRow();
			if (result != 0) {
				setBenutzerID(rs.getInt("benutzer_id"));
			}
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at checkLogin: "+ sqlEx.toString());
		}
		con.disconnect();
		return result;
	}
	

	public int getBenutzerID() {
		return benutzer_id;
	}
	
	public void setBenutzerID(int benutzer_id) {
		this.benutzer_id = benutzer_id;
	}
	
	
	public String[] getLogin(int benutzer_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT username, password FROM login WHERE benutzer_id = '" + benutzer_id + "'");
			rs.last();
			login[0] = rs.getString("username");
			login[1] = rs.getString("password");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getLogin: "+ sqlEx.toString());
		}
		con.disconnect();
		return login;
	}
	
	
	public void addLogin(int benutzer_id, String user, String pswd) {
		con.connect();
		try {
			con.stmt.executeUpdate("INSERT INTO login (benutzer_id, username, password) VALUES ('" + benutzer_id + "', '" + user + "', '"+ security.Md5.getMd5(pswd) + "')");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at addLogin: "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	
	public void updateLogin(int benutzer_id, String user, String pswd) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE login SET username = '" + user + "', " +
					"password = '" + security.Md5.getMd5(pswd) + "' WHERE benutzer_id = '" + benutzer_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at updateLogin: "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	
	public String checkPassword(int benutzer_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT password FROM login WHERE benutzer_id = '" + benutzer_id + "'");
			rs.last();
			password = rs.getString("password");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at checkPassword: "+ sqlEx.toString());
		}
		con.disconnect();
		return password;
	}
	
	
	public void updateUsername(int benutzer_id, String user) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE login SET username = '" + user + "' WHERE benutzer_id = '" + benutzer_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at updateUsername: "+ sqlEx.toString());
		}
		con.disconnect();
	}

}
