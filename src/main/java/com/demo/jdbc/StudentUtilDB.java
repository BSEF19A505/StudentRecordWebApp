package com.demo.jdbc;

import java.sql.DriverManager;

import java.util.ArrayList;
import java.util.List;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class StudentUtilDB {
	Connection con=null;
	ResultSet rs=null;
	Statement st=null;
	public StudentUtilDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1/demotest";
		con = (Connection) DriverManager.getConnection(url,"root","root");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Student> getStudents() throws Exception{
		List<Student> students= new ArrayList<>();
		
		try {
		PreparedStatement pst=(PreparedStatement) con.prepareStatement("Select * from studentinfo.record");
		
		 rs = (ResultSet) pst.executeQuery();          
		while(rs.next())
		{
			 st=(Statement) con.createStatement();
		
			 String Email = rs.getString("email");
			String FirstName=rs.getString("firstname");
			String LastName=rs.getString("lastname");
			int ID=rs.getInt("id");
			
			
			Student tempstudent=new Student(ID,FirstName,LastName,Email);
			students.add(tempstudent);
				
		}
		return students;
		}finally {
			con.close();
			st.close();
			rs.close();
		}
		
		
	
	}
}



