package com.pogo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="userEmployee")
public class UserEmployee 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userempid")
	private Integer userempid;
	@Column(name="loginname")
	private String loginname;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Column(name="division")
	private String division;
	@Column(name="region")
	private String region;
	@Column(name="branch")
	private String branch;
	@Column(name="dateofjoining")
	private Date dateofjoining;
	@Column(name="designation")
	private String designation;
	
	@Column(name="password")
	private String password;
	@Column(name="repassword")
	private String repassword;
	@Column(name="email")
	private String eamil;
	
	@Column(name="dob")
	private Date dob;
	@Column(name="gender")
	private String gender;
	@Column(name="address")
	private String address;
	@Column(name="phone")
	private String phone;
	@Column(name="mobile")
	private String usermobile;
	//@Column(name="active")
	//private boolean active;
	
	
	
	
	public Date getDateofjoining() {
		return dateofjoining;
	}
	public void setDateofjoining(Date dateofjoining) {
		this.dateofjoining = dateofjoining;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public Integer getUserempid() {
		return userempid;
	}
	public void setUserempid(Integer userempid) {
		this.userempid = userempid;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsermobile() {
		return usermobile;
	}
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}
	
	
	
	
	
}
