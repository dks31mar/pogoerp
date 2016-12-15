package com.pogo.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.bean.PoQuotationItemDetailBean;
import com.pogo.dao.QuotationDao;
import com.pogo.model.PoQuotationDetail;
import com.pogo.model.PoQuotationItemDetail;
@Repository("quotationdao")
public class QuotationDaoImp implements QuotationDao{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addQPoDtail(PoQuotationDetail pqd) {
		sessionFactory.getCurrentSession().save(pqd);
		
	}

	@Override
	public void addQPoItemDtail(PoQuotationItemDetail poqid) {
		sessionFactory.getCurrentSession().save(poqid);
		
	}

	@Override
	public List<PoQuotationDetail> viewQuotation() {
		
		return sessionFactory.getCurrentSession().createCriteria(PoQuotationDetail.class).addOrder(Order.desc("qodate")).list();
	}

}
