package com.pogo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pogo.bean.AddEmailListBean;
import com.pogo.service.LeadGenerationCampaignsService;

@Controller
public class LeadGenerationCampaignsController {
	@Autowired LeadGenerationCampaignsService service ;
	
	@RequestMapping(value = "/newemailcampaign" , method = RequestMethod.GET)
    public ModelAndView newMailCampaign(){
		System.out.println("enter in new mail campaign");
		List<AddEmailListBean> emaillist = new ArrayList<AddEmailListBean>();
		emaillist = service.mailList();
		Map<String , Object> model = new HashMap<String , Object>();
		model.put("list",emaillist);
		return new ModelAndView("getemaillist");
	}
	@RequestMapping(value = "/saveemail" , method = RequestMethod.POST)
	public ModelAndView saveEmail(@ModelAttribute("email") AddEmailListBean emailbean , BindingResult bind ){
		System.out.println("save method of new mail campaign");
		service.addemail(emailbean);
		return new ModelAndView("addEmailList");
	}
}
