package com.zettamine.boot.cms.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.boot.cms.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {
	//List<Contact> findByOrderByContactName();
	
	List<Contact> findByOrderByContactNameAsc();

	List<Contact> findByOrderByContactNameDesc();


}
