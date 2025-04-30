package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateInfoDao {
	String query="update  bookinfo set bookname=? , img_path=?, author=?,rating=? where id=? AND bookid=?";
	String url="jdbc:mysql://localhost:3306/BookManagementSystemDB";
	String username="root";
	String password="Shwetha@29" ;
    public void update(String bookname, String fileName, String author,String rating,int id,int bookid)
    {
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con=DriverManager.getConnection(url,username,password);
    		PreparedStatement pt=con.prepareStatement(query);
    		pt.setString(1, bookname);
    		pt.setString(2, fileName);
    		pt.setString(3, author);
    		pt.setString(4, rating);
    		pt.setInt(5, id);
    		pt.setInt(6, bookid);
    		pt.executeUpdate();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}
