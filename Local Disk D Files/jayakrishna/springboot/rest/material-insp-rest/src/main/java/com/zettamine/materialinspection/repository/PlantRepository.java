package com.zettamine.materialinspection.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.materialinspection.entities.Plant;

public interface PlantRepository extends JpaRepository<Plant, Serializable> {
	
	boolean existsByName(String plantName);

	
}
