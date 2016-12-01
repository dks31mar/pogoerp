package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Column(name="action_type")
private String actionType;
@Column(name="contact_person")
private String contactPerson;
@Column(name="action_taken")
private String actionTaken;
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
public String getActionType() {
	return actionType;
}
public void setActionType(String actionType) {
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
