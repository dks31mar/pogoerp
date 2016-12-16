package com.pogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StockController {


@RequestMapping(value="stockdetails", method=RequestMethod.GET)
	 public ModelAndView  stockdetails()
	 {
		 return  new ModelAndView("stockdetails");
	 }

@RequestMapping(value="stockinvoicedetails", method=RequestMethod.GET)
	 public ModelAndView  stockinvoicedetails()
	 {
		 return  new ModelAndView("stockinvoicedetails");
	 }

@RequestMapping(value="addseriallotno", method=RequestMethod.GET)
	 public ModelAndView  viewaddserialno()
	 {
		 return  new ModelAndView("addseriallotno");
	 }
//list of stock from productstock 
@RequestMapping(value="viewstock", method=RequestMethod.GET)
	 public ModelAndView  viewstockList()
	 {
	
	
		 return  new ModelAndView("viewstock");
	 }


}
