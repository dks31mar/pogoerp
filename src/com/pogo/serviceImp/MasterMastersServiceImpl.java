package com.pogo.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.pogo.bean.CountryBean;
import com.pogo.bean.CustomerLevelsBean;
import com.pogo.bean.CustomerSourceBean;
import com.pogo.bean.DistrictBean;
import com.pogo.bean.ExpenseMasterBean;
import com.pogo.bean.LocationBean;
import com.pogo.bean.ServiceProviderBean;
import com.pogo.bean.StateBean;
import com.pogo.dao.MasterMastersDao;
import com.pogo.model.Country;
import com.pogo.model.CustomerLevels;
import com.pogo.model.CustomerSource;
import com.pogo.model.District;
import com.pogo.model.ExpenseMaster;
import com.pogo.model.Location;
import com.pogo.model.ServiceProvider;
import com.pogo.model.State;
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
	public List<Country> countryList(){
		return masterMastersdao.countryList();
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
		masterMastersdao.deleteCountry(id);
	}
	@Override
	public String getCountryById(String id){
		List<Country> country=masterMastersdao.getCountryById(id);
		Map<String, Object> dd=new HashMap<>();
 		for(Country data: country)
		{
			
			dd.put("countryId",data.getCountryId() );
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
		state.setCountry(c);
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
		State state=new State();
		state.setStateId(poref1.getStateId());
		state.setState(poref1.getState());
		
		masterMastersdao.editState(state);
	}

	public List<District> districtList(){
		return masterMastersdao.districtList();
	}
	
    @Override
    @Transactional
    public void addDistrict(DistrictBean poref1){
	  District district=new District();
	  district.setDistrict(poref1.getDistrict());
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
	District district=new District();
	district.setDistrictId(poref1.getDistrictId());
	district.setDistrict(poref1.getDistrict());
	
	masterMastersdao.editDistrict(district);
}
   
   @Override
	
	public List<Location> locationList(){
		return masterMastersdao.locationList();
	}
	
	@Override
	@Transactional
	public void addLocation(LocationBean poref1) {
		Location location=new Location();
		location.setLocation(poref1.getLocation());
		
		masterMastersdao.addLocation(location);
		
	}
	@Override
	@Transactional
	public void deleteLocation(int id){
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
		Location location=new Location();
		location.setLocationId(poref1.getLocationId());
		location.setLocation(poref1.getLocation());
		
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
	expensehead.setExpensetype(poref1.getExpensetype());
	expensehead.setExlimit(poref1.getExlimit());
	expensehead.setUnit(poref1.getUnit());
	
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
		dd.put("expensetype",data.getExpensetype() );
		dd.put("unit",data.getUnit() );
		dd.put("exlimit",data.getExlimit() );
		
		
		
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
	expensemaster.setExpensetype(poref1.getExpensetype());
	expensemaster.setExlimit(poref1.getExlimit());
	expensemaster.setUnit(poref1.getUnit());
	masterMastersdao.editExpenseHeader(expensemaster);
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
public Object getServiceProvider(int id) {
	// TODO Auto-generated method stub
	return null;
}

}
