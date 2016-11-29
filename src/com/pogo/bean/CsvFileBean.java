package com.pogo.bean;

import java.util.Date;

import javax.mail.Multipart;



public class CsvFileBean {

	
	private int id ;
	private String filename;
    private long size;
    private Date date;
    /*private Multipart file;
   
    public Multipart getFile() {
		return file;
	}

	public void setFile(Multipart file) {
		this.file = file;
	}*/

	
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
