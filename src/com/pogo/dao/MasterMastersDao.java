package com.pogo.dao;

import java.util.List;

import com.pogo.model.Country;
import com.pogo.model.CustomerLevels;
import com.pogo.model.CustomerSource;
import com.pogo.model.District;
import com.pogo.model.ExpenseMaster;
import com.pogo.model.Location;
import com.pogo.model.ServiceProvider;
import com.pogo.model.State;


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

	 
	 List<District> districtList();
	 void addDistrict(District poref1);
	 void deleteDistrict(Integer id);
	 List<District> getDistrictById (String id);
	 void editDistrict(District poref1);
	 
	 List<Location> locationList();
	 void addLocation(Location poref1);
	 void deleteLocation(int id);
	 List<Location> getLocationById (String id);
	 void editLocation(Location poref1);
	 
	 List<ExpenseMaster> expenseheadList();
	 void addExpensehead(ExpenseMaster poref1);
	 void deleteExpenceserheader(int id);
	 List<ExpenseMaster> getExpenceserheaderById (String id);
	 void editExpenseHeader(ExpenseMaster poref1);

	 
	List<CustomerSource> getCustomerSourceList();
	void deleteCustomerSource(int id);
	void addCustomerSource(CustomerSource cur);
	List<CustomerSource> getCustomerSource(String id);
	void editCustomerSource(CustomerSource customer);

	List<State> getstatelistbycountryid(String cuntryid);
	List<ServiceProvider> getServiceProviderList();
	void addServiceProvider(ServiceProvider spb);

}
