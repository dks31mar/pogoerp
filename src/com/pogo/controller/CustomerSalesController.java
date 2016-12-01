package com.pogo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pogo.bean.AddActionBean;
import com.pogo.bean.AddDiaryBean;
import com.pogo.bean.AddFollowUpBean;
import com.pogo.bean.CountryBean;
import com.pogo.bean.CustomerLevelsBean;
import com.pogo.bean.CustomerSalesBean;
import com.pogo.bean.DistrictBean;
import com.pogo.bean.LocationBean;
import com.pogo.bean.StateBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.service.CustomerSalesService;
import com.pogo.service.MasterMastersService;
import com.pogo.service.MasterOrganizationService;
import com.sun.java.swing.plaf.motif.resources.motif;

import java.text.ParseException;
import java.util.List;

@Controller
public class CustomerSalesController {
	@Autowired
	private CustomerSalesService customerSalesService;
	@Autowired
	private MasterOrganizationService empServive;
	@Autowired
	private MasterMastersService masterService;

	@RequestMapping(value = "/getSales", method = RequestMethod.GET)
	public String getCustomerPage(Model model) throws ParseException {
		List<UserEmployeeBean> emp = empServive.getUserDetails();
		model.addAttribute("listemp", emp);
		List<CountryBean> country = masterService.countryDetails();
		model.addAttribute("countrylist", country);
		List<CustomerLevelsBean> cusStatus = masterService.getCustomersStatus();
		model.addAttribute("cusStatus", cusStatus);
		List<LocationBean> locationlist = masterService.getLocationDetails();
		model.addAttribute("locList", locationlist);
		return "getSales";
	}

	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customerSalesBean") CustomerSalesBean customerSalesBean,
			BindingResult result) throws ParseException {
		customerSalesService.addCustomerSales(customerSalesBean);
		return "redirect:/getSales";

	}

	@RequestMapping(value = "/getstate/{id}", method = RequestMethod.POST)
	public @ResponseBody String getState(@PathVariable("id") int id, HttpServletRequest request, Model model)
			throws JsonProcessingException {
		List<StateBean> list = masterService.getStateByCountryId(id);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(list);
	}
	@RequestMapping(value = "/getdistrictLists/{id}", method = RequestMethod.POST)
	public @ResponseBody String getDistrict(@PathVariable("id")int id, HttpServletRequest request)
			throws JsonProcessingException {
		List<DistrictBean> list1 = masterService.getDistrictByStateIdAndcountryId(id);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(list1);	
	}


	@RequestMapping(value = "/getSalesList", method = RequestMethod.GET)
	public String getSalesList(Model model) {
		List<CustomerSalesBean> salesList = customerSalesService.findAllData();
		model.addAttribute("salesList", salesList);
		return "getSalesList";
	}

	@RequestMapping(value = "/editcustomer", method = RequestMethod.GET)
	public String editcustomerData(@RequestParam("id") int id, Model model) throws ParseException 
	{
	 model.addAttribute("editcustomers",customerSalesService.getCustomerDetailsById(id));
	    List<UserEmployeeBean> emp = empServive.getUserDetails();
		model.addAttribute("listemp", emp);
		List<CountryBean> country = masterService.countryDetails();
		model.addAttribute("countrylist", country);
		List<CustomerLevelsBean> cusStatus = masterService.getCustomersStatus();
		model.addAttribute("cusStatus", cusStatus);
		List<LocationBean> locationlist = masterService.getLocationDetails();
		model.addAttribute("locList", locationlist);
		return "editcustomer";
	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public String updatecustomer(@ModelAttribute("customerSalesBean") CustomerSalesBean customerSalesBean)
			throws ParseException {
		customerSalesService.upadtecustomerData(customerSalesBean);
		return "updateCustomer";
	}

	@RequestMapping(value = "/addDiaryForEntrySales", method = RequestMethod.GET)
	public ModelAndView getAddDiaryForEntery(Model model,@RequestParam int id) throws ParseException {
		 List<UserEmployeeBean> emp = empServive.getUserDetails();
		model.addAttribute("listemp", emp);
		CustomerSalesBean salesList = customerSalesService.getCustomerDetailsById(id);
		model.addAttribute("salesList", salesList);
		return new ModelAndView("AddDiaryForEntrySales");
	}

	@RequestMapping(value = "/saveDiaryForEntrySales", method = RequestMethod.POST)
	public String saveDiaryForEntery(@ModelAttribute("addDiaryBean") AddDiaryBean addDiaryBean) 
	{
		customerSalesService.savediary(addDiaryBean);
        return "AddDiaryForEntrySales";
	}

	@RequestMapping(value = "/createQuotation", method = RequestMethod.GET)
	public ModelAndView CreateQuotation() {

		return new ModelAndView("CreateQuotationForm");
	}

	@RequestMapping(value = "/addFollowup", method = RequestMethod.GET)
	public ModelAndView AddFollowup(Model model) 
	{
		List<CustomerSalesBean> salesList = customerSalesService.findAllData();
		model.addAttribute("salesList", salesList);
		List<AddActionBean> actionlist=masterService.findAllAction();
		model.addAttribute("actionList", actionlist);
		return new ModelAndView("AddFollowupForm");
	}
	
	@RequestMapping(value="/savefollowup", method=RequestMethod.POST)
	public String addfollowup(@ModelAttribute("addFollowUpBean")AddFollowUpBean addFollowUpBean,BindingResult result)
	{
		customerSalesService.addFollowup(addFollowUpBean);
		return "AddFollowupForm";
	}
	@RequestMapping(value="/attachFiles", method=RequestMethod.GET)
   public String attachFiles()
   {
		return "attachfiles";
   }
	@RequestMapping(value="/getCustomerRecord", method=RequestMethod.POST)
	public @ResponseBody String getCustomerData(@PathVariable("id") int id,HttpServletRequest request)throws JsonProcessingException
	{
		List<CustomerSalesBean> list=customerSalesService.findAllDataById(id);
		System.out.println(list.size());
		ObjectMapper map=new ObjectMapper();
		return map.writeValueAsString(list);
		
	}
	
}
