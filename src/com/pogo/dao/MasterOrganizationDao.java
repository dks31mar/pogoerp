package com.pogo.dao;

import java.util.List;

import com.pogo.model.CompanyProfile;
import com.pogo.model.CompetitiorsProfile;
import com.pogo.model.Designation;
import com.pogo.model.SmsAllocation;
import com.pogo.model.UserEmployee;
import com.pogo.model.Zones;

public interface MasterOrganizationDao {

	List<Zones> getBranches();

	void addZoneDeatils(Zones zon);

	Zones editZones(int empid);


	List<Zones> getStates();

	void updateRegion(Zones zon);

	Zones deleteRegion(int id);

	void deleteRegion(Zones zones);
	
	
	

	
	void addCompany(CompanyProfile company);
	void addUser(UserEmployee emp);

	List<UserEmployee> getuserData();

	UserEmployee getUserById(int id);

	void updateUser(UserEmployee user);

	List<UserEmployee> searchUser(String loginname);

	List<UserEmployee> getuserEmpId(int userId);

	void updateEmp(UserEmployee emp);

	UserEmployee getEmployee(int empid);

	UserEmployee get(Integer userempid);

	void createDesign(Designation degn);

	List<String> findDesignation(String designation);

	List<Designation> getDesignation();

	List<Designation> getDesignation(int designationid);

	List<Designation> getDesignationname();

	List<Designation> findlistBylevel(int h);

	void upDatelevel(Designation level);

	public List<Designation> findDesignationByPageNo(int i);

	List<Designation> forDesignationGetId(int id);

	void updateDesignation(Designation deg);

	Designation getDesgById(int id);

	void deleteDesignation(Designation deg);


void saveDataCompetitiors(CompetitiorsProfile compti);

void updateCompetitior(CompetitiorsProfile comprof);

	

	void permitForSms(SmsAllocation sms);

	void denyForSms(SmsAllocation sms);

	List<SmsAllocation> getPermitSmsUser();


}

