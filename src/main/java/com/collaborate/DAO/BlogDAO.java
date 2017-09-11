package com.collaborate.DAO;

import java.util.List;

import com.collaborate.model.Blog;

public interface BlogDAO 
{
	public boolean createBlog(Blog blog);
	public Blog getBlog(int blogID);
	public List<Blog>getBlog();
	public boolean approveBlog(Blog blog);
	public boolean editBlog(int blogId);
	public boolean deleteBlog(int blogId);
	
}
