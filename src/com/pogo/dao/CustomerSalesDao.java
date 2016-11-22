package com.pogo.dao;

import java.util.List;

import com.pogo.model.CustomerSales;

public interface CustomerSalesDao 
{

	void addCutomer(CustomerSales customerSales);

	List<CustomerSales> getsalesList();

}
