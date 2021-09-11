package com.solinvictus.hibernate.main;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.solinvictus.hibernate.model.Address;
import com.solinvictus.hibernate.model.Asset;
import com.solinvictus.hibernate.model.Department;
import com.solinvictus.hibernate.model.Employee;
import com.solinvictus.hibernate.util.HibernateUtil;

public class HibernateAnnotationMain {

	public static void main(String[] args) {
		
		Employee e1 = new Employee("Aayush", 26, new Date() ,new Address("19", "Metro greens", "Saddu", "Raipur", "CG"));
		Employee e2 = new Employee("Shobhit", 26, new Date() ,new Address("20", "Metro greens", "Saddu", "Raipur", "CG"));
		Employee e3 = new Employee("Anurag", 26, new Date() ,new Address("21", "Metro greens", "Saddu", "Raipur", "CG"));
		Employee e4 = new Employee("Vishal", 26, new Date() ,new Address("22", "Metro greens", "Saddu", "Raipur", "CG"));
		Employee e5 = new Employee("Snake", 26, new Date() ,new Address("23", "Metro greens", "Saddu", "Raipur", "CG"));
		Employee e6 = new Employee("Mazhar", 26, new Date() ,new Address("24", "Metro greens", "Saddu", "Raipur", "CG"));
		Employee e7 = new Employee("Panda", 26, new Date() ,new Address("25", "Metro greens", "Saddu", "Raipur", "CG"));
		Employee e8 = new Employee("Ayush", 26, new Date() ,new Address("26", "Metro greens", "Saddu", "Raipur", "CG"));
		
		Asset a1 = new Asset("Lenovo", "Thinkpad T480", "");
		Asset a2 = new Asset("Lenovo", "Thinkpad T480", "");
		Asset a3 = new Asset("Lenovo", "Thinkpad T480", "");
		Asset a4 = new Asset("Lenovo", "Thinkpad T470", "");
		Asset a5 = new Asset("Lenovo", "Thinkpad T470", "");
		Asset a6 = new Asset("Lenovo", "Thinkpad T470", "");
		Asset a7 = new Asset("Lenovo", "Thinkpad T470", "");
		Asset a8 = new Asset("Lenovo", "Thinkpad T470", "");
		Asset a9 = new Asset("Lenovo", "Thinkpad T470", "");
		Asset a10 = new Asset("Lenovo", "Thinkpad T470", "");
		
		Department d1 = new Department("IT" );
		Department d2 = new Department("Operations");
		Department d3 = new Department("Sales");
		
		//set Department of Employee
		e1.setDepartment(d1);
		e2.setDepartment(d1);
		e3.setDepartment(d1);
		e4.setDepartment(d2);
		e5.setDepartment(d2);
		e6.setDepartment(d2);
		e7.setDepartment(d3);
		e8.setDepartment(d3);
		
		//set asset for Employee
		e1.setAsset(a1);
		e2.setAsset(a2);
		e3.setAsset(a3);
		e4.setAsset(a4);
		e5.setAsset(a5);
		e6.setAsset(a6);
		e7.setAsset(a7);
		e8.setAsset(a8);
		
		//set Employee to asset
		a1.setEmployee(e1);
		a2.setEmployee(e2);
		a3.setEmployee(e3);
		a4.setEmployee(e4);
		a5.setEmployee(e5);
		a6.setEmployee(e6);
		a7.setEmployee(e7);
		a8.setEmployee(e8);
		a9.setEmployee(null);
		a10.setEmployee(null);
		
		//set Employee list in Department object
		Set<Employee> s1= new HashSet<Employee>();
		s1.add(e1);
		s1.add(e2);
		s1.add(e3);
		
		Set<Employee> s2= new HashSet<Employee>();
		s2.add(e4);
		s2.add(e5);
		s2.add(e6);
		
		Set<Employee> s3= new HashSet<Employee>();
		s3.add(e7);
		s3.add(e8);
		s3.add(e1);
		
		d1.setEmployees(s1);
		d2.setEmployees(s2);
		d3.setEmployees(s3);
		
		//Get Session
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		
		//start transaction
		session.beginTransaction();
		
		//Save the Model object
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		session.save(e5);
		session.save(e6);
		session.save(e7);
		session.save(e8);
		
		session.save(d1);
		session.save(d2);
		session.save(d3);
		
		session.save(a1);
		session.save(a2);
		session.save(a3);
		session.save(a4);
		session.save(a5);
		session.save(a6);
		session.save(a7);
		session.save(a8);
		session.save(a9);
		session.save(a10);
		
		//Commit transaction
		session.getTransaction().commit();
		
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
		
		System.out.println("done");
	}

}
