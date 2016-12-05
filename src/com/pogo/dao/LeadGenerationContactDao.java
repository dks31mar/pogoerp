package com.pogo.dao;

import java.util.List;

import com.pogo.model.Contact;

public interface LeadGenerationContactDao {

	void saveContacts(Contact c);

	List<Contact> getcontactlist();

}
