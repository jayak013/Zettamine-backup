package com.zettamine.materialinspection.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.materialinspection.entities.Material;

public interface MaterialRepository extends JpaRepository<Material, Serializable>{

}
