package com.pogo.serviceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.pogo.bean.AddActionBean;
import com.pogo.bean.AddPlanBean;
import com.pogo.bean.CountryBean;
import com.pogo.bean.CurrencyBean;
import com.pogo.bean.CustomerLevelsBean;
import com.pogo.bean.CustomerSourceBean;
import com.pogo.bean.DistrictBean;
import com.pogo.bean.ExpenseDetailsBean;
import com.pogo.bean.ExpenseEntryBean;
import com.pogo.bean.ExpenseMasterBean;
import com.pogo.bean.LocationBean;
import com.pogo.bean.ModeOfDispatchBean;

import com.pogo.bean.ServiceProviderBean;

import com.pogo.bean.StateBean;
import com.pogo.bean.SupplierMasterBean;
import com.pogo.bean.TeamSegmentBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.dao.MasterMastersDao;
import com.pogo.model.AddAction;
import com.pogo.model.AddPlan;
import com.pogo.model.Country;
import com.pogo.model.Currency;
import com.pogo.model.CustomerLevels;
import com.pogo.model.CustomerSales;
import com.pogo.model.CustomerSource;
import com.pogo.model.District;
import com.pogo.model.ExpenseDetails;
import com.pogo.model.ExpenseEntry;
import com.pogo.model.ExpenseMaster;
import com.pogo.model.Location;

import com.pogo.model.ModeOfDispatch;

import com.pogo.model.ServiceProvider;

import com.pogo.model.State;
import com.pogo.model.SupplierMaster;
import com.pogo.model.TeamSegment;
import com.pogo.model.UserEmployee;
import com.pogo.service.MasterMastersService;

