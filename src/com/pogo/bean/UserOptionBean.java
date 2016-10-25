package com.pogo.bean;

import java.io.Serializable;

public class UserOptionBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String optionId;

	private String empId;
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
