package com.pogo.dao;

import java.util.List;

import com.pogo.model.UserEmployee;

public interface UserEmployeeDao 
{

	void addUser(UserEmployee emp);

	List<UserEmployee> getuserData();

	UserEmployee getUserId(int id);

}
