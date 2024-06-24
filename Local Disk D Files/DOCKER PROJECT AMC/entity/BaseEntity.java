package com.zettamine.amc.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Base entity class providing common auditing fields.
 * This class is annotated with @MappedSuperclass to indicate that it is not an entity itself but should be inherited by subclasses.
 * It is also annotated with @EntityListeners(AuditingEntityListener.class) to enable automatic population of auditing fields.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public class BaseEntity {
    /**
     * The date and time when the entity was created.
     */
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    /**
     * The user who created the entity.
     */
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    /**
     * The date and time when the entity was last modified.
     */
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    /**
     * The user who last modified the entity.
     */
    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
}

