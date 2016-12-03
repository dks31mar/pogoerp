package com.pogo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pogo.bean.ContactBean;
import com.pogo.bean.CustomerLevelsBean;
import com.pogo.service.LeadGenerationContactService;

@Controller
public class LeadGenerationContactController {
	
	@Autowired LeadGenerationContactService contactservice;
	
	
	
	@RequestMapping(value = "/getcontact" ,method = RequestMethod.GET)
	public ModelAndView contact(){
		return new ModelAndView("contact");
	}

	@RequestMapping(value = "/savecontact" ,method = RequestMethod.POST)
	@ResponseBody
	public void savecontact(@RequestBody String json , Model model) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		ContactBean bean = mapper.readValue(json, ContactBean.class);
		ContactBean bean1 = new ContactBean();
		contactservice.saveContacts(bean);
		
	}
	
	
}
