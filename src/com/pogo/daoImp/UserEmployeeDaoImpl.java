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

		return (List<UserEmployee>)sessionf.getCurrentSession().createCriteria(UserEmployee.class).list();
	}

	@Override
	public UserEmployee getUserId(int id) {
		
		return  (UserEmployee) sessionf.getCurrentSession().createCriteria(UserEmployee.class)
				.add(Restrictions.eq("userempid",id)).list();
	}

}
