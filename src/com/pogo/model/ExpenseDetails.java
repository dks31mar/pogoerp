package com.pogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table( name = "expensedetails")
public class ExpenseDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int expensedetailsid;
    
    @Column(name = "expensedate")
	private String expensedate;
    @Column(name = "exphead")
	private String exphead;
    @Column(name = "discription")
	private String discription;
    @Column(name = "rates")
	private double rates;
    @Column(name = "qty")
	private Integer qty;
    @Column(name = "total")
	private double total;
    @Column(name = "isapproved")
	private String isapproved;
    @Column(name = "contactperson")
	private String contactperson;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "expentryid")
	private ExpenseEntry  expentryid;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "expensemasterId")
	private ExpenseMaster  expensemasterId;
	
    
    public int getExpensedetailsid() {
		return expensedetailsid;
	}

	public void setExpensedetailsid(int expensedetailsid) {
		this.expensedetailsid = expensedetailsid;
	}

	public String getExpensedate() {
		return expensedate;
	}

	public void setExpensedate(String expensedate) {
		this.expensedate = expensedate;
	}

	public String getExphead() {
		return exphead;
	}

	public void setExphead(String exphead) {
		this.exphead = exphead;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public double getRates() {
		return rates;
	}

	public void setRates(double rates) {
		this.rates = rates;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getIsapproved() {
		return isapproved;
	}

	public void setIsapproved(String isapproved) {
		this.isapproved = isapproved;
	}

	public String getContactperson() {
		return contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

    public ExpenseEntry getExpentryid() {
		return expentryid;
	}

	public void setExpentryid(ExpenseEntry expentryid) {
		this.expentryid = expentryid;
	}

	public ExpenseMaster getExpensemasterId() {
		return expensemasterId;
	}

	public void setExpensemasterId(ExpenseMaster expensemasterId) {
		this.expensemasterId = expensemasterId;
	}

	
	
}
