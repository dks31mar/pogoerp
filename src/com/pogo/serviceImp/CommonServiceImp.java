package com.pogo.serviceImp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.dao.CommonDao;
import com.pogo.model.PorefSupplierDetail;
import com.pogo.service.CommonService;
@Service("commonservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CommonServiceImp implements CommonService{

	@Autowired
	private	CommonDao commondao;

	@Override
	public void getPoRefNo(HttpServletRequest request) {
		PorefSupplierDetail porefId=new PorefSupplierDetail();
		commondao.getPoReFNo(request,porefId);
		
	}
}
