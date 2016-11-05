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

import com.pogo.bean.DesignationBean;
import com.pogo.bean.CountryBean;
import com.pogo.bean.CurrencyBean;

import com.pogo.bean.UnitBean;

import com.pogo.bean.CustomerLevelsBean;
import com.pogo.bean.DistrictBean;
import com.pogo.bean.ProductHeadBean;
import com.pogo.bean.ProductSubHeadBean;





import com.pogo.bean.StateBean;


import com.pogo.bean.UserEmployeeBean;
import com.pogo.dao.UserEmployeeDao;
import com.pogo.model.CompanyInfo;

import com.pogo.model.Designation;
import com.pogo.model.Country;
import com.pogo.model.CustomerLevels;

import com.pogo.model.State;




import com.pogo.model.UserEmployee;



import com.pogo.model.Zones;
import com.pogo.service.CompanyInfoService;


import com.pogo.service.MasterMastersService;

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
	private UserEmployeeDao empDao;

	
	
	
	
	@Autowired
	private MasterMastersService masterMastersService;
	
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
	/******Designation*******/
@RequestMapping(value="/getdesignation",method = RequestMethod.GET)
	public ModelAndView getUserEmp(Model model)
	{
	List<DesignationBean> list=new ArrayList<DesignationBean>();
	list=userEmployeeservice.getDesignation();
	List<Designation> designation =empDao.getDesignationname();
	Map<String, Object> mode= new HashMap<String,Object>();
	mode.put("designationlist", list);
	model.addAttribute("desig", designation);
	
		return new ModelAndView("designation",mode);
}
@RequestMapping(value = "/saveDesignation", method = RequestMethod.POST) 
public String saveDetails(Model model,
		@ModelAttribute("designationbean") DesignationBean designationBean)
   {
	userEmployeeservice.adddDesignation(designationBean);
	//List<Designation> listDesignation=userEmployeeservice.getListbylevel();
	return "redirect:getdesignation";
}
	
