package com.pogo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="invoicedetail")
public class InvoiceDetail implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="invoicedetailid")
	private Integer invoicedetailid ;
	@Column(name="invno")
	private	String invno ;
	@Column(name="particular")
	private String	particular ;
	@Column(name="posrno")
	private Integer posrno ;
	@Column(name="receiveqty")
	private double receiveqty ;
	@Column(name="totalqty")
	private double totalqty ;
	
	
	public Integer getInvoicedetailid() {
		return invoicedetailid;
	}
	public void setInvoicedetailid(Integer invoicedetailid) {
		this.invoicedetailid = invoicedetailid;
	}
	public String getInvno() {
		return invno;
	}
	public void setInvno(String invno) {
		this.invno = invno;
	}
	public String getParticular() {
		return particular;
	}
	public void setParticular(String particular) {
		this.particular = particular;
	}
	public Integer getPosrno() {
		return posrno;
	}
	public void setPosrno(Integer posrno) {
		this.posrno = posrno;
	}
	public double getReceiveqty() {
		return receiveqty;
	}
	public void setReceiveqty(double receiveqty) {
		this.receiveqty = receiveqty;
	}
	public double getTotalqty() {
		return totalqty;
	}
	public void setTotalqty(double totalqty) {
		this.totalqty = totalqty;
	}
	
	
	
}
