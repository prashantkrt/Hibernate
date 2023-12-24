package com.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.entity.Employee;
import com.util.HibernateUtil2;

public class LaunchRetrival {

	public static void main(String[] args) {

		Session session = null;		

		try {
			session = HibernateUtil2.getSession();
			if (session != null) {				
				Employee emp = session.get(Employee.class, 1);
				System.out.println(emp);				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		
			
			HibernateUtil2.closeSession(session);
			HibernateUtil2.closeSessionFactory();
		}
	}
}
