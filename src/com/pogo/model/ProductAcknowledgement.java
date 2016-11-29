package com.pogo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productacknowledgement")
public class ProductAcknowledgement implements Serializable{
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="productacknowledgementid")
	private Integer productacknowledgementid   ;
	@Column(name="porefno")
    private String porefno  ;
	@Column(name="posrno")
    private String posrno ;
	@Column(name="particular")
    private String particular  ;
	@Column(name="receiveqty")
    private double receiveqty ;
	@Column(name="pendingqty")
    private double pendingqty ;
	@Column(name="expdate")
    private String expdate ;
	
	
	public Integer getProductacknowledgementid() {
		return productacknowledgementid;
	}
	public void setProductacknowledgementid(Integer productacknowledgementid) {
		this.productacknowledgementid = productacknowledgementid;
	}
	public String getPorefno() {
		return porefno;
	}
	public void setPorefno(String porefno) {
		this.porefno = porefno;
	}
	public String getPosrno() {
		return posrno;
	}
	public void setPosrno(String posrno) {
		this.posrno = posrno;
	}
	public String getParticular() {
		return particular;
	}
	public void setParticular(String particular) {
		this.particular = particular;
	}
	public double getReceiveqty() {
		return receiveqty;
	}
	public void setReceiveqty(double receiveqty) {
		this.receiveqty = receiveqty;
	}
	public double getPendingqty() {
		return pendingqty;
	}
	public void setPendingqty(double pendingqty) {
		this.pendingqty = pendingqty;
	}
	public String getExpdate() {
		return expdate;
	}
	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
}
