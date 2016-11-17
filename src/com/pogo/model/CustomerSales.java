package com.pogo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salescall")
public class CustomerSales 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customerid")
private Integer customerId;
	@Column(name="creation_date")
private Date creationDate;
	@Column(name="orderdate")
private Date orderdate;
	@Column(name="organisation")
private String organisation;
	@Column(name="orgShortName")
private String orgShortName;
	@Column(name="initiatedBy")
private String initiatedBy;
	@Column(name="acmanager")
private String acmanager;
	@Column(name="address")
private String address;
	@Column(name="state")
private String state;
	@Column(name="districtName")
private String districtName;
	@Column(name="sublocation")
private String sublocation;
	@Column(name="contactPerson")
private String contactPerson;
	@Column(name="telephoneNo")
private String telephoneNo;
	@Column(name="emailId")
private String emailId;
	@Column(name="status")
private String status;
	@Column(name="mobileNo")
private String mobileNo;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
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
	public String getInitiatedBy() {
		return initiatedBy;
	}
	public void setInitiatedBy(String initiatedBy) {
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getSublocation() {
		return sublocation;
	}
	public void setSublocation(String sublocation) {
		this.sublocation = sublocation;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

}
