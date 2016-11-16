package com.pogo.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.LeadGenerationCampaignsDao;
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
}
