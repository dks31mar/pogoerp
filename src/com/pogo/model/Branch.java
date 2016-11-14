package com.pogo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="branch")
public class Branch 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="branchid")
private  Integer branchId;
	@Column(name="branchname")
private String branchname;
	@Column(name="stateid")
	private String state;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="designation_id")
    private Designation designation;

	
	
	public Designation getDesignation() {
		return designation;
	}
	public void setDesignation(Designation designation) {
		this.designation = designation;
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
