package com.pogo.dao;

import java.util.List;

import com.pogo.model.AddDiary;
import com.pogo.model.AddFollowUp;
import com.pogo.model.Contact;
import com.pogo.model.CustomerSales;
import com.pogo.model.ProductMaster;

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

	List<CustomerSales> getCustomerData(String organisation);

	
	List<CustomerSales> getOrganisationname(CustomerSales cs);
}
