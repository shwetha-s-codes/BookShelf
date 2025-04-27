package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchBookId {
	String query="select bookid from bookinfo where bookname=? and author=? and rating=? and id=?";
	String url="jdbc:mysql://localhost:3306/BookManagementSystemDB";
	String username="root";
	String password="Shwetha@29" ;
	public int fetch(int id,String bookname,String author,String rating)
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement ptstmt=con.prepareStatement(query);
		
		ptstmt.setString(1,bookname);
		ptstmt.setString(2,author);
		ptstmt.setString(3,rating);
		ptstmt.setInt(4,id);
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
