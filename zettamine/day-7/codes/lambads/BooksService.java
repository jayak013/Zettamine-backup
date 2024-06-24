package com.zettamine.java.lambads;

import java.util.Collections;
import java.util.List;

public class BooksService {
	public List<Book> getBooksInOrderOfBookId(){
		BooksDAO dao = new BooksDAO();
		
		List<Book> allBooks = dao.getAllBooks();
		
		Collections.sort(allBooks, (o1, o2) ->  o1.getBookId() - o2.getBookId());					

		return allBooks;
	}
}
