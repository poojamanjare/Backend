package com.collaborate.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*import com.collaborate.DAO.BlogCommentDAO;
import com.collaborate.DAO.BlogDAO;
import com.collaborate.DAO.ForumDAO;
import com.collaborate.DAO.UsersDAO;
import com.collaborate.DAOImpl.BlogCommentDAOImpl;
import com.collaborate.DAOImpl.BlogDAOImpl;
import com.collaborate.DAOImpl.ForumDAOImpl;
import com.collaborate.DAOImpl.UsersDAOImpl;*/











import com.collaborate.model.BlogComment;
import com.collaborate.model.BlogPost;
import com.collaborate.model.Friend;
import com.collaborate.model.Job;
import com.collaborate.model.ProfilePicture;
//import com.collaborate.model.SendMail;
import com.collaborate.model.Users;


@Configuration

@ComponentScan("com.collaboration")
@EnableTransactionManagement
public class DBConfig 
{
	
	//====create data base object used for localsessionfactory==============================================
	public DataSource getOracleDataSource()
	{
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		driverManagerDataSource.setUsername("DB");
		driverManagerDataSource.setPassword("pooja");
		return driverManagerDataSource;
	}
	
	//=======================hibernate properties used by localsessionfactory===========================
	public Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.show_sql", "true");
		return properties;
	}
	//===========create session factory bean using localsessionfactory===============================
	@Bean
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getOracleDataSource());
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		System.out.println("Session factory created......");
		localSessionFactoryBuilder.addAnnotatedClass(BlogPost.class);
		localSessionFactoryBuilder.addAnnotatedClass(Users.class);
		localSessionFactoryBuilder.addAnnotatedClass(Job.class);
		localSessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		localSessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);
		localSessionFactoryBuilder.addAnnotatedClass(Friend.class);
		//localSessionFactoryBuilder.addAnnotatedClass(SendMail.class);
		return localSessionFactoryBuilder.buildSessionFactory();
		
	}
	
	//=================Hibernate Transaction Bean===============================================
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
	}
	
	

}
