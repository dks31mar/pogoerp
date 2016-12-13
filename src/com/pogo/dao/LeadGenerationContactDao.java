package com.pogo.dao;

import java.util.List;

import com.pogo.bean.ContactBean;
import com.pogo.model.Contact;

public interface LeadGenerationContactDao {

	void saveContacts(Contact c);

	List<Contact> getcontactlist();

	void deleteContacts(int id);

	List<Contact> getContactsDetails(String id);

	void editContactsDetails(Contact list);

}
