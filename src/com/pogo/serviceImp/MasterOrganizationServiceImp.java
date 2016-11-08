package com.pogo.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.pogo.bean.ZonesBean;
import com.pogo.dao.MasterOrganizationDao;
import com.pogo.model.Zones;
import com.pogo.service.MasterOrganizationService;

@Service("regionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MasterOrganizationServiceImp implements MasterOrganizationService{

	@Autowired
	private MasterOrganizationDao regionDao;

	@Override
	public List<Zones> getBranches() {
		List<Zones> getbranch =regionDao.getBranches();
		for(Zones s:getbranch)
			System.out.println(s.getZonesname());
		
			
	
		return getbranch;
	}

	
	 public ZonesBean  editZones(int empid) {
			Zones zones = regionDao.editZones(empid);
			ZonesBean bean=new ZonesBean();
			bean.setZonesid(zones.getZonesid());
			bean.setZonesname(zones.getZonesname());
			bean.setZonesphone(zones.getZonesphone());
			bean.setZonesemail(zones.getZonesemail());
			bean.setZonesfax(zones.getZonesfax());
			bean.setZonesaddress(zones.getZonesaddress());
			return bean;
}


	 @Override
		public void addZoneDeatils(ZonesBean poref) {
			Zones zon=new Zones();
			
			zon.setZonesaddress(poref.getZonesaddress());
			zon.setZonesemail(poref.getZonesemail());
			zon.setZonesname(poref.getZonesname());
			zon.setZonesfax(poref.getZonesfax());
			zon.setZonesphone(poref.getZonesphone());
			
			
			regionDao.addZoneDeatils(zon);
			
		}


	@Override
	public List<Zones> getStates() {
		List<Zones> getbranch =regionDao.getBranches();
		for(Zones s:getbranch)
			System.out.println(s.getZonesname());
		
			return getbranch;
	
	}


	@Override
	@Transactional
	public void updateregion(ZonesBean zonesBean) {
		Zones zon=new Zones();
		zon.setZonesid(zonesBean.getZonesid());
		zon.setZonesaddress(zonesBean.getZonesaddress());
		zon.setZonesemail(zonesBean.getZonesemail());
		zon.setZonesname(zonesBean.getZonesname());
		zon.setZonesfax(zonesBean.getZonesfax());
		zon.setZonesphone(zonesBean.getZonesphone());
		regionDao.updateRegion(zon);
	}


	@Override
	@Transactional
	public void deleteRegion(int id) {
		Zones zones =regionDao.deleteRegion(id);
		//System.out.println("on service"+zones.getZonesaddress());
		regionDao.deleteRegion(zones);
		
	}


	
	
}