/*@RequestMapping(value = "authority", method = RequestMethod.GET)
public @ResponseBody
String designationList(Model model, @RequestParam String designation)
		throws JsonProcessingException {
	List<String> designList = userEmployeeservice.findDataByDesignation(designation);
	Map<String, Object> h=new HashMap<>();
	h.put("designationid", designList);
	String listString = "";

	for (String s : designList)
	{
	    listString += s+">>";
	}
	Gson gson=new Gson();
	String json=gson.toJson(designList);
	return new ObjectMapper().writeValueAsString(listString);
}*/
/*@RequestMapping(value = "getdesignationId", method = RequestMethod.GET)
public @ResponseBody
String getDesignation(@RequestParam int designationid)
		throws JsonProcessingException {
	List<DesignationBean> desigbean = userEmployeeservice.getDesignation(designationid);
	System.out.println(desigbean);
	ObjectMapper map = new ObjectMapper();
	return map.writeValueAsString(desigbean);
}*/
/*@RequestMapping(value = "/show-designation", method = RequestMethod.GET)
public ModelAndView showAllDesignation(Map model,@RequestParam int designationid) {
	List<Designation> designation =empDao.getDesignationname();
	System.out.println(designationid);
	model.put("desig", designation);
	System.out.println(designation);
	return new ModelAndView("getdesignation",model);
}*/
@RequestMapping(value="show-designation",method=RequestMethod.POST)
@ResponseBody
public void getData(@RequestBody String json,Model model) throws IOException{
	
	
	System.out.println(json);
	ObjectMapper mapper=new ObjectMapper();
	//DesignationBean degbean=mapper.readValue(json, DesignationBean.class);
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

	
	
	@RequestMapping(value="/appregis",method = RequestMethod.GET)
	public ModelAndView MobileAppRegis(@ModelAttribute("producthead") ProductHeadBean productHeadBean,
			HttpServletRequest request){

		
		return new ModelAndView("appregis");
}
	
	

	
	
	
	
	
	


	/************************************************** use by shweta ***************************************************/
	@RequestMapping(value="/customerLevels",method = RequestMethod.GET)
	public ModelAndView getcustomerLevels( @ModelAttribute("command") CustomerLevelsBean customerlevel,HttpServletRequest request,BindingResult result ){
		System.out.println("in customerlevels  method");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customerLevelsList",  prepareCustomerLevelsListofBean(masterMastersService.customerLevelsList()));
		System.out.println("***************************************** inside customer list ****************************");
	return new ModelAndView("getcustomerlevel",model);
	}

	
	
	
	private List<CustomerLevelsBean> prepareCustomerLevelsListofBean(List<CustomerLevels> prodel){
		List<CustomerLevelsBean> beans = null;
		if(prodel != null && !prodel.isEmpty()){
			beans = new ArrayList<CustomerLevelsBean>();
			CustomerLevelsBean bean = null;
			for(CustomerLevels pro : prodel){
				bean = new CustomerLevelsBean();
				//System.out.println(bean);
				bean.setId(pro.getId());
				bean.setStatus(pro.getStatus());
				bean.setLevel(pro.getLevel());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	@RequestMapping(value="addcustomerlevels",method=RequestMethod.POST)
	@ResponseBody
	public void addCustomerLevels(@RequestBody String json,Model model) throws IOException{
	System.out.println("********************inside add customer levels**************\n"+json);
		ObjectMapper mapper=new ObjectMapper();
		CustomerLevelsBean poref=mapper.readValue(json, CustomerLevelsBean.class);
		CustomerLevelsBean poref1=new CustomerLevelsBean();
		//poref1.setCurrencyid(poref.getCurrencyid());
		poref1.setStatus(poref.getStatus());
		
		//poref.setPorefentryitemdetailid(null);
		
		
		
		masterMastersService.addCustomerLevels(poref1);
		//model.addAttribute("prolist",  prepareListofBean(prinicipalposervice.proList()));
	//return toJson1(poref1);
	}
	
	@RequestMapping(value = "deletecustomerlevels", method = RequestMethod.GET)
	public ModelAndView deleteCustomerLevels(@RequestParam("id") int id) {
		masterMastersService.deleteCustomerLevels(id);
		Map<String, Object> model= new HashMap<String,Object>();
		List<CustomerLevelsBean> list=new ArrayList<CustomerLevelsBean>();
		model.put("customerLevelsList",  prepareCustomerLevelsListofBean(masterMastersService.customerLevelsList()));
		
		
		return new ModelAndView("getcustomerlevel",model);
	}
	
	@RequestMapping(value = "getcustomerlevel", method = RequestMethod.GET)
	public void getCustomerLevel(@RequestParam("id") String id,HttpServletResponse res )throws ParseException  {
		String cuList=masterMastersService.getCustomerLevelsById(id);
		System.out.println("inside get customerlevel");
		
		System.out.println(cuList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(cuList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("outside get customerlevel");
	}
	
	

	@RequestMapping(value="editcustomerlevel",method=RequestMethod.POST)
	@ResponseBody
	public void editCustomerLevel(@RequestBody String json,Model model) throws IOException{
	System.out.println("inside edit customer level");
		ObjectMapper mapper=new ObjectMapper();
		CustomerLevelsBean poref=mapper.readValue(json, CustomerLevelsBean.class);
		CustomerLevelsBean poref1=new CustomerLevelsBean();
		poref1.setId(poref.getId());
		poref1.setStatus(poref.getStatus());
		
		masterMastersService.editCustomerLevels(poref1);
		
	}
	
	@RequestMapping(value="/country",method = RequestMethod.GET)
	public ModelAndView getcountry( @ModelAttribute("command") CountryBean country,HttpServletRequest request,BindingResult result ){
		System.out.println("inside country  method");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("countryList",  prepareCountryListofBean(masterMastersService.countryList()));
		System.out.println("***************************************** inside country list ****************************");
	return new ModelAndView("getcountry",model);
	}
	@SuppressWarnings("unused")
	private List<CountryBean> prepareCountryListofBean(List<Country> prodel){
		List<CountryBean> beans = null;
		if(prodel != null && !prodel.isEmpty()){
			beans = new ArrayList<CountryBean>();
			CountryBean bean = null;
			for(Country pro : prodel){
				bean = new CountryBean();
				//System.out.println(bean);
				bean.setCountryId(pro.getCountryId());
				bean.setCountry(pro.getCountry());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	@RequestMapping(value="addcountry",method=RequestMethod.POST)
	@ResponseBody
	public void addCountry(@RequestBody String json,Model model) throws IOException{
	System.out.println("********************inside add customer levels**************\n"+json);
		ObjectMapper mapper=new ObjectMapper();
		CountryBean poref=mapper.readValue(json, CountryBean.class);
		CountryBean poref1=new CountryBean();
		poref1.setCountry(poref.getCountry());
		masterMastersService.addCountry(poref1);
	}
		
	@RequestMapping(value = "deletecountry", method = RequestMethod.GET)
	public ModelAndView deleteCountry(@RequestParam("countryId") Integer id) {
		masterMastersService.deleteCountry(id);
		Map<String, Object> model= new HashMap<String,Object>();
		List<CountryBean> list=new ArrayList<CountryBean>();
		model.put("countryList",  prepareCountryListofBean(masterMastersService.countryList()));
		return new ModelAndView("getcountry",model);
		
		
	}
		
	@RequestMapping(value = "getcountry", method = RequestMethod.GET)
	public void getCountry(@RequestParam("countryId") String id,HttpServletResponse res )throws ParseException  {
		String cuList=masterMastersService.getCountryById(id);
		System.out.println("inside get country method");
		
		System.out.println(cuList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(cuList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("outside get country method");
	}
	
	

	@RequestMapping(value="editcountry",method=RequestMethod.POST)
	@ResponseBody
	public void editCountry(@RequestBody String json,Model model) throws IOException{
	System.out.println("inside edit country method   \n"+json);
		ObjectMapper mapper=new ObjectMapper();
		CountryBean poref=mapper.readValue(json, CountryBean.class);
		CountryBean poref1=new CountryBean();
		poref1.setCountryId(poref.getCountryId());
		poref1.setCountry(poref.getCountry());
		
		masterMastersService.editCountry(poref1);
		
	}
	@RequestMapping(value="/state",method = RequestMethod.GET)
	public ModelAndView getState( @ModelAttribute("command") CountryBean country,HttpServletRequest request,BindingResult result ){
		System.out.println("inside state  method");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("stateList",  prepareStateListofBean(masterMastersService.stateList()));
		System.out.println("***************************************** inside state list ****************************");
	return new ModelAndView("getstate",model);
	}
	@SuppressWarnings("unused")
	private List<StateBean> prepareStateListofBean(List<State> prodel){
		List<StateBean> beans = null;
		if(prodel != null && !prodel.isEmpty()){
			beans = new ArrayList<StateBean>();
			StateBean bean = null;
			for(State pro : prodel){
				bean = new StateBean();
				//System.out.println(bean);
				bean.setStateId(pro.getStateId());
				bean.setState(pro.getState());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	@RequestMapping(value="addstate",method=RequestMethod.POST)
	@ResponseBody
	public void addState(@RequestBody String json,Model model) throws IOException{
	System.out.println("********************inside add state method **************\n"+json);
		ObjectMapper mapper=new ObjectMapper();
		StateBean poref=mapper.readValue(json, StateBean.class);
		StateBean poref1=new StateBean();
		poref1.setState(poref.getState());
		masterMastersService.addState(poref1);
	}
	
	@RequestMapping(value = "deletestate", method = RequestMethod.GET)
	public ModelAndView deleteState(@RequestParam("stateId") Integer id) {
		masterMastersService.deleteState(id);
		Map<String, Object> model= new HashMap<String,Object>();
		List<StateBean> list=new ArrayList<StateBean>();
		model.put("stateList",  prepareStateListofBean(masterMastersService.stateList()));
		return new ModelAndView("getstate",model);
		
		
	}
	
	
	@RequestMapping(value = "getstate", method = RequestMethod.GET)
	public void getState(@RequestParam("stateId") String id,HttpServletResponse res )throws ParseException  {
		String cuList=masterMastersService.getStateById(id);
		System.out.println("inside get state method");
		
		System.out.println(cuList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(cuList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("outside get state method");
	}
	

	@RequestMapping(value="editstate",method=RequestMethod.POST)
	@ResponseBody
	public void editState(@RequestBody String json,Model model) throws IOException{
	System.out.println("inside edit state method   \n"+json);
		ObjectMapper mapper=new ObjectMapper();
		StateBean poref=mapper.readValue(json, StateBean.class);
		StateBean poref1=new StateBean();
		poref1.setStateId(poref.getStateId());
		poref1.setState(poref.getState());
		
		masterMastersService.editState(poref1);
		
	}
	@RequestMapping(value="/district",method = RequestMethod.GET)
	public ModelAndView getDistrict( @ModelAttribute("command") DistrictBean district,HttpServletRequest request,BindingResult result ){
		System.out.println("inside district  method");
		Map<String, Object> model = new HashMap<String, Object>();
		//model.put("districtList",  prepareDistrictListofBean(masterMastersService.districtList()));
		System.out.println("***************************************** inside district list ****************************");
	return new ModelAndView("getstate",model);
	}
	/************************************************** use by shweta ***************************************************/

	
	/************************************************** used by satyendra ***************************************************/
	@RequestMapping(value="/addzone",method = RequestMethod.GET)
	public String editZones()
	{
		
		//regionService.saveZones(id);
	//model.addAttribute("zones", regionService.saveZones(id));
	
		return "userbean";
}
}
