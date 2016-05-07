/**
 * 
 */
package com.poc.medocs.batch;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.medocs.medocsdata.entities.MedecineDosageBO;
import com.medocs.medocsdata.entities.MedecinePackagingBO;
import com.medocs.medocsdata.entities.MedicineDescriptionBO;
import com.poc.medocs.dto.MedicamentDTO;
import com.poc.medocs.utils.DecimalUtils;

/**
 * @author x
 *
 */
@Component("processor")
public class MedocsItemProcessor implements ItemProcessor<MedicamentDTO, MedicineDescriptionBO> {
	
	private static final Logger LOG = Logger.getLogger(MedocsItemProcessor.class);
	private static final int  PRICE_SCALE = 2;

	@Override
	public MedicineDescriptionBO process(MedicamentDTO item) throws Exception {
		MedicineDescriptionBO bo = null;
		if(item != null){
			bo = new MedicineDescriptionBO();
			bo.setNom(item.getNom());
			bo.setDci1(item.getDci1());
			bo.setForme(item.getForme());
			bo.setPrincipeGenerique(item.getPrincipeGenerique());
			bo.setPh(DecimalUtils.getDecimal(item.getPh(), PRICE_SCALE));
			bo.setPpv(DecimalUtils.getDecimal(item.getPpv(), PRICE_SCALE));
			bo.setPrixBR(DecimalUtils.getDecimal(item.getPrixBR(), PRICE_SCALE));
			bo.setTauxRemboursement(item.getTauxRemboursement());
			
			MedecineDosageBO dosage = new MedecineDosageBO();
			dosage.setDosage(item.getDosage());
			dosage.setUniteDosage(item.getUniteDosage());
			bo.setDosage(dosage );
			
			MedecinePackagingBO presentation = new MedecinePackagingBO();
			presentation.setPackagingForm(item.getPresentation());
			bo.setPresentation(presentation );
			LOG.info(bo.toString());
		}
		
		return bo;
	}

}
