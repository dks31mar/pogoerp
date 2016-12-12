package com.pogo.bean;

import org.springframework.web.multipart.MultipartFile;

public class AddFollowUpBean 
{
	
	private Integer followUpId;
	private String followupDate;
	private String followupTimeIn;
	private String followupTimeOut;
	private String actionType;
	private String actionTaken;
	private String followupTimeInMin;
	private String followupTimeOutMin;
	private String contactPerson;
	private String action;
	private int actionId;
	private String custStatus;
	private String cusAddress;
	private String cusOrganisation;
	private String remarks;
	
	private Integer cusfileId;
	private MultipartFile file;
	private String fileName;
	private String fileType;
	
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
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getActionId() {
		return actionId;
	}
	public void setActionId(int actionId) {
		this.actionId = actionId;
	}
	public String getCustStatus() {
		return custStatus;
	}
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	public String getCusOrganisation() {
		return cusOrganisation;
	}
	public void setCusOrganisation(String cusOrganisation) {
		this.cusOrganisation = cusOrganisation;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Integer getCusfileId() {
		return cusfileId;
	}
	public void setCusfileId(Integer cusfileId) {
		this.cusfileId = cusfileId;
	}
	
	
}
