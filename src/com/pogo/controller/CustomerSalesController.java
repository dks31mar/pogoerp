package com.pogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pogo.bean.CountryBean;
import com.pogo.bean.CustomerLevelsBean;
import com.pogo.bean.CustomerSalesBean;
import com.pogo.bean.DesignationBean;
import com.pogo.bean.DistrictBean;
import com.pogo.bean.LocationBean;
import com.pogo.bean.StateBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.service.CustomerSalesService;
import com.pogo.service.MasterMastersService;
import com.pogo.service.MasterOrganizationService;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerSalesController 
{
	@Autowired
	private CustomerSalesService customerSalesService;
	@Autowired
	private MasterOrganizationService empServive;
	@Autowired
	private MasterMastersService masterService;
	
@RequestMapping(value="/getSales",method=RequestMethod.GET)
public String getCustomerPage(Model model) throws ParseException
{
	List<UserEmployeeBean> emp =empServive.getUserDetails(); 
	model.addAttribute("listemp", emp);
	List<CountryBean> country=masterService.countryDetails();
	model.addAttribute("countrylist", country);
	List<CustomerLevelsBean> cusStatus=masterService.getCustomersStatus();
	model.addAttribute("cusStatus", cusStatus);
	List<LocationBean> locationlist=masterService.getLocationDetails();
	model.addAttribute("locList", locationlist);
	return "getSales";
}
@RequestMapping(value="/saveCustomer", method=RequestMethod.POST)
public String saveCustomer(@ModelAttribute("customerSalesBean") CustomerSalesBean customerSalesBean,BindingResult result )throws ParseException
{
	customerSalesService.addCustomerSales(customerSalesBean);
	return "redirect:/getSales";
	
}
@RequestMapping(value = "/getstate/{id}", method = RequestMethod.POST)
public @ResponseBody String getState(@PathVariable("id") int id,
		HttpServletRequest request, Model model)
		throws JsonProcessingException {
    List<StateBean> list=masterService.getStateByCountryId(id); 
	System.out.println(list);
	ObjectMapper mapper = new ObjectMapper();

	return mapper.writeValueAsString(list);
}

@RequestMapping(value = "/getdistrictList/{id}/{countryId}", method = RequestMethod.POST)
public @ResponseBody String getDistrict(@PathVariable("id") int id,
		@PathVariable("countryId") int countryId,
		HttpServletRequest request, Model model)
		throws JsonProcessingException {

	List<DistrictBean> list = masterService.getDistrictByStateIdAndcountryId(id,
			countryId);
	System.out.println(list.size());
	System.out.println("I am on controller");
	ObjectMapper mapper = new ObjectMapper();
	return mapper.writeValueAsString(list);
}


@RequestMapping(value="/getSalesList", method=RequestMethod.GET)
public String getSalesList(Model model)
{
	List<CustomerSalesBean> salesList=customerSalesService.findAllData();
	model.addAttribute("salesList", salesList);
	return "getSalesList";
}

}
