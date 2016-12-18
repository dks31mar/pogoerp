package com.pogo.model;

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
@Table( name = "expenseentry")
public class ExpenseEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int expentryid;
	
	@Column(name="followupid")
	private Integer followupid;
	
	@Column(name = "creation_date")
	private String crdate;
	
	@Column(name = "orgnisationid")
	private Integer orgnisationid;
	
	
	@Column(name = "orgnisation")
	private String orgnisation;
	
	
	
	@Column(name = "grandtotal")
	private double grandtotal;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "userid")
	private UserEmployee  useremp;
	public UserEmployee getUseremp() {
		return useremp;
	}

	public void setUseremp(UserEmployee useremp) {
		this.useremp = useremp;
	}
	
	public Integer getFollowupid() {
		return followupid;
	}

	public void setFollowupid(Integer followupid) {
		this.followupid = followupid;
	}

	public Integer getOrgnisationid() {
		return orgnisationid;
	}

	public void setOrgnisationid(Integer orgnisationid) {
		this.orgnisationid = orgnisationid;
	}

	
	public int getExpentryid() {
		return expentryid;
	}

	public void setExpentryid(int expentryid) {
		this.expentryid = expentryid;
	}

	public String getOrgnisation() {
		return orgnisation;
	}

	public void setOrgnisation(String orgnisation) {
		this.orgnisation = orgnisation;
	}

	public String getCrdate() {
		return crdate;
	}

	public void setCrdate(String crdate) {
		this.crdate = crdate;
	}

	public double getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}
	
	/*
	
	
	
	@Column(name = "expname")
	private String expname;
	
	@Column(name= "description")
	private String description;
	
	@Column(name = "rates")
	private double rates;
	
	@Column(name="qty")
	private Integer qty;
	
	
	@Column(name = "total")
	private double total;
	*/
	
	
	
	/*

	public String getExpname() {
		return expname;
	}

	public void setExpname(String expname) {
		this.expname = expname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRates() {
		return rates;
	}

	public void setRates(double rates) {
		this.rates = rates;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
*/
	

	
	

	

	

	

	
	
	
	

}
