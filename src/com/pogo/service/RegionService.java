package com.pogo.service;

import java.text.ParseException;
import java.util.List;

import com.pogo.bean.RegionBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.model.Zones;

public interface RegionService {

	List<Zones> getBranches();
	void saveEdit(RegionBean reg)throws ParseException;
	Zones getUserById(int userId);

    List<Zones> getUserDetails();

	
}
