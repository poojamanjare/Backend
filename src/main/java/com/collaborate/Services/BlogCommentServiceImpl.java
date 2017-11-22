package com.collaborate.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.DAO.BlogCommentDAO;
import com.collaborate.model.BlogComment;

@Service
public class BlogCommentServiceImpl implements BlogCommentService
{

	@Autowired
	private BlogCommentDAO blogCommentDAO;
	
	public void addBlogComment(BlogComment blogComment) 
	{
		blogCommentDAO.addBlogComment(blogComment);
		
	}

	public List<BlogComment> getBlogComments(int blogId) {
		
		return blogCommentDAO.getBlogComments(blogId);
	}

}
