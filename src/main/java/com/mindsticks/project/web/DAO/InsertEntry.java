package com.mindsticks.project.web.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEntry {
	
	public static String insert(int cid, String first, String last, String city) {
		Connection conn;
		PreparedStatement pstmt;
		
		try {
			conn = GetConnection.initialize();

			String sql;
			sql = "insert into CustomerInfo values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cid);
			pstmt.setString(2, first);
			pstmt.setString(3, last);
			pstmt.setString(4, city);

			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

			return("Values Inserted Successfully");
			

		} catch (SQLException e) {
			e.printStackTrace();
			return("SQL Exception during Inserting Values ");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return("Exception during Inserting Values ");
		}

		
	}

}
