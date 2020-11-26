package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BestellungOperations {
	
	SQLConnection con = new SQLConnection();
	
	private ResultSet rs = null;
	ResultSetMetaData rsmd;
	
	private String warenkorb[][];
	private int anzahl;
	private boolean vorhanden;
	private int artikel_id;
	private String[] artikel = new String[5];
	private String[] lieferant;
	private String[] kostenstelle;
	private String eMailAdresse;
	private String kundennummer;
	private int bestell_nr;
	private String kreditor;
		
	public void addArtikelInWarenkorb(int bearbeiter_id, int artikel_id, double preis, int anzahl) {
		con.connect();
		try {
			con.stmt.executeUpdate("INSERT INTO warenkorb (bearbeiter_id, artikel_id, preis, anzahl) VALUES ('" + bearbeiter_id + "', '" + artikel_id + "', '" + preis + "', '" + anzahl + "')");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at addArtikelInWarenkorb : "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	public boolean checkArtikelInWarenkorb(int bearbeiter_id, int artikel_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT COUNT(*) FROM warenkorb WHERE bearbeiter_id = '" + bearbeiter_id + "' AND artikel_id = '" + artikel_id + "'");
			rs.last();
			vorhanden = rs.getBoolean(1);
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at checkArtikelInWarenkorb: "+ sqlEx.toString());
		}
		con.disconnect();
		return vorhanden;
	}
	
	public void updateArtikelInWarenkorb(int bearbeiter_id, int artikel_id, int anzahl) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE warenkorb SET anzahl = '" + anzahl + "' WHERE bearbeiter_id = '" + bearbeiter_id + "' AND artikel_id = '" + artikel_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at updateArtikelInWarenkorb: "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	public void deleteArtikelVonWarenkorb(int bearbeiter_id, int artikel_id) {
		con.connect();
		try {
			con.stmt.executeUpdate("DELETE FROM warenkorb WHERE bearbeiter_id = '" + bearbeiter_id + "' AND artikel_id = '" + artikel_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at deleteArtikelVonWarenkorb : "+ sqlEx.toString());
		}
		con.disconnect();
	}
		
	public int getAnzahlArtikelInWarenkorb(int bearbeiter_id) {
		
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT COUNT(*) FROM warenkorb WHERE bearbeiter_id = '" + bearbeiter_id + "'");
			rs.last();
			anzahl = rs.getInt(1);
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getAnzahlArtikelInWarenkorb: "+ sqlEx.toString());
		}
		con.disconnect();
		return anzahl;
	}
	
	public String[][] getArtikelInWarenkorb(int bearbeiter_id) {
		
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT a.referenz, a.name, w.anzahl, w.preis, w.preis*w.anzahl, l.lieferant_id, w.artikel_id FROM artikel a, lieferant l, warenkorb w WHERE w.bearbeiter_id = '" + bearbeiter_id + "' AND a.lieferant_id = l.lieferant_id ORDER BY l.lieferant_id ASC");
			rs.last();
			int rowCnt = rs.getRow();
	        if (rowCnt != 0) { 
		        rs.first();
		        warenkorb = new String[6][rowCnt];
		        int i = 0;
		        do {
		        	warenkorb[0][i] = rs.getString("l.lieferant_id");
		        	warenkorb[1][i] = rs.getString("a.name");
		        	warenkorb[2][i] = rs.getString("w.anzahl");
					warenkorb[3][i] = rs.getString("w.preis");
				//	warenkorb[4][i] = rs.getString("a.preis*w.anzahl");
					warenkorb[4][i] = rs.getString("w.artikel_id");
					warenkorb[5][i] = rs.getString("a.referenz");
	        		i++;
	        	}
		        while (rs.next() && i < rowCnt); 
	        }
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getArtikelInWarenkorb: "+ sqlEx.toString());
		}
		con.disconnect();
		return warenkorb;
	}
	
	public void updateArtikelAnzahlUndPreisInWarenkorb(int bearbeiter_id, int artikel_id, int anzahl, double preis) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE warenkorb SET anzahl = '" + anzahl + "', preis = '" + preis + "' WHERE bearbeiter_id = '" + bearbeiter_id + "' AND artikel_id = '" + artikel_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at updateArtikelAnzahlUndPreisInWarenkorb : "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
/*	public String getEmailAdresse(int bearbeiter_id, int artikel_id, int lieferant_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT l.email FROM lieferant l, warenkorb w, artikel a WHERE w.bearbeiter_id = '" + bearbeiter_id + "' AND a.artikel_id = '" + artikel_id + "' AND a.lieferant_id = l.lieferant_id AND l.lieferant_id = '" + lieferant_id + "'");
			rs.last();
			eMailAdresse = rs.getString("l.email");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getEmailAdresse: "+ sqlEx.toString());
		}
		con.disconnect();
		return eMailAdresse;
	} */
	
	public String getEmailAdresse(int lieferant_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT email FROM lieferant WHERE lieferant_id = '" + lieferant_id + "'");
			rs.last();
			eMailAdresse = rs.getString("email");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getEmailAdresseShort: "+ sqlEx.toString());
		}
		con.disconnect();
		return eMailAdresse;
	}
	
	public String getKundenNummer(int lieferant_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT kundennummer FROM lieferant WHERE lieferant_id = '" + lieferant_id + "'");
			rs.last();
			kundennummer = rs.getString("kundennummer");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getKundenNummer: "+ sqlEx.toString());
		}
		con.disconnect();
		return kundennummer;
	}
	
	public String getLieferantName(int lieferant_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT kreditor FROM lieferant WHERE lieferant_id = '" + lieferant_id + "'");
			rs.last();
			kreditor = rs.getString("kreditor");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getLieferantName: "+ sqlEx.toString());
		}
		con.disconnect();
		return kreditor;
	}
	
	public void deleteArtikelAusWarenkorb(int bearbeiter_id) {
		con.connect();
		try {
			con.stmt.executeUpdate("DELETE FROM warenkorb WHERE bearbeiter_id = '" + bearbeiter_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at deleteArtikelAusWarenkorb : "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	public void insertArtikelInBestellung(int bestell_nr, int bearbeiter_id, int artikel_id, double preis, int anzahl) {
		con.connect();
		try {
			con.stmt.executeUpdate("INSERT INTO bestellung (bestell_nr, bearbeiter_id, artikel_id, preis, anzahl) VALUES ('" + bestell_nr + "', '" + bearbeiter_id + "', '" + artikel_id + "', '" + preis + "', '" + anzahl + "')");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at insertArtikelInBestellung : "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	public int findLastBestellNr() {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT MAX(bestell_nr) from bestellung");
			rs.last();
			bestell_nr = rs.getInt("MAX(bestell_nr)");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at findLastBestellNr: "+ sqlEx.toString());
		}
		con.disconnect();
		return bestell_nr;
	}
	
}

