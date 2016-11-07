package com.pogo.service;

import java.util.List;

import com.pogo.bean.CountryBean;
import com.pogo.bean.CustomerLevelsBean;
import com.pogo.bean.StateBean;
import com.pogo.bean.UnitBean;
import com.pogo.bean.ZonesBean;
import com.pogo.model.Country;
import com.pogo.model.CustomerLevels;
import com.pogo.model.State;


public interface MasterMastersService {

	List<CustomerLevels> customerLevelsList();
	void addCustomerLevels(CustomerLevelsBean poref1);
	void deleteCustomerLevels(int id);
	String getCustomerLevelsById(String id);
	void editCustomerLevels(CustomerLevelsBean poref1);
	List<Country> countryList();
	void addCountry(CountryBean poref1);
	void deleteCountry(Integer id);
	String getCountryById(String id);
	void editCountry(CountryBean poref1);

	List<State> stateList();
	void addState(StateBean poref1);
	void deleteState(Integer id);
	String getStateById(String id);
	void editState(StateBean poref1);

	
}
