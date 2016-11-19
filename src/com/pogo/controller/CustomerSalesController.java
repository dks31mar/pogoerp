package com.pogo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pogo.bean.PoRefEntryItemDetailBean;

@Controller
public class CustomerSalesController 
{
@RequestMapping(value="/getSales",method=RequestMethod.GET)
public String getCustomerPage(Model model)
{
	
	return "getSales";
}
@RequestMapping(value="/getSalesList", method=RequestMethod.GET)
public String getSalesList(Model model)
{
	return "getSalesList";
}
@RequestMapping(value="/AddDiaryForEntrySales",method = RequestMethod.GET)
public ModelAndView getAddDiaryForEntery()
		{

return new ModelAndView("AddDiaryForEntrySales");
}
}
