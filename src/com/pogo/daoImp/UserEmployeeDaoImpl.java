package com.pogo.daoImp;


import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.UserEmployeeDao;
import com.pogo.model.UserEmployee;

@Repository("userEmployeeDao")
public class UserEmployeeDaoImpl implements UserEmployeeDao
{
	@Autowired
	private SessionFactory sessionf;

	@Override
	public void addUser(UserEmployee emp) {
		sessionf.getCurrentSession().save(emp);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEmployee> getuserData() {
		return (List<UserEmployee>)sessionf.getCurrentSession().createCriteria(UserEmployee.class)
				.add(Restrictions.eq("active", true))
				.list();
	}

	
	@Override
	public UserEmployee getUserById(int id) {
		
		return (UserEmployee) sessionf.getCurrentSession()
				.createCriteria(UserEmployee.class)
				.add(Restrictions.eq("active", true))
				.add(Restrictions.eq("userempid", id)).uniqueResult();
	}

	@Override
	public void updateUser(UserEmployee user) {
		sessionf.getCurrentSession().update(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEmployee> searchUser(String loginname) {
		return sessionf.getCurrentSession().createCriteria(UserEmployee.class)
				.add(Restrictions.like("loginname", loginname+"%"))
				.add(Restrictions.eq("active", true)).list();
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
		return (UserEmployee) sessionf.getCurrentSession().get(
				UserEmployee.class, empid);
	}

	@Override
	public UserEmployee get(Integer userempid) {
		
		return (UserEmployee) sessionf.getCurrentSession().createCriteria(UserEmployee.class).add(Restrictions.eq("userempid", userempid));
	}

	
}
