package com.zettamine.amc.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class representing an Appraisal Company.
 * This class maps to the "appraisal_company" table in the "mpa" schema.
 */
@Entity
@Table(name = "appraisal_company")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppraisalCompany extends BaseEntity {
    /**
     * The unique identifier for the appraisal company.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer amcId;

    /**
     * The registration ID of the appraisal company.
     */
    @Column(unique = true, nullable = false)
    private String amcRegId;

    /**
     * The name of the appraisal company.
     */
    @Column(unique = true, nullable = false)
    private String amcName;

    /**
     * The address of the appraisal company.
     */
    @Column(nullable = false)
    private String address;

    /**
     * The city where the appraisal company is located.
     */
    @Column(nullable = false)
    private String city;

    /**
     * The state where the appraisal company is located.
     */
    @Column(nullable = false)
    private String state;

    /**
     * The ZIP code of the location of the appraisal company.
     */
    @Column(nullable = false)
    private String zipcode;

    /**
     * The country where the appraisal company is located.
     */
    @Column(nullable = false)
    private String country;

    /**
     * The phone number of the appraisal company.
     */
    @Column(unique = true, nullable = false)
    private String phone;

    /**
     * The email address of the appraisal company.
     */
    @Column(unique = true, nullable = false)
    private String email;

    /**
     * The website URL of the appraisal company.
     */
    @Column(unique = true)
    private String website;

    /**
     * Additional notes about the appraisal company.
     */
    private String notes;

    /**
     * The appraisal methodology used by the appraisal company.
     */
    private String appraisalMethodology;

    /**
     * The lower limit for property values handled by the appraisal company.
     */
    @Column(name = "valu_low_limit", precision = 18, scale = 2)
    private BigDecimal valueLowLimit;

    /**
     * The service areas covered by the appraisal company.
     */
    @OneToMany(mappedBy = "amc", cascade = CascadeType.ALL)
    private List<ServiceArea> serviceAreas;

    /**
     * The appraisers associated with the appraisal company.
     */
    @OneToMany(mappedBy = "amc", cascade = CascadeType.ALL)
    private List<Appraiser> appraisers;

    /**
     * The property types handled by the appraisal company.
     */
    @ManyToMany
    @JoinTable(
            name = "appraisal_company_property_type",
            joinColumns = @JoinColumn(name = "amc_id"),
            inverseJoinColumns = @JoinColumn(name = "prop_type_id")
    )
    private List<PropertyType> propertyTypes;
}

