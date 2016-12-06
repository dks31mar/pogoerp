package com.pogo.bean;




public class ExpenseEntryBean {
    
	private int expentryid;
	
private String crdate;
	
	
	private String date;
	
	
	private String description;
	
	
	private String unit_expense;
	
	
	private Integer total;
	
	
    private Integer customerId ;
    
    private String organisation;
	
	
	public int getExpentryid() {
		return expentryid;
	}

	public void setExpentryid(int expentryid) {
		this.expentryid = expentryid;
	}

	public String getCrdate() {
		return crdate;
	}

	public void setCrdate(String crdate) {
		this.crdate = crdate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnit_expense() {
		return unit_expense;
	}

	public void setUnit_expense(String unit_expense) {
		this.unit_expense = unit_expense;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	
	
}
