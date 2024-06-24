package com.zettamine.amc.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class representing a Property Type.
 * This class maps to the "appraisal_property_types" table in the "mpa" schema.
 */
@Entity
@Table(name = "appraisal_property_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyType extends BaseEntity {
    /**
     * The unique identifier for the property type.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prop_type_id")
    private Integer propertyId;

    /**
     * The name of the property type.
     */
    @Column(name = "prop_type_name", nullable = false)
    private String propertyTypeName;

    /**
     * The list of appraisal companies associated with this property type.
     */
    @ManyToMany(mappedBy = "propertyTypes")
    private List<AppraisalCompany> amc;

    /**
     * Returns a string representation of the PropertyType object.
     *
     * @return A string representation of the PropertyType object.
     */
    @Override
    public String toString() {
        return "PropertyType [propertyId=" + propertyId + ", propertyTypeName=" + propertyTypeName + "]";
    }
}

