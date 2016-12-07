package com.pogo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.pogo.bean.AddDiaryBean;
import com.pogo.service.CustomerSalesService;
@Controller
public class ReportController {

	@Autowired
	private CustomerSalesService CustomerSalesService;

	/*@RequestMapping(value="pendingtasks",method = RequestMethod.GET)
	public ModelAndView getPendigTasks(Model model){
		System.out.println("get the diary data as a list on pending page");
		List<AddDiaryBean> list=CustomerSalesService.getDiaryList();
		model.addAttribute("diaryList",list );
	     return new ModelAndView("pendingtasks");
	}	*/
	/*pendingThingsTo*/
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
	

}