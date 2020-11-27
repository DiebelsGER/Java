package mysql.tables;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import mysql.connection.MySQLConnect;

public class AuftragTabelle {
			
	MySQLConnect con = new MySQLConnect();
		
	private ResultSet rs = null;
	
	private int result;
	
	private String auftrag[];
	private String nummer;
			
	public int checkAuftragNummer(String auftragNummer) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT nummer FROM auftrag WHERE nummer = '" + auftragNummer + "'");
			rs.last();
			result = rs.getRow();
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception: "+ sqlEx.toString());
		}
		con.disconnect();
		return result;
	}
	
	
	public int getAuftragID(String auftragNummer) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT auftrag_id FROM auftrag WHERE nummer = '" + auftragNummer + "'");
			rs.last();
			result = rs.getInt("auftrag_id");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception: "+ sqlEx.toString());
		}
		con.disconnect();
		return result;
	}
	
	
	public int getKundeID(String auftragNummer) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT kunde_id FROM auftrag WHERE nummer = '" + auftragNummer + "'");
			rs.last();
			result = rs.getInt("kunde_id");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception: "+ sqlEx.toString());
		}
		con.disconnect();
		return result;
	}
	
	
	public int getKieferID(String auftragNummer) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT kieferbereich_id FROM auftrag WHERE nummer = '" + auftragNummer + "'");
			rs.last();
			result = rs.getInt("kieferbereich_id");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception: "+ sqlEx.toString());
		}
		con.disconnect();
		return result;
	}
	
	
	public void updateErledigt(int auftrag_id, int erledigt) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE auftrag SET erledigt = '" + erledigt + "' WHERE auftrag_id = '" + auftrag_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception: "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	
	public String[] getAuftrag(int auftrag_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT a.nummer, a.datum, a.kunde_id, p.name, a.arbeitsart, a.zahnfarbe, a.legierung, a.erledigt, a.benutzer_id, " +
					"at.name, v.name, k.name, p.impex-plus FROM auftrag a, auftrag_typ at, versicherung v, kieferbereich k, patient p WHERE a.auftrag_id = '" + auftrag_id + 
					"' AND a.patient_id = p.patient_id AND at.auftrag_typ_id = a.auftrag_typ_id AND v.versicherung_id = a.versicherung_id AND k.kieferbereich_id = a.kieferbereich_id");
			rs.next();
			auftrag = new String[12];
			auftrag[0] = rs.getString("a.nummer");
			auftrag[1] = rs.getString("a.datum");
			auftrag[2] = rs.getString("a.kunde_id");
			auftrag[3] = rs.getString("a.patient");
			auftrag[4] = rs.getString("v.name");
			auftrag[5] = rs.getString("at.name");
			auftrag[6] = rs.getString("k.name");
			auftrag[7] = rs.getString("a.arbeitsart");
			auftrag[8] = rs.getString("a.zahnfarbe");
			auftrag[9] = rs.getString("a.legierung");
			auftrag[10] = rs.getString("a.benutzer_id");
			auftrag[11] = rs.getString("a.erledigt");
			
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getAuftrag: "+ sqlEx.toString());
		}
		con.disconnect();
		return auftrag;
	}


	
	public void addAuftragKommentar(int auftrag_id, String kommentar) {
		con.connect();
		try {
			con.stmt.executeUpdate("INSERT INTO auftrag_kommentar (auftrag_id, text) VALUES ('" + auftrag_id + "', '" + kommentar + "')");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception: "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	
	public int catchAuftragID(String nummer, String datum, int kunde_id, String patient, int versicherung_id, int auftrag_typ_id, int kieferbereich_id, String arbeitsart, String zahnfarbe, String legierung, int benutzer_id) {
		con.connect();
		try {
			con.stmt.executeUpdate("INSERT into auftrag (nummer, datum, kunde_id, patient, versicherung_id, auftrag_typ_id, kieferbereich_id, arbeitsart, zahnfarbe, legierung, benutzer_id" +
					") VALUES ('" + nummer + "', '" + datum + "', '" + kunde_id + "', '" + patient + "', '" + versicherung_id + "', '" + auftrag_typ_id + "', '" + kieferbereich_id +
					"', '" + arbeitsart + "', '" + zahnfarbe + "', '" + legierung + "', '" + benutzer_id + "')", Statement.RETURN_GENERATED_KEYS);  
			
			rs = con.stmt.getGeneratedKeys(); 
			  
			if (rs.next())
				result = rs.getInt(1);
						
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at catchAuftragID: "+ sqlEx.toString());
		}
		con.disconnect();
		return result;
	}
	
	
	public void updateAuftrag(int auftrag_id, String datum, int kunde_id, String patient, int versicherung_id, int auftrag_typ_id, String arbeitsart, String zahnfarbe, String legierung, int benutzer_id) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE auftrag SET datum = '" + datum + "', kunde_id = '" + kunde_id + "', patient = '" + patient + "', versicherung_id = '" + versicherung_id + 
					"', auftrag_typ_id = '" + auftrag_typ_id + "', arbeitsart = '" + arbeitsart + "', zahnfarbe = '" + zahnfarbe + 
					"', legierung = '" + legierung + "', benutzer_id = '" + benutzer_id + "' WHERE auftrag_id = '" + auftrag_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception: "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	public String freieAuftragNummerSuchen() {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT MIN(nummer+1) FROM auftrag WHERE nummer+1 NOT IN (SELECT nummer FROM auftrag)");
			rs.last();
			nummer = rs.getString("MIN(nummer+1)");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at freieAuftragNummerSuchen: "+ sqlEx.toString());
		}
		con.disconnect();
		return nummer;
	}
		
		
}
