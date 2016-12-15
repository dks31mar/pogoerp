package com.pogo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pogo.bean.JsonArraytoJson;
import com.pogo.bean.PoQuotationDetailBean;
import com.pogo.bean.PoQuotationItemDetailBean;
import com.pogo.service.QuotationService;

 @Controller
public class QuotationController {

	 @Autowired
	 private QuotationService quotationservice;
	 
	 @RequestMapping(value="quotation",method=RequestMethod.GET)
	 public ModelAndView quotation() {
		 return  new ModelAndView("quotation");
		 
		
	}
	 
	 
	 @RequestMapping(value="savequotation",method=RequestMethod.POST)
	 @ResponseBody
	 public void addQuotationUsingAjax(@RequestBody String json,Model model) throws IOException{
	 	System.out.println(json);
	 	Gson gson=new Gson();
	 	JsonArraytoJson [] js=gson.fromJson(json, JsonArraytoJson[].class);
	 	System.out.println(js.length);
	 	List<String> lst=new ArrayList<String>();
	 		for(JsonArraytoJson e:js){
	 			System.out.println(e.getName()+"\t\t\t\t<><><><><><><><>\t"+e.getValue());
	 			lst.add(e.getValue());
	 			}
	 	System.out.println(lst.size());
	 	String [] meth=lst.toArray(new String[lst.size()]);

	 		for(int i=0;i<meth.length;i=i+24){
	 			PoQuotationDetailBean poqd=new PoQuotationDetailBean();
	 			PoQuotationItemDetailBean poqid=new PoQuotationItemDetailBean();
	 			poqid.setPartno(meth[i]);
	 			poqid.setUtprice(Double.parseDouble(meth[i+1]));
	 			poqid.setDisc(Double.parseDouble(meth[i+2]));
	 			poqid.setNetprice(Double.parseDouble(meth[i+3]));
	 			poqid.setQty(Integer.parseInt(meth[i+4]));
	 			poqid.setTotal(Double.parseDouble(meth[i+5]));
	 			poqid.setDelivery(meth[i+6]);
	 			poqd.setCustname(meth[i+7]);
	 			poqd.setQorefno(meth[i+8]);
	 			poqd.setAddress(meth[i+9]);
	 			poqd.setEmail(meth[i+10]);
	 			poqd.setQodate(meth[i+11]);
	 			poqd.setQovalid(meth[i+12]);
	 			poqd.setNettotal(Double.parseDouble(meth[13]));
	 			poqd.setTerms1(meth[14]);
	 			poqd.setTerms2(meth[15]);
	 			poqd.setTerms3(meth[16]);
	 			poqd.setTerms4(meth[17]);
	 			poqd.setTerms5(meth[18]);
	 			poqd.setTerms6(meth[19]);
	 			poqd.setTerms7(meth[20]);
	 			poqd.setTerms8(meth[21]);
	 			poqd.setTerms9(meth[22]);
	 			poqd.setTerms10(meth[23]);
	 			
	 			if(i==0){
					System.out.println("inside if    "+i);
					quotationservice.addQPoDtail(poqd);
					quotationservice.addQPoItemDtail(poqd,poqid);
					
				}else{
					quotationservice.addQPoItemDtail(poqd,poqid);
					}
				}
	 			
	 		
	 			
	 }

	 
	 @RequestMapping(value="createOrder", method=RequestMethod.GET)
	 public ModelAndView  CreateOrder()
	 {
		 return  new ModelAndView("createOrder");
	 }
	 
	 @RequestMapping(value="/viewQuotation", method=RequestMethod.GET)
	 public ModelAndView  viewQuotation(Model model)
	 {
		 List<PoQuotationDetailBean> list=quotationservice.viewQuotation();
		 
		 
		 model.addAttribute("list", list);
		 return  new ModelAndView("viewQuotation");
	 }
	 
 }
 
 
	 

