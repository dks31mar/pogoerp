package com.pogo.bean;

import com.pogo.model.PorefSupplierDetail;

public class PrinicipalPoPDFBean {

	
	private Integer porefentryitemdetailid;
	private String porefno;
 	private String particular;
 	private String tpinjpy;
 	private double qty;
 	private double totaljpy;
 	private double totalinr;
 	private String ackdate;  
 	private String remarks;
 	private int posrno;
 	private String invno;
 	private String invdate;
 	private String customerporefe;
 	private String productdescription;
 	private PorefSupplierDetail porefnobysupplier;
 	private String porefsupplierdetailid;
 	private String porefdate;
    private String principalname;
    private String specification;
	private int profileid;
    private int roe;
    private String address;
    private double total;
    private double totalQty;
    private double totalprice;
    
    
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public double getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(double totalQty) {
		this.totalQty = totalQty;
	}
	public PrinicipalPoPDFBean() {
		super();
	}
	
	
	public PrinicipalPoPDFBean(String porefno,String porefdate, String principalname, String address, double totalprice, Integer totalQty) {
		super();
		this.porefno=porefno;
		this.porefdate = porefdate;
		this.principalname = principalname;
		this.address = address;
		this.totalprice = totalprice;
		this.totalQty = totalQty;
	}
	public PrinicipalPoPDFBean(Integer porefentryitemdetailid,String productdescription,
			String particular, String tpinjpy, double qty,double total,String porefno,String porefdate, 
			String principalname, String address, double totalprice, double totalQty) {
		super();
		this.porefno=porefno;
		this.porefdate = porefdate;
		this.principalname = principalname;
		this.address = address;
		this.totalprice = totalprice;
		this.totalQty = totalQty;
		this.porefentryitemdetailid = porefentryitemdetailid;
		this.particular = particular;
		this.tpinjpy = tpinjpy;
		this.qty = qty;
		this.productdescription = productdescription;
		this.total=total;
	}
	public Integer getPorefentryitemdetailid() {
		return porefentryitemdetailid;
	}
	public void setPorefentryitemdetailid(Integer porefentryitemdetailid) {
		this.porefentryitemdetailid = porefentryitemdetailid;
	}
	public String getPorefno() {
		return porefno;
	}
	public void setPorefno(String porefno) {
		this.porefno = porefno;
	}
	public String getParticular() {
		return particular;
	}
	public void setParticular(String particular) {
		this.particular = particular;
	}
	public String getTpinjpy() {
		return tpinjpy;
	}
	public void setTpinjpy(String tpinjpy) {
		this.tpinjpy = tpinjpy;
	}
	public double getQty() {
		return qty;
	}
	public void setQty(double qty) {
		this.qty = qty;
	}
	public double getTotaljpy() {
		return totaljpy;
	}
	public void setTotaljpy(double totaljpy) {
		this.totaljpy = totaljpy;
	}
	public double getTotalinr() {
		return totalinr;
	}
	public void setTotalinr(double totalinr) {
		this.totalinr = totalinr;
	}
	public String getAckdate() {
		return ackdate;
	}
	public void setAckdate(String ackdate) {
		this.ackdate = ackdate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getPosrno() {
		return posrno;
	}
	public void setPosrno(int posrno) {
		this.posrno = posrno;
	}
	public String getInvno() {
		return invno;
	}
	public void setInvno(String invno) {
		this.invno = invno;
	}
	public String getInvdate() {
		return invdate;
	}
	public void setInvdate(String invdate) {
		this.invdate = invdate;
	}
	public String getCustomerporefe() {
		return customerporefe;
	}
	public void setCustomerporefe(String customerporefe) {
		this.customerporefe = customerporefe;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	public PorefSupplierDetail getPorefnobysupplier() {
		return porefnobysupplier;
	}
	public void setPorefnobysupplier(PorefSupplierDetail porefnobysupplier) {
		this.porefnobysupplier = porefnobysupplier;
	}
	public String getPorefsupplierdetailid() {
		return porefsupplierdetailid;
	}
	public void setPorefsupplierdetailid(String porefsupplierdetailid) {
		this.porefsupplierdetailid = porefsupplierdetailid;
	}
	public String getPorefdate() {
		return porefdate;
	}
	public void setPorefdate(String porefdate) {
		this.porefdate = porefdate;
	}
	public String getPrincipalname() {
		return principalname;
	}
	public void setPrincipalname(String principalname) {
		this.principalname = principalname;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public int getProfileid() {
		return profileid;
	}
	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}
	public int getRoe() {
		return roe;
	}
	public void setRoe(int roe) {
		this.roe = roe;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
    
    
    
}
