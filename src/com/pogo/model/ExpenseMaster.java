package com.pogo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expensemaster")
public class ExpenseMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int expensemasterId;
	private String expensehead;
	private String expensetype;
	private String unit;
	private String limit;
	public int getExpensemasterId() {
		return expensemasterId;
	}
	public void setExpensemasterId(int expensemasterId) {
		this.expensemasterId = expensemasterId;
	}
	public String getExpensehead() {
		return expensehead;
	}
	public void setExpensehead(String expensehead) {
		this.expensehead = expensehead;
	}
	public String getExpensetype() {
		return expensetype;
	}
	public void setExpensetype(String expensetype) {
		this.expensetype = expensetype;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	

}
