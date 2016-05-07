/**
 * 
 */
package com.medocs.medocsdata.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.medocs.medocsdata.entities.MedicineDescriptionBO;

/**
 * @author x
 *
 */
@ContextConfiguration(locations={"classpath:META-INF/spring/module-context.xml","classpath:META-INF/spring/medocs-datasource-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MedecineDescriptionDAOTest {
	
	@Autowired
	private MedecineDescriptionDAO medecineDescriptionDAO;

	/**
	 * Test method for {@link org.springframework.data.jpa.repository.JpaRepository#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<MedicineDescriptionBO> descriptions = this.medecineDescriptionDAO.findAll();
		assertNotNull(descriptions);
		assertEquals(5916, descriptions.size());
	}

}
