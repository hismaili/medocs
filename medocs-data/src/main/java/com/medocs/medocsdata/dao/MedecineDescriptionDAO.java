package com.medocs.medocsdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medocs.medocsdata.entities.MedicineDescriptionBO;

public interface MedecineDescriptionDAO extends JpaRepository<MedicineDescriptionBO, String> {

}
