package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="producthead")
public class ProductHead {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="productheadid",columnDefinition="bigint(15)")
	private Integer productheadid;
	@Column(name="productheadname",columnDefinition="varchar(50)")
	private String productheadname;
	public Integer getProductheadid() {
		return productheadid;
	}
	public void setProductheadid(Integer productheadid) {
		this.productheadid = productheadid;
	}
	public String getProductheadname() {
		return productheadname;
	}
	public void setProductheadname(String productheadname) {
		this.productheadname = productheadname;
	}
	
	
	
}
