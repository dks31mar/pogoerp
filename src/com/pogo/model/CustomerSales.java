package com.pogo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="customersalescall")
public class CustomerSales 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customerid")
private Integer customerId;
	@Column(name="creation_date")
private String creationDate;
	@Column(name="orderdate")
private String orderdate;
	@Column(name="organisation")
private String organisation;
	@Column(name="orgShort_name")
private String orgShortName;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="emp_id")
private UserEmployee initiatedBy;
	@Column(name="acmanager")
private String acmanager;
	@Column(name="address")
private String address;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state_id")
private State state;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="district_id")
private District districtName;
	
	@Column(name="contact_person")
private String contactPerson;
	@Column(name="telephoneNo")
private String telephoneNo;
	@Column(name="email_id")
private String emailId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customerLevel_id")
private CustomerLevels status;
	@Column(name="mobile_no")
private String mobileNo;
@Column(name="category")	
private String  category;
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="country_id")
private Country country;
@ManyToOne(fetch=FetchType.EAGER,optional=true)
@JoinColumn(name="location_id")
private Location location;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public String getOrgShortName() {
		return orgShortName;
	}
	public void setOrgShortName(String orgShortName) {
		this.orgShortName = orgShortName;
	}
	
	public UserEmployee getInitiatedBy() {
		return initiatedBy;
	}
	public void setInitiatedBy(UserEmployee initiatedBy) {
		this.initiatedBy = initiatedBy;
	}
	public String getAcmanager() {
		return acmanager;
	}
	public void setAcmanager(String acmanager) {
		this.acmanager = acmanager;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public District getDistrictName() {
		return districtName;
	}
	public void setDistrictName(District districtName) {
		this.districtName = districtName;
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public CustomerLevels getStatus() {
		return status;
	}
	public void setStatus(CustomerLevels status) {
		this.status = status;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	

}
