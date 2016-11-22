package com.pogo.bean;

import java.util.Date;
public class AddEmailListBean {

	private Integer emaillistid;
	private String emaillist;
	private Date creationdate;
	private Integer empid;
	private String status;
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
