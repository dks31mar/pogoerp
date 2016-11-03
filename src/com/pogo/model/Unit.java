package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="units")
public class Unit {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="unittypeid",columnDefinition="bigint(20)")
	private Integer unittypeid;
	@Column(name="unittype",columnDefinition="varchar(25)")
	private String unittype;
	public Integer getUnittypeid() {
		return unittypeid;
	}
	public void setUnittypeid(Integer unittypeid) {
		this.unittypeid = unittypeid;
	}
	public String getUnittype() {
		return unittype;
	}
	public void setUnittype(String unittype) {
		this.unittype = unittype;
	}
	
	
	
	
}
