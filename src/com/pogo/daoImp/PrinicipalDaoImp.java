package com.pogo.daoImp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.PrinicipalDao;
import com.pogo.model.CustomerLevels;
import com.pogo.model.PoRefEntryItemDetail;
import com.pogo.model.PoRefEntryItemDetailCopy;
import com.pogo.model.PorefSupplierDetail;
import com.pogo.model.ProductAcknowledgement;
import com.pogo.model.ProductMaster;
@Repository("prinicipaldao")
@SuppressWarnings("unchecked")
public class PrinicipalDaoImp implements PrinicipalDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ProductMaster> getPartNo(ProductMaster pm) {
		String hint=pm.getProductname();
		hint=hint+"%";
	Criteria r=	sessionFactory.getCurrentSession().createCriteria(ProductMaster.class).add(Restrictions.like("productname", hint)).setProjection(Projections.property("productname"));

	
	List<ProductMaster> list=	(List<ProductMaster>)r.list();
	System.out.println(list);
		return list;
	}

	@Override
	public List<ProductMaster> getproductDetail(ProductMaster pm) {
	
		ProjectionList projList=Projections.projectionList();
		projList.add(Projections.property("description"));
		projList.add(Projections.property("costprice"));
		projList.add(Projections.property("unitprice"));
		Criteria r=	sessionFactory.getCurrentSession().createCriteria(ProductMaster.class).add(Restrictions.eq("productname", pm.getProductname())).setProjection(Projections.distinct(projList));
		List list=r.list();
		
		return list;
	}

	@Override
	public void addPoDetails(PoRefEntryItemDetail poRefEntry) {
		System.out.println(poRefEntry.getPorefentryitemdetailid());
		sessionFactory.getCurrentSession().flush();
		if(poRefEntry.getPorefentryitemdetailid()==null){
		sessionFactory.getCurrentSession().save(poRefEntry);
		sessionFactory.getCurrentSession().flush();
		}else {
			sessionFactory.getCurrentSession().update(poRefEntry);
			sessionFactory.getCurrentSession().flush();
		}
	}

	
	@Override
	public List<PoRefEntryItemDetailCopy> proList() {
		sessionFactory.getCurrentSession().flush();
		return (List<PoRefEntryItemDetailCopy>) sessionFactory.getCurrentSession().createCriteria(PoRefEntryItemDetailCopy.class).list();
	}

	@Override
	public void deleteProduct(PoRefEntryItemDetailCopy prepareModel) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM PoRefEntryItemDetailCopy WHERE porefentryitemdetailid = "+prepareModel.getPorefentryitemdetailid()).executeUpdate();
		sessionFactory.getCurrentSession().flush();
		
	}

	
	@Override
	public List<PoRefEntryItemDetailCopy> getProductEdit(int particular) {
		sessionFactory.getCurrentSession().flush();
	List<PoRefEntryItemDetailCopy> list=sessionFactory.getCurrentSession().createCriteria(PoRefEntryItemDetailCopy.class).add(Restrictions.eq("porefentryitemdetailid", particular)).list();
	System.out.println(""+list.iterator().next().getParticular());	
	return  list;
	}

	@Override
	public void savePo() {
		sessionFactory.getCurrentSession().createSQLQuery("insert into pogodb.porefentryitemdetail Select * from pogodb.porefentryitemdetailcopy").executeUpdate();
		
	}

	@Override
	public void getTotal(HttpServletRequest res) {
	Integer total=(Integer)	sessionFactory.getCurrentSession().createCriteria(PoRefEntryItemDetailCopy.class).setProjection(Projections.sum("totaljpy")).uniqueResult();
	
	System.out.println("&&&&&&&&&&&&&&&&            &&&&&&                        "+total);
	
	}

	@Override
	public Object getGrantTotal(HttpServletRequest res) {
		
		return (Integer)sessionFactory.getCurrentSession().createCriteria(PoRefEntryItemDetailCopy.class).setProjection(Projections.sum("totaljpy")).uniqueResult();
	}

	@Override
	public void addPoSupplier(PorefSupplierDetail porefs) {
		
		sessionFactory.getCurrentSession().save(porefs);
		
	}

	@Override
	public List<PorefSupplierDetail> getSupplierlist() {
		
		return (List<PorefSupplierDetail>) sessionFactory.getCurrentSession().createCriteria(PorefSupplierDetail.class).list();
	}

	@Override
	public List<PoRefEntryItemDetail> getPoDetailByPorefNo(String poref) {
		return  sessionFactory.getCurrentSession().createCriteria(PoRefEntryItemDetail.class).add(Restrictions.eq("porefnobysupplier.porefno",poref)).list();
		/*System.out.println("seasrcgh");
		Criteria poentry=sessionFactory.getCurrentSession().createCriteria(PoRefEntryItemDetail.class);
		Criteria supplier=poentry.createAlias("porefnobysupplier","po");
		supplier.add(Restrictions.eq("po.porefno", poref));
		List<PoRefEntryItemDetail> list=poentry.list();*/
		
		
		//return sessionFactory.getCurrentSession().createCriteria(PoRefEntryItemDetail.class).add(Restrictions.eq("porefnobysupplier.porefno", poref)).list();
	}

	@Override
	public void updatePoSupplier(PorefSupplierDetail porefsup) {
		
		sessionFactory.getCurrentSession().merge(porefsup);
	}

	@Override
	public PorefSupplierDetail getidbyporefnumber(String s) {
	PorefSupplierDetail d=	(PorefSupplierDetail) sessionFactory.getCurrentSession().get(PorefSupplierDetail.class, s);
	
	return d;
	}

	@Override
	public void deletePoById(PoRefEntryItemDetail poref) {
	
		sessionFactory.getCurrentSession().delete(poref);
		
	}

	@Override
	public List<PoRefEntryItemDetail> getPoDetailByPorefId(String poref) {
		int id=Integer.parseInt(poref);
		
		return (List<PoRefEntryItemDetail>) sessionFactory.getCurrentSession().createCriteria(PoRefEntryItemDetail.class).add(Restrictions.eq("porefentryitemdetailid", id)).list();
	}

	@Override
	public List<PoRefEntryItemDetail> getackDetailByPorefNo(String poref) {
		return  sessionFactory.getCurrentSession().createCriteria(PoRefEntryItemDetail.class).add(Restrictions.eq("porefnobysupplier.porefno",poref)).list();
	}

	@Override
	public ProductAcknowledgement getPendindQty(String porefNo, String particular) {
		ProductAcknowledgement pa=(ProductAcknowledgement) sessionFactory.getCurrentSession().createCriteria(ProductAcknowledgement.class).add(Restrictions.eq("porefno", porefNo)).add(Restrictions.eq("particular", particular)).uniqueResult();
		return pa;
	}
	
	
}
