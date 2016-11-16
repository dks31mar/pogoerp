package com.pogo.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.bean.AddEmailListBean;
import com.pogo.dao.LeadGenerationCampaignsDao;
import com.pogo.model.AddEmailList;
import com.pogo.service.LeadGenerationCampaignsService;

@Service("service")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LeadGenerationCampaignsServiceImpl implements LeadGenerationCampaignsService {
	@Autowired LeadGenerationCampaignsDao dao;
	
@Override
@Transactional
	public void addemail(AddEmailListBean bean){
	
	AddEmailList email = new AddEmailList();
	email.setName(bean.getName());
	email.setEmaillist(bean.getEmaillist());
	dao.addemail(email);
}

@Override
@Transactional
public List<AddEmailListBean> mailList() {
	List<AddEmailList> modellist = dao.mailList();
	List<AddEmailListBean> list1 = new ArrayList<AddEmailListBean>();
	for(AddEmailList el:modellist){
		AddEmailListBean beanlist = new AddEmailListBean();
		beanlist.setEmaillistid(el.getEmaillistid());
		beanlist.setName(el.getName());
		beanlist.setEmaillist(el.getEmaillist());
		beanlist.setStatus(el.getStatus());
		list1.add(beanlist);
	}
	
	return list1;
}
}
