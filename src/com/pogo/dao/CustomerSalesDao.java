package com.pogo.dao;

import java.util.List;

import com.pogo.model.AddDiary;
import com.pogo.model.AddFollowUp;
import com.pogo.model.Contact;
import com.pogo.model.CustomerLevels;
import com.pogo.model.CustomerSales;


import com.pogo.model.ProductMaster;


import com.pogo.model.CustomersFileUplaod;

import com.pogo.model.UserEmployee;


public interface CustomerSalesDao 
{

	void addCutomer(CustomerSales customerSales);

	List<CustomerSales> getsalesList(String id);

	CustomerSales getCustomerDetailsbyId(int id);

	void updateCustomer(CustomerSales sales);

	void saveDiary(AddDiary diary);

	int addfollowup(AddFollowUp followUp);

	List<CustomerSales> getsalesListById();

	void saveContact(Contact contact);
	List<AddDiary> getdiarydata(int id, int pid);


	
	List<CustomerSales> getOrganisationname(CustomerSales cs);

	List<UserEmployee> getDatafromDiary();

	Integer getPlanByid(Integer userempid, int i);

	List<CustomerSales> getCustomerdatabyCompanyName(String organization);


	List<CustomerSales> getCustomerdatabyCompanyName(int id);



	int getTotalsms(Integer userempid, int i);

	int getTotalappointment(Integer userempid, int i);

	int getTotalemail(Integer userempid, int i);

	int getTotalphone(Integer userempid, int i);

	int getTotalothers(Integer userempid, int i);


	void savefiles(CustomersFileUplaod fileUplaod);

	AddDiary getDiarybyId(int id);

	void updateDiary(AddDiary addDiary);


	List<CustomersFileUplaod> getdatafromfiles();

	CustomersFileUplaod getfilesDataBy(int id);

	void delateFilesData(CustomersFileUplaod files);

	public CustomerSales verifyOrg(String organisation);

	String getorgName(Integer followupId);

	

	List<AddDiary> getdiarydata1(int pid);

	List<AddFollowUp> getfollowUpUserId(String id, String sdate);

	List<AddFollowUp> followUpListByUserId(Object s, String sdate, String edate);

	List<AddFollowUp> followUpListByUserId1(String empid, String sdate, String edate, String day);

	List<CustomerLevels> getlistcustomerlevel();

	int getcountcustomerlevel(CustomerLevels sl);


	



}
