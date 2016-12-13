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
import com.pogo.bean.AddEmailListBean;
import com.pogo.bean.ContactBean;
import com.pogo.dao.LeadGenerationContactDao;
import com.pogo.dao.MasterOrganizationDao;
import com.pogo.model.AddEmailList;
import com.pogo.model.Contact;
import com.pogo.model.Department;
import com.pogo.service.LeadGenerationContactService;

@Service("contactservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LeadGenerationContactServiceImpl implements LeadGenerationContactService {

	@Autowired LeadGenerationContactDao contactdao ;
	@Autowired
	private MasterOrganizationDao userEmpdao;
	
	@Override
	@Transactional
	public void saveContacts(ContactBean bean1) {


		
		Contact c = new Contact();
		c.setContactId(bean1.getContactId());
		c.setContactName(bean1.getContactName());

		c.setDeptName(userEmpdao.getDep(bean1.getDepId()));
		c.setDesName(userEmpdao.getDesgById(bean1.getDesId()));
		

		

		c.setPhone(bean1.getPhone());
		c.setContemail(bean1.getContemail());
		c.setDob(bean1.getDob());
		c.setDoa(bean1.getDoa());


		

		contactdao.saveContacts(c);
		
	}

	@Override
	public List<ContactBean> getcontactlist() {
		List<Contact> contactlist = contactdao.getcontactlist();
		List<ContactBean> list = new ArrayList<ContactBean>();
		for(Contact c:contactlist){
			ContactBean bean = new ContactBean();
			bean.setContactId(c.getContactId());
			bean.setContactName(c.getContactName());
			System.out.println("@@@@@@@@@@&&&&&&&&&&&&&^^^^^^^^^^^*********");
			//System.out.println("department list *****************************"+c.getDeptName().getDepName());

			//bean.setDeptName1(c.getDeptName().getDepName());
			//bean.setDesName(c.getDesName().getDesignation());

			bean.setDeptName1(c.getDeptName().getDepName());
		//bean.setDesName(c.getDesName().getDesignation());

			bean.setDob(c.getDob());
			list.add(bean);
			
			
			
		}
		return list;
	}

	@Override
	public void deleteContacts(int id) {
		contactdao.deleteContacts(id);
		
	}

	@Override
	public String getContactsDetails(String id) {
		
		List<Contact> contacts = contactdao.getContactsDetails(id);
		Map<String,Object> model = new HashMap<String,Object>();
		for(Contact list : contacts){
			model.put("contactId", list.getContactId());
			model.put("contactName", list.getContactName());
		//	model.put("deptName1",list.getDeptName1() );
			//model.put("desName", list.getDesName());
			model.put("dob", list.getDob());
			
			
		}
		
		Gson gson = new Gson();
		String emaillist = gson.toJson(model);
		return emaillist;
	}

	@Override
	public void editContactsDetails(ContactBean bean) {
		Contact list = new Contact();
		list.setContactId(bean.getContactId());
		list.setContactName(bean.getContactName());
		//list.setDeptName(bean.getDeptName1());
		//list.setDesName(bean.getDesName());
		
		contactdao.editContactsDetails(list);
		
	}
	

	
}
