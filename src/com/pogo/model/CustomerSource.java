package com.pogo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customersource")
public class CustomerSource implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customersourceId",columnDefinition="int(11)")
	private int customersourceId;
	@Column(name="source",columnDefinition="varchar(100)")
	private String source;
	public int getCustomersourceId() {
		return customersourceId;
	}
	public void setCustomersourceId(int customersourceId) {
		this.customersourceId = customersourceId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
	

}
