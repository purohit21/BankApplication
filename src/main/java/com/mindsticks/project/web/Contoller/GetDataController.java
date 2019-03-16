package com.mindsticks.project.web.Contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mindsticks.project.web.DAO.GetEntry;
import com.mindsticks.project.web.model.Customer;

import java.util.ArrayList;

/**
 * Servlet implementation class GetDataController
 */
@WebServlet("/getData")
public class GetDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		
		ArrayList<Customer> dataEntries=(ArrayList<Customer>) GetEntry.getData();
		System.out.println(dataEntries);
		Gson gson = new Gson();
		String jsonList = gson.toJson(dataEntries);
		
	
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		out.print(jsonList);
		
		
		
				
	}

}