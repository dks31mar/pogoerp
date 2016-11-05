package com.pogo.dao;

import java.util.List;

import com.pogo.model.Designation;
import com.pogo.model.UserEmployee;

public interface UserEmployeeDao 
{

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

	List<Designation> findlistBylevel();

	

	

}
