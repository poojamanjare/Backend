package com.collaborate.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import oracle.net.aso.f;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.DAO.BlogDAO;
import com.collaborate.DAO.ForumDAO;
import com.collaborate.model.Forum;

public class ForumDAOTestCase 
{
	static ForumDAO forumDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collaborate");
		annotationConfigApplicationContext.refresh();
		forumDAO=(ForumDAO)annotationConfigApplicationContext.getBean("ForumDAO");
	}
	
	@Ignore
	@Test
	public void createForumTest()
	{
		Forum forum=new Forum();
		forum.setForumId(201);
		forum.setForumName("Programming language");
		forum.setStatus("NA");
		forum.setForumContent("This is 1st forum");
		forum.setCreateDate(new Date());
		
		assertTrue("problem in creation of forum", forumDAO.createForum(forum));
		
	}
	@Ignore
	@Test
	public void getForumByIdTest()
	{
		assertNotNull("problem in getting forum by forumId", forumDAO.getForum(201));
	}
	
	@Ignore
	@Test
	public void getAllForumTest()
	{
		List<Forum>listForum=forumDAO.getForum();
		assertTrue("problem in getting list of all Forum", listForum.size()>0);
	}
	
	@Ignore
	@Test
	public void approvedForumTest()
	{
		Forum forum=new Forum();
		forum.setForumId(201);
		forum.setForumName("pqr");
		forum.setStatus("NA");
		forum.setForumContent("This is 1st forum");
		forum.setCreateDate(new Date());
		
		assertTrue("problem in creation of forum", forumDAO.approveForum(forum));
	}
	
	@Test
	public void getAllApproveForumTest()
	{
		List<Forum>listForum=forumDAO.getApproveForum();
		assertTrue("problem in getting list of all Forum", listForum.size()>0);
	}
	
	@Ignore
	@Test
	public void updateForumTest()
	{
		assertTrue("problem in updating forum", forumDAO.updateForum(201));
	}
	
	@Ignore
	@Test
	public void deleteForumTest()
	{
		assertTrue("problem in deleting forum", forumDAO.deleteForum(201));
	}
	
	
	
	
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