@Service("masterMastersService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MasterMastersServiceImpl implements MasterMastersService {
	@Autowired
	private	MasterMastersDao masterMastersdao;
	

	@Override
	
	public List<CustomerLevels> customerLevelsList(){
		return masterMastersdao.customerLevelsList();
	}
	
	@Override
	@Transactional
	public void addCustomerLevels(CustomerLevelsBean poref1) {
		CustomerLevels customer=new CustomerLevels();
		customer.setStatus(poref1.getStatus());
		
		masterMastersdao.addCustomerLevels(customer);
		
	}
	@Override
	@Transactional
	public void deleteCustomerLevels(int id){
		masterMastersdao.deleteCustomerLevels(id);
	}
	@Override
	public String getCustomerLevelsById(String id){
		List<CustomerLevels> customerlevels=masterMastersdao.getCustomerLevelsById(id);
		Map<String, Object> dd=new HashMap<>();
 		for(CustomerLevels data: customerlevels)
		{
			
			dd.put("id",data.getId() );
			dd.put("status",data.getStatus());
			
		}
 		Gson gson=new Gson();
 		
 	String customerlevel=	gson.toJson(dd);
		
		return customerlevel;
	}
	@Override
	@Transactional
	public void editCustomerLevels(CustomerLevelsBean poref1){
		CustomerLevels customer=new CustomerLevels();
		customer.setId(poref1.getId());
		customer.setStatus(poref1.getStatus());
		
		masterMastersdao.editCustomerLevels(customer);
	}
	@Override
	public List<CountryBean> countryList(){
		
		List<Country> country=masterMastersdao.countryList();

		List<CountryBean> beans = new ArrayList<CountryBean>();
		//List<State> state=mast
			
			for(Country pro : country){
				CountryBean bean = new CountryBean();
				
				bean.setCountryId(pro.getCountryId());
				bean.setCountry(pro.getCountry());
				
				//State state = new State();
				
				
	
				
				beans.add(bean);
			}
	
		
		return beans;
	}
	@Override
	@Transactional
	public void addCountry(CountryBean poref1){
		Country country=new Country();
		country.setCountry(poref1.getCountry());
		
		masterMastersdao.addCountry(country);
	}
	@Override
	@Transactional
	public void deleteCountry(Integer id){
		System.out.println("delete");
		
		//State sateid= masterMastersdao.getStateIdByContryId(id);
		//System.out.println(sateid);
		masterMastersdao.deleteCountry(id);
	}
	@Override
	public String getCountryById(String id){
		List<Country> country=masterMastersdao.getCountryById(id);
		Map<String, Object> dd=new HashMap<>();
 		for(Country data: country)
		{
			 
			dd.put("countryId",data.getCountryId());
			dd.put("country",data.getCountry());
			
		}
 		Gson gson=new Gson();
 		
 	String countrylist=	gson.toJson(dd);
		
		return countrylist;
	}
	
	@Override
	@Transactional
	public void editCountry(CountryBean poref1){
		Country country=new Country();
		country.setCountryId(poref1.getCountryId());
		country.setCountry(poref1.getCountry());
		masterMastersdao.editCountry(country);
	}

	
	@Override
	public List<State> stateList(){
		return masterMastersdao.stateList();
	}
	
	@Override
	@Transactional
	public void addState(StateBean poref1){
		Country c=new Country();
		c.setCountryId(poref1.getStateId());
		State state=new State();
		state.setState(poref1.getState());
		state.setCountry(c);//comment for test
		masterMastersdao.addState(state);
	}
	
	@Override
	@Transactional
	public void deleteState(Integer id){
		masterMastersdao.deleteState(id);
	}
	
	@Override
	public String getStateById(String id){
		List<State> state=masterMastersdao.getStateById(id);
		Map<String, Object> dd=new HashMap<>();
 		for(State data: state)
		{
			
			dd.put("stateId",data.getStateId() );
			dd.put("state",data.getState());
			
		}
 		Gson gson=new Gson();
 		
 	String statelist=	gson.toJson(dd);
		
		return statelist;
	}
	
	@Override
	@Transactional
	public void editState(StateBean poref1){
		System.out.println("inside edit state service impl");
		Country c=new Country();
		c.setCountryId(poref1.getCountryId());
		State state=new State();
		state.setStateId(poref1.getStateId());
		state.setState(poref1.getState());
		/*state.setCountry(c);*///comment for test
		System.out.println("outside edit state service impl");
		masterMastersdao.editState(state);
	}

	public List<District> districtList(){
		return masterMastersdao.districtList();
	}
	
    
	
    @Override
    @Transactional
    public void addDistrict(DistrictBean poref1){
    	State s=new State();
		s.setStateId(poref1.getDistrictId());
		System.out.println(poref1.getDistrictId());
    	District district=new District();
		district.setDistrict(poref1.getDistrict());
		district.setState(s);//comment for test
		masterMastersdao.addDistrict(district);
     }

   @Override
   @Transactional
    public void deleteDistrict(Integer id){
	masterMastersdao.deleteDistrict(id);
   }
   
   @Override
   public String getDistrictById(String id){
	List<District> district=masterMastersdao.getDistrictById(id);
	Map<String, Object> dd=new HashMap<>();
		for(District data: district)
	{
		
		dd.put("districtId",data.getDistrictId() );
		dd.put("district",data.getDistrict());
		
	}
		Gson gson=new Gson();
		String districtlist=	gson.toJson(dd);
	
	return districtlist;
}
   
   @Override
   @Transactional
   public void editDistrict(DistrictBean poref1){
	  System.out.println(""+poref1.getDistrictId());
	   State s=new State();
	  s.setStateId(Integer.parseInt(poref1.getStateId()));
	District district=new District();
	district.setDistrictId(poref1.getDistrictId());
	district.setDistrict(poref1.getDistrict());
	district.setState(s);//comment for test
	masterMastersdao.editDistrict(district);
}
   
   @Override
	
	public List<Location> locationList(Integer id){
		return masterMastersdao.locationList(id);
	}
	
	@Override
	@Transactional
	public void addLocation(LocationBean poref1) {
		District district = new District();
		district.setDistrictId(poref1.getLocationId());
		System.out.println(poref1.getDistrictId());
		
		Location location=new Location();
		location.setLocation(poref1.getLocation());
		location.setDistrict(district);//comment for test
		masterMastersdao.addLocation(location);
		
		
	}
	@Override
	@Transactional
	public void deleteLocation(int id ){
		
		
		masterMastersdao.deleteLocation(id);
	}
	@Override
	public String getLocationById(String id){
		List<Location> location=masterMastersdao.getLocationById(id);
		Map<String, Object> dd=new HashMap<>();
		for(Location data: location)
		{
			
			dd.put("locationId",data.getLocationId() );
			dd.put("location",data.getLocation());
			
		}
		Gson gson=new Gson();
		
	String locationlist=	gson.toJson(dd);
		
		return locationlist;
	}
	@Override
	@Transactional
	public void editLocation(LocationBean poref1){
		District district=new District();
		district.setDistrictId(poref1.getDistrictId());
		System.out.println(poref1.getDistrictId());
		Location location=new Location();
		location.setLocationId(poref1.getLocationId());
		location.setLocation(poref1.getLocation());
		location.setDistrict(district);//comment for test
		masterMastersdao.editLocation(location);
	}
	
@Override
	
	public List<ExpenseMaster> expenseheadList(){
		return masterMastersdao.expenseheadList();
	}
@Override
@Transactional
public void addExpensehead(ExpenseMasterBean poref1) {
	ExpenseMaster expensehead=new ExpenseMaster();
	expensehead.setExpensehead(poref1.getExpensehead());
	
	expensehead.setRates(poref1.getRates());
	
	
	masterMastersdao.addExpensehead(expensehead);
	
}
@Override
@Transactional
public void deleteExpenceserheader(int id){
	masterMastersdao.deleteExpenceserheader(id);
}
@Override
public String getExpenceheaderById(String id){
	List<ExpenseMaster> expensemaster =masterMastersdao.getExpenceserheaderById(id);
	Map<String, Object> dd=new HashMap<>();
	for(ExpenseMaster data: expensemaster)
	{
		
		dd.put("expensemasterId",data.getExpensemasterId() );
		dd.put("expensehead",data.getExpensehead());
		
		
		dd.put("rates",data.getRates() );
		
		
		
	}
	Gson gson=new Gson();
	
String list=	gson.toJson(dd);
	
	return list;
}
@Override
@Transactional
public void editExpenseHeader(ExpenseMasterBean poref1){
	ExpenseMaster expensemaster=new ExpenseMaster();
	expensemaster.setExpensemasterId(poref1.getExpensemasterId());
	expensemaster.setExpensehead(poref1.getExpensehead());
	
	expensemaster.setRates(poref1.getRates());
	
	masterMastersdao.editExpenseHeader(expensemaster);
}


@Override
public String getUnitByExpense(String unit) {
	System.out.println(unit);
	List<ExpenseMaster> getdetail=new ArrayList<ExpenseMaster>();
	getdetail=masterMastersdao.getUnitByExpense(unit);
	System.out.println("expense details  "+getdetail);
	Map<String, String> map=new HashMap<>();
	for(ExpenseMaster s:getdetail){
		//map.put("expensetype", s.getExpensetype());
		map.put("rates",String.valueOf(s.getRates()));
	}
	String json = new Gson().toJson(map);
	return json;
	
	
}

@Override
public String expenseListAuto() {
	List<ExpenseMaster> list=masterMastersdao.getExpenseListById();
	String json = new Gson().toJson(list);
	
	return json;
}



@Override
public List<CustomerSourceBean> getCustomerSourceList(){
	List<CustomerSource> getdetails = masterMastersdao.getCustomerSourceList();
	List<CustomerSourceBean> lists=new ArrayList<CustomerSourceBean>();
	for(CustomerSource list: getdetails)
	{
		CustomerSourceBean data=new CustomerSourceBean();
		data.setCustomersourceId(list.getCustomersourceId());
		data.setSource(list.getSource());
		
		lists.add(data);
	}
	return lists ;
}
@Override
public void deleteCustomerSource(int id) {
	masterMastersdao.deleteCustomerSource(id);
}
@Override
public void addCustomerSource(CustomerSourceBean poref1) {
	CustomerSource cur=new CustomerSource();
	cur.setSource(poref1.getSource());
	
	masterMastersdao.addCustomerSource(cur);
}

@Override
public String getCustomerSource(String id){
	List<CustomerSource> customer =masterMastersdao.getCustomerSource(id);
	Map<String, Object> dd=new HashMap<>();
	for(CustomerSource data: customer)
	{
		
		dd.put("customersourceId",data.getCustomersourceId() );
		dd.put("source",data.getSource());
		
		
		
		
	}
	Gson gson=new Gson();
	
String list=	gson.toJson(dd);
	
	return list;
}
@Override
@Transactional
public void editCustomerSource(CustomerSourceBean poref1){
	CustomerSource customer=new CustomerSource();
	customer.setCustomersourceId(poref1.getCustomersourceId());
	customer.setSource(poref1.getSource());
	
	masterMastersdao.editCustomerSource(customer);
}


@Override
public List<StateBean> stateListbycountryid(String cuntryid) {
	List<State> list=masterMastersdao.getstatelistbycountryid(cuntryid);
	List<StateBean> beanlist=new ArrayList<>();
	Integer id=Integer.parseInt(cuntryid);
	for(State state:list){
		StateBean statebean=new StateBean();
		statebean.setCountryId(id);
		statebean.setStateId(state.getStateId());
		statebean.setState(state.getState());
		System.out.println(state.getState());
		beanlist.add(statebean);
	}
	
 	return beanlist;
}

@Override
public List<DistrictBean> districtListbystateid(String stateid) {
	List<District> list=masterMastersdao.getdistrictlistbystateid(stateid);
	List<DistrictBean> beanlist=new ArrayList<>();
	Integer id=Integer.parseInt(stateid);
	for(District district:list){
		DistrictBean districtbean=new DistrictBean();
		districtbean.setStateId(stateid);
		districtbean.setDistrictId(district.getDistrictId());
		districtbean.setDistrict(district.getDistrict());
		System.out.println(district.getDistrict());
		beanlist.add(districtbean);
	}
	
 	return beanlist;
}
@Override
public List<ModeOfDispatchBean> getModeOfDispatchList(){
	List<ModeOfDispatch> getdispatchelist = masterMastersdao.getModeOfDispatchList();
	List<ModeOfDispatchBean> getlist = new ArrayList<ModeOfDispatchBean>();
	for(ModeOfDispatch list : getdispatchelist){
		ModeOfDispatchBean data = new ModeOfDispatchBean();
		data.setModeofdispatchId(list.getModeofdispatchId());
		data.setModeofdispatch(list.getModeofdispatch());
		getlist.add(data);
	}
	return getlist;
}
@Override
@Transactional
public void addModeOfDispatch(ModeOfDispatchBean poref1) {
	ModeOfDispatch modeofdispatch=new ModeOfDispatch();
	modeofdispatch.setModeofdispatch(poref1.getModeofdispatch());
	
	masterMastersdao.addModeOfDispatch(modeofdispatch);
	
}

@Override
public void deleteModeOfDispatch(int id) {
	masterMastersdao.deleteModeOfDispatch(id);
}
@Override
public String getModeOfDispatchbyId(String id){
	List<ModeOfDispatch> modeofdispatch =masterMastersdao.getModeOfDispatchbyId(id);
	Map<String, Object> dd=new HashMap<>();
	for(ModeOfDispatch data: modeofdispatch)
	{
		
		dd.put("modeofdispatchId",data.getModeofdispatchId() );
		dd.put("modeofdispatch",data.getModeofdispatch());
	}
	Gson gson=new Gson();
	
	String list=	gson.toJson(dd);
		
		return list;	
}	


@Override
@Transactional
public void editModeOfDispatch(ModeOfDispatchBean poref1){
	ModeOfDispatch modeofdispatch=new ModeOfDispatch();
	modeofdispatch.setModeofdispatchId(poref1.getModeofdispatchId());
	modeofdispatch.setModeofdispatch(poref1.getModeofdispatch());
	
	masterMastersdao.editModeOfDispatch(modeofdispatch);
}

@Override
public List<TeamSegmentBean> getTeamSegmentList(){
	List<TeamSegment> teamsegmentlist = masterMastersdao.getTeamSegmentList();
	List<TeamSegmentBean> getlist = new ArrayList<TeamSegmentBean>();
	for(TeamSegment list : teamsegmentlist){
		TeamSegmentBean data = new TeamSegmentBean();
		data.setTeamid(list.getTeamid());
		data.setTeam(list.getTeam());
		getlist.add(data);
	}
	return getlist;
}
@Override
@Transactional
public void addteam(TeamSegmentBean poref1) {
	TeamSegment team=new TeamSegment();
	team.setTeam(poref1.getTeam());
	
	masterMastersdao.addteam(team);;
	
}

@Override
public void deleteteam(int id) {
	masterMastersdao.deleteteam(id);
}
@Override
public String getTeambyId(String id){
	List<TeamSegment> team =masterMastersdao.getTeambyId(id);
	Map<String, Object> dd=new HashMap<>();
	for(TeamSegment data: team)
	{
		
		dd.put("teamid",data.getTeamid() );
		dd.put("team",data.getTeam());
	}
	Gson gson=new Gson();
	
	String list=	gson.toJson(dd);
		
		return list;	
}	


@Override
@Transactional
public void editTeam(TeamSegmentBean poref1){
	TeamSegment team=new TeamSegment();
	team.setTeamid(poref1.getTeamid());
	team.setTeam(poref1.getTeam());
	
	masterMastersdao.editTeam(team);
}


@Override
public List<ServiceProviderBean> getServiceProviderList() {
	List<ServiceProvider> list=masterMastersdao.getServiceProviderList();
	List<ServiceProviderBean> list2=new ArrayList<>();
	for(ServiceProvider sp:list){
		ServiceProviderBean spb=new ServiceProviderBean();
		spb.setContactperson(sp.getContactperson());
		spb.setEmail(sp.getEmail());
		spb.setMobile(sp.getMobile());
		spb.setPhone(sp.getPhone());
		spb.setServiceaddress(sp.getServiceaddress());
		spb.setServicename(sp.getServicename());
		spb.setTransportationmodeid(sp.getTransportationmodeid());
		spb.setTransportationserviceid(sp.getTransportationserviceid());
		list2.add(spb);
		
	}
	return list2;
}

@Override
public void addServiceProvider(ServiceProviderBean serviceprovider) {
	ServiceProvider spb=new ServiceProvider();
	spb.setContactperson(serviceprovider.getContactperson());
	spb.setEmail(serviceprovider.getEmail());
	spb.setMobile(serviceprovider.getMobile());
	spb.setPhone(serviceprovider.getPhone());
	spb.setServiceaddress(serviceprovider.getServiceaddress());
	spb.setServicename(serviceprovider.getServicename());
	spb.setTransportationmodeid(serviceprovider.getTransportationmodeid());
	spb.setTransportationserviceid(serviceprovider.getTransportationserviceid());
	
	masterMastersdao.addServiceProvider(spb);
	
}

@Override
public ServiceProviderBean getServiceProvider(int id) {
	
	ServiceProvider sp=masterMastersdao.getServiceProvider(id);
	
	ServiceProviderBean bean=new ServiceProviderBean();
	bean.setContactperson(sp.getContactperson());
	bean.setEmail(sp.getEmail());
	bean.setMobile(sp.getMobile());
	bean.setPhone(sp.getPhone());
	bean.setServiceaddress(sp.getServiceaddress());
	bean.setServicename(sp.getServicename());
	bean.setTransportationmodeid(sp.getTransportationmodeid());
	bean.setTransportationserviceid(sp.getTransportationserviceid());
	
	return bean;
}

@Override
@Transactional
public void editSourceProviderbyId(ServiceProviderBean servicepro) {
	
	ServiceProvider sp=new ServiceProvider();
	
	sp.setContactperson(servicepro.getContactperson());
	sp.setEmail(servicepro.getEmail());
	sp.setMobile(servicepro.getMobile());
	sp.setPhone(servicepro.getPhone());
	sp.setServiceaddress(servicepro.getServiceaddress());
	sp.setServicename(servicepro.getServicename());
	sp.setTransportationmodeid(servicepro.getTransportationmodeid());
	sp.setTransportationserviceid(servicepro.getTransportationserviceid());
	
	masterMastersdao.editSourceProviderbyId(sp);
}

@Override
public List<CountryBean> countryDetails() 
{
	List<Country> countries=masterMastersdao.getCountryDetails();
	List<CountryBean> bean=new ArrayList<CountryBean>();
	for(Country data:countries)
	{
		CountryBean countryBean=new CountryBean();
		countryBean.setCountryId(data.getCountryId());
		countryBean.setCountry(data.getCountry());
		bean.add(countryBean);
	}
	
	return bean;
}

@Override
public List<CustomerLevelsBean> getCustomersStatusList() {
	List<CustomerLevels> cusStatus=masterMastersdao.getCustomerStatusDetailsList();
	List<CustomerLevelsBean> beans=new ArrayList<CustomerLevelsBean>();
	for(CustomerLevels status:cusStatus)
	{
		CustomerLevelsBean cstatus=new CustomerLevelsBean();
		cstatus.setId(status.getId());
		cstatus.setStatus(status.getStatus());
		beans.add(cstatus);
	}
	return beans;
}

@Override
public List<StateBean> getStateByCountryId(int id) {
	List<State> state=masterMastersdao.getStateByContryId(id);
	List<StateBean> beans=new ArrayList<StateBean>();
	for(State data:state)
	{
		StateBean stateBean=new StateBean();
		stateBean.setStateId(data.getStateId());
		System.out.println("On service State"+ data.getStateId());
		stateBean.setState(data.getState());
		System.out.println("on Service"+ data.getState());

		Country country=data.getCountry();

		stateBean.setCountryId(country.getCountryId());
		stateBean.setCountryName(country.getCountry());
		beans.add(stateBean);
	}
	return beans;
}

@Override
public List<LocationBean> getLocationDetails() 
{
	List<Location> locations=masterMastersdao.getLocationDetails();
	List<LocationBean> locationbeans=new ArrayList<LocationBean>();
	for(Location data:locations)
	{
		LocationBean bean=new LocationBean();
		bean.setLocationId(data.getLocationId());
		bean.setLocation(data.getLocation());
		locationbeans.add(bean);
	}
	return locationbeans;
}

@Override
public List<DistrictBean> getDistrictByStateIdAndcountryId(int id) 
{
	List<District> districts=masterMastersdao.getdistrictByStateIdAndCountryId(id);
	List<DistrictBean> districtBeans=new ArrayList<DistrictBean>();
	for(District data:districts)
	{
		DistrictBean bean=new DistrictBean();
		bean.setDistrictId(data.getDistrictId());

		bean.setDistrict(data.getDistrict());
		System.out.println("on service" +data.getDistrict());
		System.out.println("on service District" +data.getDistrict());
		State state=data.getState();
		bean.setStatesId(state.getStateId());
		bean.setStateName(state.getState());
		System.out.println("On Service for district"+state.getState());
		bean.setStatesId(state.getStateId());
		bean.setCountryName(state.getCountry().getCountry());
		bean.setCountryId(state.getCountry().getCountryId());
		districtBeans.add(bean);

	}
	return districtBeans;
}

@Override
public void deleteServiceprovider(int id) {
	
	masterMastersdao.deleteserviceprovider(id);
	

}



/*@Override
public List<AddPlan> actionPlanList() {
	return masterMastersdao.actionPlanList();
}


@Override
public AddActionBean EditForActionPlan(int id) {
	
	AddAction addaction=masterMastersdao.getplanDataById(id);
	AddActionBean actionbean= new AddActionBean();
	actionbean.setAction(addaction.getAction());
	return actionbean;
	
}*/


/*@Override
@Transactional
public void saveAddAction(AddPlanBean planbean) {
	
	AddPlan bean=new AddPlan();
	bean.setPlan(planbean.getPaln());
	masterMastersdao.saveAddAction(bean);
	
}*/

@Override

public List<AddActionBean> findAllAction() {
	List<AddAction> actionlist=masterMastersdao.getactiondata();
	List<AddActionBean> actionbean=new ArrayList<AddActionBean>();
	
	
	for(AddAction data:actionlist)
	{
		AddActionBean bean=new AddActionBean();
		bean.setId(data.getId());
		bean.setAction(data.getAction());
		actionbean.add(bean);
	}
	return actionbean;
}
public List<AddPlanBean> getActionList() {
	List<AddPlan> addplan=masterMastersdao.getActionList();
	List<AddPlanBean> bean=new ArrayList<>();
  return bean;
	
}

@Override
public void saveAddAction(AddActionBean actionBean2) 
{
	AddAction action=new AddAction();
	action.setAction(actionBean2.getAction());
	masterMastersdao.saveAddAction(action);
	
}


@Override
public void addActionPlan(AddPlanBean poref1) {

	AddPlan plan=new AddPlan();
	plan.setPlan(poref1.getPlan());
	masterMastersdao.addActionPlan(plan);

	

	
}

@Override
public AddActionBean getActionById(int id) {
     AddAction action=masterMastersdao.getActionDataById(id);
     AddActionBean bean=new AddActionBean();
     bean.setAction(action.getAction());
     bean.setId(action.getId());
     
	return bean;

}

@Override

@Transactional
public void editforAddAction(AddActionBean poref1) {
	AddAction action=new AddAction();
	action.setId(poref1.getId());
	action.setAction(poref1.getAction());
	
	masterMastersdao.editforAddAction(action);
	
}

@Override
public String getActionRecord(String id) {
	List<AddAction> action =masterMastersdao.getActionRecord(id);
	Map<String, Object> dd=new HashMap<>();
	for(AddAction data: action)
	{
		
		dd.put("customersourceId",data.getId() );
		dd.put("source",data.getAction());
			
	}
	Gson gson=new Gson();
	
String list=	gson.toJson(dd);
	
	return list;
}

@Override
public List<AddActionBean> getAddActionList() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void deleteaddAction(int id) {
	masterMastersdao.deleteaddAction(id);
	
}

@Override
public List<AddPlanBean> PlanList() {
	List<AddPlan> planlist=masterMastersdao.getplandata();
	List<AddPlanBean> planbean=new ArrayList<AddPlanBean>();
	for(AddPlan data:planlist)
	{
		AddPlanBean bean=new AddPlanBean();
		bean.setId(data.getId());
		bean.setPlan(data.getPlan());
		planbean.add(bean);
	}
	return planbean;
}
public void saveSupplierMaster(SupplierMasterBean servicepro) {
	SupplierMaster sm=new SupplierMaster();
	sm.setAddress(servicepro.getAddress());
	sm.setCurrency(servicepro.getCurrency());
	sm.setName(servicepro.getName());
	masterMastersdao.saveSupplierMaster(sm);
}

@Override
public List<SupplierMasterBean> getSupplierMaster() {
	List<SupplierMaster> sm=masterMastersdao.getSupplierMaster();
	List<SupplierMasterBean> bean=new ArrayList<>();
	for(SupplierMaster s:sm){
		SupplierMasterBean sbean=new SupplierMasterBean();
		sbean.setAddress(s.getAddress());
		sbean.setCurrency(s.getCurrency());
		sbean.setName(s.getName());
		sbean.setSuppliermasterid(s.getSuppliermasterid());
		bean.add(sbean);
	}
	return bean;
}

@Override
public String getSupmst(String id) {
	List<SupplierMaster> sm=masterMastersdao.getSupmst(id);
	Map<String, Object> dd=new HashMap<>();
		for(SupplierMaster data: sm)
	{
		
		dd.put("id", data.getSuppliermasterid());
		dd.put("name", data.getName());
		dd.put("address",data.getAddress());
		dd.put("currency",data.getCurrency());
	}
		Gson gson=new Gson();
		
	String suppliermst=	gson.toJson(dd);
	
	return suppliermst;
}

@Override
@Transactional
public void editSupplierMaster(SupplierMasterBean servicepro) {
	
	SupplierMaster sm=new SupplierMaster();
	sm.setAddress(servicepro.getAddress());
	sm.setCurrency(servicepro.getCurrency());
	sm.setName(servicepro.getName());
	sm.setSuppliermasterid(servicepro.getSuppliermasterid());
	masterMastersdao.editSupplierMaster(sm);
}

@Override
@Transactional
public void deleteSuppilerMst(int id) {
	
		masterMastersdao.deleteSuppilerMst(id);
	
}


	



@Override
public String getplanRecord(String id) {
	List<AddPlan> plan =masterMastersdao.getplanRecord(id);
	Map<String, Object> dd=new HashMap<>();
	for(AddPlan data:plan)
	{
		
		dd.put("id",data.getId());
		dd.put("plan",data.getPlan());
		
		
	}
	Gson gson=new Gson();
	
String list=	gson.toJson(dd);
	
	return list;
}

@Override
@Transactional
public void updateForAddPaln(AddPlanBean planbean) {
	
		AddPlan action=new AddPlan();
		action.setId(planbean.getId());
		action.setPlan(planbean.getPlan());
		
		masterMastersdao.updateForAddPaln(action);
	
}

@Override
public void deleteAddPlan(int id) {
	AddPlan plan = masterMastersdao.getplanById(id);
	masterMastersdao.deleteAddPlan(plan);
	//AddPlan plan= masterMastersdao.deleteAddPlan(id);
	//masterMastersdao.updateAddPlan(plan);
	
}

@Override
public List<AddPlanBean> findAddPlan() {
	List<AddPlan> actionlist=masterMastersdao.getPlanata();
	List<AddPlanBean> actionbean=new ArrayList<AddPlanBean>();
	
	
	for(AddPlan data:actionlist)
	{
		AddPlanBean bean=new AddPlanBean();
		bean.setId(data.getId());
		bean.setPlan(bean.getPlan());
		actionbean.add(bean);
	}
	return actionbean;
}

@Override
@Transactional
public void saveExpenseEntry(ExpenseEntryBean bean) {
	
	UserEmployee useremp = new UserEmployee();
	useremp.setUserempid(bean.getUserempid());
	
	ExpenseEntry e=new ExpenseEntry();
	e.setExpentryid(bean.getExpentryid());
	e.setCrdate(bean.getCrdate());
	
	e.setOrgnisation(bean.getOrgnisation());
	
	
	
	
	
	//e.setUserid(bean.getUserid());
	e.setUseremp(useremp);
	e.setGrandtotal(bean.getGrandtotal());
	masterMastersdao.saveExpenseEntry(e);	
	
}

@Override
public void saveExpenseDetails(ExpenseDetailsBean details) {
	
	ExpenseDetails d = new ExpenseDetails();
	
	d.setExpensedetailsid(details.getExpensedetailsid());
	d.setExpensedate(details.getExpensedate());
	d.setExphead(details.getExphead());
	d.setDiscription(details.getDiscription());
	d.setRates(details.getRates());
	d.setQty(details.getQty());
	d.setTotal(details.getTotal());
	masterMastersdao.saveExpenseDetails(d);	
	
}

@Override
public Map<String, Double> getExpenseReportList(int id) {
	Map<String, Double> list1 = masterMastersdao.getExpenseReportList(id);
	List<ExpenseEntryBean> list2 = new ArrayList<ExpenseEntryBean>();
	/*for(ExpenseEntry list : list1 ){
		ExpenseEntryBean data = new ExpenseEntryBean();
		data.setExpentryid(list.getExpentryid());
		data.setCrdate(list.getCrdate());
		data.setOrgnisation(list.getOrgnisation());
		data.setEmpname(list.getUseremp().getFirstname()+" "+list.getUseremp().getLastname());
		
		
		
		data.setGrandtotal(list.getGrandtotal());
		
		data.setUserempid(list.getUseremp().getUserempid());
		data.setUserid(list.getUseremp().getFirstname());
		data.setUserid(list.getUseremp().getLastname());
		//System.out.println("userlist service impl *************************************"+list.getUserid());
		list2.add(data);
	}*/
	return list1;
}

@Override
public List<ExpenseEntryBean> getExpenseReportListByDate(String sdate , String edate) {
	List<ExpenseEntry> list1 = masterMastersdao.getExpenseReportListByDate(sdate, edate);
	List<ExpenseEntryBean> list2 = new ArrayList<ExpenseEntryBean>();
	for(ExpenseEntry list : list1){
		ExpenseEntryBean data = new ExpenseEntryBean();
		data.setExpentryid(list.getExpentryid());
		data.setGrandtotal(list.getGrandtotal());
		data.setCrdate(list.getCrdate());
		list2.add(data);
	}
	return list2;
}

@Override
public List<UserEmployeeBean> getAccountManagerList() {
	List<UserEmployee> accountmanagerlist = masterMastersdao.getAccountManagerList();
	List<UserEmployeeBean> aclist = new ArrayList<UserEmployeeBean>();
	for(UserEmployee list : accountmanagerlist){
		UserEmployeeBean data = new UserEmployeeBean();
		data.setUserempid(list.getUserempid());
		data.setFirstname(list.getFirstname()+" "+list.getLastname());
		data.setLastname(list.getLastname());
		aclist.add(data);
	}
	
	return aclist;
}

@Override
public List<UserEmployeeBean> accountManagerListBySelect(String manager) {
	List<UserEmployee> accountmanagerlist = masterMastersdao.getAccountManagerList(manager);
	List<UserEmployeeBean> aclist = new ArrayList<UserEmployeeBean>();
	for(UserEmployee list : accountmanagerlist){
		UserEmployeeBean data = new UserEmployeeBean();
		data.setUserempid(list.getUserempid());
		data.setFirstname(list.getFirstname());
		data.setLastname(list.getLastname());
		aclist.add(data);
	}
	
	return aclist;
}

@Override
public List<ExpenseDetailsBean> getExpenseReportDetailList() {
	List<ExpenseDetails> list = masterMastersdao.getExpenseReportDetailList();
	List<ExpenseDetailsBean> list1 = new ArrayList<ExpenseDetailsBean>();
	for(ExpenseDetails l : list){
		ExpenseDetailsBean data = new ExpenseDetailsBean();
		data.setExpensedate(l.getExpensedate());
		data.setDiscription(l.getDiscription());
		data.setExphead(l.getExphead());
		data.setQty(l.getQty());
		data.setTotal(l.getTotal());
		//data.s(masterMastersdao.getorgname);
		list1.add(data);
	}
	
	
	return list1;
	
}









}










