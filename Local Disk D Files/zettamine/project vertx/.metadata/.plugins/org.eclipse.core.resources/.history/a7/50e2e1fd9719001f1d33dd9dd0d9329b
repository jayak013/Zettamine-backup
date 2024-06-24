package com.zettamine.vertex.entities;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "EQPT_CATG")
public class EquipmentCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer catgId;

	@Column(name = "catg_name", nullable = false, unique = true)
	private String catgName;

	@Column(name = "notes", length = 150)
	private String notes;

	
}
