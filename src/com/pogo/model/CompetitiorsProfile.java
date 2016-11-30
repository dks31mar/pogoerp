package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="competitorProfile")
public class CompetitiorsProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="compid",columnDefinition="Bigint(12)")
	private Integer compid;
	
	@Column(name="name",columnDefinition="varchar(11)")
	private String name;
	
	@Column(name="contactperson",columnDefinition="varchar(11)")
	private String contactperson;
     
	@Column(name="address",columnDefinition="varchar(100)")
	private String address;
	
	@Column(name="designation",columnDefinition="varchar(100)")
	private String designation;
	
	@Column(name="mobileno",columnDefinition="int(25)")
	private String mobileno;
	
	@Column(name="phoneno",columnDefinition="int(25)")
    private String phoneno;
    
	@Column(name="emailid",columnDefinition="varchar(50)")
    private String emailid;
	
	@Column(name="productbrand",columnDefinition="varchar(10)")
    private String productbrand;

	@Column(name="productname",columnDefinition="varchar(20)")
    private String productname;
	
	@Column(name="warrentyperiod",columnDefinition="varchar(10)")
	private String warrentyperiod;
	
	@Column(name="price", columnDefinition="int(10)")
	private String price;
	
	@Column(name="no_of_freeamc" ,columnDefinition="varchar(10)")
	private String nooffreeamc;
	
	@Column(name="amcrate")
    private String amcrate;

	public Integer getCompid() {
		return compid;
	}

	public void setCompid(Integer compid) {
		this.compid = compid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactperson() {
		return contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getProductbrand() {
		return productbrand;
	}

	public void setProductbrand(String productbrand) {
		this.productbrand = productbrand;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getWarrentyperiod() {
		return warrentyperiod;
	}

	public void setWarrentyperiod(String warrentyperiod) {
		this.warrentyperiod = warrentyperiod;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNooffreeamc() {
		return nooffreeamc;
	}

	public void setNooffreeamc(String nooffreeamc) {
		this.nooffreeamc = nooffreeamc;
	}

	public String getAmcrate() {
		return amcrate;
	}

	public void setAmcrate(String amcrate) {
		this.amcrate = amcrate;
	}

	

}
