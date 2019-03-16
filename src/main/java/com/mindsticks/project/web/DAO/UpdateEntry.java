package com.mindsticks.project.web.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEntry {

	public static String update(int cid, String city) {
		Connection conn;
		PreparedStatement pstmt;
		
		try {
			conn = GetConnection.initialize();

			String sql;
			sql="update CustomerInfo set city=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, city);
			pstmt.setInt(2, cid);
			

			int rows=pstmt.executeUpdate();

			pstmt.close();
			conn.close();
			if(rows>0)
			return("Value Updated Successfully");
			else
			return("No matching record found");

		} catch (SQLException e) {
			e.printStackTrace();
			return("SQL Exception during Updating Values ");
						
		} catch (Exception e) {
			e.printStackTrace();
			return("Exception during Updating Values ");
		}

		
	}
}
