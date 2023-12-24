package com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class LaunchApplication {

	public static void main(String[] args) {

		// activate hibernate
//		Configuration config = new Configuration();
//		config.configure();
//		
//		//load session factory
//		SessionFactory sessionFactory = config.buildSessionFactory();
//		
//		//open session
//		Session session = sessionFactory.openSession();

		// method chaining
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		// Student st = session.load(Student.class, 3); EntityNotFoundException won't go to the else block
		// javax.persistence.EntityNotFoundException: No row with the given identifier exists: [com.entity.Student#3]
		
		//go for the eager loading as it gives null to the student object
		Student st = session.get(Student.class, 3);
		if (st != null) {
			// non select operation need transaction
			System.out.println("Delete operation successfull:)");
			Transaction transaction = session.beginTransaction();
			session.delete(st);
			transaction.commit();
		} 
		else {
			System.out.println("Record not found :(");
		}
		
		session.close();
	}

}
