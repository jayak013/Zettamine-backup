package com.zettamine.boot.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zettamine.boot.mvc.dto.Book;

@Controller
@RequestMapping("/library")
public class LibraryController {
	
	@GetMapping("/book")
	public String book(Model model) {
		
		Book b = new Book();
		b.setBookId(101);
		b.setBookName("Chethan Bagh");
		b.setBookPrice("20000");
		
		model.addAttribute("book", b);
		return "book";
	}
	
	@GetMapping("/books")
	public String books(Model model) {
		
		List<Book> books = new ArrayList<>();
		
		books.add(new Book(101,"chethan","3200"));
		books.add(new Book(102,"keerthan","2200"));
		books.add(new Book(103,"mahaan","4500"));
		
		model.addAttribute("books", books);
		return "books";
	}
	
	@GetMapping("/search")
	public String books(@RequestParam(value = "isbn",required = false,defaultValue = "0") Integer isbn,Model model) {
		
		List<Book> books = new ArrayList<>();
		
		books.add(new Book(101,"chethan","3200"));
		books.add(new Book(102,"keerthan","2200"));
		books.add(new Book(103,"mahaan","4500"));
		
		Book book = new Book();
		for(Book b:books) {
			if(isbn.equals(b.getBookId())) {
				book = b;
			}
		}
		
		model.addAttribute("book", book);
		return "book";
	}
	@GetMapping("/search/{id}")
	public String bookPathVariable(@PathVariable(value = "id",required = false) Integer isbn,Model model) {
		
		List<Book> books = new ArrayList<>();
		
		books.add(new Book(101,"chethan","3200"));
		books.add(new Book(102,"keerthan","2200"));
		books.add(new Book(103,"mahaan","4500"));
		
		Book book = new Book();
		for(Book b:books) {
			if(isbn.equals(b.getBookId())) {
				book = b;
			}
		}
		
		model.addAttribute("book", book);
		return "book";
	}
}
