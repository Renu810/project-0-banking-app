package com.revature.bms.dao;

import java.util.List;


import com.revature.bms.model.Employee;


public interface EmployeeDAO {
	public boolean addEmployee(Employee employee);
	public boolean updateDetails(Employee employee);
	public List<Employee> ViewDetails();
	public boolean checkUserEmployee(Employee employee);
	public boolean isEmployeeExists(int employeeId);
	public Employee getEmployeerById(int employeeId);
	public boolean deleteEmployee(int employeeId);
}
