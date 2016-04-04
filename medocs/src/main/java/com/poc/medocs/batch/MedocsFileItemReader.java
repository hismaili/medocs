package com.poc.medocs.batch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.poc.medocs.dto.MedicamentDTO;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("reader")
public class MedocsFileItemReader implements ResourceAwareItemReaderItemStream<MedicamentDTO> {
	
	private static final Logger LOG = Logger.getLogger(MedocsFileItemReader.class);
	@Value("classpath:data/ref-des-medicaments-cnops-2014.xlsx")
	private Resource resource;
	private XSSFWorkbook wb;
	private int currentRowIndex;
	private XSSFSheet sheet;

	@Override
	public MedicamentDTO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		MedicamentDTO medoc = null;
		
		int last = sheet.getLastRowNum();
		
		if(currentRowIndex < last) {
			XSSFRow row = sheet.getRow(currentRowIndex);
			//String cellCode = row.getCell(0).getStringCellValue();
			String cellNom = row.getCell(1).getStringCellValue();
			String cellDci1 = row.getCell(2).getStringCellValue();
			String cellDosage1 = row.getCell(3).getStringCellValue();
			String cellUniteDosage1 = row.getCell(4).getStringCellValue();
			String cellForme = row.getCell(5).getStringCellValue();
			String cellPresentation = row.getCell(6).getStringCellValue();
			String cellPpv = String.valueOf(row.getCell(7).getNumericCellValue());
			String cellPh = String.valueOf(row.getCell(8).getNumericCellValue());
			String cellPrixBr = String.valueOf(row.getCell(9).getNumericCellValue());
			String cellPrincipeGenerique = row.getCell(10).getStringCellValue();
			String cellTaux = row.getCell(11).getStringCellValue();
			medoc = new MedicamentDTO(cellNom, cellDci1, cellDosage1, cellUniteDosage1, cellForme,
					cellPresentation, cellPpv, cellPh, cellPrixBr, cellPrincipeGenerique, cellTaux);
			currentRowIndex++;
			LOG.info(medoc.toString());
		}
			
		return medoc;
	}

	@Override
	public void close() throws ItemStreamException {
		try {
			if(this.resource != null && this.resource.getInputStream() != null) {
				this.resource.getInputStream().close();
			}
			
		} catch (IOException e) {
			LOG.error("IOException occured. Can't close resource "+this.resource.getFilename(), e);
			throw new ItemStreamException("can't close resource "+this.resource.getFilename(), e);
		} catch (Exception e) {
			LOG.error("Unexpected exception occured. Can't close resource "+this.resource.getFilename(), e);
			throw new ItemStreamException("Unexpected exception. Can't close resource "+this.resource.getFilename(), e);
		}
		
	}

	@Override
	public void open(ExecutionContext arg0) throws ItemStreamException {
		try {
			wb = new XSSFWorkbook(this.resource.getInputStream());
			sheet = this.wb.getSheetAt(0);
			this.currentRowIndex = this.sheet.getFirstRowNum()+1;
		} catch (IOException e) {
			LOG.error("IOException occured. Can't open resource "+this.resource.getFilename(), e);
			throw new ItemStreamException("can't open resource "+this.resource.getFilename(), e);
		} catch (Exception e) {
			LOG.error("Unexpected exception occured. Can't open resource "+this.resource.getFilename(), e);
			throw new ItemStreamException("Unexpected exception. Can't open resource "+this.resource.getFilename(), e);
		}
		
	}

	@Override
	public void update(ExecutionContext arg0) throws ItemStreamException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the resource
	 */
	public Resource getResource() {
		return resource;
	}

	@Override
	public void setResource(Resource resource) {
		this.resource= resource;
		
	}

}
