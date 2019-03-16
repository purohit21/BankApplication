package com.mindsticks.project.web.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mindsticks.project.web.model.Customer;



public class GetEntry {
	
	public static ArrayList<Customer> getData() {
		
		ArrayList<Customer> cust=new ArrayList<Customer>();
		try {
			Connection conn=GetConnection.initialize();
			Statement st=conn.createStatement();
			
			String sql="select id,firstname,lastname,city from CustomerInfo;";
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				Customer cs=new Customer();
				cs.setCid(rs.getInt("id"));
				cs.setFirstname(rs.getString("firstname"));
				cs.setLastname(rs.getString("lastname"));
				cs.setCity(rs.getString("city"));
				cust.add(cs);	
					
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cust;
		
	}

	
}
