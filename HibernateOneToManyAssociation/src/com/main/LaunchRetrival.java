package com.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.entity.Department;
import com.util.HibernateUtility;

public class LaunchRetrival {

	public static void main(String[] args) {

		Session session = null;		

		try {
			session = HibernateUtility.getSession();
			if (session != null) {				
				Department emp = session.get(Department.class, "2212");
				System.out.println(emp);				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		
			
			HibernateUtility.closeSession(session);
			HibernateUtility.closeSessionFactory();
		}
	}
}
