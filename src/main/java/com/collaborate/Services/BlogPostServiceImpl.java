package com.collaborate.Services;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.DAO.BlogPostDAO;
import com.collaborate.model.BlogPost;

@Service
public class BlogPostServiceImpl implements BlogPostService
{
	@Autowired
	private BlogPostDAO blogPostDAO;

	public void addBlogPost(BlogPost blogPost) 
	{
		blogPostDAO.addBlogPost(blogPost);
		
	}

	public List<BlogPost> getBlogs(int approved) {
		
		return blogPostDAO.getBlogs(approved);
	}

	public BlogPost getBlogById(int blogId) {
		
		return blogPostDAO.getBlogById(blogId);
	}

	public void updateBlogPost(BlogPost blogPost) 
	{
		blogPostDAO.updateBlogPost(blogPost);
	}

	public List<BlogPost> getNotification(String userId) 
	{
		
		return blogPostDAO.getNotification(userId);
	}

}
