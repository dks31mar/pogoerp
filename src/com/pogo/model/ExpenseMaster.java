package com.pogo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expensemaster")
public class ExpenseMaster implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="expensemasterId",columnDefinition="bigint(11)")
	private Integer expensemasterId;
	@Column(name="expensehead",columnDefinition="varchar(255)")
	private String expensehead;
	@Column(name="expensetype",columnDefinition="varchar(255)")
	private String expensetype;
	@Column(name="unit",columnDefinition="bigint(11)")
	private Integer unit;
	@Column(name="exlimit",columnDefinition="bigint(11)")
	private Integer exlimit;
	public Integer getExpensemasterId() {
		return expensemasterId;
	}
	public void setExpensemasterId(Integer expensemasterId) {
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
	public Integer getUnit() {
		return unit;
	}
	public void setUnit(Integer unit) {
		this.unit = unit;
	}
	public Integer getExlimit() {
		return exlimit;
	}
	public void setExlimit(Integer exlimit) {
		this.exlimit = exlimit;
	}
	
	
	
}
