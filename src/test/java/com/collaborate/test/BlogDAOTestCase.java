package com.collaborate.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
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
	
	@Test
	public void createBlogTest()
	{
		Blog blog= new Blog();
		blog.setBlogId(101);
		blog.setBlogName("abc");
		blog.setBlogContent("This is 1st blog");
		blog.setLikes(0);
		blog.setUserId("Pooja");
		blog.setStatus("NA");
		blog.setCreateDate(new Date());
		assertTrue("problem in Blog Creation",blogDAO.createBlog(blog));
	}
	
	
	
	
	

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
