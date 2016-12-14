package com.pogo.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.bean.ContactBean;
import com.pogo.dao.LeadGenerationContactDao;
import com.pogo.model.AddEmailList;
import com.pogo.model.Contact;

@Repository("contactdao")
public class LeadGenerationContactDaoImpl implements LeadGenerationContactDao{
	@Autowired SessionFactory sessionfactory;

	@Override
	public void saveContacts(Contact c) {
		sessionfactory.getCurrentSession().save(c);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getcontactlist() {
		return (List<Contact>) sessionfactory.getCurrentSession().createCriteria(Contact.class).list();
		
	}

	@Override
	public void deleteContacts(int id) {
		sessionfactory.getCurrentSession().createQuery("DELETE FROM Contact WHERE contactid =" +id).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getContactsDetails(String id) {
		int f=Integer.parseInt(id);
		
		return (List<Contact>) sessionfactory.getCurrentSession().createCriteria(Contact.class)
				.add(Restrictions.eq("id", f)).list();
	}

	@Override
	public void editContactsDetails(Contact list) {
		sessionfactory.getCurrentSession().update(list);
		
	}
	
}
