package com.pogo.serviceImp;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.internal.compiler.util.GenericXMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.pogo.bean.UserEmployeeBean;
import com.pogo.dao.RegionDao;
import com.pogo.daoImp.RegionDaoImp;
import com.pogo.model.Zones;
import com.pogo.service.RegionService;

@Service("regionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RegionServiceImp implements RegionService{

	@Autowired
	private RegionDao regionDao;

	@Override
	public List<Zones> getBranches() {
		List<Zones> getbranch =regionDao.getBranches();
		for(Zones s:getbranch)
			System.out.println(s.getZonesname());
		
			
	
		return getbranch;
	}

	
	@Override
	public Zones getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zones> getUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	

	/*public void saveZones( RegionBean regbean) throws ParseException 
	   Zones zone=new Zones();
	zone.setZonesid(regbean.getZonesid());
	zone.setZonesname(regbean.getZonesname());
	zone.setZonesphone(regbean.getZonesphone());
	zone.setZonesmail(regbean.getZonesemail());
	zone.setZonesfax(regbean.getZonesfax());
	zone.setZonesaddress(regbean.getZonesaddress());
	userEmpdao.addUser(zone);
		
}*/
}