package com.zettamine.materialinspection.service;

import java.util.List;
import java.util.Optional;

import com.zettamine.materialinspection.entities.Vendor;

public interface VendorService {
	
	Vendor addVendor(Vendor vendor);
	
	List<Vendor> getAllVendors();
	
	void removeVendor(Integer id);
	
	Optional<Vendor> getVendorById(Integer id);
	
}
