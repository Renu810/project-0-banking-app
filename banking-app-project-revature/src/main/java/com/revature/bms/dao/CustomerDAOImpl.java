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

import com.revature.bms.util.DBConnection;




public class CustomerDAOImpl implements CustomerDAO{
	
	private static Logger logger = Logger.getLogger("CustomerDAOImpl");
	
	Connection connection = DBConnection.getDBConnection();
  int result1;
	private final String ADD_CUSTOMER_QUERY = "insert into hr.customer values(?,?,?,?,?,?,?,?)";
	private final String UPDATE_CUSTOMER_QUERY = "update hr.customer set customerName = ?, password=? , accountNumber = ? , amount = ? , phoneNo = ? , gender = ? , address = ? where customerId = ?";
	private final String FIND_CUSTOMER_DETAIL = "select * from hr.customer";
	
	public boolean addCustomer(Customer customer) {
		int res=0;
		logger.info("Adding Cuatomer with the name : "+customer.getCustomerName());
		try {
			PreparedStatement statement = connection.prepareStatement(ADD_CUSTOMER_QUERY);
			statement.setInt(1, customer.getCustomerId());
			statement.setString(2, customer.getCustomerName());
			statement.setString(3, customer.getPassword());
			statement.setInt(4, customer.getAccountNumber());
			statement.setInt(5, customer.getAmount());
			statement.setInt(6, customer.getPhoneNo());
			statement.setString(7, customer.getGender());
			statement.setString(8, customer.getAddress());
			
			res = statement.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error during adding customer with the name : "+customer.getCustomerName());
		}
		logger.info("Successfully Added customer with the name : "+customer.getCustomerName());
		if (res == 0)
			return false;
		else
			return true;
	}
	
	public boolean Deposit(int amount,int customerId) {
		int res=0;
		Customer customer=new Customer();
		try {
			PreparedStatement statement = connection.prepareStatement("update hr.customer set amount=amount+? where customerId=?");
			statement.setInt(1,amount);
			statement.setInt(2,customerId);
			
			res=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (res == 0)
			return false;
		else
			return true;
	
	}

	public boolean Withdraw(int amount1,int customerId1) {
		int res=0;
		Customer customer=new Customer();
		try {
			PreparedStatement statement = connection.prepareStatement("update hr.customer set amount=amount-? where customerId=?");
			statement.setInt(1, amount1);
			statement.setInt(2,customerId1);
			
			res=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (res == 0)
			return false;
		else
			return true;
	
	}

	public int viewbalance(int customerId) {
		ResultSet res ;
		int amount =0;
		Customer customer=new Customer();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from hr.customer where customerId=? ");
			statement.setInt(1,customer.getCustomerId());
			 res = statement.executeQuery();
			 res.next();
			 amount = res.getInt("amount");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return amount;
		
	}

	public boolean updateDetails(Customer customer) {
		int res = 0;
		
		try {
			PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_QUERY);
			statement.setInt(8, customer.getCustomerId());
			statement.setString(1, customer.getCustomerName());
			statement.setString(2, customer.getPassword());
			statement.setInt(3, customer.getAccountNumber());
			statement.setInt(4, customer.getAmount());
			statement.setInt(5, customer.getPhoneNo());
			statement.setString(6, customer.getGender());
			statement.setString(7, customer.getAddress());
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

	public List<Customer> ViewAllDetails() {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(FIND_CUSTOMER_DETAIL);
			while (res.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(res.getInt(1));
				customer.setCustomerName(res.getString(2));
				customer.setPassword(res.getString(3));
				customer.setAccountNumber(res.getInt(4));
				customer.setAmount(res.getInt(5));
				customer.setPhoneNo(res.getInt(6));
				customer.setGender(res.getString(7));
				customer.setAddress(res.getString(8));
				customers.add(customer);
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return customers;
	}
	public boolean checkUserCustomer(Customer customer) {
		boolean result = false;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from hr.customer where customerId = ? and password = ?");
//			PreparedStatement statement = connection.prepareStatement("select employeeId = ? and password = ? from hr.employee ");
			statement.setInt(1,customer.getCustomerId());
			statement.setString(2,customer.getPassword());
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

	public boolean isCustomerExists(int customerId) {
		boolean result = false;

		try {
			PreparedStatement stat = connection.prepareStatement("select * from hr.customer where customerId = ?");
			stat.setInt(1, customerId);
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

	public Customer getCuatomerById(int customerId) {
		Customer customer = new Customer();
		PreparedStatement stat = null;
		try {
			stat = connection.prepareStatement("select * from hr.customer where customerId = ?");
			stat.setInt(1, customerId);
			ResultSet res = stat.executeQuery();
			res.next();

			customer.setCustomerId(res.getInt("customerId"));
			customer.setCustomerName(res.getString("customerName"));
			customer.setPassword(res.getString("password"));
			customer.setAccountNumber(res.getInt("accountNumber"));
			customer.setAmount(res.getInt("amount"));
			customer.setPhoneNo(res.getInt("phoneNo"));
			customer.setGender(res.getString("gender"));
			customer.setAddress(res.getString("address"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

	public boolean deleteCustomer(int customerId) {
		boolean result = false;

		try {
			PreparedStatement stat = connection.prepareStatement("delete from hr.customer where customerId = ?");
			stat.setInt(1, customerId);

			stat.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	


