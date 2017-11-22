package com.collaborate.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.DAO.BlogCommentDAO;
import com.collaborate.model.BlogComment;

@Repository
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public BlogCommentDAOImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	public void addBlogComment(BlogComment blogComment) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(blogComment);
		System.out.println("BlogComment create successfully...!!!");
		session.getTransaction().commit();
		
	}
	public List<BlogComment> getBlogComments(int blogId) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("From BlogComment where blogPost.blogId="+blogId);
		System.out.println("getting blogcomments for BlogId "+blogId+" successsfully...!!!");
		return query.list();
		
	}

}
