package com.zettamine.materialinspection.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.materialinspection.entities.Vendor;
import com.zettamine.materialinspection.service.VendorService;

@RestController
@RequestMapping("/user")
public class VendorController {

	private VendorService vendorService;

	public VendorController(VendorService vendorService) {
		this.vendorService = vendorService;
	}

	@PostMapping("/vendor")
	public String saveVendor(@RequestBody Vendor vendor) {
		vendorService.addVendor(vendor);
		return  "Vendor is added successfully";
	}
	
	@PutMapping("/vendor")
	public String updateVendor(@RequestBody Vendor vendor) {
		Optional<Vendor> vendorById = vendorService.getVendorById(vendor.getVendorId());
		if(vendorById.isPresent()) {
			vendorService.addVendor(vendor);
			return "Vendor is Updated Successfully";
		}
		return "Vendor is not available. So Unable to Update";
	}

	@GetMapping("/vendors")
	public List<Vendor> showAllVendors() {
		List<Vendor> listOfVendors = vendorService.getAllVendors();
		return listOfVendors;
	}

	@DeleteMapping("/vendor/{id}")
	public String deleteVendor(@PathVariable("id") Integer id) {
		Optional<Vendor> vendor = vendorService.getVendorById(id);
		if(vendor.isPresent()) {
			vendorService.removeVendor(id);
			return "Vendor is removed successfully";
		}
		return "Vendor with ID "+id+" is not available";
		
	}
	
	@GetMapping("/vendor/{id}")
	public ResponseEntity<?> getMethodName(@PathVariable Integer id) {
		Optional<Vendor> vendor = vendorService.getVendorById(id);
		if(vendor.isPresent()) {
			return new ResponseEntity<Vendor>(vendor.get(), HttpStatus.OK);
		}
		return new ResponseEntity<String>("Vedor is not available", HttpStatus.NOT_FOUND);
	}
	

}
