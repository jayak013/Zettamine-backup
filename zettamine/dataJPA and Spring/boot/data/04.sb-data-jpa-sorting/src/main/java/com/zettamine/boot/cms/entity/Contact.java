package com.zettamine.boot.cms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "CONTACT_MASTER")
public class Contact {
	@Id
	private Integer contactId;
	private String contactName;
	private String contactNumber;
	
	@Override
	public String toString() {
		return String.format("Contact [%3d | %-19s | %-10s]", contactId , contactName, contactNumber);
	}	
}
