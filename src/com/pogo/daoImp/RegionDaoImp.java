package com.pogo.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.RegionDao;
import com.pogo.model.Zones;
@Repository("regionDao")
public class RegionDaoImp implements RegionDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Zones> getBranches() {
		return (List<Zones>)sessionFactory.getCurrentSession().createCriteria(Zones.class).list();
	}

	
	
}
