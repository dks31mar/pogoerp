package com.pogo.bean;

public class SubMenuBean {
	
	
private String optiondescription;
private String formname;
/**
 * @return the optiondescription
 */
public String getOptiondescription() {
	return optiondescription;
}
/**
 * @param optiondescription the optiondescription to set
 */
public void setOptiondescription(String optiondescription) {
	this.optiondescription = optiondescription;
}
/**
 * @return the formname
 */
public String getFormname() {
	return formname;
}
/**
 * @param formname the formname to set
 */
public void setFormname(String formname) {
	this.formname = formname;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "SubMenuBean [optiondescription=" + optiondescription
			+ ", formname=" + formname + "]";
}





}
