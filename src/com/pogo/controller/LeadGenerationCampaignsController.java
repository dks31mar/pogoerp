package com.pogo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pogo.bean.AddAddressBean;
import com.pogo.bean.AddEmailListBean;
import com.pogo.service.LeadGenerationCampaignsService;

@Controller
public class LeadGenerationCampaignsController {
	@Autowired LeadGenerationCampaignsService service ;
	
	@RequestMapping(value = "/newemailcampaign" , method = RequestMethod.GET)
    public ModelAndView newMailCampaign(){
		System.out.println("enter in new mail campaign");
		List<AddEmailListBean> emaillist = new ArrayList<AddEmailListBean>();
		emaillist = service.mailList();
		Map<String , Object> model = new HashMap<String , Object>();
		model.put("Elist",emaillist);
		return new ModelAndView("getemaillist",model);
	}
	
	
	
	@RequestMapping(value = "/addemail" , method = RequestMethod.GET)
    public ModelAndView addEmail(){
		System.out.println("enter in new mail campaign");
		List<AddEmailListBean> emaillist = new ArrayList<AddEmailListBean>();
		emaillist = service.mailList();
		Map<String , Object> model = new HashMap<String , Object>();
		model.put("list",emaillist);
		return new ModelAndView("addemaillist",model);
	}
	@RequestMapping(value = "/saveemail" , method = RequestMethod.POST)
	public ModelAndView saveEmail(@RequestBody String json , Model model  )throws IOException{
		System.out.println("save method of new mail campaign");
		ObjectMapper mapper = new ObjectMapper();
		AddEmailListBean listbean = mapper.readValue(json,AddEmailListBean.class );
		
		System.out.println(listbean.getName()); 
		
		service.addemail(listbean);
		return new ModelAndView("addemaillist");
	}
	@RequestMapping(value = "/deleteemail" , method = RequestMethod.GET)
	public ModelAndView deleteEmail(@RequestParam("emaillistid") int id){
		System.out.println("enter in delete method controller ");
		
		service.deleteEmail(id);
		List<AddEmailListBean> emaillist = new ArrayList<AddEmailListBean>();
		emaillist = service.mailList();
		Map<String , Object> model = new HashMap<String,Object>();
		model.put("list", emaillist);
		return new ModelAndView("addemaillist",model);
	}
	
	@RequestMapping(value = "/getemail" , method = RequestMethod.POST)
	public void getEmail(@RequestParam("emaillistid") String id,HttpServletResponse res)throws ParseException{
		String cuList=service.getEmail(id);
		System.out.println(cuList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(cuList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("outside get email list method");
		
	}
	
	@RequestMapping(value = "/editmail" , method = RequestMethod.POST)
	@ResponseBody
	public void editEmail(@RequestBody String json , Model model) throws IOException{
		System.out.println("inside editemail method controller");
		ObjectMapper mapper = new ObjectMapper();
		AddEmailListBean listbean = mapper.readValue(json, AddEmailListBean.class);
		System.out.println(listbean.getEmaillist());
		service.editEmail(listbean);
		
	}
	
	@RequestMapping(value = "/addaddress" , method = RequestMethod.GET)
	public ModelAndView address(){
		List<AddAddressBean> list = new ArrayList<AddAddressBean>();
		list = service.addAddressList();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("addresslist", list);
		return new ModelAndView("getaddress",model);
	}
	
	@RequestMapping(value = "/saveaddress" , method = RequestMethod.POST)
	public ModelAndView saveAddress(@RequestBody String json , Model model  )throws IOException{
		System.out.println("save method in controller for save address");
		ObjectMapper mapper = new ObjectMapper();
		AddAddressBean listbean = mapper.readValue(json,AddAddressBean.class );
		
		System.out.println(listbean.getName()); 
		
		service.addaddress(listbean);
		return new ModelAndView("getaddress");
	}
	@RequestMapping(value = "/deleteaddress", method = RequestMethod.GET)
	public ModelAndView deleteAddress(@RequestParam("id") int id){
		service.deleteAddress(id);
		List<AddAddressBean> list = new ArrayList<AddAddressBean>();
		list = service.addAddressList();
		Map<String , Object> model = new HashMap<String , Object>();
		model.put("addresslist", list);
		return new ModelAndView("getaddress",model);
	}
	@RequestMapping(value = "/getaddress" , method = RequestMethod.POST)
	public void getAddress(@RequestParam("id") String id,HttpServletResponse res)throws ParseException{
		String cuList=service.getAddress(id);
		System.out.println(cuList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(cuList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("outside get email list method");
		
	}
	
	@RequestMapping(value = "/editaddress" , method = RequestMethod.POST)
	@ResponseBody
	public void editAddress(@RequestBody String json , Model model) throws IOException{
		System.out.println("inside edit address method controller");
		ObjectMapper mapper = new ObjectMapper();
		AddAddressBean listbean = mapper.readValue(json, AddAddressBean.class);
		System.out.println(listbean.getFax());
		service.editAddress(listbean);
		System.out.println("outside edit address method");
		
	}
	
	@RequestMapping(value = "/importcsvfile" , method = RequestMethod.GET)
    public ModelAndView csvfileupload(){
		System.out.println("enter in csv file");
		//List<AddEmailListBean> emaillist = new ArrayList<AddEmailListBean>();
		//emaillist = service.mailList();
		//Map<String , Object> model = new HashMap<String , Object>();
		//model.put("Elist",emaillist);
		return new ModelAndView("getcsvfile");
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

