package com.pogo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ibm.icu.text.SimpleDateFormat;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.pogo.bean.AddActionBean;
import com.pogo.bean.AddDiaryBean;
import com.pogo.bean.AddFollowUpBean;
import com.pogo.bean.AddPlanBean;
import com.pogo.bean.ContactBean;
import com.pogo.bean.CountryBean;
import com.pogo.bean.CustomerFileUploadBean;
import com.pogo.bean.CustomerLevelsBean;
import com.pogo.bean.CustomerSalesBean;
import com.pogo.bean.DepartmentBean;
import com.pogo.bean.DesignationBean;
import com.pogo.bean.DistrictBean;
import com.pogo.bean.LocationBean;
import com.pogo.bean.ProductMasterBean;
import com.pogo.bean.StateBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.model.CustomerLevels;
import com.pogo.model.CustomersFileUplaod;
import com.pogo.service.CustomerSalesService;
import com.pogo.service.MasterMastersService;
import com.pogo.service.MasterOrganizationService;
import com.sun.java.swing.plaf.motif.resources.motif;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		List<CustomerLevelsBean> cusStatus = masterService.getCustomersStatusList();
		model.addAttribute("cusStatus", cusStatus);
		List<LocationBean> locationlist = masterService.getLocationDetails();
		model.addAttribute("locList", locationlist);
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		model.addAttribute("today", df.format(new Date()));
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
	public @ResponseBody String getDistrict(@PathVariable("id") int id, HttpServletRequest request)
			throws JsonProcessingException {
		List<DistrictBean> list1 = masterService.getDistrictByStateIdAndcountryId(id);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(list1);
	}

	@RequestMapping(value = "/getSalesList", method = RequestMethod.GET)
	public String getSalesList(@RequestParam("id") String id,Model model) {
		List<CustomerSalesBean> salesList = customerSalesService.findAllData(id);
		model.addAttribute("salesList", salesList);
		return "getSalesList";
	}

	@RequestMapping(value = "/editcustomer", method = RequestMethod.GET)
	public String editcustomerData(@RequestParam("id") int id, Model model) throws ParseException {
		model.addAttribute("editcustomers", customerSalesService.getCustomerDetailsById(id));
		List<UserEmployeeBean> emp = empServive.getUserDetails();
		model.addAttribute("listemp", emp);
		List<CountryBean> country = masterService.countryDetails();
		model.addAttribute("countrylist", country);
		List<CustomerLevelsBean> cusStatus = masterService.getCustomersStatusList();
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
	public ModelAndView getAddDiaryForEntery(Model model) throws ParseException {
		List<UserEmployeeBean> emp = empServive.getUserDetails();
		model.addAttribute("listemp", emp);
		// CustomerSalesBean salesList =
		// customerSalesService.getCustomerDetailsById(id);
		// model.addAttribute("salesList", salesList);
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		model.addAttribute("today", df.format(new Date()));
		List<AddPlanBean> planlist = masterService.PlanList();
		model.addAttribute("planlist", planlist);
		List<DesignationBean> degList = empServive.GetDesignationList();
		model.addAttribute("designationlist", degList);
		return new ModelAndView("AddDiaryForEntrySales");
	}

	@RequestMapping(value = "/saveDiaryForEntrySales", method = RequestMethod.POST)
	public String saveDiaryForEntery(@ModelAttribute("addDiaryBean") AddDiaryBean addDiaryBean) {
		customerSalesService.savediary(addDiaryBean);
		return "redirect:/addDiaryForEntrySales";
	}

	@RequestMapping(value = "/createQuotation", method = RequestMethod.GET)
	public ModelAndView CreateQuotation() {

		return new ModelAndView("CreateQuotationForm");
	}

	@RequestMapping(value = "/addFollowup", method = RequestMethod.GET)
	public ModelAndView AddFollowup(Model model) {

		//List<CustomerSalesBean> salesList = customerSalesService.findAllData();
		//model.addAttribute("salesList", salesList);

		String s="all";
		List<CustomerSalesBean> salesList = customerSalesService.findAllData(s);
		model.addAttribute("salesList", salesList);

		List<AddActionBean> actionlist = masterService.findAllAction();
		model.addAttribute("actionList", actionlist);
		List<CustomerLevelsBean> cusStatus = masterService.getCustomersStatusList();
		model.addAttribute("cusStatus", cusStatus);
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		model.addAttribute("today", df.format(new Date()));
		return new ModelAndView("AddFollowupForm");
	}

	@RequestMapping(value = "/savefollowup", method = RequestMethod.POST)
	public String addfollowup(@ModelAttribute("addFollowUpBean") AddFollowUpBean addFollowUpBean,HttpServletRequest request,
			BindingResult result) throws IOException {
		HttpSession session=request.getSession();
		try {
			int userid=(int) session.getAttribute("userid");
			System.out.println(userid);
			customerSalesService.addFollowup(addFollowUpBean,userid);
			return "redirect:addFollowup";
		} catch (Exception e) {
			return "redirect:/LoginPage.jsp";
		}
		
		

		
	}

	@RequestMapping(value = "/attachFiles", method = RequestMethod.GET)
	public String attachFiles(Model model)
 {
		List<CustomerFileUploadBean> fileList=customerSalesService.getFollowupFilesList();
		model.addAttribute("filesList", fileList);
		return "attachfiles";
	}
	
	 @RequestMapping(value={"download-files"}, method={RequestMethod.GET})
	    public void DownloadFile(@RequestParam int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
	        CustomersFileUplaod file = customerSalesService.downloadDataById(id);
	        response.setContentType(file.getFileType());
	        response.setContentLength(file.getFile().length);
	        response.setHeader("ContentDisposition", "attachment:filename=\"" + file.getFileName() + "\"%s\"");
	        FileCopyUtils.copy((byte[])file.getFile(),response.getOutputStream());
	        response.sendRedirect("attachFiles");
	    }
	 @RequestMapping(value={"delete-file"}, method={RequestMethod.GET})
	    public void DeleteFile(@RequestParam int id, HttpServletResponse response) throws IOException {
		 customerSalesService.DeletefileById(id);
	        response.sendRedirect("attachFiles");
	    }

	/*@RequestMapping(value = "/fileUplaod", method = RequestMethod.POST)
	public void filesave(@ModelAttribute("customerFile") CustomerFileUploadBean customerFileUploadBean,
			HttpServletResponse response) throws IOException {
		MultipartFile multipartFile = customerFileUploadBean.getFile();
		CustomersFileUplaod fileUplaod = new CustomersFileUplaod();
		fileUplaod.setFile(multipartFile.getBytes());
		fileUplaod.setFileName(multipartFile.getOriginalFilename());
		fileUplaod.setFileType(multipartFile.getContentType());
		customerSalesService.saveFiles(fileUplaod);
		response.sendRedirect("attachFiles");

	}*/

	//using autocomplete for search

	@RequestMapping(value = "/getCustomerRecords", method = RequestMethod.GET)
	public void getCustomerData(HttpServletResponse request) throws JsonProcessingException {
		String list = customerSalesService.findAllDataById();
		// List<CustomerSalesBean>
		// listCustomer=customerSalesService.findOrganisation();
		// System.out.println(listCustomer);

		try {
			request.getWriter().print(list);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	//regarding data
	@RequestMapping(value = "/getcompanydatabyname", method = RequestMethod.GET)
	public void getCustomerdatabyCompanyName(@RequestParam("organization") String organization,
			HttpServletResponse res,ProductMasterBean productmasetr) {
		
		String getpart=customerSalesService.getCustomerdatabyCompanyName(organization);
	    String getpart1=getpart.replaceAll("\\[", "");
		getpart1=getpart1.replaceAll("\\]", "");
	   System.out.println(getpart1); 
	   try {
			res.getWriter().print(getpart);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	   
		}	
	
	
	@RequestMapping(value = "/contactPersons", method = RequestMethod.GET)
	public void contact(Model model, HttpServletRequest req, HttpServletResponse res) {
		List<DepartmentBean> list = empServive.getDepartmentDetails();
		Map<Integer, String> map = new HashMap<>();

		for (DepartmentBean db : list) {
			map.put(db.getDepId(), db.getDepName());
		}
		Gson gson = new Gson();
		String json = gson.toJson(map);
		try {
			PrintWriter writter = res.getWriter();
			writter.print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/contactdesignation", method = RequestMethod.GET)
	public void contactDes(Model model, HttpServletRequest req, HttpServletResponse res) {
		List<DesignationBean> beansDeg = empServive.GetDesignationList();
		System.out.println(beansDeg);
		Map<Integer, String> map = new HashMap<>();

		for (DesignationBean db : beansDeg) {
			map.put(db.getDesignationid(), db.getDesignation());
			System.out.println(db.getDesignation());

		}
		Gson gson = new Gson();
		String json = gson.toJson(map);
		try {
			PrintWriter writter = res.getWriter();
			writter.print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/savecontact", method = RequestMethod.POST)
	public String savecontactData(@ModelAttribute("contactBean") ContactBean contactBean) {
		customerSalesService.addContactPerson(contactBean);

		return "redirect:/getSales";
	}
	@ResponseBody
	@RequestMapping(value="/verifyCust",method=RequestMethod.POST)
	public  String verifycustomer(@RequestParam String organisation) throws JsonProcessingException
	{
		String result=customerSalesService.verifyOrg(organisation);
		return new ObjectMapper().writeValueAsString(result);
		
	}

}
