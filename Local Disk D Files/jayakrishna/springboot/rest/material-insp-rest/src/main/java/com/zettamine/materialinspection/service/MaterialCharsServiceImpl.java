package com.zettamine.materialinspection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zettamine.materialinspection.entities.MaterialChars;
import com.zettamine.materialinspection.entities.Vendor;
import com.zettamine.materialinspection.repository.MaterialCharsRepository;

@Service
public class MaterialCharsServiceImpl implements MaterialCharsService {
	
	private MaterialCharsRepository matCharRepo;
	
	public MaterialCharsServiceImpl(MaterialCharsRepository matCharRepo) {
		super();
		this.matCharRepo = matCharRepo;
	}



	@Override
	public MaterialChars addMaterialChar(MaterialChars matChars) {
		matChars.setCharDesc(matChars.getCharDesc().toUpperCase().trim());
		matChars.setUom(matChars.getUom().toUpperCase().trim());
		return matCharRepo.save(matChars);
	}



	@Override
	public MaterialChars getByCharId(Integer charId) {
		return matCharRepo.findById(charId).get();
	}



	@Override
	public void removeMatChars(Integer charId) {
		MaterialChars matChars = matCharRepo.findById(charId).get();
		matChars.setStatus("inactive");
		matCharRepo.save(matChars);
	}





}
