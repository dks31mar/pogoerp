package com.pogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InvoiceController {
	
 @RequestMapping(value="viewInvoice", method=RequestMethod.GET)
 public  ModelAndView viewInvoice()
  {

	 return  new ModelAndView("viewinvoice");

  }
}


