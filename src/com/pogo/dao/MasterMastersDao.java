package com.pogo.dao;

import java.util.List;

import com.pogo.model.Country;
import com.pogo.model.CustomerLevels;
import com.pogo.model.CustomerSource;
import com.pogo.model.District;
import com.pogo.model.ExpenseMaster;
import com.pogo.model.Location;

import com.pogo.model.ModeOfDispatch;

import com.pogo.model.ServiceProvider;

import com.pogo.model.State;

import com.pogo.model.TeamSegment;
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

	 
	 List<District> districtList();
	 void addDistrict(District poref1);
	 void deleteDistrict(Integer id);
	 List<District> getDistrictById (String id);
	 void editDistrict(District poref1);
	 
	 List<Location> locationList(Integer id);
	 void addLocation(Location poref1);
	 void deleteLocation(int id);
	 List<Location> getLocationById (String id);
	 void editLocation(Location poref1);
	 
	 List<ExpenseMaster> expenseheadList();
	 void addExpensehead(ExpenseMaster poref1);
	 void deleteExpenceserheader(int id);
	 List<ExpenseMaster> getExpenceserheaderById (String id);
	 void editExpenseHeader(ExpenseMaster poref1);

	
	
	List<District> getdistrictlistbystateid(String stateid);
	List<State> getstatelistbycountryid(String cuntryid);
	List<ModeOfDispatch> getModeOfDispatchList();
	void addModeOfDispatch(ModeOfDispatch modeofdispatch);
	void deleteModeOfDispatch(int id);
	List<ModeOfDispatch> getModeOfDispatchbyId(String id);
	void editModeOfDispatch(ModeOfDispatch modeofdispatch);
	
	List<TeamSegment> getTeamSegmentList();
	void addteam(TeamSegment poref1);
	void deleteteam(int id);
	List<TeamSegment> getTeambyId(String id);
	void editTeam(TeamSegment team);


	 
	List<CustomerSource> getCustomerSourceList();
	void deleteCustomerSource(int id);
	void addCustomerSource(CustomerSource cur);
	List<CustomerSource> getCustomerSource(String id);
	void editCustomerSource(CustomerSource customer);

	
	List<ServiceProvider> getServiceProviderList();
	void addServiceProvider(ServiceProvider spb);
	ServiceProvider getServiceProvider(int id);
	void editSourceProviderbyId(ServiceProvider sp);
	List<Country> getCountryDetails();
	List<CustomerLevels> getCustomerStatusDetails();
	District getDistrictDataById(Integer districtId);
	Country getCountryDataById(Integer countryId);
	List<State> getStateByContryId(int id);
	
	State getStatesById(Integer stateId);
	List<Location> getLocationDetails();
	Location getLocations(Integer sublocationId);
	CustomerLevels getCustomerStatusById(Integer customerLevelId);
	List<District> getdistrictByStateIdAndCountryId(int id,int countryId);
	void deleteserviceprovider(int id);
	


}
