package com.zettamine.boot.cms.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.zettamine.boot.cms.entity.Contact;
import com.zettamine.boot.cms.repository.ContactRepository;

@Service
public class ContactServiceImpl implements IContactService {
	private ContactRepository contactRepo;
	
	public ContactServiceImpl(ContactRepository contactRepo) {
		super();
		this.contactRepo = contactRepo;
	}

	@Override
	public List<Contact> getContactsInAscName() {
		//--- approach-1
		//List<Contact> contacts = contactRepo.findByOrderByContactName();
		//List<Contact> contacts = contactRepo.findByOrderByContactNameAsc();
		//List<Contact> contacts = contactRepo.findByOrderByContactNameDesc();
		
		//--- approach-2
		//List<Contact> contacts = contactRepo.findAll(Sort.by("contactName"));
		//List<Contact> contacts = contactRepo.findAll(Sort.by("contactName", "contactNumber"));
		//List<Contact> contacts = contactRepo.findAll(Sort.by("contactName").ascending());
		List<Contact> contacts = contactRepo.findAll(Sort.by("contactName").descending());
		
		return contacts;
	}

}
