package com.zettamine.boot.cms.services;

import java.util.List;

import com.zettamine.boot.cms.entity.Contact;

public interface IContactService {
	public List<Contact> getContactsInAscName();
}
