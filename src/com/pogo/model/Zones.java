package com.pogo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="zones")
public class Zones {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="zonesid",columnDefinition="Bigint(12)")
	private Integer zonesid;
	
	@Column(name="companyid",columnDefinition="int(11)")
	private Integer companyid;
	
	
    
	@Column(name="zonesheadid",columnDefinition="int(11)")
	private Integer zonesheadid;
     
	@Column(name="zonesname",columnDefinition="varchar(100)")
	private String zonesname;
	
	@Column(name="zonesaddress",columnDefinition="varchar(100)")
	private String zonesaddress;
	
	@Column(name="zonesphone",columnDefinition="varchar(25)")
	private String zonesphone;
	
	@Column(name="zonesfax",columnDefinition="varchar(25)")
    private String zonesfax;
    
	@Column(name="zonesemail",columnDefinition="varchar(50)")
    private String zonesemail;
	
	@Column(name="isexists",columnDefinition="varchar(1)")
    private String isexists;
	
	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Integer getZonesid() {
		return zonesid;
	}

	public void setZonesid(Integer zonesid) {
		this.zonesid = zonesid;
	}

	public Integer getZonesheadid() {
		return zonesheadid;
	}

	public void setZonesheadid(Integer zonesheadid) {
		this.zonesheadid = zonesheadid;
	}

	public String getZonesname() {
		return zonesname;
	}

	public void setZonesname(String zonesname) {
		this.zonesname = zonesname;
	}

	public String getZonesaddress() {
		return zonesaddress;
	}

	public void setZonesaddress(String zonesaddress) {
		this.zonesaddress = zonesaddress;
	}

	public String getZonesphone() {
		return zonesphone;
	}

	public void setZonesphone(String zonesphone) {
		this.zonesphone = zonesphone;
	}

	public String getZonesfax() {
		return zonesfax;
	}

	public void setZonesfax(String zonesfax) {
		this.zonesfax = zonesfax;
	}

	public String getZonesemail() {
		return zonesemail;
	}

	public void setZonesemail(String zonesemail) {
		this.zonesemail = zonesemail;
	}

	public String getIsexists() {
		return isexists;
	}

	public void setIsexists(String isexists) {
		this.isexists = isexists;
	}

	
}
