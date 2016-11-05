package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productsubhead")
public class ProductSubHead {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="productsubheadid" ,columnDefinition="bigint(15)")
	private Integer productsubheadid;
	
	@Column(name="productsubheadname",columnDefinition="varchar(50)")
	private String productsubheadname;
	
	@Column(name="productheadid",columnDefinition="bigint(15)")
	private Integer productheadid;
	public Integer getProductsubheadid() {
		return productsubheadid;
	}
	public void setProductsubheadid(Integer productsubheadid) {
		this.productsubheadid = productsubheadid;
	}
	public String getProductsubheadname() {
		return productsubheadname;
	}
	public void setProductsubheadname(String productsubheadname) {
		this.productsubheadname = productsubheadname;
	}
	public Integer getProductheadid() {
		return productheadid;
	}
	public void setProductheadid(Integer productheadid) {
		this.productheadid = productheadid;
	}
	
	

}
