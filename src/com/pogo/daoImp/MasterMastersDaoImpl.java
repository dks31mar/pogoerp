package com.pogo.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.MasterMastersDao;
import com.pogo.model.CustomerLevels;
import com.pogo.model.PorefSupplierDetail;
@Repository("masterMastersdao")
public class MasterMastersDaoImpl  implements  MasterMastersDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<CustomerLevels> customerLevelsList(){
		sessionFactory.getCurrentSession().flush();
		return (List<CustomerLevels>) sessionFactory.getCurrentSession().createCriteria(CustomerLevels.class).list();
	}
}
