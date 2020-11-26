package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ArtikelOperations {
	
	SQLConnection con = new SQLConnection();
	
	private ResultSet rs = null;
	ResultSetMetaData rsmd;
	
//	private String warenkorb[][];
//	private int anzahl;
//	private boolean vorhanden;
//	private int artikel_id;
	private String kostenstelle;
	private String[] artikel = new String[7];
	private String[] lieferant;
//	private String[] kostenstellen;
	private double preis;
	private int lieferant_id;
	private int[] mwst;
	
	public String[] getArtikel(int artikel_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT a.referenz, a.name, a.preis, a.lieferant_id, l.kreditor, k.name, m.prozent FROM artikel a, kostenstelle k, lieferant l, mehrwertsteuer m WHERE a.artikel_id = '" + artikel_id + "' AND a.lieferant_id = l.lieferant_id AND l.kostenstelle_id = k.kostenstelle_id AND a.mwst_id = m.mwst_id ORDER BY l.lieferant_id ASC");
			rs.next();
			artikel[0] = rs.getString("a.referenz");
			artikel[1] = rs.getString("a.name");
			artikel[2] = rs.getString("a.preis");
			artikel[3] = rs.getString("l.kreditor");
			artikel[4] = rs.getString("k.name");
			artikel[5] = rs.getString("a.lieferant_id");
			artikel[6] = rs.getString("m.prozent") + " %";
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getArtikel: "+ sqlEx.toString());
		}
		con.disconnect();
		return artikel;
	}
	
	public String[] getLieferanten() {
		con.connect();
		try {
		//	rs = con.stmt.executeQuery("SELECT kreditor, k.name FROM lieferant l, kostenstelle k WHERE l.kostenstelle_id = k.kostenstelle_id");
			rs = con.stmt.executeQuery("SELECT kreditor FROM lieferant ORDER BY kreditor ASC");
			rs.last();
			int rowCnt = rs.getRow();
	        if (rowCnt != 0) { 
		        rs.first();
		        lieferant = new String[rowCnt];
		        int i = 0;
		        do {
		        	lieferant[i] = rs.getString("kreditor");
	        		i++;
	        	}
		        while (rs.next() && i < rowCnt); 
	        }
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getLieferanten: "+ sqlEx.toString());
		}
		con.disconnect();
		return lieferant;
	}
	
public int getLieferantID(String lieferant_name) {
		
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT lieferant_id FROM lieferant WHERE kreditor = '" + lieferant_name + "'");
			rs.last();
			lieferant_id = rs.getInt("lieferant_id");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getLieferantID: "+ sqlEx.toString());
		}
		con.disconnect();
		return lieferant_id;
	}
	
	public String getKostenstelle(String lieferant_name) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT k.name FROM kostenstelle k, lieferant l WHERE l.kreditor = '" + lieferant_name + "' AND l.kostenstelle_id = k.kostenstelle_id");
			rs.next();
			kostenstelle = rs.getString("k.name");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getKostenstellen: "+ sqlEx.toString());
		}
		con.disconnect();
		return kostenstelle;
	}
	
		
	public void updateArtikel(int artikel_id, String name, String referenz, double preis, int mwst_id, int lieferant_id) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE artikel SET name = '" + name + "', referenz = '" + referenz + "', preis = '" + preis + "', mwst_id = '" + mwst_id + "', lieferant_id = '" + lieferant_id + "' WHERE artikel_id = '" + artikel_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at updateArtikel: "+ sqlEx.toString());
		}
		con.disconnect(); 
	}
	
	public void updatePreis(int artikel_id, double preis) {
		con.connect();
		try {
			con.stmt.executeUpdate("INSERT INTO preis (artikel_id, preis) VALUES ('" + artikel_id + "', '" + preis + "')");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at updatePreis: "+ sqlEx.toString());
		}
		con.disconnect(); 
	}
	
	public void insertNewArtikel(String name, String referenz, double preis, int mwst_id, int lieferant_id) {
		con.connect();
		try {
			con.stmt.executeUpdate("INSERT into artikel (name, referenz, preis, mwst_id, lieferant_id) VALUES ('" + name + "', '" + referenz + "', '" + preis + "', '" + mwst_id + "', '" + lieferant_id + "')");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at insertNewArtikel: "+ sqlEx.toString());
		}
		con.disconnect(); 
	}
	
	public double getPreis(int artikel_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT preis FROM artikel WHERE artikel_id = '" + artikel_id + "'");
			rs.next();
			preis = rs.getDouble("preis");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getKostenstellen: "+ sqlEx.toString());
		}
		con.disconnect();
		return preis;
	}
	
	public int[] getMwSt() {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT prozent FROM mehrwertsteuer");
			rs.last();
			int rowCnt = rs.getRow();
	        if (rowCnt != 0) { 
		        rs.first();
		        mwst = new int[rowCnt];
		        int i = 0;
		        do {
		        	mwst[i] = rs.getInt("prozent");
	        		i++;
	        	}
		        while (rs.next() && i < rowCnt); 
	        }
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getMwSt: "+ sqlEx.toString());
		}
		con.disconnect();
		return mwst;
	}
	
	public void updateArtikelPreis(int artikel_id, double preis) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE artikel SET preis = '" + preis + "' WHERE artikel_id = '" + artikel_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at updateArtikelPreis: "+ sqlEx.toString());
		}
		con.disconnect(); 
	}

}
