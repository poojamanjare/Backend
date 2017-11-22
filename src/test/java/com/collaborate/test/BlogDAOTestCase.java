package com.collaborate.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.DAO.BlogDAO;
import com.collaborate.model.Blog;

public class BlogDAOTestCase 
{
	static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collaborate");
		annotationConfigApplicationContext.refresh();
		blogDAO=(BlogDAO)annotationConfigApplicationContext.getBean("BlogDAO");
	}
	
	/*@Ignore*/
	@Test
	public void createBlogTest()
	{
		Blog blog= new Blog();
		blog.setBlogId(104);
		blog.setBlogName("Java");
		blog.setBlogContent("This is prohramming language");
		blog.setLikes(0);
		blog.setUserId("Priya");
		blog.setStatus("NA");
		blog.setCreateDate(new Date());
		
		assertTrue("problem in Blog Creation",blogDAO.createBlog(blog));
	}
	
	@Ignore
	@Test
	public void getBlogByIdTest()
	{
		assertNotNull("problem in getting blog by blogId", blogDAO.getBlog(101));
	}
	
	@Ignore
	@Test
	public void getAllBlogTest()
	{
		List<Blog>listBlog=blogDAO.getBlog();
		assertTrue("problem in getting list of all blogs", listBlog.size()>0);
	}
	
	@Ignore
	@Test
	public void approvedBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlogId(101);
		blog.setBlogName("abc");
		blog.setBlogContent("This is 1st blog");
		blog.setLikes(0);
		blog.setUserId("Pooja");
		blog.setStatus("A");
		blog.setCreateDate(new Date());
		assertTrue("problem in approve Blog",blogDAO.approveBlog(blog));
	}
	
	@Ignore
	@Test
	public void getAllApproveBlogTest()
	{
		List<Blog>listBlog=blogDAO.getApproveBlog();
		assertTrue("problem in getting list of all approve blogs", listBlog.size()>0);
	}
	
	@Ignore
	@Test
	public void updateBlogTest()
	{
		assertTrue("problem in blog updation",blogDAO.updateBlog(101));
	}
	
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		assertTrue("Problem in blog deletion",blogDAO.deleteBlog(101));
	}
	
	

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
