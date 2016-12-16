package com.pogo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer_Sales_PoDetails")
public class CustomerSalesPoDetails 
{
	@Id
	private int CustomerSalesPoId;
	private String partno;
	private double unitPrice;
	private double discount;

}
