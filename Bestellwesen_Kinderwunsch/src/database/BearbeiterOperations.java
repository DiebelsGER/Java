package database;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BearbeiterOperations {
	
	SQLConnection con = new SQLConnection();

	private ResultSet rs = null;
	ResultSetMetaData rsmd;
	
	private String[] benutzer_rechte_namen;
	private String[] benutzer;
	
	private int result;
	private int benutzer_id;
	private int benutzer_rechte_id;
	private int[] programm_berechtigungen;
	private String benutzer_name;
	
	private String berechtigung_name;
	
	public String[] getBenutzer(int benutzer_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT b.berechtigung_id, b.vorname, b.name, br.name FROM bearbeiter b, berechtigung br WHERE b.bearbeiter_id = '" + benutzer_id + "' AND br.berechtigung_id = b.berechtigung_id");
			rs.last();
	        benutzer = new String[4];
        	benutzer[0] = rs.getString("b.berechtigung_id");
        	benutzer[1] = rs.getString("b.vorname");
        	benutzer[2] = rs.getString("b.name");
        	benutzer[3] = rs.getString("br.name");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getBenutzer: "+ sqlEx.toString());
		}
		con.disconnect();
		return benutzer;
	}
	
	
	public int getBenutzerRecht(int benutzer_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT benutzer_rechte_id FROM benutzer WHERE benutzer_id = '" + benutzer_id + "'");
			rs.next();
			benutzer_rechte_id = rs.getInt("benutzer_rechte_id");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getLastBenutzerID: "+ sqlEx.toString());
		}
		con.disconnect();
		return benutzer_rechte_id;
	}
	
	
	public int getLastBenutzerID() {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT benutzer_id FROM benutzer ORDER BY benutzer_id DESC LIMIT 1");
			rs.next();
			benutzer_id = rs.getInt("benutzer_id");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getLastBenutzerID: "+ sqlEx.toString());
		}
		con.disconnect();
		return benutzer_id;
	}
	
	
	public int checkBenutzerID(int benutzer_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT benutzer_id FROM benutzer WHERE benutzer_id = '" + benutzer_id + "'");
			rs.last();
			result = rs.getRow();
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getLastBenutzerID: "+ sqlEx.toString());
		}
		con.disconnect();
		return result;
	}
	
	
	public String[] getBenutzerRechteNamen() {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT name FROM benutzer_rechte");
	        rs.last();
	        int rowCnt = rs.getRow();
	        rs.first();
	        benutzer_rechte_namen = new String[rowCnt];
	        int i = 0;
	        do {
        		benutzer_rechte_namen[i] = rs.getString("name");
        		i++;
	        }
	        while (rs.next());    
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getBenutzerRechteNamen: "+ sqlEx.toString());
		}
		con.disconnect();
		return benutzer_rechte_namen;
	}
	
	public int[] getProgrammBerechtigungen(int benutzer_recht) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT funktion FROM programm_berechtigungen WHERE benutzer_recht = '" + benutzer_recht + "' ORDER BY funktion ASC");
	        rs.last();
	        int rowCnt = rs.getRow();
	        rs.first();
	        programm_berechtigungen = new int[rowCnt];
	        int i = 0;
	        do {
	        	programm_berechtigungen[i] = rs.getInt("funktion");
        		i++;
	        }
	        while (rs.next());    
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getProgrammBerechtigungen: "+ sqlEx.toString());
		}
		con.disconnect();
		return programm_berechtigungen;
	}
	
	
	public void addBenutzer(int benutzer_id, int benutzer_rechte_id, String vorname, String name) {
		con.connect();
		try {
			con.stmt.executeUpdate("INSERT INTO benutzer (benutzer_id, benutzer_rechte_id, vorname, name) VALUES ('" + benutzer_id + "', '" + benutzer_rechte_id + 
					"', '" + vorname + "', '" + name + "')");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at addBenutzer: "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	public void updateBenutzer(int benutzer_id, int benutzer_rechte_id, String vorname, String name) {
		con.connect();
		try {
			con.stmt.executeUpdate("UPDATE benutzer SET benutzer_rechte_id = '" + benutzer_rechte_id + "', " +
					"vorname = '" + vorname + "', name = '" + name + "' WHERE benutzer_id = '" + benutzer_id + "'");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at updateBenutzer: "+ sqlEx.toString());
		}
		con.disconnect();
	}
	
	/* ------------------------------------------------ */
	
	
	public String getBearbeiterName(int id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT vorname, name FROM bearbeiter WHERE bearbeiter_id = '" + id + "'");
			rs.last();
			benutzer_name = rs.getString("vorname") + " " + rs.getString("name");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getBenutzerName: "+ sqlEx.toString());
		}
		con.disconnect();
		return benutzer_name;
	}
	
	public String getBearbeiterBerechtigung(int benutzer_id) {
		con.connect();
		try {
			rs = con.stmt.executeQuery("SELECT r.name FROM berechtigung r, bearbeiter b WHERE b.bearbeiter_id = '" + benutzer_id + "' AND r.berechtigung_id = b.berechtigung_id");
			rs.next();
			berechtigung_name = rs.getString("r.name");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getLastBenutzerID: "+ sqlEx.toString());
		}
		con.disconnect();
		return berechtigung_name;
	}
	
}