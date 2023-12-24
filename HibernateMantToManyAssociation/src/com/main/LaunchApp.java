package com.main;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import com.entity.Course;
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

					Course c1 = new Course(1, "Java", 2999);
					Course c2 = new Course(2, "MERN", 3999);
					Course c3 = new Course(3, "FrontEnd", 2999);
					Course c4 = new Course(4, "Python", 1999);
					Course c5 = new Course(5, "Git", 999);
					Course c6 = new Course(6, "Docker", 1999);

					Set<Course> course = new HashSet<>();
					course.add(c1);
					course.add(c2);
					course.add(c3);

					Set<Course> course2 = new HashSet<>();
					course2.add(c1);
					course2.add(c2);
					course2.add(c3);
					course2.add(c4);

					Set<Course> course3 = new HashSet<>();
					course3.add(c1);
					course3.add(c2);
					course3.add(c3);
					course3.add(c4);
					course3.add(c5);
					course3.add(c6);

					Student student1 = new Student("Rakesh", "Delhi", 34, course);
					Student student2 = new Student("Dibesh", "Delhi", 24, course2);
					Student student3 = new Student("Rohan", "Dehradun", 24, course3);
					
					
					session.saveOrUpdate(student1);
					session.saveOrUpdate(student2);
					session.saveOrUpdate(student3);				

					flag = true;

				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				// commit only, if tx still hasn't been committed yet by Hibernate
				if (transaction.getStatus().equals(TransactionStatus.ACTIVE)) {
					transaction.commit();
					System.out.println("Data stored successfully");
				}
			} else if (transaction != null) {
				transaction.rollback();
				System.out.println("Not processed");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
