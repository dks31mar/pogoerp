package com.pogo.dao;

import java.util.List;

import com.pogo.model.Zones;

public interface MasterOrganizationDao {

	List<Zones> getBranches();

	void addZoneDeatils(Zones zon);

	Zones editZones(int empid);

	List<Zones> getStates();

	void updateRegion(Zones zon);

	Zones deleteRegion(int id);

	void deleteRegion(Zones zones);
	
	
	
}

