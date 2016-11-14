package com.pogo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.bean.SmsAllocationBean;
import com.ibm.icu.text.Normalizer.Mode;
import com.pogo.bean.CompanyProfileBean;

import com.pogo.bean.CompetitiorsProfileBean;

import com.pogo.bean.CountryBean;
import com.pogo.bean.CurrencyBean;

import com.pogo.bean.DesignationBean;

import com.pogo.bean.UserEmployeeBean;
import com.pogo.bean.ZonesBean;
import com.pogo.dao.MasterOrganizationDao;
import com.pogo.model.CompanyProfile;
import com.pogo.model.CompetitiorsProfile;
import com.pogo.model.Designation;
import com.pogo.model.SmsAllocation;
import com.pogo.model.Zones;

import com.pogo.service.MasterOrganizationService;

@Controller
public class MasterOrganizationController {

	@Autowired
	private MasterOrganizationService regionService;
	@Autowired
	private MasterOrganizationService companyservice;
	@Autowired
	private MasterOrganizationService userEmployeeservice;
	@Autowired
	private MasterOrganizationDao empDao;

	/* Employee */
	@RequestMapping(value = "/getuseremp", method = RequestMethod.GET)
	public ModelAndView getUserEmpl(Model model,
			@RequestParam(value = "num", defaultValue = "0", required = false) int num)

	{
		List<UserEmployeeBean> list = new ArrayList<UserEmployeeBean>();
		list = userEmployeeservice.getUserDetails();
		int size = list.size();
		int result = 0;
		int rem = size % 5;
		if (rem > 0)
			result = (size / 10) + 1;
		else
			result = size / 5;
		model.addAttribute("noOfPage", num);
		model.addAttribute("totalNoOfPages", result);
		model.addAttribute("Recordlist", empDao.findDesignationByPageNo(num - 1));
		/*
		 * Map<String, Object> mode= new HashMap<String,Object>();
		 * mode.put("userlist", list);
		 */
		model.addAttribute("totalrecords", list.size());

		return new ModelAndView("getuseremp");
	}

	


	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addEmployee(Model model) {

		return "addUser";
	}

	// for edit jsp
	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public String editEmployee(@RequestParam int id, Model model) {
		model.addAttribute("employee", userEmployeeservice.getEmployee(id));

		return "editUser";
	}

	/*
	 * @RequestMapping(value="/getuseremp",method = RequestMethod.GET)
	 * 
	 * public ModelAndView getUserEmp1() { List<UserEmployeeBean> list=new
	 * ArrayList<UserEmployeeBean>(); list=userEmployeeservice.getUserDetails();
	 * Map<String, Object> model= new HashMap<String,Object>();
	 * model.put("userlist", list);
	 * 
	 * return new ModelAndView("getuseremp",model); }
	 */
	// for add employee
	@RequestMapping(value = "/saveuserEmp", method = RequestMethod.POST)
	public String saveDetails(Model model, @ModelAttribute("userbean") UserEmployeeBean userDTO) throws ParseException {
		userEmployeeservice.adduserEmp(userDTO);
		return "redirect:getuseremp";
		// return new ModelAndView("getuseremp") ;

	}

	// for Edit data fetch
	/*
	 * @RequestMapping(value = "/editUserdetails", method = RequestMethod.GET)
	 * public void editCity(@RequestParam("userempid") Integer
	 * id, @ModelAttribute("userbean")UserEmployeeBean userDTO , BindingResult
	 * result, HttpServletResponse res) { List<UserEmployee> emp =
	 * userEmployeeservice.getUserById(id); try { PrintWriter
	 * writter=res.getWriter(); writter.print(emp); } catch (IOException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * //return "getuseremp"; }
	 */
	/*
	 * @RequestMapping(value = "/editEmp", method = RequestMethod.GET) public
	 * String editEmployee(@RequestParam int id, Model model) {
	 * model.addAttribute("employee", userEmployeeservice.getEmployee(id));
	 * System.out.println("employee"); return "getuseremp"; }
	 */

