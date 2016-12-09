package com.pogo.dao;

import java.util.List;

import com.pogo.model.AddDiary;
import com.pogo.model.AddFollowUp;
import com.pogo.model.Contact;
import com.pogo.model.CustomerSales;
import com.pogo.model.CustomersFileUplaod;
import com.pogo.model.UserEmployee;

public interface CustomerSalesDao 
{

	void addCutomer(CustomerSales customerSales);

	List<CustomerSales> getsalesList();

	CustomerSales getCustomerDetailsbyId(int id);

	void updateCustomer(CustomerSales sales);

	void saveDiary(AddDiary diary);

	void addfollowup(AddFollowUp followUp);

	List<CustomerSales> getsalesListById();

	void saveContact(Contact contact);


	List<AddDiary> getdiarydata(int id, int pid);

	

	List<UserEmployee> getDatafromDiary();

	Integer getPlanByid(Integer userempid, int i);

	List<CustomerSales> getCustomerdatabyCompanyName(String organization);

	int getTotalsms(Integer userempid, int i);

	int getTotalappointment(Integer userempid, int i);

	int getTotalemail(Integer userempid, int i);

	int getTotalphone(Integer userempid, int i);

	int getTotalothers(Integer userempid, int i);


	void savefiles(CustomersFileUplaod fileUplaod);

	AddDiary getDiarybyId(int id);

	void updateDiary(AddDiary addDiary);

	List<AddDiary> getdiarydata1(int pid);

	List<AddFollowUp> getfollowUpUserId(String id, String sdate, String edate);

	List<AddFollowUp> followUpListByUserId(Object s, String sdate, String edate);

	


}
