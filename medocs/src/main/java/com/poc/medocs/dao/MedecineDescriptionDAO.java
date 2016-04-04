package com.poc.medocs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.medocs.entities.MedicineDescriptionBO;

public interface MedecineDescriptionDAO extends JpaRepository<MedicineDescriptionBO, String> {

}
