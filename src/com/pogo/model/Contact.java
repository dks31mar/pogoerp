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
@Table(name="contact")
public class Contact 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="contactid")
private int contactId;
	@Column(name="contactName")
private String contactName;
	@Column(name="contact_email")
private String contemail;
	@Column(name="phone")
private String phone;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="des_id")
private Designation desName;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dep_name")
private Department depName;
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContemail() {
		return contemail;
	}
	public void setContemail(String contemail) {
		this.contemail = contemail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Designation getDesName() {
		return desName;
	}
	public void setDesName(Designation desName) {
		this.desName = desName;
	}
	public Department getDepName() {
		return depName;
	}
	public void setDepName(Department depName) {
		this.depName = depName;
	}

}
