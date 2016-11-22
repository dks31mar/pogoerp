package com.pogo.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.pogo.bean.AddAddressBean;
import com.pogo.bean.AddEmailListBean;
import com.pogo.dao.LeadGenerationCampaignsDao;
import com.pogo.model.AddAddress;
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
	email.setStatus("N");
	System.out.println(bean.getName());
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
		System.out.println(el.getStatus());
		list1.add(beanlist);
	}
	
	return list1;
}

@Override
public void deleteEmail(int id) {
	dao.deleteEmail(id);
	
}

@Override
@Transactional
public String getEmail(String id) {
	List<AddEmailList> email = dao.getEmail(id);
	Map<String,Object> model = new HashMap<String,Object>();
	for(AddEmailList list : email){
		model.put("emaillistid", list.getEmaillistid());
		model.put("emaillist", list.getEmaillist());
		model.put("creationdate",list.getCreationdate() );
		model.put("empid", list.getEmpid());
		model.put("name", list.getName());
		model.put("status", list.getStatus());
		
	}
	
	Gson gson = new Gson();
	String emaillist = gson.toJson(model);
	return emaillist;
}

@Override
@Transactional
public void editEmail(AddEmailListBean listbean) {
	AddEmailList list = new AddEmailList();
	list.setName(listbean.getName());
	list.setStatus("N");
	list.setEmaillist(listbean.getEmaillist());
	list.setEmaillistid(listbean.getEmaillistid());
	System.out.println(listbean.getEmaillistid());
	dao.editEmail(list);
	
}

@Override
public List<AddAddressBean> addAddressList() {
	List<AddAddress> modellist = dao.addAddressList();
	List<AddAddressBean> list1 = new ArrayList<AddAddressBean>();
	for(AddAddress el:modellist){
		AddAddressBean beanlist = new AddAddressBean();
		beanlist.setId(el.getId());
		beanlist.setName(el.getName());
		beanlist.setemail(el.getemail());
		beanlist.setFax(el.getFax());
		
		System.out.println(el.getName());
		list1.add(beanlist);
	}
	
	return list1;
	
}
@Override
@Transactional
	public void addaddress(AddAddressBean bean){
	
	AddAddress info = new AddAddress();
	info.setId(bean.getId());
	info.setName(bean.getName());
	info.setemail(bean.getemail());
	info.setFax(bean.getFax());
	dao.addaddress(info);
}

@Override
public void deleteAddress(int id) {
	dao.deleteAddress(id);
	
}

@Override
@Transactional
public String getAddress(String id) {
	List<AddAddress> email = dao.getAddress(id);
	Map<String,Object> model = new HashMap<String,Object>();
	for(AddAddress list : email){
		model.put("id", list.getId());
		model.put("name", list.getName());
		model.put("email",list.getemail() );
		model.put("fax", list.getFax());
		
		
	}
	
	Gson gson = new Gson();
	String emaillist = gson.toJson(model);
	return emaillist;
}

@Override
public void editAddress(AddAddressBean listbean) {
	AddAddress list = new AddAddress();
	list.setId(listbean.getId());
	list.setName(listbean.getName());
	list.setemail(listbean.getemail());
	list.setFax(listbean.getFax());
	System.out.println("inside add address service impl ");
	dao.editAddress(list);
	System.out.println("outside add address service impl ");
}
}
