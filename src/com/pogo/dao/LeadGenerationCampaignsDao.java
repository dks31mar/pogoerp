package com.pogo.dao;



import java.util.List;

import com.pogo.model.AddAddress;
import com.pogo.model.AddEmailList;

public interface LeadGenerationCampaignsDao {

	void addemail(AddEmailList emaillist);

	List<AddEmailList> mailList();

	void deleteEmail(int id);

	List<AddEmailList> getEmail(String id);

	void editEmail(AddEmailList list);

	List<AddAddress> addAddressList();
	void addaddress(AddAddress info);

	void deleteAddress(int id);

	List<AddAddress> getAddress(String id);

	void editAddress(AddAddress list);
}
