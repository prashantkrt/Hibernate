package com.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import com.entity.Account;
import com.entity.Employee;
import com.util.HibernateUtil;

public class LaunchOneToOne {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {

					Employee emp = new Employee();
					Account account = new Account("ACC0000190", "Tapan", "Saving");
					session.save(account);

					emp.setName("Tapn");
					emp.setSalary(10000.00);
					emp.setCity("Jaipur");
					emp.setAccount(account);

					session.save(emp);
					flag = true;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println("Data stored successfully");
				// commit only, if tx still hasn't been committed yet by Hibernate
				if (transaction.getStatus().equals(TransactionStatus.ACTIVE)) {
					transaction.commit();
				}
			} else {
				transaction.rollback();
				System.out.println("Not processed");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
