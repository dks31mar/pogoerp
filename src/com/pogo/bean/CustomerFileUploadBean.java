package com.pogo.bean;

import org.springframework.web.multipart.MultipartFile;

public class CustomerFileUploadBean {
	private Integer cusfileId;
	private MultipartFile file;
	private String fileName;
	private String fileType;
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
	

}
