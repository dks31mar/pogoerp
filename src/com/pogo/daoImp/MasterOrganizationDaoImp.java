package com.pogo.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.MasterOrganizationDao;
import com.pogo.model.UserEmployee;
import com.pogo.model.Zones;
@Repository("regionDao")
public class MasterOrganizationDaoImp implements MasterOrganizationDao{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Zones> getBranches() {
		return (List<Zones>)sessionFactory.getCurrentSession().createCriteria(Zones.class).list();
		
	}

	@Override
	public void addZoneDeatils(Zones zon) {
		sessionFactory.getCurrentSession().save(zon);
	}


	@Override
	public Zones editZones(int empid) {
		return (Zones) sessionFactory.getCurrentSession().get(Zones.class, empid);

	}
	@SuppressWarnings("unchecked")
	public List<Zones> getStates() {
		return (List<Zones>)sessionFactory.getCurrentSession().createCriteria(Zones.class).list();
}

	@Override
	public void updateRegion(Zones zon) {
		System.out.println("Your zone id is \n"+zon.getZonesid());
		
		sessionFactory.getCurrentSession().update(zon);
		
	}

	@Override
	public Zones deleteRegion(int id) {
		return (Zones) sessionFactory.getCurrentSession().get(Zones.class, id);
		
		
	}

	@Override
	public void deleteRegion(Zones zones) {
		sessionFactory.getCurrentSession().delete(zones);
		
	}
}