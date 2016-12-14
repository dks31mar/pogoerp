package com.pogo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;


import java.text.ParseException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;
import com.pogo.bean.AddDiaryBean;
import com.pogo.bean.CustomerSalesBean;
import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.dao.CustomerSalesDao;
import com.pogo.service.CustomerSalesService;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pogo.bean.AddDiaryBean;
import com.pogo.bean.AddFollowUpBean;
import com.pogo.bean.AddPlanBean;
import com.pogo.bean.CustomerSalesBean;
import com.pogo.bean.DesignationBean;
import com.pogo.bean.UserEmployeeBean;

import com.pogo.service.CustomerSalesService;
import com.pogo.service.MasterMastersService;
import com.pogo.service.MasterOrganizationService;

@Controller
public class ReportController {

	@Autowired
	private CustomerSalesService CustomerSalesService;
	@Autowired
	private MasterOrganizationService empServive;
	@Autowired
	private MasterMastersService masterService;

	@RequestMapping(value="pendingThingsTo",method = RequestMethod.GET)
	public ModelAndView getPendigTasks(Model model,@RequestParam("id") int id,@RequestParam("planid") String planId)
	{
		List<AddDiaryBean> list=CustomerSalesService.getDiaryList(id,planId);
		model.addAttribute("diaryList",list );
		String empname=null;
		for(AddDiaryBean d:list){
			empname=d.getEnteryuser();
		}

		if(id!=0)
		model.addAttribute("empname", empname);
		else
			model.addAttribute("empname", "All");

		model.addAttribute("empname", empname);
		model.addAttribute("empid", id);
		model.addAttribute("planid", planId);

	     return new ModelAndView("pendingThingsto");
	}
	@RequestMapping(value="/editdiary",method=RequestMethod.GET)
	public String getdata(Model model,@RequestParam("id") int Dairyid,@RequestParam("empid") 
	int id,@RequestParam("planid") String planId) throws ParseException
	{
		model.addAttribute("diarydata", CustomerSalesService.editdiaryrecord(Dairyid));
		List<UserEmployeeBean> emp = empServive.getUserDetails();
		model.addAttribute("listemp", emp);
		List<AddPlanBean> planlist = masterService.PlanList();
		model.addAttribute("planlist", planlist);
		List<DesignationBean> degList = empServive.GetDesignationList();
		model.addAttribute("designationlist", degList);
		model.addAttribute("empid", id);
		model.addAttribute("planid", planId);
		return "editdiary";
	}
	@RequestMapping(value="updatediary",method=RequestMethod.POST)
	public String diaryData(@ModelAttribute("addDiaryBean") AddDiaryBean addDiaryBean,@RequestParam("empid")
	int id,@RequestParam("planid") String planId,BindingResult result)
	{
		CustomerSalesService.updateDiaryData(addDiaryBean);
		return "redirect:/pendingThingsTo?id="+id+"&planid="+planId;
		
	}
	
	@RequestMapping(value="pendingtasks",method = RequestMethod.GET)
	public String getthingsTo(Model model)
	{
		List<AddDiaryBean> list=CustomerSalesService.getDiaryRecord();
		model.addAttribute("diarydata",list );
	     return "pendingtasks";
	}
	
	@RequestMapping(value="followups",method = RequestMethod.GET)
	public String followUp(Model model)
	{
		//List<AddFollowUpBean> listbean=CustomerSalesService.getFollowUpRecord();
		//model.addAttribute("followupdata", listbean);
	     return "followups";
	}

	
	@RequestMapping(value="getfollowuplistbyuserid",method = RequestMethod.GET)
	@ResponseBody
	public void followUpListByUserId(@RequestParam("sdate") String sdate,@RequestParam("edate") String edate,Model model,HttpServletResponse res) throws IOException
	{
		JSONArray listbean=CustomerSalesService.followUpListByUserId(sdate,edate);
		


		System.out.println(listbean);
		//json = json.replaceAll(",$", "");
		PrintWriter w=res.getWriter();
		w.print(listbean);
	}
	
	
	@RequestMapping(value="getfollowupbyuseridndate1",method = RequestMethod.GET)
	@ResponseBody
	public void getfollowupbyuseridndate1(@RequestParam("empid") String empid,Model model,@RequestParam("sdate") String sdate,@RequestParam("edate") String edate,@RequestParam("day") String day,HttpServletResponse res) throws IOException
	{
		
		System.out.println(empid+"          "+sdate+"            "+edate+"                  "+"                  "+day);
		//List<AddFollowUpBean> desginCode	= CustomerSalesService.getfollowuplistbydatenid1(sdate,edate,empid,day);
		String desginCode	= CustomerSalesService.getfollowuplistbydatenid1(sdate,edate,empid,day);
		PrintWriter w=res.getWriter();
		w.print(desginCode);
		/*System.out.println(dateDif);
		String desginCode	= CustomerSalesService.followUpListByUserId(sdate,edate,dateDif);
		//desginCode="<th></th>";
		PrintWriter w=res.getWriter();
		w.print(desginCode);*/
	}
	
	@RequestMapping(value="getfollowupbyuseridndate",method = RequestMethod.GET)
	
	public String getfollowuplistbydatenid(@RequestParam("empid") String empid,Model model,@RequestParam("sdate") String sdate,@RequestParam("edate") String edate,@RequestParam("day") String day,HttpServletResponse res) throws IOException
	{
		//System.out.println(dateDif);
		List<AddFollowUpBean> desginCode	= CustomerSalesService.getfollowuplistbydatenid(sdate,edate,empid,day);
		//desginCode="<th></th>";
		model.addAttribute("followlist",desginCode);
		return "followupbydatenid";
	}
	@RequestMapping(value="/salesFunnel",method = RequestMethod.GET)
	public ModelAndView salesFunnel(Model model){
	Map<String, String> list= CustomerSalesService.findocountofstatus();
	model.addAttribute("customerdata",list );
	return new ModelAndView("salesFunnel");
			
}
	
}