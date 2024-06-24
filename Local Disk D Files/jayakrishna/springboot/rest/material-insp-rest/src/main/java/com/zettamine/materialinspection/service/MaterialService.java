package com.zettamine.materialinspection.service;

import java.util.List;

import com.zettamine.materialinspection.entities.Material;
import com.zettamine.materialinspection.entities.MaterialChars;

public interface MaterialService {

	Material addMaterial(Material material);

	List<Material> getAllMaterials();

	Material getMaterialById(String id);

	void removeMaterial(String id);

}
