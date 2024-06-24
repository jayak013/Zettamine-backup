package com.zettamine.materialinspection.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;


import com.zettamine.materialinspection.entities.Vendor;


public interface VendorRepository extends JpaRepository<Vendor, Serializable> {
	
}
