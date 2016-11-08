package com.pogo.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.MasterProductDao;
import com.pogo.model.Currency;
import com.pogo.model.ProductHead;
import com.pogo.model.ProductMaster;
import com.pogo.model.ProductSubHead;
import com.pogo.model.Unit;
import com.pogo.model.UserEmployee;

@SuppressWarnings("unchecked")
@Repository("masterProductDao")
public class MasterProductDaoImp implements MasterProductDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Currency> getCurrencyData() {
		
		return (List<Currency>)sessionFactory.getCurrentSession().createCriteria(Currency.class).list();
	}

	@Override
	public void addCurrency(Currency cur) {
		sessionFactory.getCurrentSession().save(cur);
		
	}

	@Override
	public void deleteCurrency(int id) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Currency WHERE currencyid = "+id).executeUpdate();
		
	}

	@Override
	public List<Currency> getCurrency(String id) {
		
		int f=Integer.parseInt(id);
		
		return (List<Currency>) sessionFactory.getCurrentSession().createCriteria(Currency.class)
				.add(Restrictions.eq("currencyid", f)).list();
	}

	@Override
	public void editCurrency(Currency cur) {
		System.out.println("doa method");
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().update(cur);
	}

	@Override
	public List<Unit> getUnitsData() {
		
		return (List<Unit>)sessionFactory.getCurrentSession().createCriteria(Unit.class).list();
	}

	@Override
	public void addUnit(Unit cur) {
		
		sessionFactory.getCurrentSession().save(cur);
	}

	@Override
	public void deleteUnit(int id) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Unit WHERE unittypeid = "+id).executeUpdate();
	}

	
	@Override
	public List<Unit> getUnitById(String id) {
int f=Integer.parseInt(id);
		
		return (List<Unit>) sessionFactory.getCurrentSession().createCriteria(Unit.class)
				.add(Restrictions.eq("unittypeid", f)).list();
	}

	@Override
	public void editUnit(Unit cur) {
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().update(cur);
		sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public List<ProductHead> getProductHeadData() {
		return (List<ProductHead>)sessionFactory.getCurrentSession().createCriteria(ProductHead.class).list();
	}

	@Override
	public void addProductHead(ProductHead cur) {
		sessionFactory.getCurrentSession().save(cur);
		
	}

	@Override
	public void deleteProductHead(int id) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ProductHead WHERE productheadid = "+id).executeUpdate();
		
	}

	@Override
	public void editProductHead(ProductHead cur) {
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().update(cur);
		sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public List<ProductHead> getProductHeadById(String id) {
		int f=Integer.parseInt(id);
		
		return (List<ProductHead>) sessionFactory.getCurrentSession().createCriteria(ProductHead.class)
				.add(Restrictions.eq("productheadid", f)).list();
	}

	@Override
	public void addProductSubHead(ProductSubHead cur) {
		
		sessionFactory.getCurrentSession().save(cur);
	}

	@Override
	public List<ProductMaster> getProData() {
		return (List<ProductMaster>)sessionFactory.getCurrentSession().createCriteria(ProductMaster.class).list();
	}

	@Override
	public void deleteProductData(int id) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ProductMaster WHERE productid = "+id).executeUpdate();
		
	}

	@Override
	public List<ProductMaster> searchProData(String proname) {
		Criteria c= sessionFactory.getCurrentSession().createCriteria(ProductMaster.class);
			Criterion pmane= Restrictions.like("productname", proname+"%");
			Criterion pcode= Restrictions.eq("productcode",proname+"%");
		 
		 return c.add(Restrictions.or(pmane, pcode)).list();
	}

	@Override
	public List<ProductSubHead> getProductSubHeadData() {
		
		return (List<ProductSubHead>)sessionFactory.getCurrentSession().createCriteria(ProductSubHead.class).list();
	}

	@Override
	public void saveproductdetail(ProductMaster promaster) {
		sessionFactory.getCurrentSession().save(promaster);
		
	}

	
	
}
