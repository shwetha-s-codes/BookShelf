package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookInfoDao {
	
	String insertQuery="insert into bookinfo (bookname,img_path,author,rating,id)values(?,?,?,?,?)";
	String url="jdbc:mysql://localhost:3306/BookManagementSystemDB";
	String username="root";
	String password="Shwetha@29";
	
	public void insert(String bookname, String filePath, String author,String rating,int id)
	{
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		
		PreparedStatement pt1=con.prepareStatement(insertQuery);
		pt1.setString(1,bookname);
		pt1.setString(2, filePath);
		pt1.setString(3, author);
		pt1.setString(4, rating);
		pt1.setInt(5, id);
		pt1.executeUpdate();
		System.out.println("Information Updated Successfully");
		
		
			
		
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	

}



