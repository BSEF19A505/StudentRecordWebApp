package com.demo.jdbc;

import java.io.IOException;

import java.util.List;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
private StudentUtilDB studentutil=new StudentUtilDB();
	
	 
	    
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		listStudents(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}





	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Student> students=studentutil.getStudents();
		request.setAttribute("Students-list", students);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
