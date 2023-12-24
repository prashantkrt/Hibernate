package com.main;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class LaunchAppEager {

	public static void main(String[] args) {

		// Tell JVM to activate Hibernate
		Configuration config = new Configuration();
		config.configure();
		// config.configure("/hibernate.config.xml");

		// SessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();

		// Open Session
		Session session = sessionFactory.openSession();
		System.out.println("Class implementing the session Factory " + sessionFactory.getClass().getName());

		// open transaction
		// No need of transaction for non select operations
		// Transaction transaction = session.beginTransaction();
		
		// eager loading
		// record whoes id is 1.
		// if record doesn't present it will student as null which gives nullpointerexception
		Student student = (Student)session.get(Student.class, 2);
		System.out.println(student);
		System.out.println("student1 id is "+student.getId());
		System.out.println("student1 name is "+student.getName());
		System.out.println("student1 age is "+student.getAge());
		System.out.println("student1 city is "+student.getCity());
		
		try {
			System.in.read();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		// go to cache memroy and retrive the data for same id value
		// only one time query will generated
		Student student2 = (Student)session.get(Student.class, 2);
		System.out.println(student2);
		System.out.println("student2 id is "+student2.getId());
		System.out.println("student2 name is "+student2.getName());
		System.out.println("student2 age is "+student2.getAge());
		System.out.println("student2 city is "+student2.getCity());
		
		try {
			System.in.read();
		} catch (IOException e) {		
			e.printStackTrace();
		}		
		
		// now here it will again hit the db for retrival of data and added to the cache memory for same ID
		// query will generate to retrive the data
		Student student3 = (Student)session.get(Student.class, 3);
		System.out.println(student2);
		System.out.println("student3 id is "+student3.getId());
		System.out.println("student3 name is "+student3.getName());
		System.out.println("student3 age is "+student3.getAge());
		System.out.println("student3 city is "+student3.getCity());			
		
		session.close();
		sessionFactory.close();
	}
}
