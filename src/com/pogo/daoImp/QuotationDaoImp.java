package com.pogo.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.bean.PoQuotationDetailBean;
import com.pogo.bean.PoQuotationItemDetailBean;
import com.pogo.dao.QuotationDao;
import com.pogo.model.PoQuotationDetail;
import com.pogo.model.PoQuotationItemDetail;
import com.pogo.model.ProductMaster;
@Repository("quotationdao")
@SuppressWarnings("unchecked")
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

	
	@Override
	public List<PoQuotationItemDetail> getQuotationByref(String qporef) {
		
		return sessionFactory.getCurrentSession().createCriteria(PoQuotationItemDetail.class).add(Restrictions.eq("poquotationdetail.qorefno", qporef)).list();
	}

	@Override
	public String getproductdesbypro(String partno) {
		// TODO Auto-generated method stub
		return (String) sessionFactory.getCurrentSession().createCriteria(ProductMaster.class).add(Restrictions.eq("productname", partno)).setProjection(Projections.property("description")).uniqueResult();
	}

	@Override
	public void updateQPoItemDtail(PoQuotationItemDetail pqidd) {
		
	sessionFactory.getCurrentSession().save(pqidd);
	sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public void updateQPoDtail(PoQuotationDetail pqd) {
		
		sessionFactory.getCurrentSession().merge(pqd);
	}

	@Override
	public Integer getqupodetailid(String qorefno) {
		
		return (Integer) sessionFactory.getCurrentSession().createCriteria(PoQuotationDetail.class).add(Restrictions.eq("qorefno", qorefno)).setProjection(Projections.property("poquotationdetailid")).uniqueResult();
	}

	@Override
	public void deleteAllQPoItemDtail(PoQuotationDetailBean poqid) {
		sessionFactory.getCurrentSession().createSQLQuery("delete from poquotationitemdetail where qorefno="+poqid.getQorefno()).executeUpdate();
		
	}

}
