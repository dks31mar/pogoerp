package com.pogo.service;

<<<<<<< HEAD
=======

import java.text.ParseException;
>>>>>>> branch 'master' of https://github.com/dks31mar/pogoerp.git
import java.util.List;

<<<<<<< HEAD

=======
import com.pogo.bean.DesignationBean;
import com.pogo.bean.UserEmployeeBean;
>>>>>>> branch 'master' of https://github.com/dks31mar/pogoerp.git
import com.pogo.bean.ZonesBean;
import com.pogo.model.CompanyProfile;
import com.pogo.model.UserEmployee;
import com.pogo.model.Zones;

public interface MasterOrganizationService {

	List<Zones> getBranches();

	void addZoneDeatils(ZonesBean poref);
	
	 public ZonesBean editZones(int empid);

<<<<<<< HEAD
	List<Zones> getStates();
=======
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
>>>>>>> branch 'master' of https://github.com/dks31mar/pogoerp.git

	void updateregion(ZonesBean zonesBean);

	void deleteRegion(int id);
	
	
}
