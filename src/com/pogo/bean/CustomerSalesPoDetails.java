package com.pogo.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Customer_Sales_PoDetails")
public class CustomerSalesPoDetails 
{
	private int CustomerSalesPoId;
	private String partno;
	private double unitPrice;
	private double discount;

}
