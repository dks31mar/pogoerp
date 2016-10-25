package com.pogo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.service.CommonService;

@Controller
public class CommonController {

	@Autowired
	private CommonService commonservice;
	
	@RequestMapping(value="/getaddpo",method = RequestMethod.GET)
	public ModelAndView getPage(@ModelAttribute("productadd") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){
	
		commonservice.getPoRefNo(request);
	
	return new ModelAndView("AddPrinicpalPO");
			
}
}
