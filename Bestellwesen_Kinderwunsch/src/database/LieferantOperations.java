package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class LieferantOperations {
	
	SQLConnection con = new SQLConnection();
	
	private ResultSet rs = null;
	ResultSetMetaData rsmd;
	
	private String warenkorb[][];
	private int anzahl;
	private boolean vorhanden;
	private int artikel_id;
	private String kostenstelle;
	private String[] lieferant = new String[9];
	private String[] kostenstellen;
	
	public String[] getLieferant(int lieferant_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT l.kundennummer, l.kreditor, l.email, l.strasse, l.plz, l.ort, l.telefon, l.fax, k.name FROM kostenstelle k, lieferant l WHERE l.lieferant_id = '" + lieferant_id + "' AND l.kostenstelle_id = k.kostenstelle_id ORDER BY l.lieferant_id ASC");
			rs.next();
			lieferant[0] = rs.getString("l.kundennummer");
			lieferant[1] = rs.getString("l.kreditor");
			lieferant[2] = rs.getString("l.email");
			lieferant[3] = rs.getString("l.strasse");
			lieferant[4] = rs.getString("l.plz");
			lieferant[5] = rs.getString("l.ort");
			lieferant[6] = rs.getString("l.telefon");
			lieferant[7] = rs.getString("l.fax");
			lieferant[8] = rs.getString("k.name");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getLieferant: "+ sqlEx.toString());
		}
		con.disconnect();
		return lieferant;
	}
	
	public String[] getKostenstellen() {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT name FROM kostenstelle");
			rs.last();
			int rowCnt = rs.getRow();
	        if (rowCnt != 0) { 
		        rs.first();
		        kostenstellen = new String[rowCnt];
		        int i = 0;
		        do {
		        	kostenstellen[i] = rs.getString("name");
	        		i++;
	        	}
		        while (rs.next() && i < rowCnt); 
	        }
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getKostenstellen: "+ sqlEx.toString());
		}
		con.disconnect();
		return kostenstellen;
	} 
	
	public void updateLieferant(int lieferant_id, int kostenstelle_id, String name, String kundennummer, String email, String strasse, String plz, String ort, String telefon, String fax) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE lieferant SET kostenstelle_id = '" + kostenstelle_id + "', kreditor =  '" + name + "', kundennummer =  '" + kundennummer + "', email =  '" + email + "', strasse =  '" + strasse + "', plz =  '" + plz + "', ort =  '" + ort + "', telefon =  '" + telefon + "', fax =  '" + fax + "' WHERE lieferant_id = '" + lieferant_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at updateLieferant: "+ sqlEx.toString());
		}
		con.disconnect(); 
	}
	
	public void insertLieferant(int kostenstelle_id, String name, String kundennummer, String email, String strasse, String plz, String ort, String telefon, String fax) {
		con.connect();
		try {
			con.stmt.executeUpdate("INSERT INTO lieferant (kostenstelle_id, kreditor, kundennummer, email, strasse, plz, ort, telefon, fax) VALUES ('" + kostenstelle_id + "', '" + name + "', '" + kundennummer + "', '" + email + "', '" + strasse + "',  '" + plz + "',  '" + ort + "', '" + telefon + "', '" + fax + "')");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at insertLieferant: "+ sqlEx.toString());
		}
		con.disconnect(); 
	}
	
	public void updateKostenstelle(int kostenstelle_id, int nummer, String name) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE kostenstelle SET nummer =  '" + nummer + "', name =  '" + name + "' WHERE kostenstelle_id = '" + kostenstelle_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at updateKostenstelle: "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	public void insertKostenstelle(int nummer, String name) {
		con.connect();
		try {
			con.stmt.executeUpdate("INSERT INTO kostenstelle (nummer, name) VALUES ('" + nummer + "', '" + name + "')");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at insertKostenstelle: "+ sqlEx.toString());
		}
		con.disconnect(); 
	}

}
