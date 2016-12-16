package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="poquotationitemdetail")
public class PoQuotationItemDetail
{
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="")
		private Integer poquotationitemdetailid;
		@Column(name="qosrno")
		private String qosrno;
		@Column(name="partno")
		private String partno;
		@Column(name="utprice")
		private double utprice;
		@Column(name="disc")
		private double disc;
		@Column(name="netprice")
		private double netprice;
		@Column(name="qty")
		private Integer qty;
		@Column(name="total")
		private double total;
		@Column(name="delivery")
		private String delivery;
		@ManyToOne
		@JoinColumn(name="qorefno")
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