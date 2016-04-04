/**
 * 
 */
package com.poc.medocs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author x
 *
 */
@Entity(name="MEDECINE_PACKAGING")
public class MedecinePackagingBO {
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@Column
	private int nbPackage;
	
	@Column
	private String packagingForm;
	
	@Column
	private int packagingSize;
	
	@Column
	private int packagingSizeUnit;
	
	@OneToOne
	private MedecinePackagingBO pack;

	/**
	 * @return the nbPackage
	 */
	public int getNbPackage() {
		return nbPackage;
	}

	/**
	 * @param nbPackage the nbPackage to set
	 */
	public void setNbPackage(int nbPackage) {
		this.nbPackage = nbPackage;
	}

	/**
	 * @return the packagingForm
	 */
	public String getPackagingForm() {
		return packagingForm;
	}

	/**
	 * @param packagingForm the packagingForm to set
	 */
	public void setPackagingForm(String packagingForm) {
		this.packagingForm = packagingForm;
	}

	/**
	 * @return the packagingSize
	 */
	public int getPackagingSize() {
		return packagingSize;
	}

	/**
	 * @param packagingSize the packagingSize to set
	 */
	public void setPackagingSize(int packagingSize) {
		this.packagingSize = packagingSize;
	}

	/**
	 * @return the packagingSizeUnit
	 */
	public int getPackagingSizeUnit() {
		return packagingSizeUnit;
	}

	/**
	 * @param packagingSizeUnit the packagingSizeUnit to set
	 */
	public void setPackagingSizeUnit(int packagingSizeUnit) {
		this.packagingSizeUnit = packagingSizeUnit;
	}

	/**
	 * @return the pack
	 */
	public MedecinePackagingBO getPack() {
		return pack;
	}

	/**
	 * @param pack the pack to set
	 */
	public void setPack(MedecinePackagingBO pack) {
		this.pack = pack;
	}

}
