package com.zettamine.boot.cms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zettamine.boot.cms.entities.Contact;

@Repository //optional
public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
