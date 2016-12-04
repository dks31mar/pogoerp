package com.pogo.daoImp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.LeadGenerationContactDao;
import com.pogo.model.Contact;

@Repository("contactdao")
public class LeadGenerationContactDaoImpl implements LeadGenerationContactDao{
	@Autowired SessionFactory sessionfactory;

	@Override
	public void saveContacts(Contact c) {
		sessionfactory.getCurrentSession().save(c);
		
	}
	
}
