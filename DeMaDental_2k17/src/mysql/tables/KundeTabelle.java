package mysql.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import variables.Kunde;

import mysql.connection.MySQLConnect;

public class KundeTabelle {
	
	private MySQLConnect con = new MySQLConnect();
	private Kunde kunde = new Kunde();
	
	private ResultSet rs = null;
	
	private int result;
	
	private int kunde_id;
	
	private String kunde_name;
	private String[] kunde_namen;
	private String[] sonderwunsch;
	private String kzv;
	
	public void bla() {
		System.out.println("Bla");
	}
	
	
	public Kunde getKunde(int kunde_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT anrede, vorname, name, name2, name3, strasse, plz, ort, telefon, fax, email FROM kunde WHERE kunde_id = '" + kunde_id + "'");
			rs.next();
			kunde.anrede = rs.getString("anrede");
			kunde.vorname = rs.getString("vorname");
			kunde.name = rs.getString("name");
			kunde.name2 = rs.getString("name2");
			kunde.name3 = rs.getString("name3");
			kunde.strasse = rs.getString("strasse");
			kunde.plz = rs.getString("plz");
			kunde.ort = rs.getString("ort");
			kunde.telefon = rs.getString("telefon");
			kunde.fax = rs.getString("fax");
			kunde.email = rs.getString("email");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getKunde: "+ sqlEx.toString());
		}
		con.disconnect();
		return kunde;
	}
	
	
	public String getKundeName(int id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT vorname, name FROM kunde WHERE kunde_id = '" + id + "'");
			rs.last();
			kunde_name = rs.getString("vorname") + " " + rs.getString("name");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getKundeName: "+ sqlEx.toString());
		}
		con.disconnect();
		return kunde_name;
	}
	
	
	public String[] getAllKunde() {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT vorname, name FROM kunde ");
			rs.last();
	        int rowCnt = rs.getRow();
	        rs.first();
	        kunde_namen = new String[rowCnt];
	        int i = 0;
	        do {
	        	kunde_namen[i] = rs.getString("vorname") +  " " + rs.getString("name");
        		i++;
	        }
	        while (rs.next());    
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getAllKunde: "+ sqlEx.toString());
		}
		con.disconnect();
		return kunde_namen;
	}
	
	public String getAllKundeToTxt(String suchtext) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT vorname, name FROM kunde WHERE name LIKE '" + suchtext + "%' LIMIT 1");
			System.out.println("SELECT vorname, name FROM kunde WHERE name LIKE '" + suchtext + "%' LIMIT 1");
			rs.last();
			kunde_name = rs.getString("vorname") + " " + rs.getString("name");  
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getAllKunde: "+ sqlEx.toString());
		}
		con.disconnect();
		return kunde_name;
	}
		
	
	public Kunde getKZV(int kunde_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT identifizierung FROM kzv WHERE kunde_id = '" + kunde_id + "'");
			rs.last();
			if (rs.getRow() != 0) {
				kunde.kzv = rs.getString("identifizierung");
			}
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getKZV: "+ sqlEx.toString());
		}
		con.disconnect();
		return kunde;
	}
	
	
	public int getLastKundeID() {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT kunde_id FROM kunde ORDER BY kunde_id DESC LIMIT 1");
			rs.next();
			kunde_id = rs.getInt("kunde_id");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getLastKundeID: "+ sqlEx.toString());
		}
		con.disconnect();
		return kunde_id;
	}
	
	
	public int checkKundeID(int kunde_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT kunde_id FROM kunde WHERE kunde_id = '" + kunde_id + "'");
			rs.last();
			result = rs.getRow();
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at checkKundeID: "+ sqlEx.toString());
		}
		con.disconnect();
		return result;
	}
	
	
	public void updateKunde(int kunde_id, String anrede, String vorname, String name, String name2, String name3, String strasse, String plz, String ort, String telefon, String fax, String email) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE kunde SET anrede = '" + anrede + "', " +
					"vorname = '" + vorname + "', name = '" + name + "', name2 = '" + name2 + "', name3 = '" + name3 + 
					"', strasse = '" + strasse + "', plz = '" + plz + "', ort = '" + ort + "', telefon = '" + telefon + 
					"', fax = '" + fax + "', email = '" + email + "' WHERE kunde_id = '" + kunde_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at updateKunde: "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	
	public void updateKZV(int kunde_id, String identifizierung) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE kzv SET identifizierung = '" + identifizierung + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at updateKZV: "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	
	public void addKunde(int kunde_id, String anrede, String vorname, String name, String name2, String name3, String strasse, String plz, String ort, String telefon, String fax, String email) {
		con.connect();
		try {
			con.stmt.executeUpdate("INSERT INTO kunde (kunde_id, anrede, vorname, name, name2, name3, strasse, plz, ort, telefon, fax, email) VALUES ('" + kunde_id +
					"', '" + anrede + "', '" + vorname + "',  '" + name + "', '" + name2 + "', '" + name3 + 
					"', '" + strasse + "', '" + plz + "', '" + ort + "', '" + telefon + 
					"', '" + fax + "',  '" + email + "')");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at addKunde: "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	
	public void addKZV(int kunde_id, String identifizierung) {
		con.connect();
		try {
			con.stmt.executeUpdate("INSERT INTO kzv (kunde_id, identifizierung) VALUES ('" + kunde_id + "', '" + identifizierung + "')");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at addKZV: "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	public String[] getSonderwunsch(int kunde_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT wunsch FROM sonderwunsch WHERE kunde_id = '" + kunde_id + "'");
			rs.last();
			int rowCnt = rs.getRow();
			if (rowCnt != 0) {
		        rs.first();
		        sonderwunsch = new String[rowCnt];
		        int i = 0;
		        do {
		        	sonderwunsch[i] = rs.getString("wunsch");
	        		i++;
		        }
		        while (rs.next());
			}
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getLastKundeID: "+ sqlEx.toString());
		}
		con.disconnect();
		return sonderwunsch;
	}
	
	
	public int checkKZVID(int kunde_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT kzv_id FROM kzv WHERE kunde_id = '" + kunde_id + "'");
			rs.last();
			result = rs.getRow();
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at checkKZVID: "+ sqlEx.toString());
		}
		con.disconnect();
		return result;
	}
}
