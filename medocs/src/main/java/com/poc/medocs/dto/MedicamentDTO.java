/**
 * 
 */
package com.poc.medocs.dto;

/**
 * @author x
 *
 */
public class MedicamentDTO {
	
	private String nom;
	
	//Denomination Commune internationale;
	private String dci1;
	
	private String dosage;
	
	private String uniteDosage;
	
	//ex : SOLUTION A DILUER POUR PERFUSION
	private String forme;
	
	//ex : 1 BOITE 1 FLACON 40 ML
	private String presentation;
	
	//prix publique de vente
	private String ppv;
	
	private String ph;
	
	private String prixBR;
	
	private String principeGenerique;
	
	private String tauxRemboursement;
	
	/**
	 * Default Constructor
	 */
	public MedicamentDTO(){}

	/**
	 * @param nom
	 * @param dci1
	 * @param dosage
	 * @param uniteDosage
	 * @param forme
	 * @param presentation
	 * @param ppv
	 * @param ph
	 * @param prixBR
	 * @param principeGenerique
	 * @param tauxRemboursement
	 */
	public MedicamentDTO(String nom, String dci1, String dosage, String uniteDosage, String forme, String presentation,
			String ppv, String ph, String prixBR, String principeGenerique, String tauxRemboursement) {
		super();
		this.nom = nom;
		this.dci1 = dci1;
		this.dosage = dosage;
		this.uniteDosage = uniteDosage;
		this.forme = forme;
		this.presentation = presentation;
		this.ppv = ppv;
		this.ph = ph;
		this.prixBR = prixBR;
		this.principeGenerique = principeGenerique;
		this.tauxRemboursement = tauxRemboursement;
	}

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
	 * @return the presentation
	 */
	public String getPresentation() {
		return presentation;
	}

	/**
	 * @param presentation the presentation to set
	 */
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	/**
	 * @return the ppv
	 */
	public String getPpv() {
		return ppv;
	}

	/**
	 * @param ppv the ppv to set
	 */
	public void setPpv(String ppv) {
		this.ppv = ppv;
	}

	/**
	 * @return the ph
	 */
	public String getPh() {
		return ph;
	}

	/**
	 * @param ph the ph to set
	 */
	public void setPh(String ph) {
		this.ph = ph;
	}

	/**
	 * @return the prixBR
	 */
	public String getPrixBR() {
		return prixBR;
	}

	/**
	 * @param prixBR the prixBR to set
	 */
	public void setPrixBR(String prixBR) {
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
		return "MedicamentDTO [nom=" + nom + ", dci1=" + dci1 + ", dosage=" + dosage + ", uniteDosage=" + uniteDosage
				+ ", forme=" + forme + ", presentation=" + presentation + ", ppv=" + ppv + ", ph=" + ph + ", prixBR="
				+ prixBR + ", principeGenerique=" + principeGenerique + ", tauxRemboursement=" + tauxRemboursement
				+ "]";
	}
	
}
