package com.collaborate.DAO;

import java.util.List;

import com.collaborate.model.BlogPost;

public interface BlogPostDAO 
{
	public void addBlogPost(BlogPost blogPost);
	public List<BlogPost>getBlogs(int approved);	//approved value is either 0 or 1
	public BlogPost getBlogById(int blogId);
	public void updateBlogPost(BlogPost blogPost);
	public List<BlogPost>getNotification(String userId);
}
