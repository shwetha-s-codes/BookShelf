package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDao {
	String query="delete from bookinfo where id=? AND bookid=?";
	String url="jdbc:mysql://localhost:3306/BookManagementSystemDB";
	String username="root";
	String password="Shwetha@29";
	
	public void deleteInfo(int id,int bookid)
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement pt=con.prepareStatement(query);
		pt.setInt(1, id);
		pt.setInt(2,bookid);
		pt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
