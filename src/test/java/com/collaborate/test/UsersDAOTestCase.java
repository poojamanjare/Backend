/*package com.collaborate.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.DAO.UsersDAO;
import com.collaborate.model.Users;

public class UsersDAOTestCase 
{
	static UsersDAO usersDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collaborate");
		annotationConfigApplicationContext.refresh();
		usersDAO=(UsersDAO)annotationConfigApplicationContext.getBean("UsersDAO");
	}
	
	@Ignore
	@Test
	public void createUsersTest()
	{
		Users users=new Users();
		users.setUserId("pooja");
		users.setFirstName("pooja");
		users.setLastName("Manjare");
		users.setRole("Student");
		users.setPassword("pooja");
		users.setIsOnline("yes");
		users.setStatus("NA");
		users.setEmail("pooja@gmail.com");
		users.setPhonenumber("9876543234");
		
		assertTrue("Problem in creation of users", usersDAO.createUsers(users));
	}
	
	@Ignore
	@Test
	public void getUserByIdTest()
	{
		assertNotNull("problem in getting all user", usersDAO.getUsers("priya@gmail.com"));
	}
	
		
	@Ignore
	@Test
	public void getAllUsersTest()
	{
		List<Users>listUsers=usersDAO.getUsers();
		assertTrue("problem in getting list of all Users", listUsers.size()>0);
	}
	
	@Ignore
	@Test
	public void approvedUsers()
	{
		Users users=new Users();
		users.setUserId("pooja@gmail.com");
		users.setFirstName("pooja");
		users.setLastName("Manjare");
		users.setRole("User");
		users.setPassword("pooja");
		users.setIsOnline("yes");
		users.setStatus("NA");
		
		assertTrue("Problem in creation of users", usersDAO.approveUsers(users));
	}
	
	@Ignore
	@Test
	public void getAllApproveUsersTest()
	{
		List<Users>listUsers=usersDAO.getApproveUsers();
		assertTrue("problem in getting list of approve users ", listUsers.size()>0);
	}
	
	@Ignore
	@Test
	public void updateUsersTest()
	{
		assertTrue("problem in updating user", usersDAO.updateUsers("pooja@gmail.com"));
	}
	
	@Ignore
	@Test
	public void deleteUsersTest()
	{
		assertTrue("problem in updating user", usersDAO.deleteUsers("pooja@gmail.com"));
	}

	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
*/