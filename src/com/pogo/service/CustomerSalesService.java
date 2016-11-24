package com.pogo.service;


import java.text.ParseException;
import java.util.List;

import com.pogo.bean.CustomerSalesBean;

public interface CustomerSalesService 
{

	void addCustomerSales(CustomerSalesBean customerSalesBean)throws ParseException;

	List<CustomerSalesBean> findAllData();



	public CustomerSalesBean getCustomerDetailsById(int id);

	void SaveDiaryForEntery();


}
