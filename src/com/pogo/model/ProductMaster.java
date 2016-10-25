package com.pogo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productmaster")
public class ProductMaster implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name="productid",columnDefinition="bigInt(20)" )
	private int productid; 

 	@Column(name="productname",length=50 )
	private String productname; 

 	@Column(name="arewedealingin",length=1 )
	private String arewedealingin; 

 	@Column(name="unitprice",columnDefinition="Decimal(15,2)") 
    private float unitprice; 

 	@Column(name="unitprice_sc",columnDefinition="Decimal(15,2)") 
    private float unitprice_sc; 

 	@Column(name="producttypeid",length= 11)
    private String producttypeid; 

 	@Column(name="unittypeid",length= 11) 
    private String unittypeid; 

 	@Column(name="currencyid_sc",length=11 )
    private String currencyid_sc; 

 	@Column(name="costprice",length=15 ) 
    private float costprice; 

 	@Column(name="isunderwarranty",length=1, columnDefinition="char default 'N'") 
    private String isunderwarranty; 

 	@Column(name="isunderamc",length=1,columnDefinition="char default 'N'" )
    private String isunderamc; 

 	@Column(name="noofservicewarranty",length= 11)
    private int noofservicewarranty; 

 	@Column(name="productcode",length=50,columnDefinition="char default ''" )
    private String productcode; 

 	@Column(name="productdescription",length=250 )
    private String productdescription; 

 	@Column(name="warrantyperiod",length=11 )
    private int warrantyperiod; 

 	@Column(name="amcstdprice",columnDefinition="Decimal(10,2) default '0.00'" )
    private float amcstdprice; 

 	@Column(name="discontinuedate")
    private Date discontinuedate; 

 	@Column(name="serviceable",columnDefinition="varchar(5) default 'TRUE'" )
    private String serviceable; 

 	@Column(name="ordpmfrequency",length=11 )
    private int ordpmfrequency; 

 	@Column(name="amcpmfrequency",length=11 )
    private int amcpmfrequency; 

 	@Column(name="productcategory",length=11 )
    private int productcategory; 

 	@Column(name="premiumprice",columnDefinition="Decimal(15,2)" ) 
    private float premiumprice; 

 	@Column(name="leastprice",columnDefinition="Decimal(15,2)" )
    private float leastprice; 

 	@Column(name="upgrdable",columnDefinition="char(1) " )
    private String upgrdable; 

 	@Column(name="pitmarking",columnDefinition="char(1) ")
    private String pitmarking; 

 	@Column(name="calibration",columnDefinition="char(1) ") 
    private String calibration; 

 	@Column(name="servicefrequency",columnDefinition="Decimal(15,2)" ) 
    private float servicefrequency; 

 	@Column(name="servicefrequencyin",columnDefinition="varchar(10)" )
    private String servicefrequencyin; 

 	@Column(name="sparesreqd",columnDefinition="char(1)" )
    private String sparesreqd; 

 	@Column(name="upgradelife",columnDefinition="Decimal(15,2)")
    private float upgradelife; 

 	@Column(name="lifespanin",columnDefinition="varchar(10)" ) 
    private String lifespanin; 

 	@Column(name="others",columnDefinition="varchar(500)")
    private String others; 

 	@Column(name="eos" )
    private Date eos; 

 	@Column(name="warrantyhours",length=11 )
    private int warrantyhours; 

 	@Column(name="isactive",columnDefinition="varchar(1) default 'Y'")
    private String isactive; 

 	@Column(name="level1",columnDefinition="Decimal(15,2)" )
    private float level1; 

 	@Column(name="level2",columnDefinition="Decimal(15,2)" )
    private float level2; 

 	@Column(name="level3",columnDefinition="Decimal(15,2)")
    private float level3; 

 	@Column(name="level4",columnDefinition="Decimal(15,2)")
    private float level4; 

 	@Column(name="level5",columnDefinition="Decimal(15,2)")
    private String level5; 

 	@Column(name="detaildescription",columnDefinition="Text")
    private String detaildescription; 

 	@Column(name="pieces",columnDefinition="int(11) default '1'" )
    private int pieces; 

 	@Column(name="capacity",columnDefinition="Decimal(10,2) default '1.00'" )
    private float capacity; 

 	@Column(name="box",columnDefinition="int(11) default '1'")
    private int box; 

 	@Column(name="photostatus",columnDefinition="varchar(250)")
    private String photostatus; 

	
 	
 	
 	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getArewedealingin() {
		return arewedealingin;
	}
	public void setArewedealingin(String arewedealingin) {
		this.arewedealingin = arewedealingin;
	}
	public float getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}
	public float getUnitprice_sc() {
		return unitprice_sc;
	}
	public void setUnitprice_sc(float unitprice_sc) {
		this.unitprice_sc = unitprice_sc;
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
	public String getIsunderwarranty() {
		return isunderwarranty;
	}
	public void setIsunderwarranty(String isunderwarranty) {
		this.isunderwarranty = isunderwarranty;
	}
	public String getIsunderamc() {
		return isunderamc;
	}
	public void setIsunderamc(String isunderamc) {
		this.isunderamc = isunderamc;
	}
	public int getNoofservicewarranty() {
		return noofservicewarranty;
	}
	public void setNoofservicewarranty(int noofservicewarranty) {
		this.noofservicewarranty = noofservicewarranty;
	}
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	public int getWarrantyperiod() {
		return warrantyperiod;
	}
	public void setWarrantyperiod(int warrantyperiod) {
		this.warrantyperiod = warrantyperiod;
	}
	public float getAmcstdprice() {
		return amcstdprice;
	}
	public void setAmcstdprice(float amcstdprice) {
		this.amcstdprice = amcstdprice;
	}
	public Date getDiscontinuedate() {
		return discontinuedate;
	}
	public void setDiscontinuedate(Date discontinuedate) {
		this.discontinuedate = discontinuedate;
	}
	public String getServiceable() {
		return serviceable;
	}
	public void setServiceable(String serviceable) {
		this.serviceable = serviceable;
	}
	public int getOrdpmfrequency() {
		return ordpmfrequency;
	}
	public void setOrdpmfrequency(int ordpmfrequency) {
		this.ordpmfrequency = ordpmfrequency;
	}
	public int getAmcpmfrequency() {
		return amcpmfrequency;
	}
	public void setAmcpmfrequency(int amcpmfrequency) {
		this.amcpmfrequency = amcpmfrequency;
	}
	public int getProductcategory() {
		return productcategory;
	}
	public void setProductcategory(int productcategory) {
		this.productcategory = productcategory;
	}
	public float getPremiumprice() {
		return premiumprice;
	}
	public void setPremiumprice(float premiumprice) {
		this.premiumprice = premiumprice;
	}
	public float getLeastprice() {
		return leastprice;
	}
	public void setLeastprice(float leastprice) {
		this.leastprice = leastprice;
	}
	public String getUpgrdable() {
		return upgrdable;
	}
	public void setUpgrdable(String upgrdable) {
		this.upgrdable = upgrdable;
	}
	public String getPitmarking() {
		return pitmarking;
	}
	public void setPitmarking(String pitmarking) {
		this.pitmarking = pitmarking;
	}
	public String getCalibration() {
		return calibration;
	}
	public void setCalibration(String calibration) {
		this.calibration = calibration;
	}
	public float getServicefrequency() {
		return servicefrequency;
	}
	public void setServicefrequency(float servicefrequency) {
		this.servicefrequency = servicefrequency;
	}
	public String getServicefrequencyin() {
		return servicefrequencyin;
	}
	public void setServicefrequencyin(String servicefrequencyin) {
		this.servicefrequencyin = servicefrequencyin;
	}
	public String getSparesreqd() {
		return sparesreqd;
	}
	public void setSparesreqd(String sparesreqd) {
		this.sparesreqd = sparesreqd;
	}
	public float getUpgradelife() {
		return upgradelife;
	}
	public void setUpgradelife(float upgradelife) {
		this.upgradelife = upgradelife;
	}
	public String getLifespanin() {
		return lifespanin;
	}
	public void setLifespanin(String lifespanin) {
		this.lifespanin = lifespanin;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public Date getEos() {
		return eos;
	}
	public void setEos(Date eos) {
		this.eos = eos;
	}
	public int getWarrantyhours() {
		return warrantyhours;
	}
	public void setWarrantyhours(int warrantyhours) {
		this.warrantyhours = warrantyhours;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public float getLevel1() {
		return level1;
	}
	public void setLevel1(float level1) {
		this.level1 = level1;
	}
	public float getLevel2() {
		return level2;
	}
	public void setLevel2(float level2) {
		this.level2 = level2;
	}
	public float getLevel3() {
		return level3;
	}
	public void setLevel3(float level3) {
		this.level3 = level3;
	}
	public float getLevel4() {
		return level4;
	}
	public void setLevel4(float level4) {
		this.level4 = level4;
	}
	public String getLevel5() {
		return level5;
	}
	public void setLevel5(String level5) {
		this.level5 = level5;
	}
	public String getDetaildescription() {
		return detaildescription;
	}
	public void setDetaildescription(String detaildescription) {
		this.detaildescription = detaildescription;
	}
	public int getPieces() {
		return pieces;
	}
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	public float getCapacity() {
		return capacity;
	}
	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}
	public int getBox() {
		return box;
	}
	public void setBox(int box) {
		this.box = box;
	}
	public String getPhotostatus() {
		return photostatus;
	}
	public void setPhotostatus(String photostatus) {
		this.photostatus = photostatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
    
    
}
