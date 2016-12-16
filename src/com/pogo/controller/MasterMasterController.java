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
import com.pogo.bean.AddActionBean;
import com.pogo.bean.AddPlanBean;
import com.pogo.bean.CompanyProfileBean;
import com.pogo.bean.CompetitiorsProfileBean;
import com.pogo.bean.CountryBean;
import com.pogo.bean.CurrencyBean;
import com.pogo.bean.CustomerLevelsBean;
import com.pogo.bean.CustomerSourceBean;
import com.pogo.bean.DistrictBean;
import com.pogo.bean.ExpenseMasterBean;
import com.pogo.bean.LocationBean;

import com.pogo.bean.ModeOfDispatchBean;

import com.pogo.bean.ServiceProviderBean;

import com.pogo.bean.StateBean;
import com.pogo.bean.SupplierMasterBean;
import com.pogo.bean.TeamSegmentBean;
import com.pogo.model.AddAction;
import com.pogo.model.AddPlan;
import com.pogo.model.Country;
import com.pogo.model.CustomerLevels;
import com.pogo.model.District;
import com.pogo.model.ExpenseMaster;
import com.pogo.model.Location;
import com.pogo.model.State;
import com.pogo.model.SupplierMaster;
import com.pogo.service.MasterMastersService;
@SuppressWarnings("unused")
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
		
		List<CountryBean> countrybean=masterMastersService.countryList();
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("countryList", countrybean);
		System.out.println("***************************************** inside country list ****************************");
	return new ModelAndView("getcountry",model);
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
	
	public ModelAndView deleteCountry(@RequestParam("countryId") Integer id,Model m) {
		
		
		List<StateBean> bean=masterMastersService.getStateByCountryId(id);
		
		System.out.println("<><><><><><><><>   &*&*&*&*&*&*&*    *&*&*&*&    "+bean.isEmpty());
		//
		if(bean.isEmpty()==false){
			m.addAttribute("notdeleting", "Please delete state first");
			}else{
				masterMastersService.deleteCountry(id);
			}
		List<CountryBean> countrybean=masterMastersService.countryList();
		Map<String, Object> model= new HashMap<String,Object>();
		List<CountryBean> list=new ArrayList<CountryBean>();
		model.put("countryList",  countrybean);
		
			
			
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
		model.put("country123",cuntryid);
		System.out.println("***************************************** inside state list ****************************");
	return new ModelAndView("getstate",model);
	}

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
	public ModelAndView deleteState(@RequestParam("stateId") Integer id , Model m) {
		List<DistrictBean> bean = masterMastersService.getDistrictByStateIdAndcountryId(id);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@ "+bean.isEmpty());
		if(bean.isEmpty()==false){
			m.addAttribute("notdeleting", "Please delete district first");
			
		}else {
			masterMastersService.deleteState(id);
		}
		
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
		
		masterMastersService.editState(poref);
		
	}
	@RequestMapping(value="/district",method = RequestMethod.GET)
	
	public ModelAndView getDistrict( @RequestParam("stateId") String stateid,@ModelAttribute("command") DistrictBean district,HttpServletRequest request,BindingResult result ){
		System.out.println("inside district  method");
		
		List<DistrictBean> districtlistbystateid=new ArrayList<>();
		Map<String, Object> model = new HashMap<String, Object>();
		districtlistbystateid=	masterMastersService.districtListbystateid(stateid);
		model.put("districtList",districtlistbystateid);
		model.put("state123",stateid);
		//model.put("districtList",  prepareDistrictListofBean(masterMastersService.districtList()));
		System.out.println("***************************************** inside district list ****************************");
	return new ModelAndView("getdistrict",model);
	}
	
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
		masterMastersService.addDistrict(poref);
	}
	@RequestMapping(value = "deletedistrict", method = RequestMethod.GET)
	public ModelAndView deleteDistrict(@RequestParam("districtId") Integer id , Model m) {
		
		List<LocationBean> bean = masterMastersService.getLocationDetails();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@ "+bean.isEmpty());
		if(bean.isEmpty()==false){
			m.addAttribute("notdeleting", "Please delete district first");
			
		}else {
			masterMastersService.deleteDistrict(id);
		}
		
		
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
		
		masterMastersService.editDistrict(poref);
		
	}
	@RequestMapping(value="/location",method = RequestMethod.GET)
	public ModelAndView getLocation( @RequestParam("districtId") Integer districtid,@ModelAttribute("command") LocationBean location,HttpServletRequest request,BindingResult result ){
		System.out.println("inside location  method");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("district123",districtid);
		model.put("locationList",  prepareLocationListofBean(masterMastersService.locationList(districtid)));
		System.out.println("***************************************** inside location list ****************************");
	return new ModelAndView("getlocation",model);
	}
	
	
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
		masterMastersService.addLocation(poref);
	}
	@RequestMapping(value = "deletelocation", method = RequestMethod.GET)
	public ModelAndView deleteLocation(@RequestParam("locationId") Integer id) {
		
		masterMastersService.deleteLocation(id);
		Map<String, Object> model= new HashMap<String,Object>();
		List<LocationBean> list=new ArrayList<LocationBean>();
		model.put("locationList",  prepareLocationListofBean(masterMastersService.locationList(id)));
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
		
		masterMastersService.editLocation(poref);
		
	}

	@RequestMapping(value="/expensemaster",method = RequestMethod.GET)
	public ModelAndView getexpensemaster( @ModelAttribute("command") ExpenseMasterBean expense,HttpServletRequest request,BindingResult result ){
		System.out.println("inside expense master  method");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("expenseheadList",  prepareExpenseListofBean(masterMastersService.expenseheadList()));
		System.out.println("***************************************** inside country list ****************************");
	return new ModelAndView("getexpensemaster",model);
	}
	
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
				
				bean.setRates(pro.getRates());
				
				
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
		
		poref1.setRates(poref.getRates());
		
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
		
		poref1.setRates(poref.getRates());
		
		
		masterMastersService.editExpenseHeader(poref1);
		
	}

	
	
	@RequestMapping(value="/modeofdispatch",method = RequestMethod.GET)
	public ModelAndView getTransportationMode( @ModelAttribute("command") ModeOfDispatchBean bean,HttpServletRequest request){
		System.out.println("inside mode of dispatch method");
		List<ModeOfDispatchBean> list = new ArrayList<ModeOfDispatchBean>();
		list = masterMastersService.getModeOfDispatchList();
		Map<String , Object> model = new HashMap<String,Object>();
		model.put("modeofdispatchlist", list);
		//System.out.println("***************************************** inside country list ****************************");
	return new ModelAndView("getmodeofdispatch",model);
	}
	@RequestMapping(value="addmodeofdispatch",method=RequestMethod.POST)
	@ResponseBody
	public void addModeOfDispatch(@RequestBody String json,Model model) throws IOException{
	System.out.println("********************inside add  method **************\n"+json);
		ObjectMapper mapper=new ObjectMapper();
		ModeOfDispatchBean poref=mapper.readValue(json, ModeOfDispatchBean.class);
		ModeOfDispatchBean poref1=new ModeOfDispatchBean();
		poref1.setModeofdispatch(poref.getModeofdispatch());
		
		masterMastersService.addModeOfDispatch(poref1);
	}
	@RequestMapping(value = "deletemodeofdispatch", method = RequestMethod.GET)
	public ModelAndView deleteModeOfDispatch(@RequestParam("modeofdispatchId") int id) {
		masterMastersService.deleteModeOfDispatch(id);
		List<ModeOfDispatchBean> list=new ArrayList<ModeOfDispatchBean>();
		list=masterMastersService.getModeOfDispatchList();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("modeofdispatchlist", list);
		
			
		
		return new ModelAndView("getmodeofdispatch",model);
	}
	
	@RequestMapping(value = "getmodeofdispatchbyid", method = RequestMethod.POST)
	public void getModeOfDispatchbyId(@RequestParam("modeofdispatchId") String id,HttpServletResponse res )throws ParseException  {
		String cuList=masterMastersService.getModeOfDispatchbyId(id);
		System.out.println("inside get modeofdispatch method");
		
		System.out.println(cuList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(cuList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("outside get modeofdispatch method");
	}
	
	@RequestMapping(value="editmodeofdispatch",method=RequestMethod.POST)
	@ResponseBody
	public void editModeOfDispatch(@RequestBody String json,Model model) throws IOException{
	System.out.println("inside edit mode of dispatch method   \n"+json);
		ObjectMapper mapper=new ObjectMapper();
		ModeOfDispatchBean poref=mapper.readValue(json, ModeOfDispatchBean.class);
		ModeOfDispatchBean poref1=new ModeOfDispatchBean();
		poref1.setModeofdispatchId(poref.getModeofdispatchId());
		poref1.setModeofdispatch(poref.getModeofdispatch());
		
		
		masterMastersService.editModeOfDispatch(poref1);
		
	}
	@RequestMapping(value="/teamsegment",method = RequestMethod.GET)
	public ModelAndView getTeamSegment( @ModelAttribute("command") ExpenseMasterBean expense,HttpServletRequest request){
		System.out.println("inside team segment method");
		List<TeamSegmentBean> list = new ArrayList<TeamSegmentBean>();
		list = masterMastersService.getTeamSegmentList();
		Map<String , Object> model = new HashMap<String,Object>();
		model.put("teamsegmentlist", list);
		//System.out.println("***************************************** inside country list ****************************");
	return new ModelAndView("getteamsegment",model);
	}
	@RequestMapping(value="addteam",method=RequestMethod.POST)
	@ResponseBody
	public void addTeam(@RequestBody String json,Model model) throws IOException{
	System.out.println("********************inside add  method **************\n"+json);
		ObjectMapper mapper=new ObjectMapper();
		TeamSegmentBean poref=mapper.readValue(json, TeamSegmentBean.class);
		TeamSegmentBean poref1=new TeamSegmentBean();
		poref1.setTeam(poref.getTeam());
		
		masterMastersService.addteam(poref1);
	}
	
	@RequestMapping(value = "deleteteam", method = RequestMethod.GET)
	public ModelAndView deleteteam(@RequestParam("teamid") int id) {
		masterMastersService.deleteteam(id);
		List<TeamSegmentBean> list=new ArrayList<TeamSegmentBean>();
		list=masterMastersService.getTeamSegmentList();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("teamsegmentlist", list);
		
			
		
		return new ModelAndView("getteamsegment",model);
	}
	@RequestMapping(value = "getteambyid", method = RequestMethod.POST)
	public void getTeamById(@RequestParam("teamid") String id,HttpServletResponse res )throws ParseException  {
		String cuList=masterMastersService.getTeambyId(id);
		System.out.println("inside get team method");
		
		System.out.println(cuList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(cuList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("outside get team method");
	}
	
	@RequestMapping(value="editteam",method=RequestMethod.POST)
	@ResponseBody
	public void editTeam(@RequestBody String json,Model model) throws IOException{
	System.out.println("inside edit team method   \n"+json);
		ObjectMapper mapper=new ObjectMapper();
		TeamSegmentBean poref=mapper.readValue(json, TeamSegmentBean.class);
		TeamSegmentBean poref1=new TeamSegmentBean();
		poref1.setTeamid(poref.getTeamid());
		poref1.setTeam(poref.getTeam());
		
		
		masterMastersService.editTeam(poref1);
		
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
	public void editCustomerSource(@RequestBody String json,Model model) throws IOException{
	System.out.println("*****************************************************");
		ObjectMapper mapper=new ObjectMapper();
		CustomerSourceBean poref=mapper.readValue(json, CustomerSourceBean.class);
		CustomerSourceBean poref1=new CustomerSourceBean();
		poref1.setCustomersourceId(poref.getCustomersourceId());
		poref1.setSource(poref.getSource());
		masterMastersService.editCustomerSource(poref1);
		//model.addAttribute("prolist",  prepareListofBean(prinicipalposervice.proList()));
	
	}
	
	
	@RequestMapping(value="/serviceprovider",method = RequestMethod.GET)
	public ModelAndView getServiceProvider( @ModelAttribute("command")  ServiceProviderBean service,HttpServletRequest request,BindingResult result ){
		System.out.println("inside CustomerSources  method");
		List<ServiceProviderBean> list=new ArrayList<ServiceProviderBean>();
		list=masterMastersService.getServiceProviderList();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("servicelist", list);
		
	
	return new ModelAndView("getserviceprovider",model);
	}	
	@RequestMapping(value="/getserviceprovider",method = RequestMethod.GET)
	public ModelAndView addService( @ModelAttribute("command")  CustomerSourceBean customer,HttpServletRequest request,BindingResult result ){
		
	return new ModelAndView("getaddserviceprovider");
	}	
	
	
	
	
	@RequestMapping(value="addserviceprovider",method=RequestMethod.POST)
	@ResponseBody
	public void addServiceProvider(@RequestBody String json,Model model) throws IOException{
	System.out.println("*****************************************************");
		ObjectMapper mapper=new ObjectMapper();
		ServiceProviderBean serviceprovider=mapper.readValue(json, ServiceProviderBean.class);
		masterMastersService.addServiceProvider(serviceprovider);
		//model.addAttribute("prolist",  prepareListofBean(prinicipalposervice.proList()));
	

	}
	
	@RequestMapping(value = "/editserviceprovider", method = RequestMethod.GET)
	public String getServiceProvider(@RequestParam("id") int id, Model model) {
	
		ServiceProviderBean bean=masterMastersService.getServiceProvider(id);
		System.out.println(bean.getContactperson());
		model.addAttribute("service", bean);

		return "editserviceprovider";
	}
	@RequestMapping(value = "/deleteserviceprovider", method = RequestMethod.GET)
	public ModelAndView deleteServiceProvider(@RequestParam("id") int id) {
	
		masterMastersService.deleteServiceprovider(id);
		List<ServiceProviderBean> list=new ArrayList<ServiceProviderBean>();
		list=masterMastersService.getServiceProviderList();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("servicelist", list);

		return new ModelAndView("getserviceprovider",model);
	}
	@RequestMapping(value="updateservicedata",method=RequestMethod.POST)
	@ResponseBody
	public void editServiceProvider(@RequestBody String json,Model model) throws IOException{
		ObjectMapper mapper=new ObjectMapper();
		ServiceProviderBean servicepro=mapper.readValue(json, ServiceProviderBean.class);
		
		masterMastersService.editSourceProviderbyId(servicepro);
		
	
	}
	
	
	//call the page and get list for add plan and 
	@RequestMapping(value="/addplanAction",method=RequestMethod.GET)
	public ModelAndView getPlanAction(Model model)
   {
		List<AddPlanBean> list = new ArrayList<AddPlanBean>();
		list=masterMastersService.PlanList();
		//System.out.println(list.size());
		//model.addAttribute("actionList",list );
		model.addAttribute("planList",list );
		System.out.println("***************** list of plan ********"); 
	
		return new ModelAndView("addplanAction");
	}
	
	// save for  add paln
	@RequestMapping(value="addactionplan",method=RequestMethod.POST)
	@ResponseBody
	public void addActionPlan(@RequestBody String json,Model model) throws IOException{
	System.out.println("********************save add Plan method **************\n"+json);
		ObjectMapper mapper=new ObjectMapper();
		AddPlanBean poref=mapper.readValue(json, AddPlanBean.class);
		AddPlanBean poref1=new AddPlanBean();
		poref1.setPlan(poref.getPlan());
		masterMastersService.addActionPlan(poref1);
	}
	//for edit the add plan
	
	@RequestMapping(value = "getPlanRecordForEdit", method = RequestMethod.POST)
	public void getPlanRecordForEdit(@RequestParam("addplanid") String id,HttpServletResponse res )throws ParseException  {
		System.out.println("**********************edit the  add plan    *******************************");
		System.out.println(id);	
		String planList=masterMastersService.getplanRecord(id);
		System.out.println(planList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(planList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	//update for add paln
	@RequestMapping(value="updateForAddPaln",method=RequestMethod.POST)
	@ResponseBody
	public void updateForAddPaln(@RequestBody String json,Model model) throws IOException{
	System.out.println("**********************update the add paln     *******************************");
		ObjectMapper mapper=new ObjectMapper();
		AddPlanBean planbean=mapper.readValue(json, AddPlanBean.class);
		
		masterMastersService.updateForAddPaln(planbean);
		
	}
	
	
	
	//call the page for add action and list of  add action record
	@RequestMapping(value = "/addaction", method = RequestMethod.GET)
	public ModelAndView getAction(Model model) {
		List<AddActionBean> list=masterMastersService.findAllAction();
		model.addAttribute("actionList",list );
		return new ModelAndView("addaction");
	}
	
	//save the add actin page
	@RequestMapping(value = "saveaddaction", method = RequestMethod.POST)
	@ResponseBody
	public void saveAddAction(@RequestBody String json, Model model) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		AddActionBean actionBean=mapper.readValue(json, AddActionBean.class);
		AddActionBean actionBean2=new AddActionBean();
		actionBean2.setAction(actionBean.getAction());
		masterMastersService.saveAddAction(actionBean2);
	}
	//for update the  add action
	@RequestMapping(value="editforAddAction",method=RequestMethod.POST)
	@ResponseBody
	public void editforAddAction(@RequestBody String json,Model model) throws IOException{
	System.out.println("**********************update the action     *******************************");
		ObjectMapper mapper=new ObjectMapper();
		AddActionBean addbean=mapper.readValue(json, AddActionBean.class);
		
		masterMastersService.editforAddAction(addbean);
		//model.addAttribute("prolist",  prepareListofBean(prinicipalposervice.proList()));

	}
	//get(edit) the  add action  
	@RequestMapping(value = "getActionRecord", method = RequestMethod.POST)
	public void getActionRecord(@RequestParam("addActionid") String id,HttpServletResponse res )throws ParseException  {
		System.out.println("**********************edit the action     *******************************");
		System.out.println(id);
		
		String actionList=masterMastersService.getActionRecord(id);
		System.out.println(actionList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(actionList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	//delete for add paln
	@RequestMapping(value="deleteAddPlan", method = RequestMethod.GET)
	public String deleteAddPlan(@RequestParam("addplanid") int id) {
	
		System.out.println("//delete for add paln");
		masterMastersService.deleteAddPlan(id);
			return "redirect:/addplanAction";
		


		//List<AddPlanBean> list=new ArrayList<AddPlanBean>();
		//list=masterMastersService.findAddPlan();
		//Map<String, Object> model= new HashMap<String,Object>();
		//model.put("planList", list);
	
		//return new ModelAndView("addplanAction",model);
	}
	
	// delete for  add action
	@RequestMapping(value="/deleteaddAction", method = RequestMethod.GET)
	public ModelAndView deleteaddAction(@RequestParam("addActionid") int id) {
		masterMastersService.deleteaddAction(id);
		List<AddActionBean> list=new ArrayList<AddActionBean>();
		list=masterMastersService.findAllAction();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("actionList", list);
		
		return new ModelAndView("addaction",model);
	}
	

	

		
	
	@RequestMapping(value = "/suppliermaster", method = RequestMethod.GET)
	public ModelAndView supplierMaster(@RequestParam("page") String pagename) {
		
		List<SupplierMasterBean> list=new ArrayList<SupplierMasterBean>();
		list=masterMastersService.getSupplierMaster();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("suppmstlst", list);
		return new ModelAndView("suppliermasterpage",model);
	}
	
	@RequestMapping(value="savesuppliermaster",method=RequestMethod.POST)
	@ResponseBody
	public void saveSupplierMaster(@RequestBody String json,Model model) throws IOException{
		ObjectMapper mapper=new ObjectMapper();
		SupplierMasterBean servicepro=mapper.readValue(json, SupplierMasterBean.class);
		
		masterMastersService.saveSupplierMaster(servicepro);
		
	
	}
	
	@RequestMapping(value = "getsupplierdatabyid", method = RequestMethod.POST)
	public void getSupplierdatabyId(@RequestParam("id") String id,HttpServletResponse res )throws ParseException  {
		String curList=masterMastersService.getSupmst(id);
		System.out.println(curList);
		try {
			PrintWriter writter=res.getWriter();
			writter.print(curList);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	@RequestMapping(value="editsuppliermstdata",method=RequestMethod.POST)
	@ResponseBody
	public void editSupplierMst(@RequestBody String json,Model model) throws IOException{
		ObjectMapper mapper=new ObjectMapper();
		SupplierMasterBean servicepro=mapper.readValue(json, SupplierMasterBean.class);
		
		masterMastersService.editSupplierMaster(servicepro);
		
	
	}
	
	
	@RequestMapping(value = "deletesuppliermstdata", method = RequestMethod.GET)
	public ModelAndView deleteuserCurrencyData(@RequestParam("id") int id) {
		
		masterMastersService.deleteSuppilerMst(id);
		
		List<SupplierMasterBean> list=new ArrayList<SupplierMasterBean>();
		list=masterMastersService.getSupplierMaster();
		Map<String, Object> model= new HashMap<String,Object>();
		model.put("suppmstlst", list);
		return new ModelAndView("suppliermasterpage",model);
	}

}
