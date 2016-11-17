package com.pogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerSalesController 
{
@RequestMapping(value="/getSales",method=RequestMethod.GET)
public String getCustomerPage(Model model)
{
	
	return "getSales";
}

}
