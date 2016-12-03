package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="suppliermaster")
public class SupplierMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="suppliermasterid")
	private Integer suppliermasterid;
	@Column(name="name")
	private String name ;
	@Column(name="address")
	private String address;
	@Column(name="currency")
	private String currency;
	
	public Integer getSuppliermasterid() {
		return suppliermasterid;
	}
	public void setSuppliermasterid(Integer suppliermasterid) {
		this.suppliermasterid = suppliermasterid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
}
