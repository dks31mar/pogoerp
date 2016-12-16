package com.pogo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="customerSalesPo")
public class CustomerSalesPo implements Serializable
{

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int customerPoId;
@Column(name="custmerOderNo")
private String custmerOderNo;
@Column(name="customer_name")
private String customerName;
@Column(name="quation_no")
private String quationNo;
@Column(name="customer_address")
private String customerAddress;
@Column(name="cusOderdate")
private  String cusOderdate;
@Column(name="cusReceivedate")
private String cusReceivedate;
@Column(name="net_total")
private double netTotal;
@Column(name="taxes")
private double taxes;
public int getCustomerPoId() {
	return customerPoId;
}
public void setCustomerPoId(int customerPoId) {
	this.customerPoId = customerPoId;
}
public String getCustmerOderNo() {
	return custmerOderNo;
}
public void setCustmerOderNo(String custmerOderNo) {
	this.custmerOderNo = custmerOderNo;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getQuationNo() {
	return quationNo;
}
public void setQuationNo(String quationNo) {
	this.quationNo = quationNo;
}
public String getCustomerAddress() {
	return customerAddress;
}
public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
}
public String getCusOderdate() {
	return cusOderdate;
}
public void setCusOderdate(String cusOderdate) {
	this.cusOderdate = cusOderdate;
}
public String getCusReceivedate() {
	return cusReceivedate;
}
public void setCusReceivedate(String cusReceivedate) {
	this.cusReceivedate = cusReceivedate;
}
public double getNetTotal() {
	return netTotal;
}
public void setNetTotal(double netTotal) {
	this.netTotal = netTotal;
}
public double getTaxes() {
	return taxes;
}
public void setTaxes(double taxes) {
	this.taxes = taxes;
}

}
