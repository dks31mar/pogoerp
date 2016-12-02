package com.pogo.model;

import java.io.Serializable;

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
@Table(name="invoicedetail")
public class InvoiceDetail implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="invoicedetailid")
	private Integer invoicedetailid ;
	
	@Column(name="porefno")
	private String	porefno ;
	@Column(name="particular")
	private String	particular ;
	@Column(name="posrno")
	private Integer posrno ;
	@Column(name="receiveqty")
	private double receiveqty ;
	@Column(name="totalqty")
	private double totalqty ;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="invno")
	private InvoiceTab invoicetab;
	
	
	public String getPorefno() {
		return porefno;
	}
	public void setPorefno(String porefno) {
		this.porefno = porefno;
	}
	public Integer getInvoicedetailid() {
		return invoicedetailid;
	}
	public void setInvoicedetailid(Integer invoicedetailid) {
		this.invoicedetailid = invoicedetailid;
	}
	
	public InvoiceTab getInvoicetab() {
		return invoicetab;
	}
	public void setInvoicetab(InvoiceTab invoicetab) {
		this.invoicetab = invoicetab;
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
