package com.pogo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="porefentryitemdetail")
public class PoRefEntryItemDetail implements Serializable {

	
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="porefentryitemdetailid",columnDefinition="bigInt(20)" )
	private Integer porefentryitemdetailid;
	

	@Column(name="porefno",columnDefinition="varchar(50)")
	private String porefno;
	
	@Column(name="particular",columnDefinition="varchar(50)")
	private String particular;
	@Column(name="tpinjpy",columnDefinition="varchar(50)")
	private String tpinjpy;
	@Column(name="qty",columnDefinition="int(11)")
	private int qty;
	@Column(name="totaljpy",columnDefinition="int(11)")
	private int totaljpy;
	@Column(name="totalinr",columnDefinition="int(11)")
	private int totalinr;
	@Column(name="ackdate",columnDefinition="varchar(50)")
	private String ackdate;  
	@Column(name="remarks",columnDefinition="varchar(50)")
	private String remarks;
	@Column(name="posrno",columnDefinition="int(11)")
	private int posrno;
	@Column(name="invno",columnDefinition="varchar(50)")
	private String invno;
	@Column(name="invdate",columnDefinition="varchar(50)")
	private String invdate;
	@Column(name="customerporefe",columnDefinition="varchar(50)")
	private String customerporefe;
	@Column(name="productdescription",columnDefinition="varchar(50)")
	private String productdescription;
	

	public Integer getPorefentryitemdetailid() {
		return porefentryitemdetailid;
	}
	public void setPorefentryitemdetailid(Integer porefentryitemdetailid) {
		this.porefentryitemdetailid = porefentryitemdetailid;
	}
	public String getPorefno() {
		return porefno;
	}
	public void setPorefno(String porefno) {
		this.porefno = porefno;
	}
	public String getParticular() {
		return particular;
	}
	public void setParticular(String particular) {
		this.particular = particular;
	}
	public String getTpinjpy() {
		return tpinjpy;
	}
	public void setTpinjpy(String tpinjpy) {
		this.tpinjpy = tpinjpy;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getTotaljpy() {
		return totaljpy;
	}
	public void setTotaljpy(int totaljpy) {
		this.totaljpy = totaljpy;
	}
	public int getTotalinr() {
		return totalinr;
	}
	public void setTotalinr(int totalinr) {
		this.totalinr = totalinr;
	}
	public String getAckdate() {
		return ackdate;
	}
	public void setAckdate(String ackdate) {
		this.ackdate = ackdate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getPosrno() {
		return posrno;
	}
	public void setPosrno(int posrno) {
		this.posrno = posrno;
	}
	public String getInvno() {
		return invno;
	}
	public void setInvno(String invno) {
		this.invno = invno;
	}
	public String getInvdate() {
		return invdate;
	}
	public void setInvdate(String invdate) {
		this.invdate = invdate;
	}
	public String getCustomerporefe() {
		return customerporefe;
	}
	public void setCustomerporefe(String customerporefe) {
		this.customerporefe = customerporefe;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
 	
 	
}
