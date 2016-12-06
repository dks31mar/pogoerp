package com.pogo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pogo.bean.CustomerSalesBean;
import com.pogo.service.CustomerSalesService;

@Controller
public class DairyController {
	
	@Autowired CustomerSalesService customerService;
	
	@RequestMapping(value = "/getexpenseentery" , method = RequestMethod.GET)
	public ModelAndView getExpenseEntery(Model model){
		
		
		
		Map<String , Object> m = new HashMap<String , Object>();
		return new ModelAndView("expenseentry" , m);
	}
	
	@RequestMapping(value = "/getorganisation" , method = RequestMethod.GET)
	public  void organisationlist(@RequestParam("word") String word,HttpServletResponse res ,CustomerSalesBean bean ){
		bean.setOrganisation(word);


	String	organisationname = customerService.getOrganisationname(bean);
		System.out.println(organisationname); 
		
		 try {
				res.getWriter().print(organisationname);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		
		
	}

}
