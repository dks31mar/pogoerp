package com.pogo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoicetab")
public class InvoiceTab implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="invoicetabid")
	private Integer invoicetabid ;
	@Column(name="invno")
	private String invno ;
	@Column(name="porefno")
	private String porefno ;
	@Column(name="invdate")
	private String invdate ;
	public Integer getInvoicetabid() {
		return invoicetabid;
	}
	public void setInvoicetabid(Integer invoicetabid) {
		this.invoicetabid = invoicetabid;
	}
	public String getInvno() {
		return invno;
	}
	public void setInvno(String invno) {
		this.invno = invno;
	}
	public String getPorefno() {
		return porefno;
	}
	public void setPorefno(String porefno) {
		this.porefno = porefno;
	}
	public String getInvdate() {
		return invdate;
	}
	public void setInvdate(String invdate) {
		this.invdate = invdate;
	}
	
	
	
}
