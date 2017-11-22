package com.collaborate.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.DAO.BlogCommentDAO;
import com.collaborate.DAO.BlogDAO;
import com.collaborate.DAO.UsersDAO;
import com.collaborate.model.Blog;
import com.collaborate.model.BlogComment;
import com.collaborate.model.Users;

public class BlogCommentDAOTest 
{
	static BlogCommentDAO blogCommentDAO;
	static BlogDAO blogDAO;
	static UsersDAO usersDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collaborate");
		annotationConfigApplicationContext.refresh();
		blogCommentDAO=(BlogCommentDAO) annotationConfigApplicationContext.getBean("BlogCommentDAO");
		blogDAO=(BlogDAO) annotationConfigApplicationContext.getBean("BlogDAO");
		usersDAO=(UsersDAO) annotationConfigApplicationContext.getBean("UsersDAO");
	}
	
	@Ignore
	@Test
	public void createBlogCommentTest()
	{
		System.out.println("hiiiiiiiiiiii========================");
		Blog blog=blogDAO.getBlog(103);
		Users users=usersDAO.getUsers("priya@gmail.com");
		BlogComment blogComment=new BlogComment();
		blogComment.setBlogCommentId(301);
		blogComment.setComments("this is 1st comment");
		blogComment.setUsername("priya");
		blogComment.setCreateDate(new Date());
		blogComment.setBlog(blog);
		blogComment.setUsers(users);
		
		assertTrue("problem in BlogComment Creation", blogCommentDAO.createBlogComment(blogComment));
	}
	
	@Ignore
	@Test
	public void getBlogCommentByIdTest()
	{
		assertNotNull("problem in getting blogComment by blogcommentId", blogCommentDAO.getBlogComment(301));
	}
	
	@Ignore
	@Test
	public void getAllBlogCommentsTest()
	{
		List<BlogComment>listComments=blogCommentDAO.getAllBlogcomment();
		assertTrue("problem in getting list of all blogcomments", listComments.size()>0);
	}
	
	@Test
	public void updateBlogCommentTest()
	{
		assertTrue("problem in updation of blogcomment", blogCommentDAO.updateBlogComment(301));
	}
	
	@Test
	public void deleteBlogCommentTest()
	{
		assertTrue("problem in deletion of blogcomment", blogCommentDAO.deleteBlogComment(301));
	}
	

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
