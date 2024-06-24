package com.zettamine.boot.cms.repository;

import org.springframework.data.repository.CrudRepository;

import com.zettamine.boot.cms.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
