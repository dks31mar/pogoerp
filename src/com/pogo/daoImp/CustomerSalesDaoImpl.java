package com.pogo.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pogo.dao.CustomerSalesDao;
import com.pogo.model.AddDiary;
import com.pogo.model.AddFollowUp;
import com.pogo.model.Contact;
import com.pogo.model.CustomerSales;

@Repository("customerSalesDao")
public class CustomerSalesDaoImpl implements CustomerSalesDao {
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
	public List<CustomerSales> getsalesListById() {
		ProjectionList proList=Projections.projectionList();
		proList.add(Projections.property("organisation"));
		proList.add(Projections.property("customerId"));
		Criteria r= sessionFactory.getCurrentSession().createCriteria(CustomerSales.class)
				.setProjection(Projections.distinct(proList));
		List list=r.list();
		return list;
	}

	@Override
	public void saveContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerSales> getCustomerData(String organisation) {
		return null;
		// return
		// sessionFactory.getCurrentSession().createCriteria(CustomerSales.class).add(Restrictions.eq("",
		// value))
		
	}

	@SuppressWarnings("unchecked")
	public List<AddDiary> getdiarydata() {
		return sessionFactory.getCurrentSession().createCriteria(AddDiary.class).list();
	}

}
