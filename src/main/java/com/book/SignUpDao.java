package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUpDao {
	String query="select * from login where email=?";//Validating the email
	String insertQuery="insert into login values(?,?,?)";
	String url="jdbc:mysql://localhost:3306/BookManagementSystemDB";
	String username="root";
	String password="Shwetha@29";
	
	public boolean check(String uname,String pass,String email)
	{
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		if(con!=null)
			System.out.println("Connection Established Successfully");
		else
			System.out.println("Connection is not established");
		PreparedStatement pt1=con.prepareStatement(query);
		pt1.setString(1, email);
		ResultSet rs=pt1.executeQuery();
		if(rs.next())
		{
			System.out.println("Email Already Exists");
			return false;
		}
		
		
			PreparedStatement pt2=con.prepareStatement(insertQuery);
			pt2.setString(1, uname);
			pt2.setString(2, pass);
			pt2.setString(3, email);
			pt2.executeUpdate();
			
			
		
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	

}
