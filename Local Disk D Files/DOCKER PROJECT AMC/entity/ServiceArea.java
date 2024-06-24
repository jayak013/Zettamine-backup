package com.zettamine.amc.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * Entity class representing a Service Area.
 * This class maps to the "appraisal_service_area" table in the "mpa" schema.
 */
@Entity
@Table(name = "appraisal_service_area")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ServiceArea extends BaseEntity {
    /**
     * The unique identifier for the service area.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer areaId;

    /**
     * The appraisal company associated with the service area.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "amc_id", updatable = false)
    private AppraisalCompany amc;

    /**
     * The county covered by the service area.
     */
    @Column(nullable = false)
    private String county;

    /**
     * The city covered by the service area.
     */
    @Column(nullable = false)
    private String city;

    /**
     * The state covered by the service area.
     */
    @Column(nullable = false)
    private String state;

    /**
     * The ZIP code covered by the service area.
     */
    @Column(nullable = false)
    private String zipcode;
}

