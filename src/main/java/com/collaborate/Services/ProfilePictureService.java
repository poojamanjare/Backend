package com.collaborate.Services;

import com.collaborate.model.ProfilePicture;

public interface ProfilePictureService 
{
	void uploadProfilePicture(ProfilePicture profilePicture);

	ProfilePicture getProfilePicture(String userId);


}
