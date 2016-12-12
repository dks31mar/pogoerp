package com.pogo.service;


import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.pogo.bean.AddActionBean;
import com.pogo.bean.AddDiaryBean;
import com.pogo.bean.AddFollowUpBean;
import com.pogo.bean.ContactBean;
import com.pogo.bean.CustomerFileUploadBean;
import com.pogo.bean.CustomerLevelsBean;
import com.pogo.bean.CustomerSalesBean;
import com.pogo.model.AddDiary;
import com.pogo.model.CustomersFileUplaod;

public interface CustomerSalesService 
{

	void addCustomerSales(CustomerSalesBean customerSalesBean)throws ParseException;

	List<CustomerSalesBean> findAllData();

	public CustomerSalesBean getCustomerDetailsById(int id);
	void upadtecustomerData(CustomerSalesBean customerSalesBean) throws ParseException;
	void savediary(AddDiaryBean addDiaryBean);
	void addFollowup(AddFollowUpBean addFollowUpBean) throws IOException;
	String findAllDataById();
	void addContactPerson(ContactBean contactBean);
	List<AddDiary> getdiarydata();
	List<AddDiaryBean> getDiaryList(int id, String planId);
	List<AddDiaryBean> getDiaryRecord();
	String getCustomerdatabyCompanyName(String organization);
	public AddDiaryBean editdiaryrecord(int id);
	void updateDiaryData(AddDiaryBean addDiaryBean);

	void saveFiles(CustomersFileUplaod fileUplaod);

	List<CustomerFileUploadBean> getFollowupFilesList();

	CustomersFileUplaod downloadDataById(int id);

	void DeletefileById(int id);

	public String verifyOrg(String organisation);


	

	



}
