package com.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.entity.Branch;
import com.entity.Student;
import com.util.HibernateUtil;

public class LaunchApplication {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {

					Branch branch = new Branch();
					branch.setBranchID("T21");
					branch.setBranchName("Devlopment");
					branch.setBranchLocation("JRD");

					Student student1 = new Student("Rajat", "Abc", branch);
					Student student2 = new Student("Gaurav", "Kolkata", branch);
					Student student3 = new Student("Kartik", "Purulia", branch);

					session.save(student1);
					session.save(student2);
					session.save(student3);

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
