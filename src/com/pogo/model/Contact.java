package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="conid")
	private int conid;
	
	@Column(name="name")
	private String name;
	@Column(name="department")
	private String department ;
	@Column(name=" designation")
	private String  designation ;
	@Column(name="phone")
	private String phone;
	@Column(name="email")
	private String email;
	@Column(name="dob")
	private String dob;
	@Column(name="doa")
	private String doa;
	
	public int getConid() {
		return conid;
	}
	public void setConid(int conid) {
		this.conid = conid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDoa() {
		return doa;
	}
	public void setDoa(String doa) {
		this.doa = doa;
	}
	

}
