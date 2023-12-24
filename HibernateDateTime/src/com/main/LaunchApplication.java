package com.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class LaunchApplication {

	public static void main(String[] args) {		
		
		//this style is also used 
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee();
		
		employee.setId(1);
		employee.setName("Rahul");
		employee.setAge("32");
		employee.setCity("Bhagalpur");
		employee.setDate(new Date());
		employee.setTime(new Date());
		employee.setDateTime(new Date());		
		
		session.save(employee);
		
		transaction.commit();
		session.close();
		sessionFactory.close();	
		
	}

}
