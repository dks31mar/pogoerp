package com.pogo.bean;

public class ProductAcknowledgementBean {

	private Integer productacknowledgementid   ;
    private String porefno  ;
    private String posrno ;
    private String particular  ;
    private double receiveqty ;
    private double pendingqty ;
    private String expdate ;
	
    public Integer getProductacknowledgementid() {
		return productacknowledgementid;
	}
	public void setProductacknowledgementid(Integer productacknowledgementid) {
		this.productacknowledgementid = productacknowledgementid;
	}
	public String getPorefno() {
		return porefno;
	}
	public void setPorefno(String porefno) {
		this.porefno = porefno;
	}
	public String getPosrno() {
		return posrno;
	}
	public void setPosrno(String posrno) {
		this.posrno = posrno;
	}
	public String getParticular() {
		return particular;
	}
	public void setParticular(String particular) {
		this.particular = particular;
	}
	public double getReceiveqty() {
		return receiveqty;
	}
	public void setReceiveqty(double receiveqty) {
		this.receiveqty = receiveqty;
	}
	public double getPendingqty() {
		return pendingqty;
	}
	public void setPendingqty(double pendingqty) {
		this.pendingqty = pendingqty;
	}
	public String getExpdate() {
		return expdate;
	}
	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
    
    
    
}
