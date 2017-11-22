package com.collaborate.DAO;

import com.collaborate.model.ProfilePicture;

public interface ProfilePictureDAO 
{
	void uploadProfilePicture(ProfilePicture profilePicture);

	ProfilePicture getProfilePicture(String userId);

}
