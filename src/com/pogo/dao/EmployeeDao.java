package com.pogo.dao;

import java.util.List;

import com.pogo.model.Employee1;


public interface EmployeeDao {
	
	
	public void addEmployee(Employee1 employee);

	public List<Employee1> listEmployeess();
	
	public Employee1 getEmployee(int empid);
	
	public void deleteEmployee(Employee1 employee);

	
}
