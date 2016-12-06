package com.pogo.dao;

import java.util.List;

import com.pogo.model.AddDiary;
import com.pogo.model.AddFollowUp;
import com.pogo.model.Contact;
import com.pogo.model.CustomerSales;
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


	List<AddDiary> getdiarydata();

	List<CustomerSales> getCustomerData(String organisation);

	List<UserEmployee> getDatafromDiary();

	List<AddDiary> getPlanByid(Integer userempid);

	List<CustomerSales> getCustomerdatabyCompanyName(String organization);

}
