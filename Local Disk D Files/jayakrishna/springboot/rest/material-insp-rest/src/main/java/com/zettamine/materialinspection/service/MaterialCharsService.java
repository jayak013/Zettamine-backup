package com.zettamine.materialinspection.service;

import com.zettamine.materialinspection.entities.MaterialChars;

public interface MaterialCharsService {

	MaterialChars addMaterialChar(MaterialChars matChars);

	MaterialChars getByCharId(Integer charId);

	void removeMatChars(Integer charId);
	

}
