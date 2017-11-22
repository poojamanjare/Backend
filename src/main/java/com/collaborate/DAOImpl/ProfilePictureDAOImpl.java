package com.collaborate.DAOImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.DAO.ProfilePictureDAO;
import com.collaborate.model.ProfilePicture;

@Repository
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO
{
	@Autowired
	SessionFactory sessionFactory;
	

	public void uploadProfilePicture(ProfilePicture profilePicture) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(profilePicture);
		System.out.println("profile uploaded successfully...!!!");	
		session.getTransaction().commit();
	}


	public ProfilePicture getProfilePicture(String userId) 
	{
		Session session=sessionFactory.openSession();
		//select * from profilepicture where username='admin'
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class, userId);	//select * from ProfilePicture where username=?
		session.close();
		return profilePicture;
		
	}
}