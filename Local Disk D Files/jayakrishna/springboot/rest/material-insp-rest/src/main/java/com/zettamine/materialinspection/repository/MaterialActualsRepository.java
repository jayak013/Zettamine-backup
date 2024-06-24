package com.zettamine.materialinspection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.materialinspection.entities.MaterialActuals;
import com.zettamine.materialinspection.model.MaterialActualsCompKey;

public interface MaterialActualsRepository extends 
			JpaRepository<MaterialActuals, MaterialActualsCompKey>{
	
}
