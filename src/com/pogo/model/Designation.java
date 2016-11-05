package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="designations")

public class Designation 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="designationid")
   private Integer designationid;
   @Column(name="designation")
   private String designation;
   @Column(name="level")
   private Integer level;
public Integer getDesignationid() {
	return designationid;
}
public void setDesignationid(Integer designationid) {
	this.designationid = designationid;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public Integer getLevel() {
	return level;
}
public void setLevel(Integer level) {
	this.level = level;
}
   

}
