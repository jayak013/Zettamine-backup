package com.zettamine.boot.rest.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.boot.rest.models.Book;
import com.zettamine.boot.rest.repository.BooksDAO;

@RestController
@RequestMapping("/library")
public class LibraryRestController {
	private List<Book> books = BooksDAO.getAllBooks();

	@GetMapping(path = "/book", 
				produces = { "application/json", "application/xml" })
	public ResponseEntity<Book> getBookDetails() {
		Book book = new Book();

		book.setBookId(4112356);
		book.setBookTitle("Java Complete Reference");
		book.setBookPrice(755.75f);

		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@GetMapping(path = "/book/{isbn}", 
				produces = { "application/json", "application/xml" })
	public ResponseEntity<?> getBookDetailsByISBN(@PathVariable Integer isbn) {
		Book  book = books.stream().filter(bk -> bk.getBookId().equals(isbn)).findAny().orElse(null);
		
		if(book != null)
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		else
			return new ResponseEntity<String>("no matching book found", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(path = "/books",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Book>> getAllBooks(){
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
}
