package com.pogo.service;


import java.text.ParseException;
import java.util.List;

import com.pogo.bean.AddActionBean;
import com.pogo.bean.AddDiaryBean;
import com.pogo.bean.AddFollowUpBean;
import com.pogo.bean.ContactBean;
import com.pogo.bean.CustomerSalesBean;

public interface CustomerSalesService 
{

	void addCustomerSales(CustomerSalesBean customerSalesBean)throws ParseException;

	List<CustomerSalesBean> findAllData();

	public CustomerSalesBean getCustomerDetailsById(int id);


	void upadtecustomerData(CustomerSalesBean customerSalesBean) throws ParseException;

	void savediary(AddDiaryBean addDiaryBean);

	void addFollowup(AddFollowUpBean addFollowUpBean);

	List<CustomerSalesBean> findAllDataById(int id);

	void addContactPerson(ContactBean contactBean);

	List<AddDiaryBean> getDiaryList();


	

	



}
