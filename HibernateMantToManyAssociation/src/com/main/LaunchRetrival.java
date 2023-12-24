package com.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.entity.Student;
import com.util.HibernateUtil;

public class LaunchRetrival {

	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				Student student = session.get(Student.class, 1);
				System.out.println(student);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
