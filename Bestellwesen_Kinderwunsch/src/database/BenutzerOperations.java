package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BenutzerOperations {
	
SQLConnection con = new SQLConnection();
	
	private ResultSet rs = null;
	ResultSetMetaData rsmd;
	
	private String warenkorb[][];
	private int anzahl;
	private boolean vorhanden;
	private int bearbeiter_id;
	private int benutzerRecht;
	private String[] benutzer = new String[4];
	private String[] login = new String[2];
	private String[] lieferant;
	private String[] kostenstelle;
	private String eMailAdresse;
	private int bestell_nr;
	private String[] bereich;
	private String[] berechtigung;
	
	public String[] getBenutzer(int bearbeiter_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT b.vorname, b.name, be.name, br.name, l.benutzername, l.passwort FROM bearbeiter b, bereich be, berechtigung br, login l WHERE b.bearbeiter_id = '" + bearbeiter_id + "' AND b.bereich_id = be.bereich_id AND b.berechtigung_id = br.berechtigung_id");
			rs.next();
			benutzer[0] = rs.getString("b.vorname");
			benutzer[1] = rs.getString("b.name");
			benutzer[2] = rs.getString("be.name");
			benutzer[3] = rs.getString("br.name");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getBenutzer: "+ sqlEx.toString());
		}
		con.disconnect();
		return benutzer;
	}
	
	public int getBenutzerRecht(int bearbeiter_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT berechtigung_id from bearbeiter WHERE bearbeiter_id = '" + bearbeiter_id + "'");
			rs.last();
			benutzerRecht = rs.getInt("berechtigung_id");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getBenutzerRecht: "+ sqlEx.toString());
		}
		con.disconnect();
		return benutzerRecht;
	}
	
	public String[] getLogin(int bearbeiter_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT benutzername, passwort FROM login WHERE bearbeiter_id = '" + bearbeiter_id + "'");
			rs.next();
			login[0] = rs.getString("benutzername");
			login[1] = rs.getString("passwort");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getLogin: "+ sqlEx.toString());
		}
		con.disconnect();
		return login;
	}
	
	public String[] getBereiche() {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT name FROM bereich");
			rs.last();
			int rowCnt = rs.getRow();
	        if (rowCnt != 0) { 
		        rs.first();
		        bereich = new String[rowCnt];
		        int i = 0;
		        do {
		        	bereich[i] = rs.getString("name");
	        		i++;
	        	}
		        while (rs.next() && i < rowCnt); 
	        }
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getBereiche: "+ sqlEx.toString());
		}
		con.disconnect();
		return bereich;
	}
	
	public String[] getBerechtigungen() {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT name FROM berechtigung");
			rs.last();
			int rowCnt = rs.getRow();
	        if (rowCnt != 0) { 
		        rs.first();
		        berechtigung = new String[rowCnt];
		        int i = 0;
		        do {
		        	berechtigung[i] = rs.getString("name");
	        		i++;
	        	}
		        while (rs.next() && i < rowCnt); 
	        }
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getBerechtigungen: "+ sqlEx.toString());
		}
		con.disconnect();
		return berechtigung;
	}
	
	public void updateBenutzer(int benutzer_id, String vorname, String name, int bereich_id, int berechtigung_id) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE bearbeiter SET vorname = '" + vorname + "', name = '" + name + "', bereich_id = '" + bereich_id + "', berechtigung_id = '" + berechtigung_id + "' WHERE bearbeiter_id = '" + benutzer_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at updateBenutzer: "+ sqlEx.toString());
		}
		con.disconnect(); 
	}
	
	public void updateLogin(int benutzer_id, String benutzername, String passwort) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE login SET benutzername = '" + benutzername + "', passwort = '" + passwort + "' WHERE bearbeiter_id = '" + benutzer_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at updateLogin: "+ sqlEx.toString());
		}
		con.disconnect(); 
	}
	
	public void insertNewBenutzer(String vorname, String name, int bereich_id, int berechtigung_id) {
		con.connect();
		try {
			con.stmt.executeUpdate("INSERT into bearbeiter (vorname, name, bereich_id, berechtigung_id) VALUES ('" + vorname + "', '" + name + "', '" + bereich_id + "', '" + berechtigung_id + "')");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at insertNewBenutzer: "+ sqlEx.toString());
		}
		con.disconnect(); 
	}
	
	public void insertNewLogin(int benutzer_id, String benutzername, String passwort) {
		con.connect();
		try {
			con.stmt.executeUpdate("INSERT into login (bearbeiter_id, benutzername, passwort) VALUES ('" + benutzer_id + "', '" + benutzername + "', '" + passwort + "')");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at insertNewLogin: "+ sqlEx.toString());
		}
		con.disconnect(); 
	}
	
	public int findLastBenutzerID() {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT MAX(bearbeiter_id) from bearbeiter");
			rs.last();
			bearbeiter_id = rs.getInt("MAX(bearbeiter_id)");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at findLastBenutzerID: "+ sqlEx.toString());
		}
		con.disconnect();
		return bearbeiter_id;
	}

}
