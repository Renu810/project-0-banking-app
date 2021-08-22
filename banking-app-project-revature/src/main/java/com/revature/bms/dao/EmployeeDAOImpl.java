package com.revature.bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.bms.model.Customer;
import com.revature.bms.model.Employee;
import com.revature.bms.util.DBConnection;



public class EmployeeDAOImpl implements EmployeeDAO{
	private static Logger logger = Logger.getLogger("EmployeeDAOImpl");
	
	Connection connection = DBConnection.getDBConnection();
      
	private final String ADD_EMPLOYEE_QUERY = "insert into hr.employee values(?,?,?,?,?,?,?,?)";
	private final String UPDATE_EMPLOYEE_QUERY = "update hr.employee set employeeName = ?, password=? , joiningDate = ? , phoneNo = ? , gender = ? , department = ? , address = ? where employeeId = ?";
	private final String FIND_EMPLOYEE_DETAIL = "select * from hr.employee";
	
	

	
	public boolean addEmployee(Employee employee) {
		int res=0;
		logger.info("Adding Employee with the name : "+employee.getEmployeeName());
		try {
			PreparedStatement statement = connection.prepareStatement(ADD_EMPLOYEE_QUERY);
			statement.setInt(1, employee.getEmployeeId());
			statement.setString(2, employee.getEmployeeName());
			statement.setString(3, employee.getPassword());
			statement.setInt(4, employee.getJoiningDate());
			statement.setInt(5, employee.getPhoneNo());
			statement.setString(6, employee.getGender());
			statement.setString(7, employee.getDepartment());
			statement.setString(8, employee.getAddress());
			
			res = statement.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error during adding employee with the name : "+employee.getEmployeeName());
		}
		logger.info("Successfully Added employee with the name : "+employee.getEmployeeName());
		if (res == 0)
			return false;
		else
			return true;
	
	}

	public boolean updateDetails(Employee employee) {
		int res = 0;
		
		try {
			PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_QUERY);
			statement.setInt(8, employee.getEmployeeId());
			statement.setString(1, employee.getEmployeeName());
			statement.setString(2, employee.getPassword());
			statement.setInt(3, employee.getJoiningDate());
			statement.setInt(4, employee.getPhoneNo());
			statement.setString(5, employee.getGender());
			statement.setString(6, employee.getDepartment());
			statement.setString(7, employee.getAddress());
			res = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (res == 0)
			return false;
		else
			return true;
		
	}
	public List<Employee> ViewDetails() {
		List<Employee> employees = new ArrayList<Employee>();
		
		
			
			
			try {
				Statement statement = connection.createStatement();
				ResultSet res = statement.executeQuery(FIND_EMPLOYEE_DETAIL);
				while (res.next()) {
					Employee employee = new Employee();
					employee.setEmployeeId(res.getInt(1));
					employee.setEmployeeName(res.getString(2));
					employee.setPassword(res.getString(3));
					employee.setJoiningDate(res.getInt(4));
					employee.setPhoneNo(res.getInt(5));
					employee.setDepartment(res.getString(6));
					employee.setAddress(res.getString(7));
				   employee.setGender(res.getString(8));
				   employees.add(employee);
				   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		
		return employees;
	}

	public boolean checkUserEmployee(Employee employee) {
		boolean result = false;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from hr.employee where employeeId = ? and password = ?");
//			PreparedStatement statement = connection.prepareStatement("select employeeId = ? and password = ? from hr.employee ");
			statement.setInt(1,employee.getEmployeeId());
			statement.setString(2,employee.getPassword());
			ResultSet res = statement.executeQuery();
			
			if (res.next()) {
				result = true;
			}
			else {
				result=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	
	}

	public boolean isEmployeeExists(int employeeId) {
		boolean result = false;
		try {
			PreparedStatement stat = connection.prepareStatement("select * from hr.employee where employeeId = ?");
			stat.setInt(1, employeeId);
			ResultSet res = stat.executeQuery();

			if (res.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public Employee getEmployeerById(int employeeId) {
		Employee employee = new Employee();
		PreparedStatement stat = null;
		try {
			stat = connection.prepareStatement("select * from hr.employee where employeeId = ?");
			stat.setInt(1, employeeId);
			ResultSet res = stat.executeQuery();
			res.next();

			employee.setEmployeeId(res.getInt("employeeId"));
			employee.setEmployeeName(res.getString("employeeName"));
			employee.setPassword(res.getString("password"));
			employee.setJoiningDate(res.getInt("joiningDate"));
			employee.setPhoneNo(res.getInt("phoneNo"));
			employee.setGender(res.getString("gender"));
			employee.setDepartment(res.getString("department"));
			employee.setAddress(res.getString("address"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	public boolean deleteEmployee(int employeeId) {
		boolean result = false;

		try {
			PreparedStatement stat = connection.prepareStatement("delete from hr.employee where employeeId = ?");
			stat.setInt(1, employeeId);

			stat.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}	
	}	
	
	
	
	



