package com.pogo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addemaillist")
public class AddEmailList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emaillistid")
	private Integer emaillistid;
	@Column(name="emaillist", nullable = false)
	private String emaillist;
	@Column(name = "date" , columnDefinition = "date default sysdate")
	private Date creationdate;
	@Column(name="empid" , nullable = false)
	private Integer empid;
	@Column(name="status" , nullable = false , columnDefinition = "char default 'N'")
	private String status;
	@Column(name = "name")
	private String name;
	
	public Date getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getEmaillistid() {
		return emaillistid;
	}
	public void setEmaillistid(Integer emaillistid) {
		this.emaillistid = emaillistid;
	}
	public String getEmaillist() {
		return emaillist;
	}
	public void setEmaillist(String emaillist) {
		this.emaillist = emaillist;
	}
	
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
