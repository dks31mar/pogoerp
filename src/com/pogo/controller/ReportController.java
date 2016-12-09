package com.pogo.controller;
import java.text.ParseException;
import java.util.List;

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

import com.pogo.bean.AddPlanBean;
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
		model.addAttribute("empname", empname);
		model.addAttribute("empid", id);
		model.addAttribute("planid", planId);
	     return new ModelAndView("pendingThingsto");
	}
	@RequestMapping(value="/editdiary",method=RequestMethod.GET)
	public String getdata(Model model,@RequestParam("id") int Dairyid,@RequestParam("empid") int id,@RequestParam("planid") String planId) throws ParseException
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
	

}