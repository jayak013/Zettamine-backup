package com.zettamine.vertex.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spares_uid_pur_hist")
public class SparesUidPurchaseHist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "spare_id") 
	private Long spareId; 
	
	@Column(name = "part_id", insertable = false, updatable = false)
	private Long partId;
	
	@Column(name = "pur_id", insertable = false, updatable = false)
	private Long purId;
	
	@ManyToOne
	@JoinColumn(name = "part_id", nullable = false)
	private SparePart sparePart;
	
	@ManyToOne
	@JoinColumn(name = "pur_id", nullable = false)
	private SparesPurchaseHistory sparesPurHist;
	
	@Column(name = "uid")
	private String uid;
	
}
