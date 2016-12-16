package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer_Sales_PoDetails")
public class CustomerSalesPoDetails 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CustomerSalesPo_Id")
	private int CustomerSalesPoId;
	@Column(name="partno")
	private String partno;
	@Column(name="unit_price")
	private double unitPrice;
	@Column(name="discount_amnt")
	private double discountAmnt;
	@Column(name="order_no")
	private String orderno;
	@Column(name="net_price")
	private double netprice;
	@Column(name="qnty")
	private int qnty;
	@Column(name="total_amount")
	private double totalAmount;
	@Column(name="descriptions")
	private String descriptions;
	@Column(name="partno_details")
	private String partnoDetails;
	@Column(name="delivery")
	private String delivery;
	@Column(name="product_type")
	private String productType;
	public int getCustomerSalesPoId() {
		return CustomerSalesPoId;
	}
	public void setCustomerSalesPoId(int customerSalesPoId) {
		CustomerSalesPoId = customerSalesPoId;
	}
	public String getPartno() {
		return partno;
	}
	public void setPartno(String partno) {
		this.partno = partno;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getDiscountAmnt() {
		return discountAmnt;
	}
	public void setDiscountAmnt(double discountAmnt) {
		this.discountAmnt = discountAmnt;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public double getNetprice() {
		return netprice;
	}
	public void setNetprice(double netprice) {
		this.netprice = netprice;
	}
	public int getQnty() {
		return qnty;
	}
	public void setQnty(int qnty) {
		this.qnty = qnty;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public String getPartnoDetails() {
		return partnoDetails;
	}
	public void setPartnoDetails(String partnoDetails) {
		this.partnoDetails = partnoDetails;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
}
