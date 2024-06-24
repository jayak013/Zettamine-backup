package com.zettamine.boot.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zettamine.boot.mvc.dto.Book;

@Controller
@RequestMapping("/lib")
public class LibraryController {

	@GetMapping("/test")
	public String book(Model model) {
		Book book = new Book(201,"two states",2300.45);
		model.addAttribute("testBook", book);
		return "testbook";
	}
	
	@GetMapping("/allbooks")
	public String books(Model model) {
		
		List<Book> books = new ArrayList<>();
		
		books.add(new Book(210,"Zaiba",3200.84));
		books.add(new Book(211,"Khan",2200.98));
		books.add(new Book(212,"Pervez",4500.74));
		
		model.addAttribute("list", books);
		return "list";
	}
	@GetMapping("/searchbook")
	public String searchBook(@RequestParam(value = "id",required = false,defaultValue = "0")Integer id ,Model model) {
		
		List<Book> books = new ArrayList<>();
		
		books.add(new Book(210,"Zaiba",3200.84));
		books.add(new Book(211,"Khan",2200.98));
		books.add(new Book(212,"Pervez",4500.74));
		
		Optional<Book> optBook = books.stream().filter(bk->bk.getBookId().equals(id)).findFirst();
		
		Book book = optBook.get();
		
		System.out.println(book);
		
		model.addAttribute("testBook", book);
		
		return "testbook";
	}
	
	@GetMapping("/searchbook/{Zai}")
	public String searchBookPV(@PathVariable(value = "Zai") Integer id ,Model model) {
		
		List<Book> books = new ArrayList<>();
		
		books.add(new Book(210,"Zaiba",3200.84));
		books.add(new Book(211,"Khan",2200.98));
		books.add(new Book(212,"Pervez",4500.74));
		
		Optional<Book> optBook = books.stream().filter(bk->bk.getBookId().equals(id)).findFirst();
		
		Book book = optBook.get();
				
		model.addAttribute("testBook", book);
		
		return "testbook";
	}
}
