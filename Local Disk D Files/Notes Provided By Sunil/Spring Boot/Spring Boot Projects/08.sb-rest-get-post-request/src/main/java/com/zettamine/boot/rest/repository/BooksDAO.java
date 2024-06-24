package com.zettamine.boot.rest.repository;

import java.util.ArrayList;
import java.util.List;

import com.zettamine.boot.rest.models.Book;

public class BooksDAO {
	public static List<Book> getAllBooks(){
		List<Book> books = new ArrayList<Book>();
		
		Book book1 = new Book(100123, "Java Reference", 575.50f);
		Book book2 = new Book(100124, "Python Reference", 750f);
		Book book3 = new Book(100125, "Microservices Reference", 875.50f);
		Book book4 = new Book(100126, "Spring with Spring Boot Reference", 1275.50f);
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		
		return books;
	}
}
