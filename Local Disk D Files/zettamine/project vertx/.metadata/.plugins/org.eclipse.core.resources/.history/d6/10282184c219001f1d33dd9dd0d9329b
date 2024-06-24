package com.zettamine.vertex.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spares_pur_hist")
public class SparesPurchaseHistory extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer purId;
	
	@ManyToOne
	@MapsId("partId")
	@JoinColumn(name = "part_id", nullable = false, insertable = false, updatable = false)
	private SparePart sparePart;
	
	@ManyToOne
	@MapsId("oemId")
	@JoinColumn(name = "oem_id", nullable = false, insertable = false, updatable = false)
	private OEM oem;
	
	@ManyToOne
	@MapsId("supplierId")
	@JoinColumn(name = "supplier_id", nullable = false, insertable = false, updatable = false)
	private SparesSupplier sparesSupplier;
	
	@Column(name = "invoice_id",nullable = false)
	private String invoiceId;
	
	@Column(name = "part_no",nullable = true)
	private String partNo;
	
	@Column(name = "qty",nullable = false)
	private Integer qty;
	
	@Column(name = "unit_price",nullable = false)
	private Double unitPrice;
	
	

}
