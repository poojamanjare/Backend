package com.collaborate.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.DAO.BlogPostDAO;
import com.collaborate.model.BlogPost;

@Repository
@Transactional
public class BlogPostDAOImpl implements BlogPostDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public BlogPostDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	//======================add new Blog=====================================================
	public void addBlogPost(BlogPost blogPost) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(blogPost);
		System.out.println("BlogPost create successfully...!!!");
		session.getTransaction().commit();
	}
	
	//========================get list of all approved blogs=================================
	public List<BlogPost> getBlogs(int approved) 
	{
		Session session=sessionFactory.getCurrentSession();
		//if approved=0,select * from blogpost where approved=0,rejectionreason=null;
		//blogs waiting for approval
		
		String queryString="";
		if(approved==1)//list of blogs approved
			queryString="From BlogPost where approved="+approved;
		else//list of blogs waiting for approval[to ignore the blogpost which are already reject by admin]
			queryString="From BlogPost where rejectionReason is null and approved="+approved;
		
		Query query=session.createQuery(queryString);
		System.out.println("getting list of all blogs successfully...!!!");
		return query.list();
	}

	//===========================get Blog by blogid========================================
	public BlogPost getBlogById(int blogId) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		BlogPost blogPost=(BlogPost) session.get(BlogPost.class, blogId);
		System.out.println("getting blog by blogId "+blogPost.getBlogId()+" successfully...!!!");
		session.getTransaction().commit();
		return blogPost;
	}

	//==========================update blogpost====================================
	public void updateBlogPost(BlogPost blogPost) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.update(blogPost);	//update approved & rejectionReason
		//if approved->update blogpost set approved=1 where blogId=?
		//if reject->update blogpost set approved=0,rejectionreason=? where blogId=?
	}

	public List<BlogPost> getNotification(String userId) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("From BlogPost where postedBy.userId=? and viewed=? and (approved=1 or rejectionReason!=null)");
		query.setString(0, userId);
		query.setBoolean(1, false);
		return query.list();
		
	}

}
