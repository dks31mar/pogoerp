package com.pogo.dao;

import java.util.List;

import com.pogo.model.Zones;

public interface MasterOrganizationDao {

	List<Zones> getBranches();

	Zones editZones(int empid);

	void addZoneDeatils(Zones zon);
	
}

