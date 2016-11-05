package com.pogo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currency")

public class Currency {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="currencyid",columnDefinition="bigint(20)")
	private Integer currencyid;
	@Column(name="currencysymbol",columnDefinition="varchar(5)")
	private String currencysymbol; 
	@Column(name="currencyname" ,columnDefinition="varchar(25)")
	private String currencyname;
	@Column(name="currencytype",columnDefinition="varchar(2)")
	private String currencytype;
	
	
	
	public Integer getCurrencyid() {
		return currencyid;
	}
	public void setCurrencyid(Integer currencyid) {
		this.currencyid = currencyid;
	}
	public String getCurrencysymbol() {
		return currencysymbol;
	}
	public void setCurrencysymbol(String currencysymbol) {
		this.currencysymbol = currencysymbol;
	}
	public String getCurrencyname() {
		return currencyname;
	}
	public void setCurrencyname(String currencyname) {
		this.currencyname = currencyname;
	}
	public String getCurrencytype() {
		return currencytype;
	}
	public void setCurrencytype(String currencytype) {
		this.currencytype = currencytype;
	}
	
	
	
	
	
}
