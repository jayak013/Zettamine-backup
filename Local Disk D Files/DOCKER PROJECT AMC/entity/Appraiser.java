package com.zettamine.amc.entity;


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
 * Entity class representing an Appraiser.
 * This class maps to the "property_appraiser" table in the "mpa" schema.
 */
@Entity
@Table(name = "property_appraiser")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Appraiser extends BaseEntity {
    /**
     * The unique identifier for the appraiser.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appraiserId;

    /**
     * The license ID of the appraiser.
     */
    @Column(nullable = false, unique = true)
    private String appraiserLicenseId;

    /**
     * The first name of the appraiser.
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * The last name of the appraiser.
     */
    @Column(nullable = false)
    private String lastName;

    /**
     * The email address of the appraiser.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * The phone number of the appraiser.
     */
    @Column(nullable = false, unique = true)
    private String phone;

    /**
     * The appraisal company associated with the appraiser.
     */
    @ManyToOne
    @JoinColumn(name = "amc_id", updatable = false)
    private AppraisalCompany amc;

    /**
     * Indicates whether the appraiser provides expert witness testimony.
     */
    @Column(nullable = false)
    private Boolean expertWitnessTestimony;
}

