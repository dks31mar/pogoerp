package com.pogo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="country")
public class Country implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "countryId")
	private Integer countryId;
	@Column(name = "country")
	private String country;
	 /*@OneToMany(fetch = FetchType.LAZY)
	 @JoinColumn(name ="stateId")
	private State state;
	
	
	 
	
	 
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}*/

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	/*public Country(){
		  
	 }
	public Country(Integer countryId,String country , State state){
		super();
		  this.countryId = countryId;
		  this.country = country;
		  this.state = state;
	 }*/

}
