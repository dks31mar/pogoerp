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
@Table(name="addfollowup")
public class AddFollowUp 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="followUpId")
private Integer followUpId;
	@Column(name="followup_date")
private String followupDate;
	@Column(name="followup_timeIn")	
private String followupTimeIn;
	@Column(name="followupTimeIn_min")
private String followupTimeInMin;
	@Column(name="followup_out")
private String followupTimeOut;
	@Column(name="followupTimeOut_min")
	private String followupTimeOutMin;
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="action_type")
private AddAction actionType;
@Column(name="contact_person")
private String contactPerson;
@Column(name="action_taken")
private String actionTaken;
@Column(name="cus_organisation")
private String cusOrganisation;
@Column(name="cus_address")
private String cusAddress;
@Column(name="cusAddress")
private String cusStatus;
public String getCusOrganisation() {
	return cusOrganisation;
}
public void setCusOrganisation(String cusOrganisation) {
	this.cusOrganisation = cusOrganisation;
}
public String getCusAddress() {
	return cusAddress;
}
public void setCusAddress(String cusAddress) {
	this.cusAddress = cusAddress;
}
public String getCusStatus() {
	return cusStatus;
}
public void setCusStatus(String cusStatus) {
	this.cusStatus = cusStatus;
}
public AddAction getAddAction() {
	return addAction;
}
public void setAddAction(AddAction addAction) {
	this.addAction = addAction;
}
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="add_action_id")
private AddAction addAction;
public Integer getFollowUpId() {
	return followUpId;
}
public void setFollowUpId(Integer followUpId) {
	this.followUpId = followUpId;
}
public String getFollowupDate() {
	return followupDate;
}
public void setFollowupDate(String followupDate) {
	this.followupDate = followupDate;
}
public String getFollowupTimeIn() {
	return followupTimeIn;
}
public void setFollowupTimeIn(String followupTimeIn) {
	this.followupTimeIn = followupTimeIn;
}
public String getFollowupTimeOut() {
	return followupTimeOut;
}
public void setFollowupTimeOut(String followupTimeOut) {
	this.followupTimeOut = followupTimeOut;
}

public AddAction getActionType() {
	return actionType;
}
public void setActionType(AddAction actionType) {
	this.actionType = actionType;
}
public String getActionTaken() {
	return actionTaken;
}
public void setActionTaken(String actionTaken) {
	this.actionTaken = actionTaken;
}
public String getFollowupTimeInMin() {
	return followupTimeInMin;
}
public void setFollowupTimeInMin(String followupTimeInMin) {
	this.followupTimeInMin = followupTimeInMin;
}
public String getFollowupTimeOutMin() {
	return followupTimeOutMin;
}
public void setFollowupTimeOutMin(String followupTimeOutMin) {
	this.followupTimeOutMin = followupTimeOutMin;
}
public String getContactPerson() {
	return contactPerson;
}
public void setContactPerson(String contactPerson) {
	this.contactPerson = contactPerson;
}

}