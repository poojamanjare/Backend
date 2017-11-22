package com.collaborate.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.DAO.JobDAO;
import com.collaborate.model.Job;

@Service
public class JobServiceImpl implements JobService
{
	@Autowired
	JobDAO jobDAO;
	
	public void addJob(Job job) 
	{
		jobDAO.addJob(job);
		
	}

	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		return jobDAO.getAllJobs();
	}

	public Job getJob(int jobId) {
		// TODO Auto-generated method stub
		return jobDAO.getJob(jobId);
		}

}
