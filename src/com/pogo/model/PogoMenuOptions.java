package com.pogo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pogomenuoptions")
public class PogoMenuOptions implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4936909116830089901L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer  id;
	
	@Column(name = "optionid" , nullable = false ,length = 30)
	private String optionId;
	
	@Column(name = "parentoptionid" , length = 30)
	private String parentOptionId;
	
	@Column(name = "optiondescription" , length = 250)
	private String optionDescription;
	
	@Column(name = "url",length = 500)
	private String url;
	
	@Column(name = "openin" ,length = 11 )
	private Integer openin;
	
	@Column(name = "level",length = 11)
	private Integer level;
	
	@Column(name = "seqno",length = 11)
	private Integer seqno;
	
	@Column(name = "ismenu",length = 1 ,columnDefinition="char default 'Y'")
	private String ismenu;
	
	@Column(name = "customizabletext",length = 250 )
	private String customizableText;
	
	@Column(name = "imagepath",length = 500)
	private String imagePath;
	  
	public String getOptionId() {
		return optionId;
	}
	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	public String getParentOptionId() {
		return parentOptionId;
	}
	public void setParentOptionId(String parentOptionId) {
		this.parentOptionId = parentOptionId;
	}
	public String getOptionDescription() {
		return optionDescription;
	}
	public void setOptionDescription(String optionDescription) {
		this.optionDescription = optionDescription;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getOpenin() {
		return openin;
	}
	public void setOpenin(Integer openin) {
		this.openin = openin;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getSeqno() {
		return seqno;
	}
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
	public String getIsmenu() {
		return ismenu;
	}
	public void setIsmenu(String ismenu) {
		this.ismenu = ismenu;
	}
	public String getCustomizableText() {
		return customizableText;
	}
	public void setCustomizableText(String customizableText) {
		this.customizableText = customizableText;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}	 
	  
	  
	  
	  
	  
	 
	  
	 
	 
	 
	 
	 
	
	 
	
	
	 
	

