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
@Table(name="state")
public class State {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="stateId",columnDefinition="bigint(20)")
	private Integer stateId ;
	
	@Column(name="state")
	private String state ;
	
	/*
	 * many state in one country
	 * many		to		   one
	 * 
	 * */
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="countryId")
	private Country country;
	
	//private Set<District> district;
	
	
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
