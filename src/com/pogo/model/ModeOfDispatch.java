package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="modeofdispatch")
public class ModeOfDispatch {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="modeofdispatchId" )
	private int modeofdispatchId;
	@Column(name="modeofdispatch")
	private String modeofdispatch;
	public int getModeofdispatchId() {
		return modeofdispatchId;
	}
	public void setModeofdispatchId(int modeofdispatchId) {
		this.modeofdispatchId = modeofdispatchId;
	}
	public String getModeofdispatch() {
		return modeofdispatch;
	}
	public void setModeofdispatch(String modeofdispatch) {
		this.modeofdispatch = modeofdispatch;
	}
	
	
	

}
