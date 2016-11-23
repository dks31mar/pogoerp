package com.pogo.service;

import java.util.List;

import com.pogo.bean.AddAddressBean;
import com.pogo.bean.AddEmailListBean;

public interface LeadGenerationCampaignsService {

	void addemail(AddEmailListBean bean);

	List<AddEmailListBean> mailList();

	void deleteEmail(int id);

	

	String getEmail(String id);

	void editEmail(AddEmailListBean listbean);

	List<AddAddressBean> addAddressList();

	void addaddress(AddAddressBean bean);

	void deleteAddress(int id);

	String getAddress(String id);

	void editAddress(AddAddressBean listbean);
}
