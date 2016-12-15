package com.pogo.bean;

import com.pogo.model.PoQuotationDetail;

public class PoQuotationItemDetailBean
{
	  private Integer poquotationitemdetailid;
	  private String qorefno;
	  private String qosrno;
	  private String partno;
	  private double utprice;
	  private double disc;
	  private double netprice;
	  private Integer qty;
	  private double total;
	  private String delivery;
	  private PoQuotationDetail poquotationdetail;
	  
	  
	  
	  public PoQuotationDetail getPoquotationdetail() {
		return poquotationdetail;
	}
	public void setPoquotationdetail(PoQuotationDetail poquotationdetail) {
		this.poquotationdetail = poquotationdetail;
	}
	public Integer getPoquotationitemdetailid() {
			return poquotationitemdetailid;
		}
		public void setPoquotationitemdetailid(Integer poquotationitemdetailid) {
			this.poquotationitemdetailid = poquotationitemdetailid;
		}
		public String getQorefno() {
			return qorefno;
		}
		public void setQorefno(String qorefno) {
			this.qorefno = qorefno;
		}
		public String getQosrno() {
			return qosrno;
		}
		public void setQosrno(String qosrno) {
			this.qosrno = qosrno;
		}
		public String getPartno() {
			return partno;
		}
		public void setPartno(String partno) {
			this.partno = partno;
		}
		public double getUtprice() {
			return utprice;
		}
		public void setUtprice(double utprice) {
			this.utprice = utprice;
		}
		public double getDisc() {
			return disc;
		}
		public void setDisc(double disc) {
			this.disc = disc;
		}
		public double getNetprice() {
			return netprice;
		}
		public void setNetprice(double netprice) {
			this.netprice = netprice;
		}
		public Integer getQty() {
			return qty;
		}
		public void setQty(Integer qty) {
			this.qty = qty;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
		public String getDelivery() {
			return delivery;
		}
		public void setDelivery(String delivery) {
			this.delivery = delivery;
		}
		
	  
	 
	  
	 
	}