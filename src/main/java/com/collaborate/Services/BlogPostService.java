package com.collaborate.Services;

import java.util.List;

import com.collaborate.model.BlogPost;

public interface BlogPostService 
{
	public void addBlogPost(BlogPost blogPost);
	public List<BlogPost>getBlogs(int approved);
	public BlogPost getBlogById(int blogId);
	public void updateBlogPost(BlogPost blogPost);
	public List<BlogPost>getNotification(String userId);
}
