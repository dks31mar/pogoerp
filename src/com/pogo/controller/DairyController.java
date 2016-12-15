package com.pogo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.itextpdf.text.log.SysoCounter;
import com.pogo.bean.CustomerSalesBean;
import com.pogo.bean.ExpenseEntryBean;
import com.pogo.bean.JsonArraytoJson;
import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.bean.PoRefEntryItemDetailCopyBean;
import com.pogo.bean.PorefSupplierDetailBean;
import com.pogo.bean.ProductMasterBean;
import com.pogo.bean.TeamSegmentBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.model.ExpenseMaster;
import com.pogo.service.CustomerSalesService;
import com.pogo.service.MasterMastersService;

@Controller
public class DairyController {
	
	@Autowired CustomerSalesService customerService;
	
	@Autowired MasterMastersService masterservice;
	
	
@RequestMapping(value = "/getexpenseentery" , method = RequestMethod.GET)
	public ModelAndView getExpenseEntery(Model model){
		
		
		
		Map<String , Object> m = new HashMap<String , Object>();
		return new ModelAndView("expenseentry" , m);
	}
	
	/*@RequestMapping(value = "/getorganisationautolist" , method = RequestMethod.GET)
	public  void organisationlist(HttpServletResponse res  )throws JsonProcessingException{
		
		System.out.println("inside get organisation method"); 
	String	organisationname = customerService.findAllDataById();
		System.out.println(organisationname); 
		
		 try {
				res.getWriter().print(organisationname);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
	}

	@RequestMapping(value = "/getorganisationdetail" , method = RequestMethod.GET)
	public void getOrganisationDetailById(@RequestParam("organization") String organization,HttpServletResponse res,ProductMasterBean productmasetr) {
		String organisation=customerService.getCustomerdatabyCompanyName(organization);
		System.out.println(organisation); 
		   try {
				res.getWriter().print(organisation);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		   }
	*/
	@RequestMapping(value = "/getexpenseautolist" , method = RequestMethod.GET)
	public  void expenseAutoList(HttpServletResponse res  )throws JsonProcessingException{
		
		System.out.println("inside get expense auto list method"); 
		
		/*List<ExpenseMaster> list = new ArrayList<ExpenseMaster>();*/
		String  list = masterservice.expenseListAuto();
		System.out.println("@@@@@@@@@@@@@expense head list@@@@@@@@@@@@@"+list); 
		//System.out.println("On controller Expense data"+ list.size());
		 try {
				res.getWriter().print(list);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
	}

	@RequestMapping(value = "/getunitbyexpensehead" , method = RequestMethod.GET)
	public void getunitByexpense(@RequestParam("expensehead") String expense,HttpServletResponse res) {
		 
		System.out.println("inside get unit by expense head"); 
		
	String expensedetail=masterservice.getUnitByExpense(expense);
	String getpart1=expensedetail.replaceAll("\\[", "");
	getpart1=getpart1.replaceAll("\\]", "");
System.out.println(getpart1);
		System.out.println(expensedetail); 
		   try {
				res.getWriter().print(expensedetail);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		   }
	
	/*@RequestMapping(value="saveexpenseentry",method=RequestMethod.POST)
	@ResponseBody
	public void addTeam(@RequestBody String json,Model model ,  HttpServletRequest res) throws IOException{
		
	System.out.println("********************inside save expense  method **************\n"+json);
		ObjectMapper mapper=new ObjectMapper();
		ExpenseEntryBean poref=mapper.readValue(json, ExpenseEntryBean.class);
		
		masterservice.saveExpenseEntry(poref);
	}*/
	
	@RequestMapping(value = "getexpensereport" , method = RequestMethod.GET )
    public ModelAndView getExpenseReport(HttpServletRequest reuest ){
		
		List<ExpenseEntryBean> list = new ArrayList<ExpenseEntryBean>();
		list = masterservice.getExpenseReportList();
		Map<String , Object > model = new HashMap<String , Object>();
		model.put("listofexpensereport",list );
		List<UserEmployeeBean> accountmanagerlist = new ArrayList<UserEmployeeBean>();
		accountmanagerlist = masterservice.getAccountManagerList();
		model.put("listofaccountmanager",accountmanagerlist );
		return new ModelAndView("expensereport",model);
	}
	
	@RequestMapping(value = "/saveexpensereport", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")

	public ModelAndView saveExpenseReport(@RequestParam("startdate") String sdate,@RequestParam("enddate") String edate ,@RequestParam ("selectmanager") String manager,@ModelAttribute("command")  ExpenseEntryBean expense, HttpServletRequest res,BindingResult result) {
		
		
		System.out.println("start date **************" +sdate);
		System.out.println("start date **************" +manager);
		List<UserEmployeeBean> accountmanagerlist = new ArrayList<UserEmployeeBean>();
		accountmanagerlist = masterservice.getAccountManagerList();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("listofaccountmanager",accountmanagerlist );
		List<ExpenseEntryBean> list = new ArrayList<ExpenseEntryBean>();
		list = masterservice.getExpenseReportListByDate(sdate , edate);
		
		model.put("listofexpensereport",list );
		System.out.println("expense detail list**************"+list);
		List<UserEmployeeBean> accountmanagerlist12 = new ArrayList<UserEmployeeBean>();
		accountmanagerlist12 = masterservice.accountManagerListBySelect(manager);
		model.put("listofaccountmanager",accountmanagerlist12 );
		return new ModelAndView("expensereport", model);

	}
@RequestMapping(value = "/expensereportdetails",method = RequestMethod.GET)
public ModelAndView getExpenseReportDetails(HttpServletRequest reuest){
	List<ExpenseEntryBean> list = new ArrayList<ExpenseEntryBean>();
	list = masterservice.getExpenseReportList();
	Map<String , Object > model = new HashMap<String , Object>();
	model.put("listofexpensereport",list );
	return new ModelAndView("expensereportdetails",model);
}

}


