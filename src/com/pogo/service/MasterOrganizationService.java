package com.pogo.service;

import java.util.List;


import com.pogo.bean.ZonesBean;
import com.pogo.model.Zones;

public interface MasterOrganizationService {

	List<Zones> getBranches();

	void addZoneDeatils(ZonesBean poref);
	
	 public ZonesBean editZones(int empid);

	List<Zones> getStates();

	void updateregion(ZonesBean zonesBean);

	void deleteRegion(int id);
	
	
}
