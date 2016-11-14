package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="competitor")
public class CompetitiorsProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="compid",columnDefinition="Bigint(12)")
	private Integer compid;
	
	@Column(name="compname",columnDefinition="int(11)")
	private String compname;
	
	@Column(name="compaddress",columnDefinition="int(11)")
	private String compaddress;
     
	@Column(name="compphone",columnDefinition="varchar(100)")
	private String compphone;
	
	@Column(name="compfax",columnDefinition="varchar(100)")
	private String compfax;
	
	@Column(name="compemail1",columnDefinition="varchar(25)")
	private String compemail1;
	
	@Column(name="compcontactperson",columnDefinition="varchar(25)")
    private String compcontactperson;
    
	@Column(name="compcontactdesig",columnDefinition="varchar(50)")
    private String compcontactdesig;
	
	@Column(name="compemail2",columnDefinition="varchar(1)")
    private String compemail2;

	@Column(name="compphone2",columnDefinition="varchar(1)")
    private String compphone2;

	public Integer getCompid() {
		return compid;
	}

	public void setCompid(Integer compid) {
		this.compid = compid;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	public String getCompaddress() {
		return compaddress;
	}

	public void setCompaddress(String compaddress) {
		this.compaddress = compaddress;
	}

	public String getCompphone() {
		return compphone;
	}

	public void setCompphone(String compphone) {
		this.compphone = compphone;
	}

	public String getCompfax() {
		return compfax;
	}

	public void setCompfax(String compfax) {
		this.compfax = compfax;
	}

	public String getCompemail1() {
		return compemail1;
	}

	public void setCompemail1(String compemail) {
		this.compemail1 = compemail;
	}

	public String getCompcontactperson() {
		return compcontactperson;
	}

	public void setCompcontactperson(String compcontactperson) {
		this.compcontactperson = compcontactperson;
	}

	public String getCompcontactdesig() {
		return compcontactdesig;
	}

	public void setCompcontactdesig(String compcontactdesig) {
		this.compcontactdesig = compcontactdesig;
	}

	public String getCompemail2() {
		return compemail2;
	}

	public void setCompemail2(String compemail2) {
		this.compemail2 = compemail2;
	}

	public String getCompphone2() {
		return compphone2;
	}

	public void setCompphone2(String compphone2) {
		this.compphone2 = compphone2;
	}
	
	
}
