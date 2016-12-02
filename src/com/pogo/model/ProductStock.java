package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productstock")
public class ProductStock {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="productstockid")
		private Integer productstockid ;
		@Column(name="productid")
		private Integer productid ;
		@Column(name="productname")
		private String productname ;
		@Column(name="invno")
		private String invno ;
		@Column(name="serialno")
		private String serialno ;
		@Column(name="lotno")
		private String lotno ;
		public Integer getProductstockid() {
			return productstockid;
		}
		public void setProductstockid(Integer productstockid) {
			this.productstockid = productstockid;
		}
		public Integer getProductid() {
			return productid;
		}
		public void setProductid(Integer productid) {
			this.productid = productid;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public String getInvno() {
			return invno;
		}
		public void setInvno(String invno) {
			this.invno = invno;
		}
		public String getSerialno() {
			return serialno;
		}
		public void setSerialno(String serialno) {
			this.serialno = serialno;
		}
		public String getLotno() {
			return lotno;
		}
		public void setLotno(String lotno) {
			this.lotno = lotno;
		}
		
		
		
}
