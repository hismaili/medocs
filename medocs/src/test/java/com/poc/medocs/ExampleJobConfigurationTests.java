package com.poc.medocs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.poc.medocs.dao.MedecineDescriptionDAO;
import com.poc.medocs.entities.MedicineDescriptionBO;

@ContextConfiguration(locations={"/launch-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ExampleJobConfigurationTests {
	
	private static final Logger LOG = Logger.getLogger(ExampleItemReaderTests.class);

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@Autowired
	private MedecineDescriptionDAO dao;
	
	@Test
	public void testLaunchJob() throws Exception {
		JobExecution jobExec = jobLauncher.run(job, new JobParameters());
		assertNotNull(jobExec);
		if(!ExitStatus.COMPLETED.equals(jobExec.getExitStatus())) {
			for (Throwable th : jobExec.getAllFailureExceptions()) {
				LOG.error(th.getMessage());
			}
		}
		assertEquals(jobExec.getFailureExceptions().toArray().toString(), ExitStatus.COMPLETED,jobExec.getExitStatus());
		List<MedicineDescriptionBO> ent = this.dao.findAll();
		assertNotNull(ent);
		LOG.info(ent.size());
	}
	
}
