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
@Table(name="adddiaryrecord")
public class AddDiary {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="diaryId")
	private Integer diaryId;
	@Column(name="date")
	private String date;
	@Column(name="time")
	private String diarytime;
	@Column(name ="organization_name")
	private String organizationName;
	@Column(name="contact_person")
	private String contacperson;
	@Column(name="tasktype")
	private String tasktype;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="enteruser")
	private UserEmployee enteryuser;
	@Column(name="adress")
    private String address;
	@Column(name="mobileno")
	private String mobileno;
	@Column(name="email")
	private String email;
	@Column(name="objective")
	private String objective;
	
	
	
	public Integer getDiaryId() {
		return diaryId;
	}
	public void setDiaryId(Integer diaryId) {
		this.diaryId = diaryId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDiarytime() {
		return diarytime;
	}
	public void setDiarytime(String diarytime) {
		this.diarytime = diarytime;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
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
	public UserEmployee getEnteryuser() {
		return enteryuser;
	}
	public void setEnteryuser(UserEmployee enteryuser) {
		this.enteryuser = enteryuser;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
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
