package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//Pasting Jar File Properties-> Java Build Path-> Add
public class LoginDao {
	String query="select * from login where uname=? and password=? and email=?";
	String url="jdbc:mysql://localhost:3306/BookManagementSystemDB";
	String username="root";
	String password="Shwetha@29";
	
	public boolean check(String uname,String pass,String email)
	{
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,uname);
		st.setString(2,pass);
		st.setString(3, email);
		ResultSet rs=st.executeQuery();
		if(rs.next())
		{
			return true;
		}
	
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	}


