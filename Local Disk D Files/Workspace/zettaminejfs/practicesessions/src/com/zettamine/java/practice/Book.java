package com.zettamine.java.practice;

public class Book {
	private Integer bookId;
	private String bookName;
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + "]";
	}
	public Book(Integer bookId, String bookName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Integer getBookId() {
		return bookId;
	}
	public String getBookName() {
		return bookName;
	}
	
	
}
