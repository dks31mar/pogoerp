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

	@Override
	public List<Zones> getBranches() {
		return (List<Zones>)sessionFactory.getCurrentSession().createCriteria(Zones.class).list();
		
	}


	@Override
	public Zones editZones(int empid) {
		return (Zones) sessionFactory.getCurrentSession().get(Zones.class, empid);
}

	@Override
	public void addZoneDeatils(Zones zon) {
		sessionFactory.getCurrentSession().save(zon);
	}
}
