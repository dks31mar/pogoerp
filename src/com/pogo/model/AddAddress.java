package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addaddress")


public class AddAddress {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO )
	  @Column(name = "id")
		private int id ;
	  @Column(name = "name")
		private String name;
	  @Column(name = "email")
		private String email;
	  @Column(name = "fax")
		private int fax;
  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public int getFax() {
		return fax;
	}
	public void setFax(int fax) {
		this.fax = fax;
	}

	
}
