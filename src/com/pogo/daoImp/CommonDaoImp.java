package com.pogo.daoImp;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.CommonDao;
import com.pogo.model.PorefSupplierDetail;
@Repository("commondao")
@SuppressWarnings("rawtypes")
public class CommonDaoImp implements CommonDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void getPoReFNo(HttpServletRequest request,PorefSupplierDetail porefId) {
		
		sessionFactory.getCurrentSession().flush();
		
		
		Criteria criteria = sessionFactory.getCurrentSession()
			    .createCriteria(PorefSupplierDetail.class).add(Restrictions.like("porefno","%/CBW-%"))
			    .setProjection(Projections.max("porefsupplierdetailid"));
			String maxval = (String)criteria.uniqueResult();
			System.out.println(maxval);
			
			Criteria criteria1 = sessionFactory.getCurrentSession()
				    .createCriteria(PorefSupplierDetail.class).add(Restrictions.not(Restrictions.like("porefno","%/CBW-%" )))
				    .setProjection(Projections.max("porefsupplierdetailid"));
				String maxval2= (String)criteria1.uniqueResult();
			System.out.println(maxval2);
	Criteria r=	sessionFactory.getCurrentSession().createCriteria(PorefSupplierDetail.class).
			add(Restrictions.eq("porefsupplierdetailid", maxval)).
							add(Restrictions.like("porefno","%/CBW-%" )).setProjection(Projections.max("porefno"));
	
	
	
	Criteria r2=	sessionFactory.getCurrentSession().createCriteria(PorefSupplierDetail.class)
			.add(Restrictions.eq("porefsupplierdetailid", maxval2))
			.add(Restrictions.not(Restrictions.like("porefno","%/CBW-%" )))
			.setProjection(Projections.max("porefno"));
	
	List list1=r2.list();
	List list=r.list();
	Iterator itr=list.iterator();
	Iterator itr1=list1.iterator();
	
	String CBW=(String) itr.next();
	String s2=null;
	String s3=null;
	String normal=(String)itr1.next();
	try{
	if(CBW.contains("CBW")){
		String data=CBW.split("/")[2];
		int i=Integer.parseInt(data.split("-")[1]);
		s2=CBW.split("/")[0]+"/"+CBW.split("/")[1]+"/"+"CBW"+"-"+(i+1);
	}else {
		int i=Integer.parseInt(CBW.split("/")[2]);
		s2=CBW.split("/")[0]+"/"+CBW.split("/")[1]+"/"+"0"+(i+1);
	}
}catch(Exception ex){
		
	}
	try{
	if(normal.contains("CBW")){
		String data=normal.split("/")[2];
		int i=Integer.parseInt(data.split("-")[1]);
		s3=normal.split("/")[0]+"/"+normal.split("/")[1]+"/"+"CBW"+"-"+(i+1);
	}else {
		int i=Integer.parseInt(normal.split("/")[2]);
		s3=normal.split("/")[0]+"/"+normal.split("/")[1]+"/"+"0"+(i+1);
	}
	}catch(Exception ex){
		
	}
	HttpSession session=request.getSession();
	session.setAttribute("normal", s3);
	session.setAttribute("CBW", s2);
	
	}
	/************************************************** use by shweta ***************************************************/
	@SuppressWarnings("unchecked")
	@Override
	public List<PorefSupplierDetail> viewList(){
		sessionFactory.getCurrentSession().flush();
		return (List<PorefSupplierDetail>) sessionFactory.getCurrentSession().createCriteria(PorefSupplierDetail.class).addOrder(Order.desc("porefdate")).list();
	}
	/************************************************** use by shweta ***************************************************/
}

