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
@Table(name="Companypogooptions")
public class CompanyPogoOptions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name="companyid",nullable=false,length=50)
	private String companyId;
	@Column(name="optionid",nullable=false,length=10)
	private String optionId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="optionId",referencedColumnName="optionId")
	private PogoMenuOptions pMenuOption;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getOptionId() {
		return optionId;
	}
	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	public PogoMenuOptions getpMenuOption() {
		return pMenuOption;
	}
	public void setpMenuOption(PogoMenuOptions pMenuOption) {
		this.pMenuOption = pMenuOption;
	}
	
	
	
}
