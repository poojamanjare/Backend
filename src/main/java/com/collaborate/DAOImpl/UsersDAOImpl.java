package com.collaborate.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.DAO.UsersDAO;
import com.collaborate.model.Users;

@Repository("UsersDAO")
@Transactional
public class UsersDAOImpl implements UsersDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public UsersDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	//=================create user==================================
	@Transactional
	public boolean createUsers(Users users) 
	{
		try
		{
			/*sessionFactory.getCurrentSession().saveOrUpdate(users);*/
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(users);
			System.out.println("Users created successfully...!!!");
			session.getTransaction().commit();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	//==========================================
	public List<Users> getUsers(int status) 
	{
		Session session=sessionFactory.getCurrentSession();
		
		String queryString="";
		if(status==1)			//list of users approved
			queryString="From Users where status="+status;
		else				//list of users waiting for approval[to ignore the users which are already reject by admin]
			queryString="From Users where rejectReason is null and status="+status;
		
		Query query=session.createQuery(queryString);
		System.out.println("getting list of all users successfully...!!!");
		return query.list();
	}
	
	
	//=============get user by userid================================
	/*public Users getUsers(String userId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Users users=(Users)session.get(Users.class, userId);
			users.getUserId();
			System.out.println("getting users by userID "+users.getUserId()+" successfully...!!!");
			session.flush();
			session.close();
			return users;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	
	}

	//=================getting list of all users==========================
	public List<Users> getUsers() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Users");
		List<Users>listUsers=query.list();
		System.out.println("getting list of all Users successfully...!!!");
		session.close();
		return listUsers;
	}

	//============approve user====================================
	@Transactional
	public boolean approveUsers(Users users) 
	{
		try
		{
			users.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(users);
			System.out.println("Approved Users successfully...!!!");
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}
	
	//===================list of approve users==============================
	public List<Users> getApproveUsers() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Users where status='A'");
		List<Users>listUsers=query.list();
		System.out.println("getting all approve users successfully...!!!");
		session.flush();
		session.close();
		return listUsers;
	}

	//==============update user=======================================
	public boolean updateUsers(String userId) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Users users=(Users) session.get(Users.class, userId);
			users.setRole("Admin");
			System.out.println("user role get updated successfully...!!!");
			session.flush();
			session.close();
			return true;
			
		//	session.update(users);//update set online=1,firstname....lastname....where username=?
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}

	//==============delete user======================================
	public boolean deleteUsers(String userId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Users users=(Users) session.get(Users.class, userId);
			session.delete(users);
			System.out.println("user get deleted successfully...!!!");
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

*/
	@Transactional
	public boolean isUserIdValid(String userId) 
	{
			Session session=sessionFactory.getCurrentSession();
			Users users=(Users) session.get(Users.class,userId);
			System.out.println("************************"+users);
			if(users==null)
			{
				
				return true;
			}
			else
			{
				return false;
			}
		
		
	}


	@Transactional
	public boolean isEmailValid(String email) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Users where email=?");
		query.setString(0, email);
		Users users=(Users) query.uniqueResult();
		if(users==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	@Transactional
	public Users login(Users users) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Users where userId=? and password=?");	//and status=1
		query.setString(0, users.getUserId());
		query.setString(1, users.getPassword());
		//query.setBoolean(3,false);
		users=(Users) query.uniqueResult();
		return users;
	}


	public void update(Users users) 
	{
		Session session=sessionFactory.getCurrentSession();
		//session.beginTransaction();
		System.out.println("update details in users table.........!!!!!!!!");
		session.update(users);
		//session.getTransaction().commit();
		
	}


	public Users getUserById(String userId) 
	{
		Session session=sessionFactory.getCurrentSession();
		Users users=(Users) session.get(Users.class, userId);
		System.out.println("get user by userid::"+userId+ " successfully...!!!");
		return users;
	}


	public boolean isUpdatedEmailValid(String email, String userId) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Users where email=? and userId!=?");
		query.setString(0, email);
		query.setString(1, userId);
		Users users=(Users) query.uniqueResult();
		if(users==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
//====================================================================================

	/*public void updateUsers(Users users) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.update(users); 
		
	}*/


	
}