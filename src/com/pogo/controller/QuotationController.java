package com.pogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

 @Controller
public class QuotationController {

	 @RequestMapping(value="quotation",method=RequestMethod.GET)
	 public ModelAndView quotation() {
		 return  new ModelAndView("quotation");
		 
		
	}
	 @RequestMapping(value="createOrder", method=RequestMethod.GET)
	 public ModelAndView  CreateOrder()
	 {
		 return  new ModelAndView("createOrder");
	 }
	 
	 @RequestMapping(value="/viewQuotation", method=RequestMethod.GET)
	 public ModelAndView  viewQuotation()
	 {
		 
		 return  new ModelAndView("viewQuotation");
	 }
	 
 }
 
 
	 

