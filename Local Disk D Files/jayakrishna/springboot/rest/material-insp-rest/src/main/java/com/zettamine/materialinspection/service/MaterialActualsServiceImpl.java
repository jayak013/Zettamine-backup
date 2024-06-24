package com.zettamine.materialinspection.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zettamine.materialinspection.entities.MaterialActuals;
import com.zettamine.materialinspection.entities.MaterialInspLot;
import com.zettamine.materialinspection.repository.MaterialActualsRepository;
import com.zettamine.materialinspection.repository.MaterialInspLotRepository;

@Service
public class MaterialActualsServiceImpl implements MaterialActualsService {
	
	private MaterialActualsRepository matActualsRepo;
	
	private MaterialInspLotRepository matInspLotRepo;



	public MaterialActualsServiceImpl(MaterialActualsRepository matActualsRepo,
			MaterialInspLotRepository matInspLotRepo) {
		super();
		this.matActualsRepo = matActualsRepo;
		this.matInspLotRepo = matInspLotRepo;
	}



	@Override
	public List<MaterialInspLot> getAllInspLot() {
		return matInspLotRepo.findAll();
	}



	@Override
	public MaterialActuals addMaterialActuals(MaterialActuals materialActuals) {
		return matActualsRepo.save(materialActuals);
	}
	
}
