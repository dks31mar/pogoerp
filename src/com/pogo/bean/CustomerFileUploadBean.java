package com.pogo.bean;

import org.springframework.web.multipart.MultipartFile;

public class CustomerFileUploadBean {
	private Integer cusfileId;
	private MultipartFile file;
	private String fileName;
	private String fileType;
	private Integer followupId;
	private String oganisationName;
	public Integer getCusfileId() {
		return cusfileId;
	}
	public void setCusfileId(Integer cusfileId) {
		this.cusfileId = cusfileId;
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
	public Integer getFollowupId() {
		return followupId;
	}
	public void setFollowupId(Integer followupId) {
		this.followupId = followupId;
	}
	public String getOganisationName() {
		return oganisationName;
	}
	public void setOganisationName(String oganisationName) {
		this.oganisationName = oganisationName;
	}
	

}
