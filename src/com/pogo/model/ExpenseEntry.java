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
	
	@Column(name = "creation_date")
	private String crdate;
	
	@Column(name = "date")
	private String date;
	
	@Column(name= "description")
	private String description;
	
	@Column(name="unit_expense")
	private String unit_expense;
	
	@Column(name = "total")
	private Integer total;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="organisation")
    private CustomerSales customersales ;
	
	public int getExpentryid() {
		return expentryid;
	}

	public void setExpentryid(int expentryid) {
		this.expentryid = expentryid;
	}

	public String getCrdate() {
		return crdate;
	}

	public void setCrdate(String crdate) {
		this.crdate = crdate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public CustomerSales getCustomersales() {
		return customersales;
	}

	public void setCustomersales(CustomerSales customersales) {
		this.customersales = customersales;
	}

	
	
	
	

}
