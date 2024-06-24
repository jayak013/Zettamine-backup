package com.zettamine.materialinspection.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Plant {
	
	@Id
	@NotBlank(message = "*required")
	private String plantId;
	@NotBlank(message = "*required")
	private String name;
	@NotBlank(message = "*required")
	private String city;
	@NotBlank(message = "*required")
	private String state;
	@JsonIgnore
	private String status = "active";
	
	@JsonIgnore
	@OneToMany(mappedBy = "plant",cascade = CascadeType.ALL)
	private List<MaterialInspLot> materialInspLots = new ArrayList<>();
}
