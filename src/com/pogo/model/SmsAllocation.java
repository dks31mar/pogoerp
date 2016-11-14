package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="smsallocation")
public class SmsAllocation {

	@Id
	@Column(name="empid",columnDefinition="int(11)")
	private Integer	empid;
	@Column(name="isunlimited",columnDefinition="char(1) DEFAULT 'Y'")
	private String isunlimited;
	@Column(name="noofsmsallocated",columnDefinition="int(11)")
	private Integer	noofsmsallocated;
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getIsunlimited() {
		return isunlimited;
	}
	public void setIsunlimited(String isunlimited) {
		this.isunlimited = isunlimited;
	}
	public Integer getNoofsmsallocated() {
		return noofsmsallocated;
	}
	public void setNoofsmsallocated(Integer noofsmsallocated) {
		this.noofsmsallocated = noofsmsallocated;
	}
	
	
	
}
