package com.poc.medocs.batch; 

import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:launch-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MedocsFileItemReaderTest {

	@Autowired
	private MedocsFileItemReader reader;
	
	@Test
	public void testReadOnce() throws Exception {

		assertNotNull(reader);
		assertNotNull(reader.getResource());
		this.reader.open(null);
		reader.read();
		this.reader.close();
	}

}
