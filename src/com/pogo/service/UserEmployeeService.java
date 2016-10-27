package com.pogo.service;

import java.text.ParseException;
import java.util.List;

import com.pogo.bean.UserEmployeeBean;
import com.pogo.model.UserEmployee;


public interface UserEmployeeService
{

	void adduserEmp(UserEmployeeBean userDTO)throws ParseException;

	UserEmployeeBean getUserById(int userId);

    List<UserEmployeeBean> getUserDetails();

	void deleteuserEmp(int id);

	List<UserEmployeeBean> getUser(String loginname);

	void deleteRecord(int id);

	

}
