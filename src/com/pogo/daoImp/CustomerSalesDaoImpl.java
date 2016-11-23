package com.pogo.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.CustomerSalesDao;
import com.pogo.model.CustomerSales;


@Repository("customerSalesDao")
public class CustomerSalesDaoImpl implements CustomerSalesDao
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addCutomer(CustomerSales customerSales) {
		sessionFactory.getCurrentSession().save(customerSales);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerSales> getsalesList() {
		return sessionFactory.getCurrentSession().createCriteria(CustomerSales.class).list();
	}

}
