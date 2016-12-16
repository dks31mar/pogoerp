package com.pogo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerSalesPo")
public class CustomerSalesPo 
{

	@Id
private int customerPoId;
private String custmerOderNo;
private String customerName;
private String quationNo;
private String customerAddress;
private  String cusOderdate;
private String cusReceivedate;
private double netTotal;
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
