package com.pogo.service;

import java.text.ParseException;
import java.util.List;

import com.pogo.bean.UserEmployeeBean;


public interface UserEmployeeService 
{

	void adduserEmp(UserEmployeeBean userDTO)throws ParseException;

	UserEmployeeBean getUserById(int userId);

    List<UserEmployeeBean> getUserDetails();

	void deleteRecord(int id);

}
