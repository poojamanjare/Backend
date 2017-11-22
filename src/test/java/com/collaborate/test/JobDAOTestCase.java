package com.collaborate.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.DAO.JobDAO;
import com.collaborate.model.Job;

public class JobDAOTestCase 
{
	static JobDAO jobDAO;
	
	
	//@BeforeClass annoting to a public static void method so that this method run once before any of test methods in the class  
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collaborate");
		annotationConfigApplicationContext.refresh();
		jobDAO=(JobDAO) annotationConfigApplicationContext.getBean("JobDAO");
	}
	
	
	
	@Ignore
	//@Test tells junit that public void method can be run as a testcase
	@Test
	public void createJobTest()
	{
		Job job=new Job();
		job.setJobId(2);
		job.setJobProfile("software tester");
		job.setJobDesc("This is good job in IT");
		job.setQualification("BE/B.Tech");
		job.setStatus("NA");
		job.setCreateDate(new Date());
		
		assertTrue("Problem in job creation", jobDAO.createJob(job));
		
	}
	
	@Ignore
	@Test
	public void getJobByIdTest()
	{
		assertNotNull("problem in getting job by jobid ", jobDAO.getJob(1));
	}
	
	@Ignore
	@Test
	public void getAllJobsTest()
	{
		List<Job>listJobs=jobDAO.getJob();
		assertTrue("problem in getting list of all jobs", listJobs.size()>0);
	}
	
	@Ignore
	@Test
	public void approveJobTest()
	{
		Job job=new Job();
		job.setJobId(1);
		job.setJobProfile("software developer");
		job.setJobDesc("This is good job in IT");
		job.setQualification("BE/B.Tech");
		job.setStatus("NA");
		job.setCreateDate(new Date());
		
		assertTrue("Problem in job approve", jobDAO.approveJob(job));
	}
	
	@Ignore
	@Test
	public void getApproveJobtest()
	{
		List<Job>listjobs=jobDAO.getApproveJob();
		assertTrue("problem in getting list of approve job", listjobs.size()>0);
	}
	
	@Ignore
	@Test
	public void updateJobTest()
	{
		assertTrue("problem in update job", jobDAO.updateJob(1));
	}
	
	/*@Ignore*/
	@Test
	public void deleteJobTest()
	{
		assertTrue("problem in delete jov", jobDAO.deleteJob(1));
	}

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}
*/
}
