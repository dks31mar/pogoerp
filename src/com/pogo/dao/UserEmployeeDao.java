package com.pogo.dao;

import java.util.List;

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

	

}
