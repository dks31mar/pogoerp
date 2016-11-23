package com.pogo.service;

import java.util.List;

import com.pogo.bean.CountryBean;
import com.pogo.bean.CustomerLevelsBean;
import com.pogo.bean.CustomerSourceBean;
import com.pogo.bean.DistrictBean;
import com.pogo.bean.ExpenseMasterBean;
import com.pogo.bean.LocationBean;

import com.pogo.bean.ModeOfDispatchBean;
import com.pogo.bean.ServiceProviderBean;

import com.pogo.bean.StateBean;

import com.pogo.bean.TeamSegmentBean;
import com.pogo.bean.UnitBean;
import com.pogo.bean.ZonesBean;

import com.pogo.model.Country;
import com.pogo.model.CustomerLevels;
import com.pogo.model.District;
import com.pogo.model.ExpenseMaster;
import com.pogo.model.Location;
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

	
	List<District> districtList();
	void addDistrict(DistrictBean poref1);
	void deleteDistrict(Integer id);
	String getDistrictById(String id);
	void editDistrict(DistrictBean poref1);
	
	List<Location> locationList(Integer districtid);
	void addLocation(LocationBean poref1);
	void deleteLocation(int id);
	String getLocationById(String id);
	void editLocation(LocationBean poref1);
	
	List<ExpenseMaster> expenseheadList();
	void addExpensehead(ExpenseMasterBean poref1);
	void deleteExpenceserheader(int id);
    String getExpenceheaderById(String id);
	void editExpenseHeader(ExpenseMasterBean poref1);

	

	List<DistrictBean> districtListbystateid(String stateid);
	
	List<ModeOfDispatchBean> getModeOfDispatchList();
	void addModeOfDispatch(ModeOfDispatchBean poref1);
	void deleteModeOfDispatch(int id);
	String getModeOfDispatchbyId(String id);
	void editModeOfDispatch(ModeOfDispatchBean poref1);
	
	List<TeamSegmentBean> getTeamSegmentList();
	void addteam(TeamSegmentBean poref1);
	void deleteteam(int id);
	String getTeambyId(String id);
	void editTeam(TeamSegmentBean poref1);
	

	List<CustomerSourceBean> getCustomerSourceList();
	void deleteCustomerSource(int id);
	void addCustomerSource(CustomerSourceBean poref1);
	String getCustomerSource(String id);
	void editCustomerSource(CustomerSourceBean poref1);

	List<StateBean> stateListbycountryid(String cuntryid);
	List<ServiceProviderBean> getServiceProviderList();
	void addServiceProvider(ServiceProviderBean serviceprovider);
	ServiceProviderBean getServiceProvider(int id);
	void editSourceProviderbyId(ServiceProviderBean servicepro);
	List<CountryBean> countryDetails();
	List<CustomerLevelsBean> getCustomersStatus();
	List<StateBean> getStateByCountryId(int id);
	List<LocationBean> getLocationDetails();
	List<DistrictBean> getDistrictByStateIdAndcountryId(int id, int countryId);
	void deleteServiceprovider(int id);
	


}
