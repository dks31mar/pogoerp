package com.pogo.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.dao.EmployeeDao;
import com.pogo.model.Employee1;
import com.pogo.service.EmployeeService;

@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmployee(Employee1 employee) {
		employeeDao.addEmployee(employee);
	}
	@Override
	public List<Employee1> listEmployeess() {
		return employeeDao.listEmployeess();
	}
	@Override
	public Employee1 getEmployee(int empid) {
		return employeeDao.getEmployee(empid);
	}
	@Override
	public void deleteEmployee(Employee1 employee) {
		employeeDao.deleteEmployee(employee);
	}

}