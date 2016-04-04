/**
 * 
 */
package com.poc.medocs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author x
 *
 */
@Entity(name="MEDECINE_DOSAGE")
public class MedecineDosageBO {
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String code;

	@Column
	private String dosage;

	@Column
	private String uniteDosage;

	/**
	 * @return the dosage
	 */
	public String getDosage() {
		return dosage;
	}

	/**
	 * @param dosage the dosage to set
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	/**
	 * @return the uniteDosage
	 */
	public String getUniteDosage() {
		return uniteDosage;
	}

	/**
	 * @param uniteDosage the uniteDosage to set
	 */
	public void setUniteDosage(String uniteDosage) {
		this.uniteDosage = uniteDosage;
	}
	

}
