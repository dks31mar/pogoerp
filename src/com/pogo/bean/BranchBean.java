package com.pogo.bean;

public class BranchBean 
{
private  Integer branchId;
private String branchname;
private String state;
private Integer designationId;
private String designationName;

public Integer getDesignationId() {
	return designationId;
}
public void setDesignationId(Integer designationId) {
	this.designationId = designationId;
}
public String getDesignationName() {
	return designationName;
}
public void setDesignationName(String designationName) {
	this.designationName = designationName;
}
public Integer getBranchId() {
	return branchId;
}
public void setBranchId(Integer branchId) {
	this.branchId = branchId;
}
public String getBranchname() {
	return branchname;
}
public void setBranchname(String branchname) {
	this.branchname = branchname;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}

}

