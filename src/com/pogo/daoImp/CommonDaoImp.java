package com.pogo.daoImp;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.pogo.dao.CommonDao;
import com.pogo.model.PorefSupplierDetail;
import com.pogo.model.ProductMaster;
@Repository("commondao")
public class CommonDaoImp implements CommonDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void getPoReFNo(HttpServletRequest request,PorefSupplierDetail porefId) {
		String hint="b%";
		sessionFactory.getCurrentSession().flush();
	Criteria r=	sessionFactory.getCurrentSession().createCriteria(PorefSupplierDetail.class).
							add(Restrictions.like("porefno","%/CBW-%" )).setProjection(Projections.max("porefno"));
	
	
	
	Criteria r2=	sessionFactory.getCurrentSession().createCriteria(PorefSupplierDetail.class)
			.add(Restrictions.not(Restrictions.like("porefno","%/CBW-%" )))
			.setProjection(Projections.max("porefno"));
	
	List list1=r2.list();
	List list=r.list();
	Iterator itr=list.iterator();
	Iterator itr1=list1.iterator();
	
	String CBW=(String) itr.next();
	String normal=(String)itr1.next();
	HttpSession session=request.getSession();
	session.setAttribute("normal", normal);
	session.setAttribute("CBW", CBW);
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PorefSupplierDetail> viewList(){
		sessionFactory.getCurrentSession().flush();
		return (List<PorefSupplierDetail>) sessionFactory.getCurrentSession().createCriteria(PorefSupplierDetail.class).list();
	}
}
