package com.collaborate.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.DAO.UsersDAO;
import com.collaborate.model.Users;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UsersDAO usersDAO;

	public boolean createUsers(Users users) 
	{
		return usersDAO.createUsers(users);
	}

	public List<Users> getUsers(int status) {
		
		return usersDAO.getUsers(status);
	}
	
	/*public Users getUsers(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Users> getApproveUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean approveUsers(Users users) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUsers(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUsers(String userId) {
		// TODO Auto-generated method stub
		return false;
	}*/

	public boolean isUserIdValid(String userId) 
	{
		System.out.println("userid **********(in userServiceImpl)  ::"+userId);
		return usersDAO.isUserIdValid(userId);
	}

	public boolean isEmailValid(String email) 
	{
		System.out.println("in serviceimpl----------->"+email);
		return usersDAO.isEmailValid(email);
	}

	public Users login(Users users) 
	{
		
		return usersDAO.login(users);
	}

	public void update(Users users) 
	{
		System.out.println("in serviceimpl.....update isonline");
		usersDAO.update(users);
	}

	public Users getUserById(String userId) 
	{
		System.out.println("in serviceimpl:::::::::::::"+userId);
		return usersDAO.getUserById(userId);
	}

	public boolean isUpdatedEmailValid(String email, String userId) 
	{
		// TODO Auto-generated method stub
		return usersDAO.isUpdatedEmailValid(email, userId);
	}

	public List<Users> getUsers(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*public void updateUsers(Users users) 
	{
		usersDAO.updateUsers(users);
		
	}
*/
	

}
