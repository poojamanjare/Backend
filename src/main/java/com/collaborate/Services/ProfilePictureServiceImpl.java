package com.collaborate.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.DAO.ProfilePictureDAO;
import com.collaborate.model.ProfilePicture;

@Service
public class ProfilePictureServiceImpl implements ProfilePictureService
{
	@Autowired
	ProfilePictureDAO profilePictureDAO;

	public void uploadProfilePicture(ProfilePicture profilePicture) 
	{
		System.out.println("in serviceimpl...profile.............");
		profilePictureDAO.uploadProfilePicture(profilePicture);
		
	}

	public ProfilePicture getProfilePicture(String userId) 
	{
		
		return profilePictureDAO.getProfilePicture(userId);
	}
}
