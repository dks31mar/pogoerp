package com.pogo.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.bean.ContactBean;
import com.pogo.dao.LeadGenerationContactDao;
import com.pogo.dao.MasterOrganizationDao;
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

}
