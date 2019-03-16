package com.mindsticks.project.web.Contoller;

import java.io.BufferedReader;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.mindsticks.project.web.DAO.InsertEntry;

/**
 * Servlet implementation class insertDataController
 */
@WebServlet("/insertData")
public class InsertDataController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader reader = request.getReader();
	    while ((line = reader.readLine()) != null) {
	      sb.append(line);
	    }
	    
	    JSONObject jsonobj = new JSONObject(sb.toString());
	       
	    String customerid=jsonobj.getString("cid");
	    int id=Integer.parseInt(customerid);
	    
	    String insertionResult=InsertEntry.insert(id,jsonobj.getString("first"), jsonobj.getString("last"), jsonobj.getString("city"));
	    System.out.println(insertionResult);
	    response.setHeader("Result", insertionResult);
	   
	    
	   
	}

}
