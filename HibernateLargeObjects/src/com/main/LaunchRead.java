package com.main;


import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.entity.Profile;

public class LaunchRead {

	public static void main(String[] args) throws IOException {
		
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Profile.class)
				.buildSessionFactory();

		Session session = sessionFactory.openSession();		

		//eager loading
		Profile profile = session.get(Profile.class, 12);
		System.out.println(profile);	
		
		System.out.println(profile.getProfileId());
		System.out.println(profile.getName());
		
		byte img[]  = profile.getImg();
		//where you want to store;
		FileOutputStream fos = new FileOutputStream("/Users/prashantkumartiwary/Downloads/pink2.jpeg");
		fos.write(img);
		
		char file[] = profile.getCharFile();
//		for(char s : file)
//			System.out.println(s+" ");
		
		FileWriter fw = new FileWriter("/Users/prashantkumartiwary/Downloads/mytext3.txt");
		fw.write(file);
		
		fw.close();
		fos.close();	
		session.close();
		sessionFactory.close();
	}

}
