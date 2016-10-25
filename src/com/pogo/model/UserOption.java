package com.pogo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "useroption")
public class UserOption implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "optionid",length=10)
	private String optionId;
	@Column(name = "empid",length=11)
	private String empId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="optionId",referencedColumnName="optionId")
	private CompanyPogoOptions cpogooption;
	
	
	
	public CompanyPogoOptions getCpogooption() {
		return cpogooption;
	}
	public void setCpogooption(CompanyPogoOptions cpogooption) {
		this.cpogooption = cpogooption;
	}
	public String getOptionId() {
		return optionId;
	}
	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
