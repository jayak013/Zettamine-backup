package com.zettamine.vertex.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OEM_MD")
public class OEM extends BaseEntity {

	@Id
	private String oemId;

	@Column(name = "oem_name", nullable = false, unique = true)
	private String oemName;

}
