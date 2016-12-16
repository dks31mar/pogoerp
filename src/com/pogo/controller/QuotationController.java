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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pogo.bean.JsonArraytoJson;
import com.pogo.bean.PoQuotationDetailBean;
import com.pogo.bean.PoQuotationItemDetailBean;
import com.pogo.model.PoQuotationItemDetail;
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
	 
	 
	 @RequestMapping(value="getquotationlistbyid", method=RequestMethod.GET)
	 public ModelAndView  getQuotationByref(@RequestParam("qporef") String qporef,@RequestParam("qpoid") String qpoid,Model model)
	 {
		 
		 List<PoQuotationItemDetailBean> list=quotationservice.getQuotationByref(qporef);
		 List<String> list2=new ArrayList<String>();
		 String comapnyname="";
		 String adress="";
		 String date="";
		 String days="";
		 String email="";
		 String term1="",term2="",term3="",term4="",term5="",term6="",term7="",term8="",term9="",term10="",total="";
		 for(PoQuotationItemDetailBean b:list){
			comapnyname=b.getPoquotationdetail().getCustname();
			email=b.getPoquotationdetail().getEmail();
			date=b.getPoquotationdetail().getQodate();
			days=b.getPoquotationdetail().getQovalid();
			adress=b.getPoquotationdetail().getAddress();
			term1=b.getPoquotationdetail().getTerms1();
			term2=b.getPoquotationdetail().getTerms2();
			term3=b.getPoquotationdetail().getTerms3();
			term4=b.getPoquotationdetail().getTerms4();
			term5=b.getPoquotationdetail().getTerms5();
			term6=b.getPoquotationdetail().getTerms6();
			term7=b.getPoquotationdetail().getTerms7();
			term8=b.getPoquotationdetail().getTerms8();
			term9=b.getPoquotationdetail().getTerms9();
			term10=b.getPoquotationdetail().getTerms10();
			total=Double.toString(b.getPoquotationdetail().getNettotal());
		 }
		 for(PoQuotationItemDetailBean b:list){
			 String des=quotationservice.getproductdesbypro(b.getPartno());
			 list2.add(des);
		 }
		 model.addAttribute("total",total);
		 model.addAttribute("term1",term1);
		 model.addAttribute("term2",term2);
		 model.addAttribute("term3",term3);
		 model.addAttribute("term4",term4);
		 model.addAttribute("term5",term5);
		 model.addAttribute("term6",term6);
		 model.addAttribute("term7",term7);
		 model.addAttribute("term8",term8);
		 model.addAttribute("term9",term9);
		 model.addAttribute("term10",term10);
		 
		 model.addAttribute("email",email);
		 model.addAttribute("adress",adress);
		 model.addAttribute("customername",comapnyname);
		 model.addAttribute("date",date);
		 model.addAttribute("days",days);
		 model.addAttribute("poref1",qporef);
		 model.addAttribute("list",list);
		 model.addAttribute("list2",list2);
		 
		 return  new ModelAndView("getquotaionbyid");
	 }
	 
	 
	 
	 
	 @RequestMapping(value="updatequotation",method=RequestMethod.POST)
	 @ResponseBody
	 public void updateQuotationUsingAjax(@RequestBody String json,Model model) throws IOException{
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

	 		for(int i=0;i<meth.length;i=i+25){
	 			PoQuotationDetailBean poqd=new PoQuotationDetailBean();
	 			PoQuotationItemDetailBean poqid=new PoQuotationItemDetailBean();
	 			
	 			if(meth[i].isEmpty()==false){
	 			poqid.setPoquotationitemdetailid(Integer.parseInt(meth[i]));
	 			}
	 			poqid.setPartno(meth[i+1]);
	 			poqid.setUtprice(Double.parseDouble(meth[i+2]));
	 			poqid.setDisc(Double.parseDouble(meth[i+3]));
	 			poqid.setNetprice(Double.parseDouble(meth[i+4]));
	 			poqid.setQty(Integer.parseInt(meth[i+5]));
	 			poqid.setTotal(Double.parseDouble(meth[i+6]));
	 			poqid.setDelivery(meth[i+7]);
	 			poqd.setCustname(meth[i+8]);
	 			poqd.setQorefno(meth[i+9]);
	 			poqd.setAddress(meth[i+10]);
	 			poqd.setEmail(meth[i+11]);
	 			poqd.setQodate(meth[i+12]);
	 			poqd.setQovalid(meth[i+13]);
	 			poqd.setNettotal(Double.parseDouble(meth[14]));
	 			poqd.setTerms1(meth[15]);
	 			poqd.setTerms2(meth[16]);
	 			poqd.setTerms3(meth[17]);
	 			poqd.setTerms4(meth[18]);
	 			poqd.setTerms5(meth[19]);
	 			poqd.setTerms6(meth[20]);
	 			poqd.setTerms7(meth[21]);
	 			poqd.setTerms8(meth[22]);
	 			poqd.setTerms9(meth[23]);
	 			poqd.setTerms10(meth[24]);
	 			
	 			if(i==0){
					System.out.println("inside if    "+i);
					quotationservice.updateQPoDtail(poqd);
					quotationservice.deleteAllQPoItemDtail(poqd,poqid);
					quotationservice.updateQPoItemDtail(poqd,poqid);
					
				}else{
					quotationservice.updateQPoItemDtail(poqd,poqid);
					}
				}
	 			
	 		
	 			
	 }
	 
 }
 
 
	 

