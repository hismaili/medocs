/**
 * 
 */
package com.medocs.medocsdata.entities;

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
	private String packagingForm;
	
	@Column
	private String longDescription;
	
	@OneToOne
	private MedecinePackagingBO pack;

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

	@Override
	public String toString() {
		return "MedecinePackagingBO [id=" + id + ", packagingForm=" + packagingForm + ", longDescription="
				+ longDescription + ", pack=" + pack + "]";
	}	
	

}
