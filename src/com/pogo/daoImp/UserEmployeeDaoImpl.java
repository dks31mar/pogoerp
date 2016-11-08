package com.pogo.daoImp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.dao.UserEmployeeDao;
import com.pogo.model.Designation;
import com.pogo.model.UserEmployee;
import com.sun.org.glassfish.gmbal.Description;

@Repository("userEmployeeDao")
public class UserEmployeeDaoImpl implements UserEmployeeDao {
	@Autowired
	private SessionFactory sessionf;

	@Override
	public void addUser(UserEmployee emp) {
		sessionf.getCurrentSession().save(emp);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEmployee> getuserData() {
		return (List<UserEmployee>) sessionf.getCurrentSession().createCriteria(UserEmployee.class)
				.add(Restrictions.eq("active", true)).list();
	}

	@Override
	public UserEmployee getUserById(int id) {

		return (UserEmployee) sessionf.getCurrentSession().createCriteria(UserEmployee.class)
				.add(Restrictions.eq("active", true)).add(Restrictions.eq("userempid", id)).uniqueResult();
	}

	@Override
	public void updateUser(UserEmployee user) {
		sessionf.getCurrentSession().update(user);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEmployee> searchUser(String loginname) {
		return sessionf.getCurrentSession().createCriteria(UserEmployee.class)
				.add(Restrictions.like("loginname", loginname + "%")).add(Restrictions.eq("active", true)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEmployee> getuserEmpId(int userId) {

		return (List<UserEmployee>) sessionf.getCurrentSession().createCriteria(UserEmployee.class)
				.add(Restrictions.eq("active", true)).add(Restrictions.eq("userempid", userId)).list();
	}

	@Override
	public void updateEmp(UserEmployee emp) {
		sessionf.getCurrentSession().update(emp);
		sessionf.getCurrentSession().flush();

	}

	@Override
	public UserEmployee getEmployee(int empid) {
		return (UserEmployee) sessionf.getCurrentSession().get(UserEmployee.class, empid);
	}

	@Override
	public UserEmployee get(Integer userempid) {

		return (UserEmployee) sessionf.getCurrentSession().createCriteria(UserEmployee.class)
				.add(Restrictions.eq("userempid", userempid));
	}

	@Override
	public void createDesign(Designation degn) {
		sessionf.getCurrentSession().save(degn);

	}

	@SuppressWarnings("unchecked")
	@Override

	public List<String> findDesignation(String designation) {

		List list = sessionf.getCurrentSession().createCriteria(Designation.class)
				.setProjection(Projections.property("designation")).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Designation> getDesignation() {

		return sessionf.getCurrentSession().createCriteria(Designation.class).addOrder(Order.asc("level")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Designation> getDesignation(int designationid) {

		return sessionf.getCurrentSession().createCriteria(Designation.class)
				.add(Restrictions.eq("designationid", designationid)).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Designation> getDesignationname() {
		return sessionf.getCurrentSession().createCriteria(Designation.class).addOrder(Order.asc("level")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Designation> findlistBylevel(int h) {

		return sessionf.getCurrentSession().createCriteria(Designation.class).add(Restrictions.gt("level", h - 1))
				.list();
	}

	@Override
	public void upDatelevel(Designation u) {
		sessionf.getCurrentSession().createQuery(
				"Update Designation SET designation=" + u.getDesignation() + "WHERE designationid=" + u.getLevel() + 1)
				.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Designation> findDesignationByPageNo(int i) {
		return sessionf.getCurrentSession().createCriteria(UserEmployee.class).add(Restrictions.eq("active", true))
				.setMaxResults(5).setFirstResult(i * 5).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Designation> forDesignationGetId(int desgid) {
		
		return sessionf.getCurrentSession().createCriteria(Designation.class).add(Restrictions.eq("designationid", desgid)).list();
	}

	@Override
	public void updateDesignation(Designation deg) {
		sessionf.getCurrentSession().update(deg);
		
	}

	@Override
	public Designation getDesgById(int id) {
		
		 return (Designation) sessionf.getCurrentSession().get(Designation.class, id);
		
		
	
	}

	@Override
	public void deleteDesignation(Designation deg) {
		sessionf.getCurrentSession().delete(deg);
		
	}

}
