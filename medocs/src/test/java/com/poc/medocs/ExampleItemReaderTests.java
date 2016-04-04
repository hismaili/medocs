package com.poc.medocs; 

import com.poc.medocs.batch.MedocsFileItemReader;

import junit.framework.TestCase;

public class ExampleItemReaderTests extends TestCase {

	private MedocsFileItemReader reader = new MedocsFileItemReader();
	
	public void testReadOnce() throws Exception {
		assertEquals("Hello world!", reader.read());
	}

	public void testReadTwice() throws Exception {
		reader.read();
		assertEquals(null, reader.read());
	}

}
