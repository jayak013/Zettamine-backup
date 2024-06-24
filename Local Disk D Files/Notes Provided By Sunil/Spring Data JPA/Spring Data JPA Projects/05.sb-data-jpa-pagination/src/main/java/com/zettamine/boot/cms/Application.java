package com.zettamine.boot.cms;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.zettamine.boot.cms.entity.Contact;
import com.zettamine.boot.cms.repository.ContactRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		ContactRepository repo = context.getBean(ContactRepository.class);
		
		int pageNo = 0;
		int pageSize = 4;
		/*
		Page<Contact> page = repo.findAll(Pageable.ofSize(pageSize));
		List<Contact> contacts = page.getContent();
		printContacts(contacts);
		*/
		
		/*
		Page<Contact> page = repo.findAll(PageRequest.of(pageNo, pageSize));
		List<Contact> contacts = page.getContent();
		printContacts(contacts);
		*/
		
		long noOfContacts = repo.count();
		long noOfPages = noOfContacts / pageSize;
		
		if(noOfContacts % pageSize !=0 ) {
			noOfPages++;
		}
		
		for(int i=0; i<noOfPages; i++) {
			Page<Contact> page = repo.findAll(PageRequest.of(i, pageSize));
			List<Contact> contacts = page.getContent();
			printContacts(i, noOfPages, contacts);
		}
	}

	private static void printContacts(int pageNo, long noOfPages, List<Contact> contacts) {
		System.out.printf("------- Contacts %d / %d -------\n", (pageNo+1), noOfPages);
		contacts.forEach(System.out::println);	
		System.out.println();
	}

	private static void printContacts(List<Contact> contacts) {
		contacts.forEach(System.out::println);		
	}
}
