package com.zettamine.materialinspection.service;

import java.util.List;

import com.zettamine.materialinspection.entities.MaterialActuals;
import com.zettamine.materialinspection.entities.MaterialInspLot;

public interface MaterialActualsService {

	List<MaterialInspLot> getAllInspLot();

	MaterialActuals addMaterialActuals(MaterialActuals materialActuals);

}
