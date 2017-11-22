package com.collaborate.DAO;

import java.util.List;

import com.collaborate.model.Job;

public interface JobDAO 
{
	void addJob(Job job);
	List<Job>getAllJobs();
	Job getJob(int jobId);

}
