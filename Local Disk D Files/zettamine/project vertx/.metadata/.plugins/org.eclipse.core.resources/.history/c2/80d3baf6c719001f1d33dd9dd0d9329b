package com.zettamine.vertex.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "MNTC_LOG_I")
@IdClass(MaintenanceLogItem.class)
public class MaintenanceLogItem extends BaseEntity {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "log_id", nullable = false)
	private MaintenanceLogHeader maintenanceHeaderLog;

	private MaintenanceLogHeader maintenanceLogHeader;

	@Id
	@ManyToOne
	@JoinColumn(name = "task_id", nullable = false)
	private MaintenanceTask maintenanceTask;
	
	@Column(name = "notes")
	private String notes;
	
	@Column(name = "repl_notes")
	private String replacementNotes;

}
