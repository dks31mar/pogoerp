package com.pogo.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
@Controller
public class ReportController {

	@Autowired
	private CustomerSalesService CustomerSalesService;

	@RequestMapping(value="pendingThingsTo",method = RequestMethod.GET)
	public ModelAndView getPendigTasks(Model model,@RequestParam int id,@RequestParam("planid") String planId)
	{
		List<AddDiaryBean> list=CustomerSalesService.getDiaryList(id,planId);
		model.addAttribute("diaryList",list );
		String empname=null;
		for(AddDiaryBean d:list){
			empname=d.getEnteryuser();
		}
		model.addAttribute("empname", empname);
	     return new ModelAndView("pendingThingsto");
	}
	@RequestMapping(value="/editdiary",method=RequestMethod.GET)
	public String getdata(Model model,@RequestParam int id)
	{
		model.addAttribute("diarydata", CustomerSalesService.editdiaryrecord(id));
		return "editdiary";
	}
	@RequestMapping(value="updatediary",method=RequestMethod.POST)
	public String diaryData(@ModelAttribute("addDiaryBean") AddDiaryBean addDiaryBean)
	{
		CustomerSalesService.updateDiaryData(addDiaryBean);
		return "redirect:/pendingThingsTo";
		
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
		
	     return "followups";
	}
	
	@RequestMapping(value="/salesFunnel",method = RequestMethod.GET)
	public ModelAndView salesFunnel(Model model){
	List<CustomerSalesBean> list= CustomerSalesService.findlistRecord();
	model.addAttribute("customerdata",list );
	return new ModelAndView("salesFunnel");
			
}

}