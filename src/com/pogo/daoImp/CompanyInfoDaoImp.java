package com.pogo.daoImp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.CompanyInfoDao;
import com.pogo.model.CompanyInfo;
@Repository("companyInfodao")
public class CompanyInfoDaoImp implements CompanyInfoDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCompany(CompanyInfo company) {
		
		sessionFactory.getCurrentSession().save(company);
		sessionFactory.getCurrentSession().flush();
		
	}
}
