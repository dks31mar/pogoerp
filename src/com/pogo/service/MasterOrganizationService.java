package com.pogo.service;

import java.text.ParseException;
import java.util.List;


import com.pogo.bean.UserEmployeeBean;
import com.pogo.bean.ZonesBean;
import com.pogo.model.Zones;

public interface MasterOrganizationService {

	List<Zones> getBranches();
	
    public ZonesBean editZones(int id);

	void addZoneDeatils(ZonesBean poref);


  
}
