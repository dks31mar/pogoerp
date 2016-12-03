package com.pogo.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.bean.ContactBean;
import com.pogo.dao.LeadGenerationContactDao;
import com.pogo.model.Contact;
import com.pogo.service.LeadGenerationContactService;

@Service("contactservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LeadGenerationContactServiceImpl implements LeadGenerationContactService {

	@Autowired LeadGenerationContactDao contactdao ;
	
	@Override
	@Transactional
	public void saveContacts(ContactBean bean1) {
		Contact c = new Contact();
		c.setConid(bean1.getConid());
		c.setName(bean1.getName());
		c.setDepartment(bean1.getDepartment());
		c.setDesignation(bean1.getDesignation());
		c.setPhone(bean1.getPhone());
		c.setEmail(bean1.getEmail());
		c.setDob(bean1.getDob());
		c.setDoa(bean1.getDoa());
		contactdao.saveContacts(c);
		
	}

}
