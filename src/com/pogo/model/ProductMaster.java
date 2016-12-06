package com.pogo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="productmaster",schema="pogodb")
public class ProductMaster implements Serializable{

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="productid",columnDefinition="bigInt(20)")
	private Integer productid; 

	@Column(name="productheadid",columnDefinition="bigInt(20)" )
	private Integer productheadid;
 	
	@Column(name="productsubheadid",columnDefinition="bigInt(20)" )
 	private Integer productsubheadid;
	
 	@Column(name="productname",columnDefinition="varchar(55)")
	private String productname; 


 	@Column(name="unitprice",columnDefinition="Decimal(15,2)") 
    private float unitprice; 

 	
 	@Column(name="producttypeid",columnDefinition="varchar(11)")
    private String producttypeid; 

 	@Column(name="unittypeid",columnDefinition="varchar(55)") 
    private String unittypeid; 

 	@Column(name="currencyid_sc",columnDefinition="varchar(55)")
    private String currencyid_sc; 

 	@Column(name="costprice",columnDefinition="float" ) 
    private float costprice; 

 	@Column(name="productcode",length=50,columnDefinition="varchar(55)" )
    private String productcode; 

 	@Column(name="description",columnDefinition="varchar(255)")
    private String description; 

 	@Column(name="serviceable",columnDefinition="varchar(5) default 'Y'" )
    private String serviceable; 

 	@Column(name="productcategory",columnDefinition="varchar(55)" )
    private String productcategory; 

 	@Column(name="isactive",columnDefinition="varchar(1) default 'Y'")
    private String isactive;

 	@Column(name="color",columnDefinition="varchar(55)")
 	private String color;
 	
 	@Column(name="sellingprice",columnDefinition="float")
 	private float sellingprice;
 	
 	
 	

	public float getSellingprice() {
		return sellingprice;
	}

	public void setSellingprice(float sellingprice) {
		this.sellingprice = sellingprice;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getProductheadid() {
		return productheadid;
	}

	public void setProductheadid(Integer productheadid) {
		this.productheadid = productheadid;
	}

	public Integer getProductsubheadid() {
		return productsubheadid;
	}

	public void setProductsubheadid(Integer productsubheadid) {
		this.productsubheadid = productsubheadid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public float getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}

	public String getProducttypeid() {
		return producttypeid;
	}

	public void setProducttypeid(String producttypeid) {
		this.producttypeid = producttypeid;
	}

	public String getUnittypeid() {
		return unittypeid;
	}

	public void setUnittypeid(String unittypeid) {
		this.unittypeid = unittypeid;
	}

	public String getCurrencyid_sc() {
		return currencyid_sc;
	}

	public void setCurrencyid_sc(String currencyid_sc) {
		this.currencyid_sc = currencyid_sc;
	}

	public float getCostprice() {
		return costprice;
	}

	public void setCostprice(float costprice) {
		this.costprice = costprice;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceable() {
		return serviceable;
	}

	public void setServiceable(String serviceable) {
		this.serviceable = serviceable;
	}

	public String getProductcategory() {
		return productcategory;
	}

	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
 	
}
