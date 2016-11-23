package com.pogo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stateId")
	private StateZone stateNames;

	public StateZone getStateNames() {
		return stateNames;
	}
	public void setStateNames(StateZone stateNames) {
		this.stateNames = stateNames;
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
	


	
}
