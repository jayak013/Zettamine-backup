package com.zettamine.boot.cms;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zettamine.boot.cms.entity.Contact;
import com.zettamine.boot.cms.repository.ContactRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private ContactRepository contactRepo;
	
	@Autowired
	public void setContactRepo(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Contact contact;
		
		Optional<Contact> optContact = contactRepo.findByContactName("Rajesh");
		if(optContact.isPresent()) {
			contact = optContact.get();
			System.out.println(contact);
		}else {
			System.out.println("no matching contact found");
		}
		
		Contact ct = contactRepo.findByContactNumber("7878454514");
		System.out.println(ct);
		
		Optional<Contact> optContact1 =contactRepo.findByContactNameAndContactNumber("Rajesh","6584748596");
		if(optContact1.isPresent()) {
			contact = optContact1.get();
			System.out.println(contact);
		}else {
			System.out.println("No matching contact found!!");
		}	
		
		List<Contact> contacts = contactRepo.findByContactNameOrContactNumber("Sanjay Patil","6584748596");
		contacts.forEach(cnt -> System.out.println(cnt.toString()));
		
		List<String> cNames = contactRepo.findContactNames();
		cNames.forEach(nme -> System.out.println(nme));
		
		Optional<Contact> optContact2 = contactRepo.findContactByName("Rajesh");
		if(optContact2.isPresent()) {
			contact = optContact2.get();
			System.out.println(contact);
		}else {
			System.out.println("No matching contact found!!");
		}
		
		List<String> names = contactRepo.findNamesWith("S");
		System.out.println(names);
		
		contact = contactRepo.findAllByContactName("Siva Kumar");
		System.out.println(contact);
	}
}