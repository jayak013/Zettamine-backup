package com.zettamine.mat.entity;

import org.apache.commons.lang3.builder.EqualsExclude;

import com.zettamine.mat.dto.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "material")
public class Material extends BaseEntity{
	
	@Id
	@Column(name = "mat_id")
	private String materialId;
	private String name;
	private String type;
	
}
