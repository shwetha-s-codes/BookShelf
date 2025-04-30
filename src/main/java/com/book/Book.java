package com.book;

public class Book {
	
	String bookname;
	String img_path;
	String author;
	String rating;
	int bookId;
	//Setters and Getters
	
	public void setBookName(String bookname)
	{
		
		this.bookname=bookname;
		
	}
	
	public String getBookName()
	{
		
		return bookname;
	}
	
	public void setImgPath(String img_path)
	{
		this.img_path=img_path;
		System.out.println(img_path);
		
	}
	
	public String getImgPath()
	{
		System.out.println(img_path);
		return img_path;
		
	}
	
	
	public void setAuthor(String author)
	{
		this.author=author;
		
	}
	
	
	public String getAuthor()
	{
		
		return author;
	}
	
	
	public void setRating(String rating)
	{
		this.rating=rating;
	}

	
	public String getRating()
	{
		
		return rating;
	}
	public void setBookId(int bookId)
	{
		this.bookId=bookId;
	}
	public int  getBookId()
	{
		return bookId;
	}

}
