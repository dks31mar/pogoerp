package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="poquotationdetail")
public class PoQuotationDetail
{
		  @GeneratedValue(strategy=GenerationType.AUTO)
		  @Column(name="poquotationdetailid")
		  private Integer poquotationdetailid;
		  @Column(name="custname")
		  private String custname;
		  @Id
		  @Column(name="qorefno")
		  private String qorefno;
		  @Column(name="qodate")
		  private String qodate;
		  @Column(name="qovalid")
		  private String qovalid;
		  @Column(name="address")
		  private String address;
		  @Column(name="terms1")
		  private String terms1;
		  @Column(name="terms2")
		  private String terms2;
		  @Column(name="terms3")
		  private String terms3;
		  @Column(name="terms4")
		  private String terms4;
		  @Column(name="terms5")
		  private String terms5;
		  @Column(name="terms6")
		  private String terms6;
		  @Column(name="terms7")
		  private String terms7;
		  @Column(name="terms8")
		  private String terms8;
		  @Column(name="terms9")
		  private String terms9;
		  @Column(name="terms10")
		  private String terms10;
		  @Column(name="nettotal")
		  private double nettotal;
		  @Column(name="email")
		  private String email;
			
		  
		  
		  public Integer getPoquotationdetailid() {
				return poquotationdetailid;
			}
			public void setPoquotationdetailid(Integer poquotationdetailid) {
				this.poquotationdetailid = poquotationdetailid;
			}
			public String getCustname() {
				return custname;
			}
			public void setCustname(String custname) {
				this.custname = custname;
			}
			public String getQorefno() {
				return qorefno;
			}
			public void setQorefno(String qorefno) {
				this.qorefno = qorefno;
			}
			public String getQodate() {
				return qodate;
			}
			public void setQodate(String qodate) {
				this.qodate = qodate;
			}
			public String getQovalid() {
				return qovalid;
			}
			public void setQovalid(String qovalid) {
				this.qovalid = qovalid;
			}
			public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public String getTerms1() {
				return terms1;
			}
			public void setTerms1(String terms1) {
				this.terms1 = terms1;
			}
			public String getTerms2() {
				return terms2;
			}
			public void setTerms2(String terms2) {
				this.terms2 = terms2;
			}
			public String getTerms3() {
				return terms3;
			}
			public void setTerms3(String terms3) {
				this.terms3 = terms3;
			}
			public String getTerms4() {
				return terms4;
			}
			public void setTerms4(String terms4) {
				this.terms4 = terms4;
			}
			public String getTerms5() {
				return terms5;
			}
			public void setTerms5(String terms5) {
				this.terms5 = terms5;
			}
			public String getTerms6() {
				return terms6;
			}
			public void setTerms6(String terms6) {
				this.terms6 = terms6;
			}
			public String getTerms7() {
				return terms7;
			}
			public void setTerms7(String terms7) {
				this.terms7 = terms7;
			}
			public String getTerms8() {
				return terms8;
			}
			public void setTerms8(String terms8) {
				this.terms8 = terms8;
			}
			public String getTerms9() {
				return terms9;
			}
			public void setTerms9(String terms9) {
				this.terms9 = terms9;
			}
			public String getTerms10() {
				return terms10;
			}
			public void setTerms10(String terms10) {
				this.terms10 = terms10;
			}
			public double getNettotal() {
				return nettotal;
			}
			public void setNettotal(double nettotal) {
				this.nettotal = nettotal;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			  
			  
		  
	  
	  
	}