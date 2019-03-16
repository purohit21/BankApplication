package com.mindsticks.project.web.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEntry {
	
	
	public static String delete(int cid) {
		Connection conn;
		PreparedStatement pstmt;
		
		try {
			conn = GetConnection.initialize();

			String sql="delete from CustomerInfo where id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cid);
			

	        int rslt=pstmt.executeUpdate();

			pstmt.close();
			conn.close();
			
			if(rslt>0)
			return("Entry Deleted Successfully");
			else
			return("No Record found for given Entry");

		} catch (SQLException e) {
			e.printStackTrace();
			return("SQL Exception during Deleting Entry ");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return("Exception during Deleting Entry ");
		}

	}
}
