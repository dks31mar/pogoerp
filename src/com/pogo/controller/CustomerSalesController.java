package com.pogo.controller;


import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pogo.bean.AddDiaryBean;
import com.pogo.bean.CountryBean;
import com.pogo.bean.CustomerLevelsBean;
import com.pogo.bean.CustomerSalesBean;
import com.pogo.bean.DistrictBean;
import com.pogo.bean.LocationBean;
import com.pogo.bean.StateBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.bean.ZonesBean;
import com.pogo.service.CustomerSalesService;
import com.pogo.service.MasterMastersService;
import com.pogo.service.MasterOrganizationService;

import java.text.ParseException;
import java.util.List;



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
	ObjectMapper mapper = new ObjectMapper();
	return mapper.writeValueAsString(list);
}

@RequestMapping(value = "/getdistrict/{id}", method = RequestMethod.GET)
public @ResponseBody String getDistrict(@PathVariable("id") int id,
		HttpServletRequest request, Model model)
		throws JsonProcessingException {
	List<DistrictBean> list = masterService.getDistrictByStateIdAndcountryId(id);
			
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

@RequestMapping(value="/editcustomer", method=RequestMethod.GET)
public String editcustomerData(Model model,@RequestParam int id)
{
	model.addAttribute("editcustomer",customerSalesService.getCustomerDetailsById(id));
	return "editcustomer";
}



@RequestMapping(value="/AddDiaryForEntrySales",method = RequestMethod.GET)
public ModelAndView getAddDiaryForEntery()
		{


return new ModelAndView("AddDiaryForEntrySales");
}

@RequestMapping(value="/SaveDiaryForEntrySales",method = RequestMethod.POST)
@ResponseBody
public void SaveDiaryForEntery(@RequestBody String json, Model model) throws IOException 
{
	//System.out.println("print diary data \n",+json);


	System.out.println("Add zone data   \n" + json);
	ObjectMapper mapper = new ObjectMapper();
	AddDiaryBean adddiary = mapper.readValue(json, AddDiaryBean.class);

	AddDiaryBean poref1 = new AddDiaryBean();

	//CustomerSalesService.SaveDiaryForEntery(adddiary);
}

@RequestMapping(value="/CreateQuotationForm",method = RequestMethod.GET)
public ModelAndView CreateQuotation()
		{

return new ModelAndView("CreateQuotationForm");
}
@RequestMapping(value="/AddFollowupForm",method = RequestMethod.GET)
public ModelAndView AddFollowup()
		{

return new ModelAndView("AddFollowupForm");
}
@RequestMapping(value="/editCustomerForm",method = RequestMethod.GET)
public ModelAndView EditCustomer()
		{

return new ModelAndView("editCustomerForm");
}

}
