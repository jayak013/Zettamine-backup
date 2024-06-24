package com.zettamine.materialinspection.service;

import java.util.List;
import java.util.Optional;

import com.zettamine.materialinspection.entities.Plant;

public interface PlantService {

	Plant addPlant(Plant plant);

	List<Plant> getAllPlants();

	void removePlant(String id);

	Optional<Plant> getPlantById(String id);
	
	boolean isPlantNameExists(String plantName);

	boolean isPlantIdExists(String plantId);

}
