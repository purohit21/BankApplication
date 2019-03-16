package com.mindsticks.project.web.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindsticks.project.web.model.Customer;

public class GetConnection {
	
	public static Connection initialize() throws SQLException, Exception{
		
	    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    final String DB_URL="jdbc:mysql://localhost/test";

	      //  Database credentials
	      final String USER = "root";
	      final String PASS = "Pavan@21";
	      Connection conn; 
	      
    		Class.forName(JDBC_DRIVER);
    		 conn = DriverManager.getConnection(DB_URL, USER, PASS);
	  	
		return conn;
		
	}

}
