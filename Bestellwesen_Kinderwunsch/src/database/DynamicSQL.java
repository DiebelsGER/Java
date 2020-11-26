package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import database.SQLConnection;;

public class DynamicSQL {
	
	SQLConnection con = new SQLConnection();
		
	private ResultSet rs = null;
	ResultSetMetaData rsmd;
	
	private Object[][] data;
		
	public Object[][] getData(String sql) {
		con.connect();
		try {
			rs = con.stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			int clmCnt = rsmd.getColumnCount();
	        rs.last();
	        int rowCnt = rs.getRow();
	        if (rowCnt != 0) {
		        rs.first();
		        data = new Object[rowCnt][clmCnt];
		        int index = 0;
		        do {
		        	for(int i=0; i<clmCnt; i++ ) {
		        		data[index][i] = rs.getString(i+1);
		        	}
		        	index++;
		        }
		        while (rs.next());
	        }		    
		} catch (SQLException sqlEx) {
			System.out.println("SQL Exception at getData: "+ sqlEx.toString());
		}
		con.disconnect();
		return data;
	}

}
