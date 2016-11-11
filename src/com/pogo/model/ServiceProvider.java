package com.pogo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="transportationservicedetail")
public class ServiceProvider implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="transportationserviceid",columnDefinition="int(11)")
	private Integer transportationserviceid;
	@Column(name="servicename",columnDefinition="varchar(100)")
	private String servicename;
	@Column(name="contactperson",columnDefinition="varchar(100)")
	private String contactperson;
	@Column(name="mobile",columnDefinition="varchar(50)")
	private String mobile;
	@Column(name="phone",columnDefinition="varchar(50)")
	private String phone;
	@Column(name="serviceaddress",columnDefinition="varchar(150)")
	private String serviceaddress;
	@Column(name="email",columnDefinition="varchar(100)")
	private String email;
	@Column(name="transportationmodeid",columnDefinition="varchar(50)")
	private String transportationmodeid;
	public Integer getTransportationserviceid() {
		return transportationserviceid;
	}
	public void setTransportationserviceid(Integer transportationserviceid) {
		this.transportationserviceid = transportationserviceid;
	}
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public String getContactperson() {
		return contactperson;
	}
	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getServiceaddress() {
		return serviceaddress;
	}
	public void setServiceaddress(String serviceaddress) {
		this.serviceaddress = serviceaddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTransportationmodeid() {
		return transportationmodeid;
	}
	public void setTransportationmodeid(String transportationmodeid) {
		this.transportationmodeid = transportationmodeid;
	}
	
}
