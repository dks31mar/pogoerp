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
@Table(name="zonestate")
public class StateZone 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="stateid")
private Integer stateId;
	@Column(name="statename")
private String stateName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="zonesid")
	private Zones zones;
	
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Zones getZones() {
		return zones;
	}
	public void setZones(Zones zones) {
		this.zones = zones;
	}
	
}

