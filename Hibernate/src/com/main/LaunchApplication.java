package com.main;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class LaunchApplication {

	public static void main(String[] args) {
		
		//Inform JVM to activate Hibernate		
		Configuration config = new Configuration();
		config.configure();	
	
		//Creating session factory to hold all other required objects for hibernate
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		//Persistence operation
		Session session = sessionFactory.openSession();
		
		//Only for not select operations Transaction must be there
		Transaction transaction = session.beginTransaction();		
		
		//Creation of persistence object
		Student student = new Student();
		student.setId(1);
		student.setName("Rajat");
		student.setCity("Chandigarh");
		student.setAge(38);		
		
		//perform persistence operations		
		session.save(student);
		
		//commiting		
		transaction.commit();
		
		//closing the resources
		session.close();
		sessionFactory.close();
	}

}
