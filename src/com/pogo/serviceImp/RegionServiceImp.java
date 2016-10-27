package com.pogo.serviceImp;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.internal.compiler.util.GenericXMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

	
}
