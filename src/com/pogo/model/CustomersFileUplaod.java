package com.pogo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="customerFile")
public class CustomersFileUplaod implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cusfileId;
	private byte[] file;
	private String fileName;
	private String fileType;
	private Integer followupId;
	public Integer getFollowupId() {
		return followupId;
	}
	public void setFollowupId(Integer followupId) {
		this.followupId = followupId;
	}
	public Integer getCusfileId() {
		return cusfileId;
	}
	public void setCusfileId(Integer cusfileId) {
		this.cusfileId = cusfileId;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
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
