package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FetchToUpdate {
	String query="select * from bookinfo where id=? AND  bookid=?";
	String url="jdbc:mysql://localhost:3306/BookManagementSystemDB";
	String username="root";
	String password="Shwetha@29" ;
	public Book fetch(int id,int bookId)
	
	{
		//List<Book> book=new ArrayList<>();
		Book b1=new Book();
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement ptstmt=con.prepareStatement(query);
		
		ptstmt.setInt(1,id);
		ptstmt.setInt(2,bookId);
		
		ResultSet rs=ptstmt.executeQuery();
		
		if(rs.next())
		{
			b1.setBookName(rs.getString("bookname"));
			b1.setImgPath(rs.getString("img_Path"));
			b1.setAuthor(rs.getString("author"));
			b1.setRating(rs.getString("rating"));
			
			
		}
		
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b1;
		
	}

}
