package com.pogo.serviceImp;

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
import com.pogo.bean.StateBean;
import com.pogo.dao.MasterMastersDao;
import com.pogo.model.Country;
import com.pogo.model.CustomerLevels;
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
		
		//masterMastersdao.getdata(poref1.getCountryId());
		//List<Country> list = masterMastersdao.getdata(id);
		
		State state=new State();
		state.setState(poref1.getState());
		//state.setCountryId(list);
		
		
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

}
