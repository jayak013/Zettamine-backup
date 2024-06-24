package com.zettamine.materialinspection.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.zettamine.materialinspection.entities.Plant;
import com.zettamine.materialinspection.service.PlantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class PlantController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlantController.class);
	
	private PlantService plantService;

	public PlantController(PlantService plantService) {
		this.plantService = plantService;
	}

	@PostMapping("/plant")
	public ResponseEntity<String> savePlant(@Valid @RequestBody Plant plant) {
		LOGGER.info("Invoked the savePlant(Plant plant)");
		if(plantService.isPlantIdExists(plant.getPlantId())) {
			LOGGER.info("Returning Plant ID is already existed");
			return new ResponseEntity<String>("Plant ID is already existed",HttpStatus.NOT_FOUND);
		}
	    if(!plantService.isPlantNameExists(plant.getName())) {
			plantService.addPlant(plant);
			LOGGER.info("Returning plant is created successfully");
			return new ResponseEntity<String>("Plant is added successfully",HttpStatus.OK);
		}
	    LOGGER.info("Returning Plant Name is already existed");
		return new ResponseEntity<String>("Plant Name is already existed",HttpStatus.NOT_FOUND);
	}

	@GetMapping("/plants")
	public ResponseEntity<List<Plant>> showAllPlants() {
		LOGGER.info("Invoked the showAllPlants()");
		List<Plant> listOfPlants = plantService.getAllPlants();
		LOGGER.info("returning List Of Plants of Size : {}",listOfPlants.size());
		return new ResponseEntity<List<Plant>>(listOfPlants,HttpStatus.OK);
	}

	/*
	 * @DeleteMapping("/plant/{id}") public ResponseEntity<?>
	 * deleteVendor(@PathVariable("id") String id, Model model) {
	 * plantService.removePlant(id); return new
	 * RedirectView("/zettamine/user/show-plants"); }
	 */

	@PutMapping("/plant/{id}")
	public String updatePlant(@PathVariable("id") String id) {
		plantService.getPlantById(id);
		return "add-plant-page";
	}
	
	@GetMapping("/plant/{id}")
	public ResponseEntity<?> getPlant(@PathVariable String id) {
		Optional<Plant> plant = plantService.getPlantById(id);
		if(plant.isPresent()) return new ResponseEntity<Plant>(plant.get(),HttpStatus.OK);
		return new ResponseEntity<String>("No Plant is available with "+id,HttpStatus.OK);
	}
}
