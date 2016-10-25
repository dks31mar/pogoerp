package com.pogo.service;

import java.util.List;

import com.pogo.model.Employee1;

public interface EmployeeService {
	
	
	public void addEmployee(Employee1 employee);

	public List<Employee1> listEmployeess();
	
	public Employee1 getEmployee(int empid);
	
	public void deleteEmployee(Employee1 employee);

	
}
