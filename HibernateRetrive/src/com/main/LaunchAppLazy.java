package com.main;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class LaunchAppLazy {
	
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

		// lazy loading
		// record whose id is 1.
		// will create a proxy object similar to mock
		// it will store the id
		
		// if id is found or not found it will create proxy object
		// if id is found it will return the actual object by triggering query internally
		// if id is wrong and I want the info for more than id i.e. it will lead to org.hibernate.ObjectNotFoundException 
		

		// if record with given id is not there it will give :ObjectNotFoundException 
		Student student = session.load(Student.class, 1);
		System.out.println(student);
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("student1 id is " + student.getId());
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// actual object now will be created when we need other details apart from ID
		System.out.println("student1 name is " + student.getName());
		System.out.println("student1 age is " + student.getAge());
		System.out.println("student1 city is " + student.getCity());

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Student student2 = session.load(Student.class, 1);
		System.out.println(student2);
		System.out.println("student2 id is " + student2.getId());

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("student2 name is " + student2.getName());
		System.out.println("student2 age is " + student2.getAge());
		System.out.println("student2 city is " + student2.getCity());

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Student student3 = session.load(Student.class, 3);
		System.out.println(student3);
		System.out.println("student3 id is " + student3.getId());
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("student3 name is " + student3.getName());
		System.out.println("student3 age is " + student3.getAge());
		System.out.println("student3 city is " + student3.getCity());

		session.close();
		sessionFactory.close();

	}

}
