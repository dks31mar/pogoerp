package com.pogo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="porefsupplierdetail")
public class PorefSupplierDetail implements Serializable{

	@Column(name="",columnDefinition="bigInt(20)",nullable=false)
	private String porefsupplierdetailid; 
	@Id
 	@Column(name="porefno",columnDefinition="varchar(50)",nullable=false)
    private String porefno; 

 	@Column(name="",columnDefinition="varchar(50)")
	private String porefdate; 

 	@Column(name="",columnDefinition="varchar(50)")
    private String principalname; 

 	@Column(name="",columnDefinition="varchar(250)")
    private String specification; 

 	@Column(name="",columnDefinition="int(11)")
	private Integer profileid; 

 	@Column(name="",columnDefinition="int(11)")
    private Integer roe; 

 	@Column(name="",columnDefinition="varchar(1000)")
    private String address; 

 	@Column(name="",columnDefinition="int(11)")
    private Integer total;

	public String getPorefsupplierdetailid() {
		return porefsupplierdetailid;
	}

	public void setPorefsupplierdetailid(String porefsupplierdetailid) {
		this.porefsupplierdetailid = porefsupplierdetailid;
	}

	public String getPorefno() {
		return porefno;
	}

	public void setPorefno(String porefno) {
		this.porefno = porefno;
	}

	public String getPorefdate() {
		return porefdate;
	}

	public void setPorefdate(String porefdate) {
		this.porefdate = porefdate;
	}

	public String getPrincipalname() {
		return principalname;
	}

	public void setPrincipalname(String principalname) {
		this.principalname = principalname;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Integer getProfileid() {
		return profileid;
	}

	public void setProfileid(Integer profileid) {
		this.profileid = profileid;
	}

	public Integer getRoe() {
		return roe;
	}

	public void setRoe(Integer roe) {
		this.roe = roe;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
 	
 	
 	
 	
}
