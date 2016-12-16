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
	
	
	@Column(name="rates",columnDefinition="bigint(11)")
	private double rates;
	
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


	public double getRates() {
		return rates;
	}


	public void setRates(double rates) {
		this.rates = rates;
	}


	
	
	
}
