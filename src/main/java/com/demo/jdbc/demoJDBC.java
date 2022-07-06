package com.demo.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class demoJDBC
 */
public class demoJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1/demotest";
		Connection con = (Connection) DriverManager.getConnection(url,"root","root");
		PreparedStatement pst=(PreparedStatement) con.prepareStatement("Select * from demotest.student");
		
		ResultSet rs = (ResultSet) pst.executeQuery();          
		if(rs.next())
		{
			Statement st=(Statement) con.createStatement();
			String email = rs.getString("email");
			out.println(email);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
