package com.main;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import com.entity.Department;
import com.entity.Employee;
import com.util.HibernateUtility;

public class LaunchOneToMany {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtility.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {

										
					Employee emp1 = new Employee("Pankaj", 20000.0, "Mumbai");

							
					Employee emp2 = new Employee("Harsha", 20000.0, "Delhi");

									
					Employee emp3 = new Employee("Vinod", 20000.0, "Bangalore");

					Set<Employee> employee = new HashSet<>();
					employee.add(emp1);
					employee.add(emp2);
					employee.add(emp3);

					Department department = new Department("2212","IT", employee);					
					session.save(department);
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
			} else if(transaction!=null) {
				transaction.rollback();
				System.out.println("Not processed");
			}
			HibernateUtility.closeSession(session);
			HibernateUtility.closeSessionFactory();
		}

	}
}
