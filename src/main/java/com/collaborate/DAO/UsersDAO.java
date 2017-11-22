package com.collaborate.DAO;

import java.util.List;

import com.collaborate.model.Users;

public interface UsersDAO 
{
	public boolean createUsers(Users users);
	public List<Users>getUsers(int status);
	//public void updateUsers(Users users);
	/*public Users getUsers(String userId);
	public List<Users>getUsers();
	public List<Users>getApproveUsers();
	public boolean approveUsers(Users users);
	public boolean updateUsers(String userId);
	public boolean deleteUsers(String userId);*/
	public boolean isUserIdValid(String userId);
	public boolean isEmailValid(String email);
	public Users login(Users users);
	public void update(Users users);
	public Users getUserById(String userId);
	public boolean isUpdatedEmailValid(String email,String userId);
}