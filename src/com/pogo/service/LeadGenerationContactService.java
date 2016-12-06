package com.pogo.service;



import java.util.List;

import com.pogo.bean.AddEmailListBean;
import com.pogo.bean.ContactBean;

public interface LeadGenerationContactService {

	void saveContacts(ContactBean bean1);

	List<ContactBean> getcontactlist();

	void deleteContacts(int id);

	String getContactsDetails(String id);

	void editContactsDetails(ContactBean bean);

}
