package com.zettamine.vertex.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ReplacementLogDetail")
@IdClass(ReplacementLogItemlId.class)
public class ReplacementLogItem {
	@Id
	@ManyToOne
	@JoinColumn(name = "log_id", nullable = false)
	private ReplacementLogHeader replLogHeader;

	@Id
	@ManyToOne
	@JoinColumn(name = "part_id")
	private SparePart sparePart;

	@Column(name = "repl_dt")
	private LocalDate replDate;

	@Column(name = "qty")
	private Integer quantity;

	@Column(name = "unit_cost")
	private Double unitCost;

	@Column(name = "repl_notes")
	private String replNotes;

	@Column(name = "tech_id")
	private Integer technicianId;
}
