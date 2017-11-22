package com.collaborate.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.DAO.JobDAO;
import com.collaborate.model.Job;

@Repository
@Transactional
public class JobDAOImpl implements JobDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public void addJob(Job job) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(job);			//insert into job values(...)
		System.out.println("Job added successfully...!!!");
		
	}

	public List<Job> getAllJobs() 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("From Job");
		System.out.println("getting list of all jobs successfully...!!!");
		return query.list();
	}

	
	public Job getJob(int jobId) {
		Session session=sessionFactory.getCurrentSession();
		Job job=(Job) session.get(Job.class, jobId);
		System.out.println("get job details by jobid successfully...!!!");
		return job;
	}

}
