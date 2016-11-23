package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="adddiaryrecord")
public class AddDiary {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SNO")
	private Integer sno;
	@Column(name="Date")
	private Integer date;
	@Column(name="Time")
	private Integer time;
	@Column(name ="Organization")
	private String Organization;
	@Column(name="Contactperson")
	private String contacperson;
	@Column(name="tasktype")
	private String tasktype;
	@Column(name="Enteruser")
	private String enteryuser;
	@Column(name="DecidingAuthority")
	private String decidingAuthority;
	@Column(name="Adress")
    private String address;
	@Column(name="mobil")
	private Integer mobileno;
	@Column(name="faxno")
	private String faxno;
	@Column(name="email")
	private String email;
	@Column(name="objective")
	private String objective;
	
	
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public Integer getDate() {
		return date;
	}
	public void setDate(Integer date) {
		this.date = date;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public String getOrganization() {
		return Organization;
	}
	public void setOrganization(String organization) {
		Organization = organization;
	}
	public String getContacperson() {
		return contacperson;
	}
	public void setContacperson(String contacperson) {
		this.contacperson = contacperson;
	}
	public String getTasktype() {
		return tasktype;
	}
	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}
	public String getEnteryuser() {
		return enteryuser;
	}
	public void setEnteryuser(String enteryuser) {
		this.enteryuser = enteryuser;
	}
	public String getDecidingAuthority() {
		return decidingAuthority;
	}
	public void setDecidingAuthority(String decidingAuthority) {
		this.decidingAuthority = decidingAuthority;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getMobileno() {
		return mobileno;
	}
	public void setMobileno(Integer mobileno) {
		this.mobileno = mobileno;
	}
	public String getFaxno() {
		return faxno;
	}
	public void setFaxno(String faxno) {
		this.faxno = faxno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	
}
