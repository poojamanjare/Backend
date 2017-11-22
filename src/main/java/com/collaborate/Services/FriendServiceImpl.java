package com.collaborate.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.DAO.FriendDAO;
import com.collaborate.model.Friend;
import com.collaborate.model.Users;

@Service
public class FriendServiceImpl implements FriendService
{
	@Autowired
	FriendDAO friendDAO;

	public List<Users> listOfSuggestedUsers(String userId) 
	{
		return friendDAO.listOfSuggestedUsers(userId);
	}

	public void friendRequest(Friend friend) 
	{
		friendDAO.friendRequest(friend);
		
	}

	public List<Friend> pendingRequets(String toId) {
		
		return friendDAO.pendingRequets(toId);
	}
	
	public void updatePendingRequests(Friend friend) 
	{
		friendDAO.updatePendingRequests(friend);
		
	}

	public List<String> listOfFriends(String userId) 
	{
		return friendDAO.listOfFriends(userId);
	}

}
