package com.pogo.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.PrinicipalDao;
import com.pogo.model.PoRefEntryItemDetail;
import com.pogo.model.PoRefEntryItemDetailCopy;
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
		projList.add(Projections.property("productdescription"));
		projList.add(Projections.property("costprice"));
		projList.add(Projections.property("unitprice"));
		Criteria r=	sessionFactory.getCurrentSession().createCriteria(ProductMaster.class).add(Restrictions.eq("productname", pm.getProductname())).setProjection(Projections.distinct(projList));
		List list=r.list();
		
		return list;
	}

	@Override
	public void addPoDetails(PoRefEntryItemDetailCopy poRefEntry) {
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

	

	/*@Override
	public PoRefEntryItemDetail getProductEdit(int particular) {
		
		return (PoRefEntryItemDetail) sessionFactory.getCurrentSession().get(PoRefEntryItemDetail.class, particular);
	}*/
	
	@Override
	public List<PoRefEntryItemDetailCopy> getProductEdit(int particular) {
		sessionFactory.getCurrentSession().flush();
	List<PoRefEntryItemDetailCopy> list=sessionFactory.getCurrentSession().createCriteria(PoRefEntryItemDetailCopy.class).add(Restrictions.eq("porefentryitemdetailid", particular)).list();
	System.out.println(""+list.iterator().next().getParticular());	
	//sessionFactory.getCurrentSession().get(PoRefEntryItemDetail.class, particular);
		
		return  list;
	}

	@Override
	public void savePo() {
		sessionFactory.getCurrentSession().createSQLQuery("insert into pogodb.porefentryitemdetail Select * from pogodb.porefentryitemdetailcopy").executeUpdate();
		
	}
	
	
}
