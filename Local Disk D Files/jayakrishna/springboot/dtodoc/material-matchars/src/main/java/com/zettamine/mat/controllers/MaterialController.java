package com.zettamine.mat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.mat.dto.MaterialModel;
import com.zettamine.mat.entity.Material;
import com.zettamine.mat.services.MaterialService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "MATERIAL CONTROLLER MODULE",
			description = "MATERIAL CONTROLLER MODULE FOR INSERT, UPDATE, FETCH AND DELETE")
public class MaterialController {
	
	@Autowired
	private MaterialService matService;
	
	@PostMapping("/material")
	@Operation(summary = "new material insert",description = "To save a newly created material into the db")
	public ResponseEntity<?> saveMaterial(@RequestBody MaterialModel materialModel){
		Material mat = matService.addMaterial(materialModel);
		return new ResponseEntity<Material>(mat,HttpStatus.CREATED);
	}
	
	@PutMapping("/material")
	@Operation(summary = "Existed material Update",description = "To update the existed material in db")
	public ResponseEntity<?> updateMaterial(@RequestBody MaterialModel materialModel){
		Material mat = matService.addMaterial(materialModel);
		return new ResponseEntity<Material>(mat,HttpStatus.OK);
	}
	
}
