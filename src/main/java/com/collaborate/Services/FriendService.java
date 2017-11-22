package com.collaborate.Services;

import java.util.List;

import com.collaborate.model.Friend;
import com.collaborate.model.Users;

public interface FriendService 
{
	List<Users>listOfSuggestedUsers(String userId);//here userId is logged in user's userId
	void friendRequest(Friend friend);
	List<Friend>pendingRequets(String toId);
	void updatePendingRequests(Friend friend);
	List<String>listOfFriends(String userId);

}
