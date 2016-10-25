package com.pogo.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.EmployeeDao;
import com.pogo.model.Employee1;


@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addEmployee(Employee1 employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee1> listEmployeess() {
		return (List<Employee1>) sessionFactory.getCurrentSession().createCriteria(Employee1.class).list();
	}

	public Employee1 getEmployee(int empid) {
		return (Employee1) sessionFactory.getCurrentSession().get(Employee1.class, empid);
	}

	public void deleteEmployee(Employee1 employee) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE empid = "+employee.getEmpId()).executeUpdate();
	}

	

}
