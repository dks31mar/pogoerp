package com.pogo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
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
import com.pogo.bean.CompanyInfoBean;
import com.pogo.bean.CurrencyBean;
import com.pogo.bean.UnitBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.model.CompanyInfo;
import com.pogo.model.UserEmployee;



import com.pogo.model.Zones;
import com.pogo.service.CompanyInfoService;
import com.pogo.service.MasterProductService;
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
	
	@Autowired
	private MasterProductService masterProductService;
	
	
	@RequestMapping(value="/getuseremp",method = RequestMethod.GET)
	public ModelAndView getUserEmp(@ModelAttribute("userbean") UserEmployee userEmployee,
			HttpServletRequest request)
	{
	List<UserEmployeeBean> list=new ArrayList<UserEmployeeBean>();
	list=userEmployeeservice.getUserDetails();
	Map<String, Object> model= new HashMap<String,Object>();
	model.put("userlist", list);
	
		return new ModelAndView("getuseremp",model);
}
	//for add jsp
	@RequestMapping(value="/addUser",method = RequestMethod.GET)
	public String addEmployee(Model model)
	{
	
		return "addUser";
}
	
	// for edit jsp
@RequestMapping(value="/editUser",method = RequestMethod.GET)
	public String editEmployee(@RequestParam int id, Model model)
	{
	model.addAttribute("employee", userEmployeeservice.getEmployee(id));
	
		return "editUser";
}
  /* @RequestMapping(value="/getuseremp",method = RequestMethod.GET)
	
	public ModelAndView getUserEmp1()	
	{
	List<UserEmployeeBean> list=new ArrayList<UserEmployeeBean>();
	list=userEmployeeservice.getUserDetails();
	Map<String, Object> model= new HashMap<String,Object>();
	model.put("userlist", list);
	
		return new ModelAndView("getuseremp",model);
}*/
	//for add employee
	@RequestMapping(value = "/saveuserEmp", method = RequestMethod.POST) 
	public String saveDetails(Model model,
			@ModelAttribute("userbean") UserEmployeeBean userDTO) throws ParseException
	   {
		userEmployeeservice.adduserEmp(userDTO);
		return "redirect:getuseremp";
		//return new ModelAndView("getuseremp") ;

	}
	
