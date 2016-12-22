package com.pogo.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pogo.bean.CustomerSalesPoDetailsBean;
import com.pogo.bean.PoQuotationDetailBean;
import com.pogo.bean.ProductMasterBean;
import com.pogo.service.QuotationService;

@Controller
public class CustomerPOController 
{
	@Autowired
	private QuotationService quotationService;
	
	@RequestMapping(value="getCustomerPo", method=RequestMethod.GET)
	public String getcusPo(Model model)
	{
		return "getCustomerPo";
	}

	@RequestMapping(value = "/getQuationList", method = RequestMethod.GET)
	public void getCustomerData(HttpServletResponse request) throws JsonProcessingException {
		String list = quotationService.findAllDataOfQuation();
     System.out.println(list);
		try {
			request.getWriter().print(list);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/getQuotationNo", method = RequestMethod.GET)
	public void getCustomerdatabyCompanyName(@RequestParam("qorefno") String qorefno,
			HttpServletResponse res,PoQuotationDetailBean poQuotationDetailBean) 
	{
		String getQuo=quotationService.getCustomerdatabyCompanyName(qorefno);
	    String getpart1=getQuo.replaceAll("\\[", "");
		getpart1=getpart1.replaceAll("\\]", "");
	System.out.println(getpart1);
	   try {
			res.getWriter().print(getQuo);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	   
		}
	
	
	
	
	
	@RequestMapping(value = "savecustmerpo", method = RequestMethod.POST)
	@ResponseBody
	public void savecustomerpodata(
			HttpServletResponse res,PoQuotationDetailBean poQuotationDetailBean,HttpServletRequest req) 
	{
		
	String d1=	req.getParameter("particulee");
	String d2=	req.getParameter("producttype");
	String []d3=	req.getParameterValues("description");
	String d4=	req.getParameter("stockqty"); 
	String d5=	req.getParameter("unitprice");
	String d6=	req.getParameter("disc");
	String d7=	req.getParameter("netprice");
	String d8=	req.getParameter("qty");
	String d9=	req.getParameter("totaljpy");
	String d10=	req.getParameter("customerporefe");
CustomerSalesPoDetailsBean bean=new CustomerSalesPoDetailsBean();
		for(int i=0;i<d3.length;i++){
	bean.setDescriptions(d3);
		}
		
		for(int j=0;j<d3.length;j++){
			System.out.println(bean.getDescriptions().toString());
		}
	   
		}	
	
}
