package com.solinvictus.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Address {

	private String houseNo;
	private String locality;
	private String sector;
	private String city;
	private String state;
	
	public Address(String houseNo, String locality, String sector, String city, String state) {
		super();
		this.houseNo = houseNo;
		this.locality = locality;
		this.sector = sector;
		this.city = city;
		this.state = state;
	}
	
	public Address() {
		
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
