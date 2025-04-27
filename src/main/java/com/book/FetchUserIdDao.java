package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchUserIdDao {
	String query="select id from login where uname=? and password=? and email=?";
	String url="jdbc:mysql://localhost:3306/BookManagementSystemDB";
	String username="root";
	String password="Shwetha@29" ;
	public int userId(String uname,String pass,String email)
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement ptstmt=con.prepareStatement(query);
		ptstmt.setString(1,uname);
		ptstmt.setString(2,pass);
		ptstmt.setString(3,email);
		ResultSet rs=ptstmt.executeQuery();
		
		if(rs.next())
		{
			return rs.getInt(1);
		}
		
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return -1;
		
	}

}
