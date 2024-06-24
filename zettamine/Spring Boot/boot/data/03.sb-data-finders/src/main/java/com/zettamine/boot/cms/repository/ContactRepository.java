package com.zettamine.boot.cms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zettamine.boot.cms.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

	Optional<Contact> findByContactName(String cname);

	Contact findByContactNumber(String cno);

	Optional<Contact> findByContactNameAndContactNumber(String cname, String cno);

	List<Contact> findByContactNameOrContactNumber(String string, String string2);
	
	//@Query("select contactName from com.zettamine.boot.cms.entity.Contact")
	@Query(value = "select contact_name from contact_master", nativeQuery = true)
	List<String> findContactNames();

	//Optional<Contact> findContactByContactName(String cname);
	
	//@Query("from com.zettamine.boot.cms.entity.Contact where contactName=:cname")
	//@Query("select ct from com.zettamine.boot.cms.entity.Contact ct where contactName=:cname")
	@Query(value = "select * from CONTACT_MASTER where CONTACT_NAME=:cname", nativeQuery = true)
	Optional<Contact> findContactByName(String cname);
	
	@Query("select contactName from com.zettamine.boot.cms.entity.Contact where contactName LIKE :cnameLike%")
	List<String> findNamesWith(String cnameLike);

	Contact findAllByContactName(String string);
}
