package com.collaborate.DAOImpl;

import java.util.List;

import oracle.net.aso.s;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaborate.DAO.FriendDAO;
import com.collaborate.model.Friend;
import com.collaborate.model.Users;

@Repository
@Transactional
public class FriendDAOImpl implements FriendDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Users> listOfSuggestedUsers(String userId) //here userid is fromid of friend table
	{
		Session session=sessionFactory.getCurrentSession();
		/*String A="select userId from Users where userId!=?";
		String B="select fromId from Friend where toId=?";
		String C="select toId from Friend where fromId=?";*/
		SQLQuery query=session.createSQLQuery("select * from Users where userId IN(select userId from Users where userId!=? minus (select fromId from Friend where toId=? union select toId from Friend where fromId=?))");
		//SQLQuery sqlQuery=session.createSQLQuery("select * from Users where userId IN("+A+"minus("+B+"union"+C+"))");
		System.out.println("get list of suggested users for "+userId+" successfully...!!!");
		/*sqlQuery.setString(0, userId);
		sqlQuery.setString(1, userId);
		sqlQuery.setString(2, userId);
		sqlQuery.addEntity(Users.class);//to convert records to Users object
		List<Users>suggestedUsers=sqlQuery.list();
		return suggestedUsers;	//here suggestedUsers is list of users List<Users>*/	
		query.setString(0, userId);
		query.setString(1, userId);
		query.setString(2, userId);
		query.addEntity(Users.class);
		//@SuppressWarnings("unchecked")
		List<Users>suggestedUsers=query.list();
		System.out.println("list of suggested users............");
		return suggestedUsers;
		}

	public void friendRequest(Friend friend) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(friend);		
	}
	
	public List<Friend> pendingRequets(String toId) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Friend where toId=? and status='P'");
		query.setString(0, toId);
		return query.list();
	}

	public void updatePendingRequests(Friend friend) 
	{
		Session session=sessionFactory.getCurrentSession();
		if(friend.getStatus()=='A')
			session.update(friend);	//update Friend set status='A' where id=?
		else
			session.delete(friend);	//delete from Friend where id=?
		
	}

	public List<String> listOfFriends(String userId) 
	{
		Session session=sessionFactory.getCurrentSession();
		SQLQuery sqlQuery1=session.createSQLQuery("select fromId from Friend where toId=? and status='A'")
				.addScalar("fromId",StandardBasicTypes.STRING);
		sqlQuery1.setString(0, userId);
		List<String>list1=sqlQuery1.list();
		System.out.println("Result of 1st query::"+list1);
		SQLQuery sqlQuery2=session.createSQLQuery("select toId from Friend where fromId=? and status='A'")
				.addScalar("toId", StandardBasicTypes.STRING);
		sqlQuery2.setString(0, userId);
		List<String>list2=sqlQuery2.list();
		System.out.println("Result of 2nd query::"+list2);
		list1.addAll(list2);//list1=list1 U list2
		System.out.println("result of list1+list2="+list1);
		return list1;
	}

	

}
