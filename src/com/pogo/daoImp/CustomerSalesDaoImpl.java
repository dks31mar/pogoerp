package com.pogo.daoImp;

import java.util.ArrayList;
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

import com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator;
import com.pogo.dao.CustomerSalesDao;
import com.pogo.model.AddDiary;
import com.pogo.model.AddFollowUp;
import com.pogo.model.Contact;
import com.pogo.model.CustomerSales;
import com.pogo.model.ProductMaster;


import com.pogo.model.State;
import com.pogo.model.UserEmployee;


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
		//proList.add(Projections.property("customerId"));
		Criteria r= sessionFactory.getCurrentSession().createCriteria(CustomerSales.class).setProjection(Projections.property("organisation"));
				
		List<CustomerSales> list=r.list();
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


	
	

	@Override
	public List<CustomerSales> getOrganisationname(CustomerSales cs) {
		// TODO Auto-generated method stub
		String hint=cs.getOrganisation();
		hint = hint + "%";
		Criteria r=	sessionFactory.getCurrentSession().createCriteria(CustomerSales.class).add(Restrictions.like("organisation", hint)).setProjection(Projections.property("organisation"));
		@SuppressWarnings("unchecked")
		List<CustomerSales> list=	(List<CustomerSales>)r.list();
		System.out.println(list);
		return list;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEmployee> getDatafromDiary() 
	{
		List<UserEmployee> d=sessionFactory.getCurrentSession().createCriteria(AddDiary.class).setProjection(Projections.distinct(Projections.property("enteryuser"))).list();
	
		List<UserEmployee> getname=new ArrayList<>();
		
		for(UserEmployee g:d){
		UserEmployee s=(UserEmployee) sessionFactory.getCurrentSession().createCriteria(UserEmployee.class).add(Restrictions.eq("userempid", g.getUserempid())).uniqueResult();
		getname.add(s);
		
		}
		return getname;
				
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AddDiary> getPlanByid(Integer userempid) {
		List<AddDiary> d=sessionFactory.getCurrentSession().createCriteria(AddDiary.class).add(Restrictions.eq("enteryuser.userempid", userempid)).list();
		for(AddDiary f:d){
			System.out.println("Plan id is>>>>>>>>>>>>>>>    "+f.getPlanName().getId());
		}
		return null;
	}

	@Override
	public List<CustomerSales> getCustomerdatabyCompanyName(String organization) {
	CustomerSales s=	(CustomerSales) sessionFactory.getCurrentSession().createCriteria(CustomerSales.class)
			.add(Restrictions.eq("organisation", organization)).uniqueResult();
	System.out.println("*********************************customer sales list ***************************"+s);
	int statusid=s.getStatus().getId();	
	
	System.out.println(statusid);
	
	Criteria state=sessionFactory.getCurrentSession().createCriteria(CustomerSales.class);
		Criteria country=state.createCriteria("status");
		country.add(Restrictions.eq("id", statusid));
		List list= state.list();
				
		return list;
		
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerSales> getCustomerdatabyCompanyName(int id) {
		return sessionFactory.getCurrentSession().createCriteria(CustomerSales.class).list();
		
	}

	

}
