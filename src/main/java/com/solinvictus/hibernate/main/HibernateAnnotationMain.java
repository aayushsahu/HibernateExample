package com.solinvictus.hibernate.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.solinvictus.hibernate.model.Address;
import com.solinvictus.hibernate.model.Employee;
import com.solinvictus.hibernate.util.HibernateUtil;

public class HibernateAnnotationMain {

	public static void main(String[] args) {
		
		Employee e = new Employee("Aayush", 26, new Date() ,new Address("19", "Metro greens", "Saddu", "Raipur", "CG"));
		//Get Session
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(e);
		
		//Commit transaction
		session.getTransaction().commit();
		//System.out.println("Employee ID="+emp.getId());
		
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
		
		System.out.println("done");
	}

}
