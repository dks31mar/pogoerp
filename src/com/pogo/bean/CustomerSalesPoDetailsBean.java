package com.pogo.bean;
public class CustomerSalesPoDetailsBean 
{
	private int CustomerSalesPoId;
	private String partno;
	private double unitPrice;
	private double discountAmnt;
	private String productType;
	private String delivery;
	private String partnoDetails;
	private String descriptions;
	private double totalAmount;
	private int qnty;
	private double netprice;
	private String orderno;
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
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getPartnoDetails() {
		return partnoDetails;
	}
	public void setPartnoDetails(String partnoDetails) {
		this.partnoDetails = partnoDetails;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getQnty() {
		return qnty;
	}
	public void setQnty(int qnty) {
		this.qnty = qnty;
	}
	public double getNetprice() {
		return netprice;
	}
	public void setNetprice(double netprice) {
		this.netprice = netprice;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

}
