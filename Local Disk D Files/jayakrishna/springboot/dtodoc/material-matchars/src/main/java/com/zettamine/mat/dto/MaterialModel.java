package com.zettamine.mat.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Material",description = "schema to hold the material info")
public class MaterialModel {
	@Schema(description = "Unique ID of the material",example = "M-00")
	private String materialId;
	@Schema(description = "Name of the material",example = "IRON")
	private String name;
	@Schema(description = "Type of the material",example = "FINISHED/SEMI-FINISHED/FINISHED")
	private String type;
}
