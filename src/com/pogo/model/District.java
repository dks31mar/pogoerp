package com.pogo.model;


import java.util.Set;

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
@Table(name="district")
public class District {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="districtId",columnDefinition="bigint(20)")
	private Integer districtId ;
	@Column(name="district")
	private String district ;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="stateId")
	private State state;
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country; 
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	/*@OneToMany(mappedBy="district" , cascade = CascadeType.ALL)
    private Set<Location> location;

	public Set<Location> getLocation() {
		return location;
	}

	public void setLocation(Set<Location> location) {
		this.location = location;
	}
*/
	

	

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
