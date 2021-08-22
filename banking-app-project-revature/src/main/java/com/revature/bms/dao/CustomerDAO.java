package com.revature.bms.dao;

import java.util.List;

import com.revature.bms.model.Customer;




public interface CustomerDAO {
	public boolean addCustomer(Customer customer);
	public boolean Deposit (int amount ,int customerId);
	public boolean Withdraw (int amount ,int customerId);
	public int viewbalance (int customerId);
	
	public boolean updateDetails(Customer customer);
	public List<Customer> ViewAllDetails ();
	public boolean checkUserCustomer(Customer customer);
	public boolean isCustomerExists(int customerId);
	public Customer getCuatomerById(int customerId);
	public boolean deleteCustomer(int customerId);
	
		
	
}
