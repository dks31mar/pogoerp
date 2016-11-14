package com.pogo.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.dao.MasterOrganizationDao;
import com.pogo.model.CompanyProfile;
import com.pogo.model.CompetitiorsProfile;
import com.pogo.model.Designation;
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
	public void addCompany(CompanyProfile company) {
		
		sessionFactory.getCurrentSession().save(company);
		sessionFactory.getCurrentSession().flush();
		
	}
	@Override
	public void addUser(UserEmployee emp) {
		sessionFactory.getCurrentSession().save(emp);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEmployee> getuserData() {
		return (List<UserEmployee>) sessionFactory.getCurrentSession().createCriteria(UserEmployee.class)
				.add(Restrictions.eq("active", true)).list();
	}

	@Override
	public UserEmployee getUserById(int id) {

		return (UserEmployee) sessionFactory.getCurrentSession().createCriteria(UserEmployee.class)
				.add(Restrictions.eq("active", true)).add(Restrictions.eq("userempid", id)).uniqueResult();
	}

	@Override
	public void updateUser(UserEmployee user) {
		sessionFactory.getCurrentSession().update(user);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEmployee> searchUser(String loginname) {
		return sessionFactory.getCurrentSession().createCriteria(UserEmployee.class)
				.add(Restrictions.like("loginname", loginname + "%")).add(Restrictions.eq("active", true)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEmployee> getuserEmpId(int userId) {

		return (List<UserEmployee>) sessionFactory.getCurrentSession().createCriteria(UserEmployee.class)
				.add(Restrictions.eq("active", true)).add(Restrictions.eq("userempid", userId)).list();
	}

	@Override
	public void updateEmp(UserEmployee emp) {
		sessionFactory.getCurrentSession().update(emp);
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public UserEmployee getEmployee(int empid) {
		return (UserEmployee) sessionFactory.getCurrentSession().get(UserEmployee.class, empid);
	}

	@Override
	public UserEmployee get(Integer userempid) {

		return (UserEmployee) sessionFactory.getCurrentSession().createCriteria(UserEmployee.class)
				.add(Restrictions.eq("userempid", userempid));
	}

	@Override
	public void createDesign(Designation degn) {
		sessionFactory.getCurrentSession().save(degn);

	}

	@SuppressWarnings("unchecked")
	@Override

	public List<String> findDesignation(String designation) {

		List list = sessionFactory.getCurrentSession().createCriteria(Designation.class)
				.setProjection(Projections.property("designation")).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Designation> getDesignation() {

		return sessionFactory.getCurrentSession().createCriteria(Designation.class).addOrder(Order.asc("level")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Designation> getDesignation(int designationid) {

		return sessionFactory.getCurrentSession().createCriteria(Designation.class)
				.add(Restrictions.eq("designationid", designationid)).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Designation> getDesignationname() {
		return sessionFactory.getCurrentSession().createCriteria(Designation.class).addOrder(Order.asc("level")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Designation> findlistBylevel(int h) {

		return sessionFactory.getCurrentSession().createCriteria(Designation.class).add(Restrictions.gt("level", h - 1))
				.list();
	}

	@Override
	public void upDatelevel(Designation u) {
		sessionFactory.getCurrentSession().createQuery(
				"Update Designation SET designation=" + u.getDesignation() + "WHERE designationid=" + u.getLevel() + 1)
				.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Designation> findDesignationByPageNo(int i) {
		return sessionFactory.getCurrentSession().createCriteria(UserEmployee.class).add(Restrictions.eq("active", true))
				.setMaxResults(5).setFirstResult(i * 5).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Designation> forDesignationGetId(int desgid) {
		
		return sessionFactory.getCurrentSession().createCriteria(Designation.class).add(Restrictions.eq("designationid", desgid)).list();
	}

	@Override
	public void updateDesignation(Designation deg) {
		sessionFactory.getCurrentSession().update(deg);
		
	}

	@Override
	public Designation getDesgById(int id) {
		
		 return (Designation) sessionFactory.getCurrentSession().get(Designation.class, id);
		
		
	
	}

	@Override
	public void deleteDesignation(Designation deg) {
		sessionFactory.getCurrentSession().delete(deg);
		
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

	public void saveDataCompetitiors(CompetitiorsProfile compti) {
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().save(compti);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateCompetitior(CompetitiorsProfile comprof) {
		// TODO Auto-generated method stub
		
	}

	

	

}