package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class LaunchAppRetrive {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Employee emp = session.get(Employee.class, 1);

		if (emp != null) {
			System.out.println(emp);
		} else {
			System.out.println("Data not present");
		}
	}

}
