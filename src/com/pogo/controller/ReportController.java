package com.pogo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.icu.text.SimpleDateFormat;
import com.pogo.bean.AddDiaryBean;
import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.model.AddDiary;
import com.pogo.service.CustomerSalesService;
import com.pogo.service.MasterMastersService;
import com.pogo.service.MasterOrganizationService;

import sun.java2d.pipe.SpanShapeRenderer.Simple;
@Controller
public class ReportController {

	@Autowired
	private CustomerSalesService CustomerSalesService;

	@RequestMapping(value="pendingtasks",method = RequestMethod.GET)
	public ModelAndView getPendigTasks(Model model){
		System.out.println("get the diary data as a list on pending page");
		List<AddDiaryBean> list=CustomerSalesService.getDiaryList();
		model.addAttribute("diaryList",list );
	     return new ModelAndView("pendingtasks");
	}	


@RequestMapping(value="Followups",method = RequestMethod.GET)
public ModelAndView getFollowups(Model model)
{
	SimpleDateFormat date=new SimpleDateFormat("dd-MM-yyyy");
	model.addAttribute("today",  date.format(new Date()));
     return new ModelAndView("Followups");
}	
}