package com.zettamine.materialinspection.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zettamine.materialinspection.entities.Plant;
import com.zettamine.materialinspection.repository.PlantRepository;
import com.zettamine.materialinspection.utils.SpaceRemover;

@Service
public class PlantServiceImpl implements PlantService {
	
	private PlantRepository plantRepo;
	
	@Autowired
	private SpaceRemover spacesRemover;

	public PlantServiceImpl(PlantRepository plantRepo) {
		this.plantRepo = plantRepo;
	}



	@Override
	public Plant addPlant(Plant plant) {
		plant.setPlantId(spacesRemover.removeSpaces(plant.getPlantId()).toUpperCase());
		plant.setName(plant.getName().trim().toUpperCase());
		plant.setCity(plant.getCity().trim().toUpperCase());
		plant.setState(plant.getState().trim().toUpperCase());
		return plantRepo.save(plant);
	}



	@Override
	public List<Plant> getAllPlants() {
		List<Plant> activePlants = plantRepo.findAll().stream().filter(p->p.getStatus().equals("active")).sorted((p1,p2)->p1.getPlantId().compareToIgnoreCase(p2.getPlantId())).collect(Collectors.toList());
		return activePlants;
	}



	@Override
	public void removePlant(String id) {
		Plant plant = plantRepo.findById(id).get();
		plant.setStatus("inactive");
		plantRepo.save(plant);
		
	}



	@Override
	public Optional<Plant> getPlantById(String id) {
		return plantRepo.findById(id);
	}



	@Override
	public boolean isPlantNameExists(String plantName) {
		plantName = plantName.toUpperCase().trim();
		return plantRepo.existsByName(plantName);
	}



	@Override
	public boolean isPlantIdExists(String plantId) {
		plantId = spacesRemover.removeSpaces(plantId.toUpperCase().trim());
		Optional<Plant> plant = plantRepo.findById(plantId);
		if(plant.isPresent()) return true;
		return false;
	}
	
}
