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
import com.pogo.bean.CountryBean;
import com.pogo.bean.CurrencyBean;
import com.pogo.bean.CustomerLevelsBean;
import com.pogo.bean.CustomerSourceBean;
import com.pogo.bean.DistrictBean;
import com.pogo.bean.ExpenseMasterBean;
import com.pogo.bean.LocationBean;
import com.pogo.bean.StateBean;
import com.pogo.model.Country;
import com.pogo.model.CustomerLevels;
import com.pogo.model.District;
import com.pogo.model.ExpenseMaster;
import com.pogo.model.Location;
import com.pogo.model.State;
import com.pogo.service.MasterMastersService;

@Controller
public class MasterMasterController {
	@Autowired
	private MasterMastersService masterMastersService;
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
	public ModelAndView getState(@RequestParam("countryId") String cuntryid, @ModelAttribute("command") CountryBean country,HttpServletRequest request,BindingResult result ){
		System.out.println("inside state  method");
		List<StateBean> statelistbycountryid=new ArrayList<>();
		Map<String, Object> model = new HashMap<String, Object>();
		
		statelistbycountryid=	masterMastersService.stateListbycountryid(cuntryid);
	
		//masterMastersService.stateList();
		model.put("stateList",statelistbycountryid);
		model.put("state123",cuntryid);
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
		masterMastersService.addState(poref);
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
		model.put("districtList",  prepareDistrictListofBean(masterMastersService.districtList()));
		System.out.println("***************************************** inside district list ****************************");
	return new ModelAndView("getdistrict",model);
	}
	@SuppressWarnings("unused")
	private List<DistrictBean> prepareDistrictListofBean(List<District> prodel){
		List<DistrictBean> beans = null;
		if(prodel != null && !prodel.isEmpty()){
			beans = new ArrayList<DistrictBean>();
			DistrictBean bean = null;
			for(District pro : prodel){
				bean = new DistrictBean();
				//System.out.println(bean);
				bean.setDistrictId(pro.getDistrictId());
				bean.setDistrict(pro.getDistrict());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	@RequestMapping(value="adddistrict",method=RequestMethod.POST)
	@ResponseBody
	public void addDistrict(@RequestBody String json,Model model) throws IOException{
	System.out.println("********************inside add district method **************\n"+json);
		ObjectMapper mapper=new ObjectMapper();
		DistrictBean poref=mapper.readValue(json, DistrictBean.class);
		DistrictBean poref1=new DistrictBean();
		poref1.setDistrict(poref.getDistrict());
		masterMastersService.addDistrict(poref1);
	}
	@RequestMapping(value = "deletedistrict", method = RequestMethod.GET)
	public ModelAndView deleteDistrict(@RequestParam("districtId") Integer id) {
		masterMastersService.deleteDistrict(id);
		Map<String, Object> model= new HashMap<String,Object>();
		List<DistrictBean> list=new ArrayList<DistrictBean>();
		model.put("districtList",  prepareDistrictListofBean(masterMastersService.districtList()));
		return new ModelAndView("getdistrict",model);
		
		
	}
	
	
	@RequestMapping(value = "getdistrict", method = RequestMethod.GET)
	public void getDistrict(@RequestParam("districtId") String id,HttpServletResponse res )throws ParseException  {
		String cuList=masterMastersService.getDistrictById(id);
		System.out.println("inside get district method");
		
		System.out.println(cuList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(cuList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("outside get district method");
	}
	

	@RequestMapping(value="editdistrict",method=RequestMethod.POST)
	@ResponseBody
	public void editDistrict(@RequestBody String json,Model model) throws IOException{
	System.out.println("inside edit district method   \n"+json);
		ObjectMapper mapper=new ObjectMapper();
		DistrictBean poref=mapper.readValue(json, DistrictBean.class);
		DistrictBean poref1=new DistrictBean();
		poref1.setDistrictId(poref.getDistrictId());
		poref1.setDistrict(poref.getDistrict());
		
		masterMastersService.editDistrict(poref1);
		
	}
	@RequestMapping(value="/location",method = RequestMethod.GET)
	public ModelAndView getLocation( @ModelAttribute("command") LocationBean location,HttpServletRequest request,BindingResult result ){
		System.out.println("inside location  method");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("locationList",  prepareLocationListofBean(masterMastersService.locationList()));
		System.out.println("***************************************** inside location list ****************************");
	return new ModelAndView("getlocation",model);
	}
	
	@SuppressWarnings("unused")
	private List<LocationBean> prepareLocationListofBean(List<Location> prodel){
		List<LocationBean> beans = null;
		if(prodel != null && !prodel.isEmpty()){
			beans = new ArrayList<LocationBean>();
			LocationBean bean = null;
			for(Location pro : prodel){
				bean = new LocationBean();
				//System.out.println(bean);
				bean.setLocationId(pro.getLocationId());
				bean.setLocation(pro.getLocation());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	
	@RequestMapping(value="addlocation",method=RequestMethod.POST)
	@ResponseBody
	public void addLocation(@RequestBody String json,Model model) throws IOException{
	System.out.println("********************inside add location method **************\n"+json);
		ObjectMapper mapper=new ObjectMapper();
		LocationBean poref=mapper.readValue(json, LocationBean.class);
		LocationBean poref1=new LocationBean();
		poref1.setLocation(poref.getLocation());
		masterMastersService.addLocation(poref1);
	}
	@RequestMapping(value = "deletelocation", method = RequestMethod.GET)
	public ModelAndView deleteLocation(@RequestParam("locationId") Integer id) {
		masterMastersService.deleteLocation(id);
		Map<String, Object> model= new HashMap<String,Object>();
		List<LocationBean> list=new ArrayList<LocationBean>();
		model.put("locationList",  prepareLocationListofBean(masterMastersService.locationList()));
		return new ModelAndView("getlocation",model);
		
		
	}
	
	
	@RequestMapping(value = "getlocation", method = RequestMethod.GET)
	public void getLocation(@RequestParam("locationId") String id,HttpServletResponse res )throws ParseException  {
		String cuList=masterMastersService.getLocationById(id);
		System.out.println("inside get location method");
		
		System.out.println(cuList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(cuList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("outside get location method");
	}
	

	@RequestMapping(value="editlocation",method=RequestMethod.POST)
	@ResponseBody
	public void editLocation(@RequestBody String json,Model model) throws IOException{
	System.out.println("inside edit location method   \n"+json);
		ObjectMapper mapper=new ObjectMapper();
		LocationBean poref=mapper.readValue(json, LocationBean.class);
		LocationBean poref1=new LocationBean();
		poref1.setLocationId(poref.getLocationId());
		poref1.setLocation(poref.getLocation());
		
		masterMastersService.editLocation(poref1);
		
	}

	@RequestMapping(value="/expensemaster",method = RequestMethod.GET)
	public ModelAndView getexpensemaster( @ModelAttribute("command") ExpenseMasterBean expense,HttpServletRequest request,BindingResult result ){
		System.out.println("inside expense master  method");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("expenseheadList",  prepareExpenseListofBean(masterMastersService.expenseheadList()));
		System.out.println("***************************************** inside country list ****************************");
	return new ModelAndView("getexpensemaster",model);
	}
	@SuppressWarnings("unused")
	private List<ExpenseMasterBean> prepareExpenseListofBean(List<ExpenseMaster> prodel){
		List<ExpenseMasterBean> beans = null;
		if(prodel != null && !prodel.isEmpty()){
			beans = new ArrayList<ExpenseMasterBean>();
			ExpenseMasterBean bean = null;
			for(ExpenseMaster pro : prodel){
				bean = new ExpenseMasterBean();
				//System.out.println(bean);
				bean.setExpensemasterId(pro.getExpensemasterId());
				bean.setExpensehead(pro.getExpensehead());
				bean.setExpensetype(pro.getExpensetype());
				bean.setExlimit(pro.getExlimit());
				bean.setUnit(pro.getUnit());
				
				beans.add(bean);
			}
		}
		return beans;
	}
	@RequestMapping(value="addexpensehead",method=RequestMethod.POST)
	@ResponseBody
	public void addExpensehead(@RequestBody String json,Model model) throws IOException{
	System.out.println("********************inside add expensehead method **************\n"+json);
		ObjectMapper mapper=new ObjectMapper();
		ExpenseMasterBean poref=mapper.readValue(json, ExpenseMasterBean.class);
		ExpenseMasterBean poref1=new ExpenseMasterBean();
		poref1.setExpensehead(poref.getExpensehead());
		poref1.setExpensetype(poref.getExpensetype());
		poref1.setExlimit(poref.getExlimit());
		poref1.setUnit(poref.getUnit());
		masterMastersService.addExpensehead(poref1);
	}
	@RequestMapping(value = "deleteexpenseheader", method = RequestMethod.GET)
	public ModelAndView deleteexpenseheader(@RequestParam("expensemasterId") Integer id) {
		masterMastersService.deleteExpenceserheader(id);
		Map<String, Object> model= new HashMap<String,Object>();
		List<ExpenseMasterBean> list=new ArrayList<ExpenseMasterBean>();
		model.put("expenseheadList",  prepareExpenseListofBean(masterMastersService.expenseheadList()));
		return new ModelAndView("getexpensemaster",model);
		
		
	}
	
	
	@RequestMapping(value = "getexpenseheader", method = RequestMethod.POST)
	public void getExpenseHeader(@RequestParam("expensemasterId") String id,HttpServletResponse res )throws ParseException  {
		String cuList=masterMastersService.getExpenceheaderById(id);
		System.out.println("inside get expenseheader method");
		
		System.out.println(cuList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(cuList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("outside get expenseheader method");
	}
	

	@RequestMapping(value="editexpenseheader",method=RequestMethod.POST)
	@ResponseBody
	public void editExpenseHeader(@RequestBody String json,Model model) throws IOException{
	System.out.println("inside edit expenseheader method   \n"+json);
		ObjectMapper mapper=new ObjectMapper();
		ExpenseMasterBean poref=mapper.readValue(json, ExpenseMasterBean.class);
		ExpenseMasterBean poref1=new ExpenseMasterBean();
		poref1.setExpensemasterId(poref.getExpensemasterId());
		poref1.setExpensehead(poref.getExpensehead());
		poref1.setExpensetype(poref.getExpensetype());
		poref1.setExlimit(poref.getExlimit());
		poref1.setUnit(poref.getUnit());
		
		masterMastersService.editExpenseHeader(poref1);
		
	}
	@RequestMapping(value="/CustomerSources",method = RequestMethod.GET)
	public ModelAndView getCustomerSources( @ModelAttribute("command")  CustomerSourceBean customer,HttpServletRequest request,BindingResult result ){
		System.out.println("inside CustomerSources  method");
		List<CustomerSourceBean> list=new ArrayList<CustomerSourceBean>();
		list=masterMastersService.getCustomerSourceList();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customersourcelist", list);
		
		System.out.println("***************************************** inside customersource list ****************************");
	return new ModelAndView("getCustomerSources",model);
	}	
	/*@RequestMapping(value = "deletecustomersource", method = RequestMethod.GET)
	public ModelAndView deleteCustomerSource(@RequestParam("customersourceId") int id) {
		List<Customer_Source_Bean> list=new ArrayList<Customer_Source_Bean>();
		list =	masterMastersService.deleteCustomerSource(id);
		Map<String, Object> model= new HashMap<String,Object>();
		
		model.put("expenseheadList", list );
		return new ModelAndView("customersourcelist",model);
		
		
	}*/
	@RequestMapping(value = "deletecustomersource", method = RequestMethod.GET)
	public ModelAndView deleteCustomerSource(@RequestParam("customersourceId") int id) {
		masterMastersService.deleteCustomerSource(id);
		List<CustomerSourceBean> list=new ArrayList<CustomerSourceBean>();
		list=masterMastersService.getCustomerSourceList();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("customersourcelist", list);
		
			
		
		return new ModelAndView("getCustomerSources",model);
	}
	
	@RequestMapping(value="addcustomersources",method=RequestMethod.POST)
	@ResponseBody
	public String addCurrency(@RequestBody String json,Model model) throws IOException{
	System.out.println(json);
		ObjectMapper mapper=new ObjectMapper();
		CustomerSourceBean poref=mapper.readValue(json, CustomerSourceBean.class);
		CustomerSourceBean poref1=new CustomerSourceBean();
		poref1.setSource(poref.getSource());
		
		masterMastersService.addCustomerSource(poref1);
		
	return toJson(poref1);
	}
	private String toJson(CustomerSourceBean poRefEntry) {
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
	@RequestMapping(value = "getcustomersource", method = RequestMethod.POST)
	public void getCustomerSource(@RequestParam("customersourceId") String id,HttpServletResponse res )throws ParseException  {
		System.out.println(id);
		String curList=masterMastersService.getCustomerSource(id);
		System.out.println(curList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(curList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	@RequestMapping(value="editcustomersource",method=RequestMethod.POST)
	@ResponseBody
	public String editCustomerSource(@RequestBody String json,Model model) throws IOException{
	System.out.println("*****************************************************");
		ObjectMapper mapper=new ObjectMapper();
		CustomerSourceBean poref=mapper.readValue(json, CustomerSourceBean.class);
		CustomerSourceBean poref1=new CustomerSourceBean();
		poref1.setCustomersourceId(poref.getCustomersourceId());
		poref1.setSource(poref.getSource());
		
		
		
		
		masterMastersService.editCustomerSource(poref1);
		//model.addAttribute("prolist",  prepareListofBean(prinicipalposervice.proList()));
	return toJson1(poref1);
	}

	private String toJson1(CustomerSourceBean poRefEntry) {
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
	
}
