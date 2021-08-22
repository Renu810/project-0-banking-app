package com.revature.bms.model;

import java.io.Serializable;


public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int employeeId;
	private String employeeName;
	private String password;
	private int joiningDate;
	private int phoneNo;
	private String gender;
	private String department;
	private String address;

	
	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public Employee(int employeeId, String password) {
		super();
		this.employeeId = employeeId;
		this.password = password;
	}


	public Employee(int employeeId, String employeeName, String password) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
	}


	public Employee(int employeeId, String employeeName, String password, int joiningDate, int phoneNo, String gender,
			String department, String address) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.joiningDate = joiningDate;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.department = department;
		this.address = address;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(int joiningDate) {
		this.joiningDate = joiningDate;
	}


	public int getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "\n Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", password=" + password
				+ ", joiningDate=" + joiningDate + ", phoneNo=" + phoneNo + ", gender=" + gender + ", department="
				+ department + ", address=" + address + "]";
	}


	
	
	
}
