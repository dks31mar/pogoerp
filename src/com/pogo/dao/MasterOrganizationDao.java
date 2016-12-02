package com.pogo.dao;

import java.util.List;

import com.pogo.model.Branch;
import com.pogo.model.CompanyProfile;
import com.pogo.model.CompetitiorsProfile;
import com.pogo.model.Designation;
import com.pogo.model.SmsAllocation;
import com.pogo.model.StateZone;
import com.pogo.model.UserEmployee;
import com.pogo.model.Zones;

public interface MasterOrganizationDao {

	List<Zones> getBranches();

	void addZoneDeatils(Zones zon);

	Zones editZones(int empid);
	List<Branch> getbranchDetails();

	List<Zones> getStates();

	void updateRegion(Zones zon);

	Zones deleteRegion(int id);
	void updateBranch(Branch branch);
	void deleteRegion(Zones zones);
	
	void addStateDeatils(StateZone stateZone);
	Branch getDataById(int id);
	StateZone getStatesId(int id);
	
	void addCompany(CompanyProfile company);
	void addUser(UserEmployee emp);

	List<UserEmployee> getuserData();

	UserEmployee getUserById(int id);

	void updateUser(UserEmployee user);

	List<UserEmployee> searchUser(String loginname);

	void updateEmp(UserEmployee emp);

	UserEmployee getEmployee(int empid);

	UserEmployee get(Integer userempid);

	void createDesign(Designation degn);

	/*List<String> findDesignation(String designation);*/

	List<Designation> getDesignation();

	/*List<Designation> getDesignation(int designationid);*/

	List<Designation> getDesignationname();

	List<Designation> findlistBylevel(int h);

	void upDatelevel(Designation level);

	public List<Designation> findDesignationByPageNo(int i);

	List<Designation> forDesignationGetId(int id);

	void updateDesignation(Designation deg);

	Designation getDesgById(int id);

	void deleteDesignation(Designation deg);


	void updateEmpStatus(UserEmployee emp);

	UserEmployee getEmpId(int id);

	List<Designation> getDesgnationData();

	List<CompanyProfile> getCompanyData();

	List<Branch> getBranchData();
	
	Designation getData(Integer designationId);

	Branch getBranch(Integer branchId);

	CompanyProfile getCom(Integer subcompanyId);



void saveDataCompetitiors(CompetitiorsProfile compti);

void updateCompetitior(CompetitiorsProfile comp);

	void permitForSms(SmsAllocation sms);

	void denyForSms(SmsAllocation sms);

	List<SmsAllocation> getPermitSmsUser();

	List<StateZone> getZoneStates(Integer id);

	List<Zones> getZones();

	Zones getZone(Integer stateId);

	StateZone getStates(Integer branchId);

	void addBranch(Branch branch);

	List<StateZone> getstateData();

	void updateStates(StateZone stateZone);


	StateZone deleteState(int id);

	void deletedata(StateZone stateZone);

	List<Branch> getBranchbystate(int id);

	Branch deleteBranch(int id);

	void deletebr(Branch branch);

	List<UserEmployee> getUserEmp(String empName);

	CompetitiorsProfile getdataForCompiter(int id);

	List<CompetitiorsProfile> getCompData();

	void deletefeture(int id);

	List<CompetitiorsProfile> getCompetitiorsProfilebyid(String id);

	void editCompetitiorsProfile(CompetitiorsProfile profile);



	

	


	

	




}

