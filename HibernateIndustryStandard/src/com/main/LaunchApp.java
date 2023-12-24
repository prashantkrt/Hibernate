package com.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Student;
import com.util.HibernateUtil;

public class LaunchApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					Student st = new Student();
					st.setId(112);
					st.setAge(23);
					st.setName("Kumar");
					st.setCity("Vijaywada");

					session.save(st);
					flag = true;
				}
			}

		} catch (HibernateException e) {

			System.out.println("Hibernate exception occurred");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Data is stored");
			}
			else {
				transaction.rollback();
				System.out.println("Not able to store the data in db");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
