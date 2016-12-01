package com.pogo.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.CustomerSalesDao;
import com.pogo.model.AddDiary;
import com.pogo.model.AddFollowUp;
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

	@Override
	public CustomerSales getCustomerDetailsbyId(int id) {
		return (CustomerSales) sessionFactory.getCurrentSession().get(CustomerSales.class, id);
	}

	@Override
	public void updateCustomer(CustomerSales sales) {
		sessionFactory.getCurrentSession().update(sales);
		
	}

	@Override
	public void saveDiary(AddDiary diary) {
		sessionFactory.getCurrentSession().save(diary);
		
	}

	@Override
	public void addfollowup(AddFollowUp followUp) {
		sessionFactory.getCurrentSession().save(followUp);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerSales> getsalesListById(int id) {
		return (List<CustomerSales>) sessionFactory.getCurrentSession().get(CustomerSales.class, id);
	}

}
