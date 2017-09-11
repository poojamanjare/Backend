package com.collaborate.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.DAO.BlogDAO;
import com.collaborate.model.Blog;

@Repository("BlogDAO")
public class BlogDAOImpl implements BlogDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}
	@Transactional
	public boolean createBlog(Blog blog) {
		// TODO Auto-generated method stub
		try
		{
			/*sessionFactory.getCurrentSession().saveOrUpdate(blog);*/
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(blog);
			System.out.println("Blog create successfully...!!!");
			session.getTransaction().commit();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	public Blog getBlog(int blogID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Blog> getBlog() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean editBlog(int blogId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteBlog(int blogId) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
