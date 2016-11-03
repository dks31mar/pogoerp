package com.pogo.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.MasterProductDao;
import com.pogo.model.Currency;
@Repository("masterProductDao")
public class MasterProductDaoImp implements MasterProductDao{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Currency> getCurrencyData() {
		
		return (List<Currency>)sessionFactory.getCurrentSession().createCriteria(Currency.class).list();
	}

	@Override
	public void addCurrency(Currency cur) {
		sessionFactory.getCurrentSession().save(cur);
		
	}
	
}
