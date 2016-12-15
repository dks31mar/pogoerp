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
	
	@Column(name = "orgnisation")
	private String orgnisation;
	
	@Column(name = "creation_date")
	private String crdate;
	
	@Column(name = "orgAddress")
	private String orgAddress;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "expname")
	private String expname;
	
	@Column(name= "description")
	private String description;
	
	@Column(name = "unit")
	private Integer unit;
	
	@Column(name="unit_expense")
	private String unit_expense;
	
	
	@Column(name = "total")
	private Integer total;
	
	@Column(name = "grandtotal")
	private Integer grandtotal;
	
	@Column(name = "managerid")
	private Integer managerid;
	
	public Integer getManagerid() {
		return managerid;
	}

	public void setManagerid(Integer managerid) {
		this.managerid = managerid;
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

	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

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

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public String getUnit_expense() {
		return unit_expense;
	}

	public void setUnit_expense(String unit_expense) {
		this.unit_expense = unit_expense;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(Integer grandtotal) {
		this.grandtotal = grandtotal;
	}

	
	
	
	

	

	
	
	
	

}
