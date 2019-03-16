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
import com.mindsticks.project.web.DAO.UpdateEntry;

/**
 * Servlet implementation class UpdateDataController
 */
@WebServlet("/updateData")
public class UpdateDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader reader = request.getReader();
	    while ((line = reader.readLine()) != null) {
	      sb.append(line);
	    }
	    
	    JSONObject jsonobj = new JSONObject(sb.toString());
	       
	    String customerid=jsonobj.getString("cid");
	    int id=Integer.parseInt(customerid);
	    
	    String updateResult=UpdateEntry.update(id, jsonobj.getString("city"));
	    System.out.println(updateResult);
	    response.setHeader("Result", updateResult);
	   
	    

		
	}

}
