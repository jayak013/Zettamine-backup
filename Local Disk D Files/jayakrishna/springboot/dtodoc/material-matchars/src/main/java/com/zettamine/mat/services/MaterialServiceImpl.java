package com.zettamine.mat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zettamine.mat.dto.MaterialModel;
import com.zettamine.mat.entity.Material;
import com.zettamine.mat.repositories.MaterialRepository;

@Service
public class MaterialServiceImpl implements MaterialService {
	
	@Autowired
	private MaterialRepository matRepo;

	@Override
	public Material addMaterial(MaterialModel material) {
		Material mat = new Material();
		mat.setMaterialId(material.getMaterialId());
		mat.setName(material.getName());
		mat.setType(material.getType());
		return matRepo.save(mat);
	}

}
