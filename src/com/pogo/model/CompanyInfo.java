package com.pogo.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="companyinfo")
public class CompanyInfo {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="companyinfoid",columnDefinition="bigint(20)")
	private Integer companyinfoid ;
	@Column(name="companyinfoname",columnDefinition="VARCHAR(100)")
	private String companyinfoname;
	
	@Column(name="companyinfocontactperson",columnDefinition="VARCHAR(25)")
	private String companyinfocontactperson ;
	@Column(name="companyinfocontactno",columnDefinition="VARCHAR(20)")
    private String companyinfocontactno;
	
	@Column(name="companyinfophone",columnDefinition="VARCHAR(25)")
	private String companyinfophone;
	@Column(name="companyinfofax",columnDefinition="VARCHAR(25)")
	private String companyinfofax;
	@Column(name="companyinfoemail",columnDefinition="VARCHAR(50)")
	private String companyinfoemail;
	
	@Column(name="companyinfovattin",columnDefinition="VARCHAR(50)")
	private String companyinfovattin;
	@Column(name="companyinfocstno",columnDefinition="VARCHAR(50)")
    private String companyinfocstno;
	@Column(name="companyinfopan",columnDefinition="VARCHAR(50)")
    private String companyinfopan;
	@Column(name="companyinfoservicetaxno",columnDefinition="VARCHAR(50)")
    private String companyinfoservicetaxno;
	
	
	@Column(name="companyinfoweb",columnDefinition="VARCHAR(100)")
    private String companyinfoweb;
	@Column(name="companyinfotermsandconditions",columnDefinition="TEXT")
    private String companyinfotermsandconditions;
	@Column(name="companyinfoaddress",columnDefinition="VARCHAR(1000)")
    private String companyinfoaddress;
	@Column(name="companylogo",columnDefinition="VARCHAR(150)")
    private String companylogo;
	public Integer getCompanyinfoid() {
		return companyinfoid;
	}
	public void setCompanyinfoid(Integer companyinfoid) {
		this.companyinfoid = companyinfoid;
	}
	public String getCompanyinfoname() {
		return companyinfoname;
	}
	public void setCompanyinfoname(String companyinfoname) {
		this.companyinfoname = companyinfoname;
	}
	public String getCompanyinfophone() {
		return companyinfophone;
	}
	public void setCompanyinfophone(String companyinfophone) {
		this.companyinfophone = companyinfophone;
	}
	public String getCompanyinfofax() {
		return companyinfofax;
	}
	public void setCompanyinfofax(String companyinfofax) {
		this.companyinfofax = companyinfofax;
	}
	public String getCompanyinfoemail() {
		return companyinfoemail;
	}
	public void setCompanyinfoemail(String companyinfoemail) {
		this.companyinfoemail = companyinfoemail;
	}
	public String getCompanyinfoweb() {
		return companyinfoweb;
	}
	public void setCompanyinfoweb(String companyinfoweb) {
		this.companyinfoweb = companyinfoweb;
	}
	public String getCompanyinfotermsandconditions() {
		return companyinfotermsandconditions;
	}
	public void setCompanyinfotermsandconditions(String companyinfotermsandconditions) {
		this.companyinfotermsandconditions = companyinfotermsandconditions;
	}
	public String getCompanyinfoaddress() {
		return companyinfoaddress;
	}
	public void setCompanyinfoaddress(String companyinfoaddress) {
		this.companyinfoaddress = companyinfoaddress;
	}
	public String getCompanylogo() {
		return companylogo;
	}
	public void setCompanylogo(String companylogo) {
		this.companylogo = companylogo;
	}
	public String getCompanyinfovattin() {
		return companyinfovattin;
	}
	public void setCompanyinfovattin(String companyinfovattin) {
		this.companyinfovattin = companyinfovattin;
	}
	public String getCompanyinfocstno() {
		return companyinfocstno;
	}
	public void setCompanyinfocstno(String companyinfocstno) {
		this.companyinfocstno = companyinfocstno;
	}
	public String getCompanyinfopan() {
		return companyinfopan;
	}
	public void setCompanyinfopan(String companyinfopan) {
		this.companyinfopan = companyinfopan;
	}
	public String getCompanyinfoservicetaxno() {
		return companyinfoservicetaxno;
	}
	public void setCompanyinfoservicetaxno(String companyinfoservicetaxno) {
		this.companyinfoservicetaxno = companyinfoservicetaxno;
	}
	public String getCompanyinfocontactperson() {
		return companyinfocontactperson;
	}
	public void setCompanyinfocontactperson(String companyinfocontactperson) {
		this.companyinfocontactperson = companyinfocontactperson;
	}
	public String getCompanyinfocontactno() {
		return companyinfocontactno;
	}
	public void setCompanyinfocontactno(String companyinfocontactno) {
		this.companyinfocontactno = companyinfocontactno;
	}
	
}
