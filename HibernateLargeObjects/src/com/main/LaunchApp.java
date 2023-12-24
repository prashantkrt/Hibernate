package com.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Profile;

public class LaunchApp {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Profile.class)
				.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		Profile profile = new Profile();
		profile.setProfileId(12);
		profile.setName("Pink Panther");
		byte imgArr[] = null;

		//try with resource
		try (FileInputStream fis = new FileInputStream(
				"/Users/prashantkumartiwary/Downloads/pinkPanther.jpeg")) {
			imgArr = new byte[fis.available()];// gives the size of the file
			fis.read(imgArr);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		profile.setImg(imgArr);
		String text = "this data is replica of text file";
		char arr[]= text.toCharArray();		
		profile.setCharFile(arr);

		session.save(profile);
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
