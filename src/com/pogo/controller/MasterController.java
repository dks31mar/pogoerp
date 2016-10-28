package com.pogo.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pogo.bean.CompanyInfoBean;
import com.pogo.bean.PoRefEntryItemDetailCopyBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.model.CompanyInfo;
import com.pogo.model.PoRefEntryItemDetailCopy;
import com.pogo.model.UserEmployee;



import com.pogo.model.Zones;
import com.pogo.service.CompanyInfoService;
import com.pogo.service.RegionService;

import com.pogo.service.UserEmployeeService;
@Controller
public class MasterController 
{
	@Autowired
	private UserEmployeeService userEmployeeservice;
	@Autowired
	private RegionService regionService;
	@Autowired
	private CompanyInfoService companyservice;
	@RequestMapping(value="/getuseremp",method = RequestMethod.GET)
	
	public ModelAndView getUserEmp(UserEmployee userEmployee,
			HttpServletRequest request)
	{
	List<UserEmployeeBean> list=new ArrayList<UserEmployeeBean>();
	list=userEmployeeservice.getUserDetails();
	Map<String, Object> model= new HashMap<String,Object>();
	model.put("userlist", list);
	
		return new ModelAndView("getuseremp",model);
}
	//for add employee
	@RequestMapping(value = "/saveuserEmp", method = RequestMethod.POST) 
	public String saveDetails(Model model,
			@ModelAttribute("userbean") UserEmployeeBean userDTO) throws ParseException
	{
		userEmployeeservice.adduserEmp(userDTO);
		return "redirect:getuseremp";

	}
	
	// for Edit data fetch
	@RequestMapping(value = "/editUserdetails", method = RequestMethod.GET)
	public String editCity(@RequestParam("id") Integer id, Model model,
			HttpServletRequest request) {
		model.addAttribute("cityDTO", new UserEmployeeBean());
		UserEmployeeBean cityDTO = userEmployeeservice.getUserById(id);
		//model.addAttribute("cityName", cityDTO.getCityName());
		
		model.addAttribute("id", id);
		
		return "editUserdetails";
	}

	
	
	@RequestMapping(value = "deleteuser", method = RequestMethod.POST)
	public String deleteuserEmpData(@RequestParam("userempid") int id) {
		userEmployeeservice.deleteuserEmp(id);
		return "getuseremp";
	}
	//search
	@RequestMapping(value = "searchEmployee", method = RequestMethod.POST)
	public @ResponseBody String filterEmpployee(@RequestParam String loginname)
			throws JsonProcessingException {
		List<UserEmployeeBean> userbean = userEmployeeservice.getUser(loginname);
		//System.out.println(userbean);
		ObjectMapper map = new ObjectMapper();
		return map.writeValueAsString(userbean);
	}

	@RequestMapping(value="/region",method = RequestMethod.GET)
	public ModelAndView getRegion(Zones porefitem,HttpServletRequest request){
	
		List<Zones> getbranch=new ArrayList<Zones>();
		getbranch=regionService.getBranches();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("branchList",  getbranch);
		return new ModelAndView("region",model);
}
	@RequestMapping(value="/savecompanyinfo",method = RequestMethod.POST)
	public ModelAndView getCompanyInfo(@ModelAttribute("command") CompanyInfoBean companyInfo,HttpServletRequest request,BindingResult result){
	
		CompanyInfo company = prepareModel(companyInfo);
		//PoRefEntryItemDetailCopy poRefEntrycopy = prepareModelCopy(porefitem);
		companyservice.addCompany(company);
		return new ModelAndView("Profile");
}
	private CompanyInfo prepareModel(CompanyInfoBean companyinfo) {
		CompanyInfo comp=new CompanyInfo();
		
		//System.out.println(porefitem.getPorefentryitemdetailid());
			comp.setCompanyinfoid (companyinfo.getCompanyinfoid());
			comp.setCompanyinfoname(companyinfo.getCompanyinfoname());
	    
			comp.setCompanyinfocontactperson(companyinfo.getCompanyinfocontactperson());
			comp.setCompanyinfocontactno(companyinfo.getCompanyinfocontactno());
	    
			comp.setCompanyinfophone(companyinfo.getCompanyinfophone());
			comp.setCompanyinfofax(companyinfo.getCompanyinfofax());
			comp.setCompanyinfoemail(companyinfo.getCompanyinfoemail());
	    
			comp.setCompanyinfovattin(companyinfo.getCompanyinfovattin());
			comp.setCompanyinfocstno(companyinfo.getCompanyinfocstno());
			comp.setCompanyinfopan(companyinfo.getCompanyinfopan());
			comp.setCompanyinfoservicetaxno(companyinfo.getCompanyinfoservicetaxno());
	    
	    
			comp.setCompanyinfoweb(companyinfo.getCompanyinfoweb());
			comp.setCompanyinfotermsandconditions(companyinfo.getCompanyinfotermsandconditions());
			comp.setCompanyinfoaddress(companyinfo.getCompanyinfoaddress());
			comp.setCompanylogo(companyinfo.getCompanylogo());
		//poref.setPorefentrycopy(porefitem);;
		
		return comp;
	}

	

	
}