package com.pogo.bean;

import java.sql.Connection;
import java.util.Date;

public class EmployeeBean {

	private boolean isConnectionFlag = false;     // Added by arvind Thakur 25-DEC-2013 for close cnnection for uing any method in mobile apps
    private Connection mobileapssconnection = null;  // Added by arvind Thakur 25-DEC-2013 for close cnnection for uing any method in mobile apps
    private String fromEmail;
    private String fromEmailPwd;
    private String marriage1;
    private String dateofbirth1;
    private int empId;
    //add by satish on 22/04/2014
    private int contactId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int designationId;
    private String designationName;
    private String email;
    private Date doj;
    private String ispresent;
    private String isAuthorizedAndrioidUser = "";
    private String module = "";
    private int totalResults = 0;
    private int listFrom = 0;
    private int noOfResult;
    private int typeid = 0;
    private int[] producttype;
    //add by Satish for change in systemlock & Ordervalue.[06/11/2014]
    private double orderValue;
    private int lockDays;
    private boolean checkPendingTask;
    private boolean  checkFeedbackTask;
    private boolean checkCollection = false;
    private String photoStatus;
    private Date marriageDate;
	public boolean isConnectionFlag() {
		return isConnectionFlag;
	}
	public void setConnectionFlag(boolean isConnectionFlag) {
		this.isConnectionFlag = isConnectionFlag;
	}
	public Connection getMobileapssconnection() {
		return mobileapssconnection;
	}
	public void setMobileapssconnection(Connection mobileapssconnection) {
		this.mobileapssconnection = mobileapssconnection;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getFromEmailPwd() {
		return fromEmailPwd;
	}
	public void setFromEmailPwd(String fromEmailPwd) {
		this.fromEmailPwd = fromEmailPwd;
	}
	public String getMarriage1() {
		return marriage1;
	}
	public void setMarriage1(String marriage1) {
		this.marriage1 = marriage1;
	}
	public String getDateofbirth1() {
		return dateofbirth1;
	}
	public void setDateofbirth1(String dateofbirth1) {
		this.dateofbirth1 = dateofbirth1;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDesignationId() {
		return designationId;
	}
	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getIspresent() {
		return ispresent;
	}
	public void setIspresent(String ispresent) {
		this.ispresent = ispresent;
	}
	public String getIsAuthorizedAndrioidUser() {
		return isAuthorizedAndrioidUser;
	}
	public void setIsAuthorizedAndrioidUser(String isAuthorizedAndrioidUser) {
		this.isAuthorizedAndrioidUser = isAuthorizedAndrioidUser;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public int getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	public int getListFrom() {
		return listFrom;
	}
	public void setListFrom(int listFrom) {
		this.listFrom = listFrom;
	}
	public int getNoOfResult() {
		return noOfResult;
	}
	public void setNoOfResult(int noOfResult) {
		this.noOfResult = noOfResult;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int[] getProducttype() {
		return producttype;
	}
	public void setProducttype(int[] producttype) {
		this.producttype = producttype;
	}
	public double getOrderValue() {
		return orderValue;
	}
	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}
	public int getLockDays() {
		return lockDays;
	}
	public void setLockDays(int lockDays) {
		this.lockDays = lockDays;
	}
	public boolean isCheckPendingTask() {
		return checkPendingTask;
	}
	public void setCheckPendingTask(boolean checkPendingTask) {
		this.checkPendingTask = checkPendingTask;
	}
	public boolean isCheckFeedbackTask() {
		return checkFeedbackTask;
	}
	public void setCheckFeedbackTask(boolean checkFeedbackTask) {
		this.checkFeedbackTask = checkFeedbackTask;
	}
	public boolean isCheckCollection() {
		return checkCollection;
	}
	public void setCheckCollection(boolean checkCollection) {
		this.checkCollection = checkCollection;
	}
	public String getPhotoStatus() {
		return photoStatus;
	}
	public void setPhotoStatus(String photoStatus) {
		this.photoStatus = photoStatus;
	}
	public Date getMarriageDate() {
		return marriageDate;
	}
	public void setMarriageDate(Date marriageDate) {
		this.marriageDate = marriageDate;
	}
    
    
}
