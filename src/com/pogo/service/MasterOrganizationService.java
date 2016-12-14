package com.pogo.service;


import java.text.ParseException;

import java.util.List;

import com.pogo.bean.AddActionBean;
import com.pogo.bean.BranchBean;
import com.pogo.bean.CompanyProfileBean;

import com.pogo.bean.CompetitiorsProfileBean;
import com.pogo.bean.DepartmentBean;
import com.pogo.bean.DesignationBean;
import com.pogo.bean.SmsAllocationBean;
import com.pogo.bean.StatezoneBean;
import com.pogo.bean.UserEmployeeBean;

import com.pogo.bean.ZonesBean;
import com.pogo.model.Branch;
import com.pogo.model.CompanyProfile;
import com.pogo.model.CompetitiorsProfile;
import com.pogo.model.UserEmployee;
import com.pogo.model.Zones;

public interface MasterOrganizationService {

	List<Zones> getBranches();

	void addZoneDeatils(ZonesBean poref);
	
	 public ZonesBean editZones(int empid);

	 List<BranchBean> getStateBranch();
	List<Zones> getStates();
	
	void addStates(StatezoneBean statezoneBean);
	public BranchBean getbranchById(int id);
	void addCompany(CompanyProfile company);
	void adduserEmp(UserEmployeeBean userDTO, String path)throws ParseException;
	StatezoneBean getSatesById(int id);
	void updateBranch(BranchBean branchBean,int id, int id2);

    List<UserEmployeeBean> getUserDetails()throws ParseException;

	void deleteuserEmp(int id);

	List<UserEmployeeBean> getUser(String loginname);

	public UserEmployeeBean getEmployee(int empid);

	void updateEmployee(UserEmployeeBean userEmployeeBean)throws ParseException;

	List<DesignationBean> getDesignation();

	void updateandinsertbylevel(DesignationBean des);

	public DesignationBean getDesignationForEdit(int desgid);

	void updateDesignation(DesignationBean designationBean);

	void deleteDesignation(int id);

	void updateStatus(int id);

	List<DesignationBean> GetDesignationList();

	List<CompanyProfileBean> getCompanyList();

	List<BranchBean> getBranchList();

	void updateregion(ZonesBean zonesBean);

	void deleteRegion(int id);
	void saveDataCompetitiors(CompetitiorsProfileBean poref);

	void updateCompetitior(CompetitiorsProfileBean compp);

	void permitForSms(SmsAllocationBean smsbean);

	void denyForSms(SmsAllocationBean smsbean);

	List<SmsAllocationBean> getPermitSmsUser();

	List<StatezoneBean> getZoneStates(Integer id);

	List<ZonesBean> getZoneslist();

	void addBranch(BranchBean branchBean);

	List<StatezoneBean> getstateData();

	void updateState(StatezoneBean statezoneBean, int id);

	void deletestate(int id);

	List<BranchBean> getBranchByState(int id);

	void deletebranch(int id);

	List<UserEmployeeBean> getUserByName(String empName);
  
	public CompetitiorsProfileBean getCompititerId(int id);

	List<CompetitiorsProfileBean> getcompetitiorList();

	void deletefeture(int id);

	void saveDepartment(DepartmentBean dep);

	List<DepartmentBean> getDepartmentDetails();

	
	String getCompetitiorsProfilebyid(String id);

	void editCompetitiorsProfile(CompetitiorsProfileBean poref1);

	String getdepartmentRecord(String id);

	void updatefordepartment(DepartmentBean addbean);

	void deletedepartment(int id);

	public String verifyLogin(String login);

	 public String verifyEmail(String email);




	

	
	
	

}
