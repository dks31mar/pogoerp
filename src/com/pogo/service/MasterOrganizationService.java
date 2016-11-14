package com.pogo.service;


import java.text.ParseException;
import java.util.List;

import com.pogo.bean.BranchBean;
import com.pogo.bean.CompanyProfileBean;
import com.pogo.bean.DesignationBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.bean.ZonesBean;
import com.pogo.model.CompanyProfile;
import com.pogo.model.UserEmployee;
import com.pogo.model.Zones;

public interface MasterOrganizationService {

	List<Zones> getBranches();
	
    public ZonesBean editZones(int id);

	void addZoneDeatils(ZonesBean poref);

	void addCompany(CompanyProfile company);
	void adduserEmp(UserEmployeeBean userDTO)throws ParseException;
	List<UserEmployee> getUserById(int userId);

    List<UserEmployeeBean> getUserDetails();

	void deleteuserEmp(int id);

	List<UserEmployeeBean> getUser(String loginname);

	public UserEmployeeBean getEmployee(int empid);

	void updateEmployee(UserEmployeeBean userEmployeeBean)throws ParseException;

	List<String> findDataByDesignation(String designation);

	List<DesignationBean> getDesignation();

	List<DesignationBean> getDesignation(int designationid);

	void updateandinsertbylevel(DesignationBean des);

	public DesignationBean getDesignationForEdit(int desgid);

	void updateDesignation(DesignationBean designationBean);

	void deleteDesignation(int id);

	void updateStatus(int id);

	List<DesignationBean> GetDesignationList();

	List<CompanyProfileBean> getCompanyList();

	List<BranchBean> getBranchList();

	

	

	

	

  
}
