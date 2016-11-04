package com.pogo.service;

import java.text.ParseException;
import java.util.List;

import com.pogo.bean.UserEmployeeBean;
import com.pogo.model.UserEmployee;


public interface UserEmployeeService
{

	void adduserEmp(UserEmployeeBean userDTO)throws ParseException;

	List<UserEmployee> getUserById(int userId);

    List<UserEmployeeBean> getUserDetails();

	void deleteuserEmp(int id);

	List<UserEmployeeBean> getUser(String loginname);

	public UserEmployeeBean getEmployee(int empid);

	void updateEmployee(UserEmployeeBean userEmployeeBean)throws ParseException;

	

	

	

}
