package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FetchBookInfoDao {
	String query="Select * from bookinfo where id=?";
	String url="jdbc:mysql://localhost:3306/BookManagementSystemDB";
	String username="root";
	String password="Shwetha@29";

	public List<Book> fetchBookInfo(int id)
	{
		List<Book> book=new ArrayList<>();
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement pt=con.prepareStatement(query);
		pt.setInt(1, id);
		ResultSet rs=pt.executeQuery();
		while(rs.next())
		{
			Book bk =new Book(); //Book Class Object
			bk.setBookName(rs.getString("bookname"));
			System.out.println(rs.getString("img_path"));
			bk.setImgPath(rs.getString("img_path"));
			bk.setAuthor(rs.getString("author"));
			bk.setRating(rs.getString("rating"));
			bk.setBookId(rs.getInt("bookid"));
			book.add(bk); //Storing all the information in the List
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return book;
	}
}
