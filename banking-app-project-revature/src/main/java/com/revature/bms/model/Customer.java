package com.revature.bms.model;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int customerId;
	private String customerName;
	private String password;
	private int accountNumber;
	private int amount;
	private int phoneNo;
	private String gender;
	private String address;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String password) {
		super();
		this.customerId = customerId;
		this.password = password;
	}

	public Customer(int customerId, String customerName, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
	}

	public Customer(int customerId, String customerName, String password, int accountNumber, int phoneNo, String gender,
			String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.accountNumber = accountNumber;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.address = address;
	}
	

	public Customer(int customerId, String customerName, String password, int accountNumber, int amount, int phoneNo,
			String gender, String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "\nCustomer [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
				+ ", accountNumber=" + accountNumber + ", amount=" + amount + ", phoneNo=" + phoneNo + ", gender="
				+ gender + ", address=" + address + "]";
	}

	

	
	
}
