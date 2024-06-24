package com.zettamine.boot.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zettamine.boot.cms.entity.Contact;
import com.zettamine.boot.cms.repository.ContactRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
    @Autowired
	private ContactRepository contactRepo;
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		Contact ct = null;
		/*
		//----- to get a Contact based on contactId( ID property value) -------
		int cid = 1025;
		Optional<Contact> optContact = contactRepo.findById(cid);
		if(optContact.isPresent()) {
			ct = optContact.get();
			System.out.println(ct);
		}else {
			System.out.println("--- no matching contact found ---");
		}
		*/
		
		/*
		//----- to get Contacts based on  multiple contactIds -----
		Iterable<Integer> cids = Arrays.asList(101,200,102,202,300,105);
		Iterable<Contact> contacts = contactRepo.findAllById(cids);
		contacts.forEach(cnt -> System.out.println(cnt));
		*/
		
		/*
		//----- to get all contacts -----
		Iterable<Contact> contacts = contactRepo.findAll();
		contacts.forEach(cnt -> System.out.println(cnt));
		*/
		
		//----- to get the number of contacts -----
		long noOfContacts = contactRepo.count();
		System.out.println("no of contacts = " + noOfContacts);
		
		//----- to check whether a contact is existing with a contactId or not
		boolean existsStatus = contactRepo.existsById(1015);
		System.out.println(existsStatus);
		
		//----- to delete a contact with contactId ----
		contactRepo.deleteById(105);		
	}

}
