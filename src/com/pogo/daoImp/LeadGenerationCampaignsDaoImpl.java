package com.pogo.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.LeadGenerationCampaignsDao;
import com.pogo.model.AddAddress;
import com.pogo.model.AddEmailList;


@Repository("dao")
public class LeadGenerationCampaignsDaoImpl implements LeadGenerationCampaignsDao {
	
	@Autowired SessionFactory sessionfactory;

	public void addemail(AddEmailList emaillist){
		sessionfactory.getCurrentSession().save(emaillist);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AddEmailList> mailList() {
		
		return (List<AddEmailList>) sessionfactory.getCurrentSession().createCriteria(AddEmailList.class).list();
	}

	@Override
	public void deleteEmail(int id) {
		System.out.println("inside delete dao method ");
		sessionfactory.getCurrentSession().createQuery("DELETE FROM AddEmailList WHERE emaillistid =" +id).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AddEmailList> getEmail(String id) {
		
		 int f=Integer.parseInt(id);
			
			return (List<AddEmailList>) sessionfactory.getCurrentSession().createCriteria(AddEmailList.class)
					.add(Restrictions.eq("id", f)).list();
	}

	@Override
	public void editEmail(AddEmailList list) {
		sessionfactory.getCurrentSession().update(list);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AddAddress> addAddressList() {
		
		return (List<AddAddress>) sessionfactory.getCurrentSession().createCriteria(AddAddress.class).list();
	}
	
	public void addaddress(AddAddress info){
		sessionfactory.getCurrentSession().save(info);
		
	}

	@Override
	public void deleteAddress(int id) {
		sessionfactory.getCurrentSession().createQuery("delete from AddAddress where id = " +id).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AddAddress> getAddress(String id) {
		
		int f=Integer.parseInt(id);
		
		return (List<AddAddress>) sessionfactory.getCurrentSession().createCriteria(AddAddress.class)
				.add(Restrictions.eq("id", f)).list();
	}

	@Override
	public void editAddress(AddAddress list) {
		sessionfactory.getCurrentSession().update(list);
		
	}
}
