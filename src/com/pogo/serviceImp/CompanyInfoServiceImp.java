package com.pogo.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.dao.CompanyInfoDao;
import com.pogo.model.CompanyInfo;
import com.pogo.service.CompanyInfoService;
@Service("companyservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CompanyInfoServiceImp implements CompanyInfoService{

	@Autowired
	private CompanyInfoDao companyInfodao;

	@Override
	public void addCompany(CompanyInfo company) {
		companyInfodao.addCompany(company);
		
	}
}
