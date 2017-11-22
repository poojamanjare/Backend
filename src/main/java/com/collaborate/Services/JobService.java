package com.collaborate.Services;

import java.util.List;

import com.collaborate.model.Job;

public interface JobService 
{
	void addJob(Job job);

	List<Job> getAllJobs();

	Job getJob(int jobId);

}
