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
import javax.persistence.ManyToOne;
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
	
	
	
	
	
	/*
	 * country has many states 
	 * one        to     many
	 * 
	 * 
	 * define a collection where 
	 * we would add values of state
	 * */
/*@OneToMany(mappedBy="country" , cascade = CascadeType.ALL)
	private Set<State> state;
	
	public Set<State> getState() {
	return state;
       }

public void setState(Set<State> state) {
	this.state = state;
        }
*/
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


}
