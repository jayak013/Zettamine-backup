package com.zettamine.boot.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zettamine.boot.cms.entity.Contact;
import com.zettamine.boot.cms.services.IContactService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	@Autowired
	private IContactService conService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Contact> contacts = conService.getContactsInAscName();
		contacts.forEach(System.out::println);
		
	}

}
