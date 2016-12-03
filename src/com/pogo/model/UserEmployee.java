package com.pogo.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
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
	@Column(name="empCode")
	private String empCode;
	@Column(name="firstname")
	private String firstname;
	@Column(name="middlename")
	private String middlename;
	@Column(name="lastname")
	private String lastname;
	@Column(name="division")
	private String division;
	@Column(name="region")
	private String region;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="branch_id")
	private Branch branchName;
	@Column(name="dateofjoining")
	private String dateofjoining;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="designation_id")
	private Designation designationName;
	@Column(name="department")
	private String department;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subcompany_id")
	private CompanyProfile companyName;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dep_id")
	private Department depName;
	@Column(name="password")
	private String password;
	@Column(name="repassword")
	private String repassword;
	@Column(name="email")
	private String eamil;
	@Column(name="dob")
	private String dob;
	@Column(name="gender")
	private String gender;
	@Column(name="address")
	private String address;
	@Column(name="phone")
	private String phone;
	@Column(name="mobile")
	private String usermobile;
	@Column(name="deviceno")
	private String deviceno;
	@Column(name="empStatus")
	private Boolean empStatus;
	@Column(name="active")
	private Boolean active;
	
	public String getDateofjoining() {
		return dateofjoining;
	}
	public void setDateofjoining(String dateofjoining) {
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
		
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
	
	public Branch getBranchName() {
		return branchName;
	}
	public void setBranchName(Branch branchName) {
		this.branchName = branchName;
	}
	public CompanyProfile getCompanyName() {
		return companyName;
	}
	public void setCompanyName(CompanyProfile companyName) {
		this.companyName = companyName;
	}
	public Designation getDesignationName() {
		return designationName;
	}
	public void setDesignationName(Designation designationName) {
		this.designationName = designationName;
	}
	
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
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
	
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getDeviceno() {
		return deviceno;
	}
	public void setDeviceno(String deviceno) {
		this.deviceno = deviceno;
	}
	public Boolean getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(Boolean empStatus) {
		this.empStatus = empStatus;
	}
	public Department getDepName() {
		return depName;
	}
	public void setDepName(Department depName) {
		this.depName = depName;
	}
	
	
	
	
}
