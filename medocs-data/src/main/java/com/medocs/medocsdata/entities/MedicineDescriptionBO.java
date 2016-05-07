/**
 * 
 */
package com.medocs.medocsdata.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;


/**
 * @author x
 *
 */
@Entity(name="MEDECINE_DESCRIPTION")
public class MedicineDescriptionBO {
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String code;
	
	@Column
	private String nom;
	
	//Denomination Commune internationale;
	@Column
	private String dci1;
	
	//ex : SOLUTION A DILUER POUR PERFUSION
	@Column
	private String forme;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private MedecineDosageBO dosage;
	
	//ex : 1 BOITE 1 FLACON 40 ML
	@OneToOne(cascade=CascadeType.PERSIST)
	private MedecinePackagingBO presentation;
	
	//prix publique de vente
	@Column
	private BigDecimal ppv;
	
	@Column
	private BigDecimal ph;
	
	@Column
	private BigDecimal prixBR;
	
	@Column
	private String principeGenerique;
	
	@Column
	private String tauxRemboursement;
	
	/**
	 * Default Constructor
	 */
	public MedicineDescriptionBO(){}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the dci1
	 */
	public String getDci1() {
		return dci1;
	}

	/**
	 * @param dci1 the dci1 to set
	 */
	public void setDci1(String dci1) {
		this.dci1 = dci1;
	}

	/**
	 * @return the forme
	 */
	public String getForme() {
		return forme;
	}

	/**
	 * @param forme the forme to set
	 */
	public void setForme(String forme) {
		this.forme = forme;
	}

	/**
	 * @return the dosage
	 */
	public MedecineDosageBO getDosage() {
		return dosage;
	}

	/**
	 * @param dosage the dosage to set
	 */
	public void setDosage(MedecineDosageBO dosage) {
		this.dosage = dosage;
	}

	/**
	 * @return the presentation
	 */
	public MedecinePackagingBO getPresentation() {
		return presentation;
	}

	/**
	 * @param presentation the presentation to set
	 */
	public void setPresentation(MedecinePackagingBO presentation) {
		this.presentation = presentation;
	}

	/**
	 * @return the ppv
	 */
	public BigDecimal getPpv() {
		return ppv;
	}

	/**
	 * @param ppv the ppv to set
	 */
	public void setPpv(BigDecimal ppv) {
		this.ppv = ppv;
	}

	/**
	 * @return the ph
	 */
	public BigDecimal getPh() {
		return ph;
	}

	/**
	 * @param ph the ph to set
	 */
	public void setPh(BigDecimal ph) {
		this.ph = ph;
	}

	/**
	 * @return the prixBR
	 */
	public BigDecimal getPrixBR() {
		return prixBR;
	}

	/**
	 * @param prixBR the prixBR to set
	 */
	public void setPrixBR(BigDecimal prixBR) {
		this.prixBR = prixBR;
	}

	/**
	 * @return the principeGenerique
	 */
	public String getPrincipeGenerique() {
		return principeGenerique;
	}

	/**
	 * @param principeGenerique the principeGenerique to set
	 */
	public void setPrincipeGenerique(String principeGenerique) {
		this.principeGenerique = principeGenerique;
	}

	/**
	 * @return the tauxRemboursement
	 */
	public String getTauxRemboursement() {
		return tauxRemboursement;
	}

	/**
	 * @param tauxRemboursement the tauxRemboursement to set
	 */
	public void setTauxRemboursement(String tauxRemboursement) {
		this.tauxRemboursement = tauxRemboursement;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MedicineDescriptionBO [nom=" + nom + ", dci1=" + dci1 + ", forme=" + forme + ", dosage=" + dosage
				+ ", presentation=" + presentation + ", ppv=" + ppv + ", ph=" + ph + ", prixBR=" + prixBR
				+ ", principeGenerique=" + principeGenerique + ", tauxRemboursement=" + tauxRemboursement + "]";
	}
	
}
