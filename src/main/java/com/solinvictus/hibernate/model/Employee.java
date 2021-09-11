package com.solinvictus.hibernate.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Column;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long employeeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "joining_date")
	private Date dateOfJoining;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name= "houseNo", column = @Column(name = "house_no")),
		@AttributeOverride(name= "locality", column = @Column(name = "locality")),
		@AttributeOverride(name= "sector", column = @Column(name = "sector")),
		@AttributeOverride(name= "city", column = @Column(name = "city")),
		@AttributeOverride(name= "state", column = @Column(name = "state"))
	})
	private Address address;
	
	public Employee(String name, int age, Date dateOfJoining, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.dateOfJoining = dateOfJoining;
		this.address = address;
	}
	public Employee() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