// for Edit data fetch
	/*@RequestMapping(value = "/editUserdetails", method = RequestMethod.GET)
	public void editCity(@RequestParam("userempid") Integer id, @ModelAttribute("userbean")UserEmployeeBean userDTO , BindingResult result,
			HttpServletResponse res) {
		List<UserEmployee> emp = userEmployeeservice.getUserById(id);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(emp);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//return "getuseremp";
	}*/
	/*@RequestMapping(value = "/editEmp", method = RequestMethod.GET)
	public String editEmployee(@RequestParam int id, Model model) {
		model.addAttribute("employee", userEmployeeservice.getEmployee(id));
		System.out.println("employee");
		return "getuseremp";
	}*/

	@RequestMapping(value = "/update-employee", method = RequestMethod.POST)
	public String updateEmployee(
			@ModelAttribute("employeebean") UserEmployeeBean userEmployeeBean)throws ParseException  {
		userEmployeeservice.updateEmployee(userEmployeeBean);
		return "redirect:/getuseremp";
	
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

	/*
	 * Master product
	 * 
	 * currency by dks
	 * */
	
	
	@RequestMapping(value="/currency",method = RequestMethod.GET)
	public ModelAndView getCurrency(@ModelAttribute("currencyBean") CurrencyBean currencyBean,
			HttpServletRequest request){
		List<CurrencyBean> list=new ArrayList<CurrencyBean>();
		list=masterProductService.getCurrencyDetails();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("currencylist", list);
		
			
		
		return new ModelAndView("currency",model);
}

	
	
	@RequestMapping(value="savecurrency",method=RequestMethod.POST)
	@ResponseBody
	public String addCurrency(@RequestBody String json,Model model) throws IOException{
	System.out.println(json);
		ObjectMapper mapper=new ObjectMapper();
		CurrencyBean poref=mapper.readValue(json, CurrencyBean.class);
		CurrencyBean poref1=new CurrencyBean();
		poref1.setCurrencyname(poref.getCurrencyname());
		poref1.setCurrencysymbol(poref.getCurrencysymbol());
		poref1.setCurrencytype(poref.getCurrencytype());
		
		//poref.setPorefentryitemdetailid(null);
		
		
		
		masterProductService.addCurrency(poref1);
		//model.addAttribute("prolist",  prepareListofBean(prinicipalposervice.proList()));
	return toJson(poref1);
	}

	private String toJson(CurrencyBean poRefEntry) {
		ObjectMapper mapper = new ObjectMapper();
	    try {
	        String value = mapper.writeValueAsString(poRefEntry);
	        // return "["+value+"]";
	        return value;
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	@RequestMapping(value = "deletecurrency", method = RequestMethod.GET)
	public ModelAndView deleteuserCurrencyData(@RequestParam("id") int id) {
		masterProductService.deleteCurrency(id);
		List<CurrencyBean> list=new ArrayList<CurrencyBean>();
		list=masterProductService.getCurrencyDetails();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("currencylist", list);
		
			
		
		return new ModelAndView("currency",model);
	}
	
	
	@RequestMapping(value = "getcurrency", method = RequestMethod.POST)
	public void getCurrency(@RequestParam("id") String id,HttpServletResponse res )throws ParseException  {
		String curList=masterProductService.getCurrency(id);
		System.out.println(curList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(curList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	@RequestMapping(value="editcurrency",method=RequestMethod.POST)
	@ResponseBody
	public String editCurrency(@RequestBody String json,Model model) throws IOException{
	System.out.println("Deeoak              *****************************************************");
		ObjectMapper mapper=new ObjectMapper();
		CurrencyBean poref=mapper.readValue(json, CurrencyBean.class);
		CurrencyBean poref1=new CurrencyBean();
		poref1.setCurrencyid(poref.getCurrencyid());
		poref1.setCurrencyname(poref.getCurrencyname());
		poref1.setCurrencysymbol(poref.getCurrencysymbol());
		poref1.setCurrencytype(poref.getCurrencytype());
		
		//poref.setPorefentryitemdetailid(null);
		
		
		
		masterProductService.editCurrency(poref1);
		//model.addAttribute("prolist",  prepareListofBean(prinicipalposervice.proList()));
	return toJson1(poref1);
	}

	private String toJson1(CurrencyBean poRefEntry) {
		ObjectMapper mapper = new ObjectMapper();
	    try {
	        String value = mapper.writeValueAsString(poRefEntry);
	        // return "["+value+"]";
	        return value;
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	@RequestMapping(value="/unit",method = RequestMethod.GET)
	public ModelAndView getUnits(@ModelAttribute("unitBean") UnitBean currencyBean,
			HttpServletRequest request){
		List<UnitBean> list=new ArrayList<UnitBean>();
		list=masterProductService.getUnitsDetails();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("unitlist", list);
		return new ModelAndView("getunit",model);
}
	
	
	@RequestMapping(value="addunit",method=RequestMethod.POST)
	@ResponseBody
	public void addUnit(@RequestBody String json,Model model) throws IOException{
	System.out.println("Deeoak              ***************************************************** \n"+json);
		ObjectMapper mapper=new ObjectMapper();
		UnitBean poref=mapper.readValue(json, UnitBean.class);
		UnitBean poref1=new UnitBean();
		//poref1.setCurrencyid(poref.getCurrencyid());
		poref1.setUnittype(poref.getUnittype());
		
		//poref.setPorefentryitemdetailid(null);
		
		
		
		masterProductService.addUnit(poref1);
		//model.addAttribute("prolist",  prepareListofBean(prinicipalposervice.proList()));
	//return toJson1(poref1);
	}
	
	@RequestMapping(value = "deleteunit", method = RequestMethod.GET)
	public ModelAndView deleteUnitData(@RequestParam("id") int id) {
		masterProductService.deleteUnit(id);
		List<UnitBean> list=new ArrayList<UnitBean>();
		list=masterProductService.getUnitsDetails();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("unitlist", list);
		return new ModelAndView("getunit",model);
	}
	
	
	
	@RequestMapping(value = "getunit", method = RequestMethod.POST)
	public void getUnit(@RequestParam("id") String id,HttpServletResponse res )throws ParseException  {
		String curList=masterProductService.getUnitById(id);
		System.out.println(curList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(curList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	
	
	@RequestMapping(value="editunit",method=RequestMethod.POST)
	@ResponseBody
	public void editUnit(@RequestBody String json,Model model) throws IOException{
	System.out.println("Deeoak              *****************************************************");
		ObjectMapper mapper=new ObjectMapper();
		UnitBean poref=mapper.readValue(json, UnitBean.class);
		UnitBean poref1=new UnitBean();
		poref1.setUnittypeid(poref.getUnittypeid());
		poref1.setUnittype(poref.getUnittype());
		
		masterProductService.editUnit(poref1);
		
	}
}