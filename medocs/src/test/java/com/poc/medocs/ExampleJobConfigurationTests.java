package com.poc.medocs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.poc.medocs.dao.MedecineDescriptionDAO;
import com.poc.medocs.entities.MedicineDescriptionBO;

@ContextConfiguration(locations={"/launch-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ExampleJobConfigurationTests {
	
	private static final long JOB_PARAMETER_MAXIMUM = 1000000;
	
	private static final Logger LOG = Logger.getLogger(ExampleItemReaderTests.class);

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@Autowired
	private MedecineDescriptionDAO dao;
	
	@Test
	public void testLaunchJob() throws Exception {
		
		JobExecution jobExec = jobLauncher.run(job, getUniqueJobParameters());
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
	
	public JobParameters getUniqueJobParameters() {
		Map<String, JobParameter> parameters = new HashMap<String, JobParameter>();
		parameters.put("random", new JobParameter((long) (Math.random() * JOB_PARAMETER_MAXIMUM)));
		return new JobParameters(parameters);
	}
	
}
