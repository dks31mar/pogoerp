package com.pogo.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pogo.bean.CompanyProfileBean;
import com.pogo.bean.DesignationBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.bean.ZonesBean;
import com.pogo.dao.MasterOrganizationDao;
import com.pogo.model.CompanyProfile;
import com.pogo.model.Designation;
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

	// for add jsp
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

}
