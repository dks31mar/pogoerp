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
import com.pogo.bean.StatezoneBean;
import com.ibm.icu.text.Normalizer.Mode;
import com.pogo.bean.AddActionBean;
import com.pogo.bean.BranchBean;
import com.pogo.bean.CompanyProfileBean;

import com.pogo.bean.CompetitiorsProfileBean;

import com.pogo.bean.CountryBean;
import com.pogo.bean.CurrencyBean;
import com.pogo.bean.DepartmentBean;
import com.pogo.bean.DesignationBean;
import com.pogo.bean.DistrictBean;
import com.pogo.bean.ModeOfDispatchBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.bean.ZonesBean;
import com.pogo.dao.MasterOrganizationDao;
import com.pogo.model.Branch;
import com.pogo.model.CompanyProfile;
import com.pogo.model.CompetitiorsProfile;
import com.pogo.model.Designation;

import com.pogo.model.UserEmployee;

import com.pogo.model.SmsAllocation;

import com.pogo.model.Zones;

import com.pogo.service.MasterOrganizationService;
import com.sun.mail.handlers.message_rfc822;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

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
			@RequestParam(value = "num", defaultValue = "0", required = false) int num) throws ParseException

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
		model.addAttribute("Recordlist", list);
		/*
		 * model.addAttribute("Recordlist", empDao.findDesignationByPageNo(num -
		 * 1));
		 */
		model.addAttribute("totalrecords", list.size());
		return new ModelAndView("getuseremp");
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		List<DesignationBean> Deglist = userEmployeeservice.GetDesignationList();
		model.addAttribute("listofDeg", Deglist);
		List<CompanyProfileBean> comlist = userEmployeeservice.getCompanyList();
		model.addAttribute("listofComp", comlist);
		List<BranchBean> branchlist = userEmployeeservice.getBranchList();
		model.addAttribute("listofBranch", branchlist);

		// System.out.println("for add emp on controller"+Deglist);
		return "addUser";
	}

	// for edit jsp
	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public String editEmployee(@RequestParam int id, Model model) {
		model.addAttribute("employee", userEmployeeservice.getEmployee(id));
		List<DesignationBean> beansDeg = userEmployeeservice.GetDesignationList();
		model.addAttribute("listofDeg", beansDeg);
		List<BranchBean> beansBran = userEmployeeservice.getBranchList();
		model.addAttribute("listofBranch", beansBran);
		List<CompanyProfileBean> beansCom = userEmployeeservice.getCompanyList();
		model.addAttribute("listofComp", beansCom);
		return "editUser";
	}

	// for add employee
	@RequestMapping(value = "/saveuserEmp", method = RequestMethod.POST)
	public String saveDetails(Model model, @ModelAttribute("userbean") UserEmployeeBean userDTO, BindingResult result)
			throws ParseException {
		userEmployeeservice.adduserEmp(userDTO);
		return "redirect:getuseremp";
		// return new ModelAndView("getuseremp") ;

	}

	@RequestMapping(value = "/update-employee", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employeebean") UserEmployeeBean userEmployeeBean,
			BindingResult result) throws ParseException {
		userEmployeeservice.updateEmployee(userEmployeeBean);
		return "redirect:/getuseremp";

	}

	@RequestMapping(value = "deleteuser", method = RequestMethod.POST)
	public String deleteuserEmpData(@RequestParam("userempid") int id) {
		userEmployeeservice.deleteuserEmp(id);
		// System.out.println("I am on controller");
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
	public String editDesignation(@RequestParam("id") int id, Model model) {
		DesignationBean bean = userEmployeeservice.getDesignationForEdit(id);
		model.addAttribute("getdata", bean);
		return "editDesignation";
	}

	@RequestMapping(value = "/update-designation", method = RequestMethod.POST)
	public String updateDesignation(@ModelAttribute("designationBean") DesignationBean designationBean) {
		System.out.println("hhhddd");
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
	/* Mobile Apps Registration */

	@RequestMapping(value = "mobileApp", method = RequestMethod.GET)
	public String forMobileApp(Model model) throws ParseException {
		List<UserEmployeeBean> list = new ArrayList<UserEmployeeBean>();
		list = userEmployeeservice.getUserDetails();
		model.addAttribute("totalrecords", list.size());
		model.addAttribute("emplDetails", list);
		// model.addAttribute("emplDetails",
		// userEmployeeservice.getUserDetails());

		return "mobileApp";

	}

	// searchEmp
	@RequestMapping(value = "searchEmp", method = RequestMethod.POST)
	public @ResponseBody String filterEmployee(@RequestParam String empName) throws JsonProcessingException {
		List<UserEmployeeBean> userbean = userEmployeeservice.getUserByName(empName);
		ObjectMapper map = new ObjectMapper();
		return map.writeValueAsString(userbean);
	}

	// updateStatus
	@RequestMapping(value = "updateEmp", method = RequestMethod.GET)
	public String statusUpdate(@RequestParam int id) {
		userEmployeeservice.updateStatus(id);
		return "redirect:/mobileApp";
	}

	/**************************** created by stayendra **********************/
//EDIT FOR ZONE(REGION)
	@RequestMapping(value = "/Editregion", method = RequestMethod.GET)
	public ModelAndView editZones(@RequestParam("id") Integer id, Zones porefitem, HttpServletRequest request,
			Model model) {
		List<Zones> getbranch = new ArrayList<Zones>();
		model.addAttribute("getregion", regionService.editZones(id));
		getbranch = regionService.getBranches();
		Map<String, Object> mode = new HashMap<String, Object>();
		mode.put("branchList", getbranch);

		return new ModelAndView("editregion", mode);
	}

	@RequestMapping(value = "/branches", method = RequestMethod.GET)
	public ModelAndView getBranches(Zones porefitem, HttpServletRequest request) {

		List<Zones> getStates = new ArrayList<Zones>();
		// getStates=regionService.getStates();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("branchList", getStates);
		return new ModelAndView("branches", model);

	}

	@RequestMapping(value = "/update-region", method = RequestMethod.POST)
	public String updateregion(@ModelAttribute("zonesBean") ZonesBean zonesBean) {
		regionService.updateregion(zonesBean);
		System.out.println("i am here");
		return "redirect:/region";

	}

	@RequestMapping(value = "/deleteRegion", method = RequestMethod.GET)
	public ModelAndView deleteRegionData(@RequestParam("id") int id, ModelMap model) {
		regionService.deleteRegion(id);
		List<Zones> getbranch = new ArrayList<Zones>();
		getbranch = regionService.getBranches();
		model.addAttribute("id", "data deleted");
		model.put("branchList", getbranch);
		return new ModelAndView("region", model);

	}
	// For State page
	/*
	 * @RequestMapping(value="/states",method = RequestMethod.GET) public String
	 * getStates(Model model){
	 * 
	 * List<BranchBean> list=regionService.getStateBranch();
	 * model.addAttribute("branchlist", list); //return new
	 * ModelAndView("states", model); return "states"; }
	 */
	// For add states

	@RequestMapping(value = "/saveStates", method = RequestMethod.POST)
	public String saveStateDetails(Model model, @ModelAttribute("statebean") StatezoneBean statezoneBean) {
		regionService.addStates(statezoneBean);
		return "addstates";

	}

	@RequestMapping(value = "/addstates", method = RequestMethod.GET)
	public ModelAndView getStates(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,
			HttpServletRequest request, BindingResult result, Model model) {

		List<ZonesBean> zone = regionService.getZoneslist();
		System.out.println(zone);
		model.addAttribute("zonesList", zone);
		return new ModelAndView("addstates");
	}

	// foe edit states
	@RequestMapping(value = "/editstates", method = RequestMethod.GET)
	public String editStates(@RequestParam("id") int id, @RequestParam("id2") int id2, Model model) {
		System.out.println(id2);
		model.addAttribute("liststate", regionService.getSatesById(id));
		model.addAttribute("zonid", id2);
		return "editstates";
	}

	// update states
	@RequestMapping(value = "/updatestates", method = RequestMethod.POST)
	public String updateStates(@ModelAttribute("statezoneBean") StatezoneBean statezoneBean,
			@RequestParam("id") int id) {
		regionService.updateState(statezoneBean, id);
		System.out.println("for update");
		return "redirect:/states?id=" + id;

	}

	@RequestMapping(value = "deleteState", method = RequestMethod.GET)
	public String deletestate(@RequestParam("id") int id, HttpServletResponse response) throws IOException {
		regionService.deletestate(id);
		return "states";
		// response.sendRedirect("states");
	}

	// foe edit Branch
	@RequestMapping(value = "/editbranch", method = RequestMethod.GET)
	public String editBranch(@RequestParam("id") int id, Model model, @RequestParam("stateid") int stateid) {
		// System.out.println("for branch"+id2);
		BranchBean branchBean = regionService.getbranchById(id);
		model.addAttribute("stateId", stateid);
		model.addAttribute("branch", branchBean);
		return "editbranch";
	}

	// update Branch
	@RequestMapping(value = "/updatebranch", method = RequestMethod.POST)
	public String updateBranch(@ModelAttribute("branchBean") BranchBean branchBean, @RequestParam("id") int id,
			@RequestParam("stateid") int id2) {
		regionService.updateBranch(branchBean, id, id2);
		return "redirect:/getbranchbystate?id=" + id2;

	}

	@RequestMapping(value = "deletebranch", method = RequestMethod.GET)
	public String deletebran(@RequestParam("id") int id) {
		regionService.deletebranch(id);
		return "newbranch";
		// response.sendRedirect("states");
	}

	@RequestMapping(value = "/sms", method = RequestMethod.GET)
	public ModelAndView getSmsAllocation(@ModelAttribute("command") SmsAllocationBean sms, HttpServletRequest request,
			BindingResult result) throws ParseException {
		System.out.println("inside sms  method");
		List<UserEmployeeBean> list = new ArrayList<UserEmployeeBean>();
		list = userEmployeeservice.getUserDetails();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("empdetails", list);
		return new ModelAndView("getsms", model);
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

	@RequestMapping(value = "/competitiorsProfile", method = RequestMethod.GET)

	public ModelAndView AddCompetitiorsProfile(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,
			HttpServletRequest request, BindingResult result) {
    List<CompetitiorsProfileBean> list = regionService.getcompetitiorList();
    Map<String , Object> model = new HashMap<String,Object>();
    model.put("complist", list);
		// regionService.AddCompetitiorsProfile(poref);
		return new ModelAndView("competitiorsProfile" , model);
	}
	
	

	@RequestMapping(value = "saveDataCompetitiors", method = RequestMethod.POST)
	@ResponseBody
	public void saveDataCompetitiors(@RequestBody String json, Model model) throws IOException {
		System.out.println("i m in controller Add comptitiorprofile data   \n" + json);
		ObjectMapper mapper = new ObjectMapper();
		
		CompetitiorsProfileBean compti = mapper.readValue(json, CompetitiorsProfileBean.class);

		CompetitiorsProfileBean poref1 = new CompetitiorsProfileBean();
		
		poref1.setName(compti.getName());
		poref1.setContactperson(compti.getContactperson());
		poref1.setAddress(compti.getAddress());
		poref1.setPhoneno(compti.getPhoneno());
		poref1.setMobileno(compti.getMobileno());
		poref1.setProductbrand(compti.getProductbrand());
		poref1.setEmailid(compti.getEmailid());
		poref1.setWarrentyperiod(compti.getWarrentyperiod());
		poref1.setProductname(compti.getProductname());
		poref1.setNooffreeamc(compti.getNooffreeamc());
		poref1.setPrice(compti.getPrice());
		poref1.setAmcrate(compti.getAmcrate());
		regionService.saveDataCompetitiors(poref1);
		System.out.println("end of save data");
	}

	@RequestMapping(value = "/addfeature", method = RequestMethod.GET)
	public ModelAndView getFeature(Model model) {
		List<CompetitiorsProfileBean> compp = regionService.getcompetitiorList();
		model.addAttribute("compList", compp);

		return new ModelAndView("feature");
	}

	@RequestMapping(value = "deletefeature", method = RequestMethod.GET)
	public ModelAndView deleteFeature(@RequestParam("id") int id) {
		regionService.deletefeture(id);
		List<CompetitiorsProfileBean> list = new ArrayList<CompetitiorsProfileBean>();
		list = regionService.getcompetitiorList();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("listofcompetitior", list);
		return new ModelAndView("redirect:/addfeature");
	}

	@RequestMapping(value = "getCompetitiorsProfilebyid", method = RequestMethod.POST)
	public void getCompetitiorsProfilebyidbyId(@RequestParam("compid") String id,HttpServletResponse res )throws ParseException  {
		System.out.println("ID IS \n"+id);
		
		String cuList=regionService.getCompetitiorsProfilebyid(id);
		System.out.println("inside getCompetitiorsProfilebyid method");
		
		
		try {
			PrintWriter writter=res.getWriter();
			writter.print(cuList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="editgetCompetitiorsProfilebyid",method=RequestMethod.POST)
	@ResponseBody
	public void editCompetitiorsProfilebyid(@RequestBody String json,Model model) throws IOException{
	System.out.println("inside edit CompetitiorsProfilebyid method   \n"+json);
		ObjectMapper mapper=new ObjectMapper();
		CompetitiorsProfileBean poref=mapper.readValue(json, CompetitiorsProfileBean.class);
		CompetitiorsProfileBean poref1=new CompetitiorsProfileBean();
		//poref1.setModeofdispatchId(poref.getModeofdispatchId());
		//poref1.setModeofdispatch(poref.getModeofdispatch());
		
		
		regionService.editCompetitiorsProfile(poref1);
		
	}

@RequestMapping(value = "/editcompetitior", method = RequestMethod.GET)
	public ModelAndView getcompetitior(@RequestParam int id, Model model) {
		CompetitiorsProfileBean bean = regionService.getCompititerId(id);
		model.addAttribute("listofcompetitior", bean);

		return new ModelAndView("competitior");
	}

	@RequestMapping(value = "/upcompetitior", method = RequestMethod.POST)

	public ModelAndView updateCompetitior(@ModelAttribute("competitiorsProfileBean") CompetitiorsProfileBean competitiorsProfileBean,BindingResult result)
			 {
		
		System.out.println(competitiorsProfileBean.getCompid());
		           regionService.updateCompetitior(competitiorsProfileBean);
                    System.out.println("update competitior profile");
		           return new ModelAndView("redirect:/addfeature");
	}

	@RequestMapping(value = "/permitforsmssend", method = RequestMethod.POST)
	@ResponseBody
	public void permitForSms(@RequestBody String json, Model model) throws IOException {
		System.out.println(json);
		ObjectMapper mapper = new ObjectMapper();
		SmsAllocationBean smsbean = mapper.readValue(json, SmsAllocationBean.class);

		userEmployeeservice.permitForSms(smsbean);
	}

	@RequestMapping(value = "/denyforsmssend", method = RequestMethod.POST)
	@ResponseBody
	public void denyForSms(@RequestBody String json, Model model) throws IOException {
		System.out.println(json);
		ObjectMapper mapper = new ObjectMapper();
		SmsAllocationBean smsbean = mapper.readValue(json, SmsAllocationBean.class);

		userEmployeeservice.denyForSms(smsbean);
	}

	@RequestMapping(value = "/getsmspermituser", method = RequestMethod.POST)
	public void getPermitSmsUser(HttpServletResponse res) throws IOException {

		PrintWriter writer = res.getWriter();
		List<SmsAllocationBean> list = new ArrayList<>();
		list = userEmployeeservice.getPermitSmsUser();
		List<Integer> list2 = new ArrayList<>();
		for (SmsAllocationBean b : list) {

			list2.add(b.getEmpid());
		}
		writer.print(list2);
	}

	@RequestMapping(value = "/states", method = RequestMethod.GET)
	public ModelAndView getZoneStates(@ModelAttribute("command") StatezoneBean porefitem, HttpServletRequest request,
			BindingResult result, @RequestParam("id") Integer id) {
		System.out.println("" + id);
		List<StatezoneBean> list = new ArrayList<>();
		list = regionService.getZoneStates(id);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("satyendra", list);
		model.put("zoneid", id);
		return new ModelAndView("states", model);
	}

	@RequestMapping(value = "/getbranchbystate", method = RequestMethod.GET)
	public ModelAndView getNewbranch(@RequestParam int id, Model model)

	{
		List<BranchBean> list = new ArrayList<>();
		list = regionService.getBranchByState(id);
		model.addAttribute("branchlist", list);
		model.addAttribute("stateid", id);
		return new ModelAndView("newbranch");
	}

	@RequestMapping(value = "/saveBranch", method = RequestMethod.POST)
	public String saveBranchDetails(Model model, @ModelAttribute("branchBean") BranchBean branchBean) {
		regionService.addBranch(branchBean);
		return "addbranch123";

	}

	@RequestMapping(value = "addbranchbystate", method = RequestMethod.GET)
	public ModelAndView addBranch(@ModelAttribute("command") PoRefEntryItemDetailBean porefitem,
			HttpServletRequest request, BindingResult result, Model model) {
		List<StatezoneBean> list = regionService.getstateData();
		model.addAttribute("liststates", list);
		return new ModelAndView("addbranch123");
	}
	@RequestMapping(value="/getDepartment" ,method=RequestMethod.GET)
	public  ModelAndView getdepartment(Model model)
	{
		List<DepartmentBean> list=regionService.getDepartmentDetails();
		model.addAttribute("bean", list);
		return new ModelAndView("department");
	}
	
	@RequestMapping(value = "savedepartment", method = RequestMethod.POST)
	@ResponseBody
	public void savedepartmentdata(@RequestBody String json, Model model) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		DepartmentBean depBean=mapper.readValue(json, DepartmentBean.class);
		DepartmentBean dep=new DepartmentBean();
		dep.setDepName(depBean.getDepName());
		userEmployeeservice.saveDepartment(dep);
	}
}
