package com.pogo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

@RequestMapping(value="/SaveDiaryForEntrySales",method = RequestMethod.POST)
@ResponseBody
public void SaveDiaryForEntery(@RequestBody String json, Model model) throws IOException 
{
	//System.out.println("print diary data \n",+json);
	//CustomerSalesService.SaveDiaryForEntery();
	
	
	
}

@RequestMapping(value="/CreateQuotationForm",method = RequestMethod.GET)
public ModelAndView CreateQuotation()
		{

return new ModelAndView("CreateQuotationForm");
}
@RequestMapping(value="/AddFollowupForm",method = RequestMethod.GET)
public ModelAndView AddFollowup()
		{

return new ModelAndView("AddFollowupForm");
}
@RequestMapping(value="/editCustomerForm",method = RequestMethod.GET)
public ModelAndView EditCustomer()
		{

return new ModelAndView("editCustomerForm");
}

}
