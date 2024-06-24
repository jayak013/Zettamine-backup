package com.zettamine.boot.cms;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zettamine.boot.cms.entities.Contact;
import com.zettamine.boot.cms.repository.ContactRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		ContactRepository contactRepo = context.getBean(ContactRepository.class);
		/*
		 * ContactRepository is an interface - then how come instance - uses Proxy
		 * Design Pattern implementation class is being created internally
		 */
		System.out.println("implementation class = " + contactRepo.getClass().getName());
		/*
		 * //----- saving or updating a Contact to persistence store/DB Table ------
		 * Contact contact = new Contact(); contact.setContactId(101);
		 * contact.setContactName("Sanjay Patil");
		 * contact.setContactNumber("9848586878");
		 * 
		 * //contactRepo.save(contact); Contact savedContact =
		 * contactRepo.save(contact); System.out.println(savedContact);
		 */

		// ------ saving multiple contacts -----------
		Contact ct1 = new Contact(102, "Siva Kumar", "7878454514");
		Contact ct2 = new Contact(103, "Mohammed Abdul", "7485857497");
		Contact ct3 = new Contact(104, "Rajesh", "6584748596");
		Contact ct4 = new Contact(105, "Prabhakar", "7485969685");

		List<Contact> contacts = Arrays.asList(ct1, ct2, ct3, ct4);
		contactRepo.saveAll(contacts);
		
		context.close();
	}

}
