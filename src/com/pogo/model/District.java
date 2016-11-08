package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="district")
public class District {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="districtId",columnDefinition="bigint(20)")
	private Integer districtId ;
	@Column(name="district")
	private String district ;
	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	
	

}
