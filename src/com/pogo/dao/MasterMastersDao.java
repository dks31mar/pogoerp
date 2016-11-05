package com.pogo.dao;

import java.util.List;

import com.pogo.bean.CountryBean;
import com.pogo.bean.CustomerLevelsBean;
import com.pogo.bean.StateBean;
import com.pogo.model.Country;
import com.pogo.model.CustomerLevels;
import com.pogo.model.State;
import com.pogo.model.Unit;

public interface MasterMastersDao {
	List<CustomerLevels> customerLevelsList();
	 void addCustomerLevels(CustomerLevels poref1);
	 void deleteCustomerLevels(int id);
	 List<CustomerLevels> getCustomerLevelsById(String id);
	 void editCustomerLevels(CustomerLevels poref1);
	 List<Country> countryList();
	 void addCountry( Country poref1);
	 void  deleteCountry(Integer id);
	 List<Country> getCountryById (String id);
	 void editCountry(Country poref1);
	 List<State> stateList();
	 void addState(State poref1);
	 List<Country> getdata (String id);
	
	 void  deleteState(Integer id);
	 List<State> getStateById (String id);
	 void editState(State poref1);
}