	@RequestMapping(value = "/update-employee", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employeebean") UserEmployeeBean userEmployeeBean)
			throws ParseException {
		userEmployeeservice.updateEmployee(userEmployeeBean);
		return "redirect:/getuseremp";

	}

	@RequestMapping(value = "deleteuser", method = RequestMethod.POST)
	public String deleteuserEmpData(@RequestParam("userempid") int id) {
		userEmployeeservice.deleteuserEmp(id);
		return "getuseremp";
	}

	// search
	@RequestMapping(value = "searchEmployee", method = RequestMethod.POST)
	public @ResponseBody String filterEmpployee(@RequestParam String loginname) throws JsonProcessingException {
		List<UserEmployeeBean> userbean = userEmployeeservice.getUser(loginname);
		ObjectMapper map = new ObjectMapper();
		return map.writeValueAsString(userbean);
	}

	/****** Designation *******/
	@RequestMapping(value = "/getdesignation", method = RequestMethod.GET)
	public ModelAndView getUserEmp(Model model) {
		List<DesignationBean> list = new ArrayList<DesignationBean>();
		list = userEmployeeservice.getDesignation();
		List<Designation> designation = empDao.getDesignationname();
		Map<String, Object> mode = new HashMap<String, Object>();
		mode.put("designationlist", list);
		model.addAttribute("desig", designation);

		return new ModelAndView("designation", mode);
	}

	/*
	 * @RequestMapping(value = "authority", method = RequestMethod.GET)
	 * public @ResponseBody String designationList(Model model, @RequestParam
	 * String designation) throws JsonProcessingException { List<String>
	 * designList = userEmployeeservice.findDataByDesignation(designation);
	 * Map<String, Object> h=new HashMap<>(); h.put("designationid",
	 * designList); String listString = "";
	 * 
	 * for (String s : designList) { listString += s+">>"; } Gson gson=new
	 * Gson(); String json=gson.toJson(designList); return new
	 * ObjectMapper().writeValueAsString(listString); }
	 */
	/*
	 * @RequestMapping(value = "getdesignationId", method = RequestMethod.GET)
	 * public @ResponseBody String getDesignation(@RequestParam int
	 * designationid) throws JsonProcessingException { List<DesignationBean>
	 * desigbean = userEmployeeservice.getDesignation(designationid);
	 * System.out.println(desigbean); ObjectMapper map = new ObjectMapper();
	 * return map.writeValueAsString(desigbean); }
	 */
	/*
	 * @RequestMapping(value = "/show-designation", method = RequestMethod.GET)
	 * public ModelAndView showAllDesignation(Map model,@RequestParam int
	 * designationid) { List<Designation> designation
	 * =empDao.getDesignationname(); System.out.println(designationid);
	 * model.put("desig", designation); System.out.println(designation); return
	 * new ModelAndView("getdesignation",model); }
	 */
	@RequestMapping(value = "show-designation", method = RequestMethod.POST)

	@ResponseBody
	public void getData(@RequestBody String json, Model model) throws IOException {

		System.out.println(json);
		ObjectMapper mapper = new ObjectMapper();
		DesignationBean degbean = mapper.readValue(json, DesignationBean.class);
		DesignationBean des = new DesignationBean();
		des.setDesignation(degbean.getDesignation());
		des.setLevel(degbean.getLevel());
		des.setPosition(degbean.getPosition());
		userEmployeeservice.updateandinsertbylevel(des);

	}

	@RequestMapping(value = "/editDesignation", method = RequestMethod.GET)
	public String editDesignation(@RequestParam int id, Model model) {
		DesignationBean bean = userEmployeeservice.getDesignationForEdit(id);
		model.addAttribute("getdata", bean);
		return "editDesignation";
	}

	@RequestMapping(value = "/update-designation", method = RequestMethod.POST)
	public String updateDesignation(@ModelAttribute("designationBean") DesignationBean designationBean) {
		userEmployeeservice.updateDesignation(designationBean);
		return "redirect:/getdesignation";

	}

	@RequestMapping(value = "deleteDesg", method = RequestMethod.GET)
	public String deleteuserDesgData(@RequestParam("designationid") int id) {
		userEmployeeservice.deleteDesignation(id);
		return "redirect:/getdesignation";
	}

	/* Profile */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView getProfile(@ModelAttribute("command") CompanyProfileBean companyInfo,
			HttpServletRequest request, BindingResult result) {

		return new ModelAndView("Profile");
	}

	@RequestMapping(value = "/savecompanyinfo", method = RequestMethod.POST)
	public ModelAndView getCompanyInfo(@ModelAttribute("command") CompanyProfileBean companyInfo,
			HttpServletRequest request, BindingResult result) {

		CompanyProfile company = prepareModel(companyInfo);
		// PoRefEntryItemDetailCopy poRefEntrycopy =
		// prepareModelCopy(porefitem);
		companyservice.addCompany(company);
		return new ModelAndView("Profile");
	}

	private CompanyProfile prepareModel(CompanyProfileBean companyinfo) {
		CompanyProfile comp = new CompanyProfile();

		// System.out.println(porefitem.getPorefentryitemdetailid());
		comp.setCompanyinfoid(companyinfo.getCompanyinfoid());
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
		// poref.setPorefentrycopy(porefitem);;

		return comp;
	}
	/*Mobile Apps Registration*/
	@RequestMapping(value="mobileApp", method=RequestMethod.GET)
	public String forMobileApp(Model model)
	{
		return "mobileApp";
		
	}
	/****************************created by stayendra**********************/

	@RequestMapping(value="/Editregion",method = RequestMethod.GET)
	public ModelAndView editZones(@RequestParam("id") Integer id,Zones porefitem,HttpServletRequest request,Model model)
			{
	    List<Zones> getbranch=new ArrayList<Zones>();
	    model.addAttribute("getregion", regionService.editZones(id));
		getbranch=regionService.getBranches();
		Map<String, Object> mode = new HashMap<String, Object>();
		mode.put("branchList",  getbranch);
		
		return new ModelAndView("editregion",mode);
}
	@RequestMapping(value="/branches",method = RequestMethod.GET)
	public ModelAndView getStates(Zones porefitem,HttpServletRequest request){
	
		List<Zones> getStates=new ArrayList<Zones>();
		//getStates=regionService.getStates();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("branchList",  getStates);
		return new ModelAndView("branches",model);
	
}
	@RequestMapping(value = "/update-region", method = RequestMethod.POST)
	public String updateregion(@ModelAttribute("zonesBean")  ZonesBean zonesBean)  {
		regionService.updateregion(zonesBean);
		System.out.println("i am here");
		return "redirect:/region";
	
	}
@RequestMapping(value="/deleteRegion",method=RequestMethod.GET)
public ModelAndView deleteRegionData(@RequestParam ("id")int id,ModelMap model)
{
	regionService.deleteRegion(id);
	List<Zones> getbranch = new ArrayList<Zones>();
	getbranch = regionService.getBranches();
	  model.addAttribute("id", "data deleted");
	  model.put("branchList", getbranch);
	return new ModelAndView("region",model);
	
}
@RequestMapping(value="/addstates",method = RequestMethod.GET)
public ModelAndView getStates(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){

	//commonservice.getPoRefNo(request);

return new ModelAndView("addstates");
}	

	

@RequestMapping(value="/sms",method = RequestMethod.GET)
public ModelAndView getSmsAllocation( @ModelAttribute("command") SmsAllocationBean sms,HttpServletRequest request,BindingResult result ){
	System.out.println("inside sms  method");
	List<UserEmployeeBean> list = new ArrayList<UserEmployeeBean>();
	list = userEmployeeservice.getUserDetails();
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("empdetails", list);
return new ModelAndView("getsms",model);
}	




@RequestMapping(value = "/region", method = RequestMethod.GET)
public ModelAndView getRegion(Zones porefitem, HttpServletRequest request) {

	List<Zones> getbranch = new ArrayList<Zones>();
	getbranch = regionService.getBranches();
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("branchList", getbranch);
	return new ModelAndView("region", model);

}
@RequestMapping(value = "addzonedetails", method = RequestMethod.POST)
@ResponseBody
public void addZoneDeatils(@RequestBody String json, Model model) throws IOException {
	System.out.println("Add zone data   \n" + json);
	ObjectMapper mapper = new ObjectMapper();
	ZonesBean poref = mapper.readValue(json, ZonesBean.class);

	ZonesBean poref1 = new ZonesBean();

	regionService.addZoneDeatils(poref);
}
/************ save competitiorsProfile *************/

@RequestMapping(value="/competitiorsProfile",method = RequestMethod.GET)

public ModelAndView AddCompetitiorsProfile(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){

	//regionService.AddCompetitiorsProfile(poref);
return new ModelAndView("competitiorsProfile");
}


@RequestMapping(value = "saveDataCompetitiors", method = RequestMethod.POST)
@ResponseBody
public void saveDataCompetitiors(@RequestBody String json, Model model) throws IOException {
	System.out.println("Add zone data   \n" + json);
	ObjectMapper mapper = new ObjectMapper();
	CompetitiorsProfileBean poref = mapper.readValue(json, CompetitiorsProfileBean.class);

	CompetitiorsProfileBean poref1 = new CompetitiorsProfileBean();

	regionService.saveDataCompetitiors(poref);
}

@RequestMapping(value="/addfeature",method = RequestMethod.GET)
public ModelAndView getFeature(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){

return new ModelAndView("feature");
}

@RequestMapping(value="/editcompetitior",method = RequestMethod.GET)
public ModelAndView getcompetitior(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result){

return new ModelAndView("competitior");
}

@RequestMapping(value="/upcompetitior",method = RequestMethod.GET)
public ModelAndView updateCompetitior(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,HttpServletRequest request,BindingResult result,Model model){
	 List<CompetitiorsProfile> getdata=new ArrayList<CompetitiorsProfile>();
	    model.addAttribute("getregion");
	    regionService.updateCompetitior();
		Map<String, Object> mode = new HashMap<String, Object>();
		mode.put("branchList",  getdata);
return new ModelAndView("updatecompetitior");
}


@RequestMapping(value="/permitforsmssend",method = RequestMethod.POST)
@ResponseBody
public void permitForSms(@RequestBody String json,Model model) throws IOException{
System.out.println(json);
	ObjectMapper mapper=new ObjectMapper();
	SmsAllocationBean smsbean=mapper.readValue(json, SmsAllocationBean.class);
	
	userEmployeeservice.permitForSms(smsbean);
}

@RequestMapping(value="/denyforsmssend",method = RequestMethod.POST)
@ResponseBody
public void denyForSms(@RequestBody String json,Model model) throws IOException{
System.out.println(json);
	ObjectMapper mapper=new ObjectMapper();
	SmsAllocationBean smsbean=mapper.readValue(json, SmsAllocationBean.class);
	
	userEmployeeservice.denyForSms(smsbean);
}
@RequestMapping(value="/getsmspermituser",method = RequestMethod.POST)
public void getPermitSmsUser(HttpServletResponse res) throws IOException{
	
	PrintWriter writer= res.getWriter();
	List<SmsAllocationBean> list=new ArrayList<>();
	list=userEmployeeservice.getPermitSmsUser();
	List<Integer> list2=new ArrayList<>();
	for(SmsAllocationBean b:list){
		
		list2.add(b.getEmpid());
	}
	writer.print(list2);
}

}
