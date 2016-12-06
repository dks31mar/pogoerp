package com.pogo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pogo.bean.AddEmailListBean;
import com.pogo.bean.ContactBean;
import com.pogo.bean.CustomerLevelsBean;
import com.pogo.bean.DepartmentBean;
import com.pogo.bean.DesignationBean;
import com.pogo.service.LeadGenerationContactService;
import com.pogo.service.MasterOrganizationService;

@Controller
public class LeadGenerationContactController {
	
	@Autowired LeadGenerationContactService contactservice;
	
	@Autowired MasterOrganizationService empServive;
	
	@RequestMapping(value = "/getcontact" ,method = RequestMethod.GET)
	public ModelAndView contact(Model  model){
		List<DepartmentBean> list = new ArrayList<DepartmentBean>();
		list = empServive.getDepartmentDetails();
		model.addAttribute("depList", list);
		List<DesignationBean> list1 = new ArrayList<DesignationBean>();
		list1 = empServive.GetDesignationList();
		Map<String , Object> m = new HashMap<String , Object>();
		System.out.println("list1 is "+list1);
		m.put("Dlist",list1);
		List<ContactBean> contactlist = new ArrayList<ContactBean>();
		contactlist = contactservice.getcontactlist();
		m.put("contactlist", contactlist);
		return new ModelAndView("contact" ,m);
	}

	@RequestMapping(value = "/savecontact123" ,method = RequestMethod.POST)
	@ResponseBody
	public void savecontact(@RequestBody String json , Model model) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		ContactBean bean = mapper.readValue(json, ContactBean.class);
		System.out.println("value is *********************"+json);
		
		//ContactBean bean1 = new ContactBean();
		contactservice.saveContacts(bean);
		
	}
	
	
	
	
}
