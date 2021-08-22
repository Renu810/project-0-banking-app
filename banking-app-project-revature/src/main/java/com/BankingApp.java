package com;

import java.util.Date;
import java.util.Scanner;

//import org.apache.log4j.Logger;

import com.revature.bms.dao.CustomerDAO;
import com.revature.bms.dao.CustomerDAOImpl;
import com.revature.bms.dao.EmployeeDAO;
import com.revature.bms.dao.EmployeeDAOImpl;
import com.revature.bms.model.Customer;
import com.revature.bms.model.Employee;
import org.apache.log4j.*;

public class BankingApp {
	int choice = 0;
	Scanner sc = new Scanner(System.in);
	Employee employee =new Employee();
	Customer customer =new Customer();
	CustomerLogin customerLogin=new CustomerLogin();
	EmployeeLogin employeeLogin =new EmployeeLogin();
	EmployeeDAO employeedao = new EmployeeDAOImpl();
	CustomerDAO customerdao = new CustomerDAOImpl();
	
    boolean result;
    private static Logger logger = Logger.getLogger("BankingApp");
	public void startBankingApp() {
		System.out.println("Please enter your name : ");
		String username = sc.next();
		logger.info("Welcome , "+username + " you logged in at : "+new Date());
		System.out.println("Welcome , "+username);
		
		
		while(true) {
		System.out.println("####### Welcome TO Banking App  #######");
		System.out.println("1.Login ");
		System.out.println("2.Create Account ");
		
		System.out.println("7.E X I T ");
		
		System.out.println("Enter your choice : ");
		choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			logger.info("Started Login");
			System.out.println("welcome to Login Page.. Login as a Customer Or Employee : ");
			System.out.println("Enter E for Employee And C for Customer :");
			String choice2 =sc.next();
			if(choice2.equals("E")) {
				System.out.println("Login As a Employee...");
				employee=employeeLoginDetails();
//				System.out.println("######Login As a Employee..."+employee);
				result=employeedao.checkUserEmployee(employee);
//				System.out.println(result);
				if (result) {
					logger.info("Welcome to banking app " );
				    employeeLogin.afterEmployeeLogin();
				}		
				else {
					logger.info("sorry  check your id and password" );
							
				}
				
			}else if(choice2.equals("C")) {
				System.out.println("Login As a Customer...");
				customer=customerLoginDetails();
//				System.out.println("######Login As a Customer..."+customer);
				result=customerdao.checkUserCustomer(customer);
//				System.out.println(result);
				if (result) {
					logger.info("Welcome to banking app "  );
				customerLogin.afterCustomerLogin();
				}		
				else {
					logger.info("Sorry check your id and password " );
							
			}}
			else {System.out.println("Please Check your login option  and Try Again....  ");}
			break;
			
			
			
		case 2:
			System.out.println("welcome to banking app.. Plz Create account As Customer or Employee : ");
			System.out.println("Enter E for Employee And C for Customer :");
			String choice1 =sc.next();
			if(choice1.equals("E")) {
				
				System.out.println("Creating Employee Account .....");
				employee =acceptEmployeeDetails();
				if (employeedao.isEmployeeExists(employee.getEmployeeId())) {
					logger.error("Employee with employee id : " + employee.getEmployeeId() + " already  exists");
				} else {
					logger.debug("Employee added");
				result=employeedao.addEmployee(employee);
				 if(result)
					 logger.info("Congratulations "+employee.getEmployeeName() +" Your Account is created succesfully....");
	    		   else
	    			   logger.info("Sorry "+employee.getEmployeeName() +" Your Account is Not Created Plz Try again....");
			         }}
				else if(choice1.equals("C")) {
				System.out.println("Creating Customer Account .....");
				customer =acceptCustomerDetails();
				if (customerdao.isCustomerExists(customer.getCustomerId())) {
					logger.error("Customer with customer id : " + customer.getCustomerId() + " already  exists");
				} else {
					logger.debug("Customer added");
				result=customerdao.addCustomer(customer);
				 if(result)
					 logger.info("Congratulations "+customer.getCustomerName() +" Your Account is created succesfully....");
	    		   else
	    			   logger.info("Sorry "+customer.getCustomerName() +" Your Account is Not Created Plz Try again....");
				
				}}
				else {
				System.out.println("Please Check your create account Type and Try Again....  ");
			}
			break;
			
			
			
			
			
		
		case 5:
			System.out.println("Please enter customer id to delete : ");
			int customerId = sc.nextInt();
			
			if(customerdao.isCustomerExists(customerId))
			{
				boolean resproduct = customerdao.deleteCustomer(customerId);
				System.out.println(resproduct + " deleted successfully :"+customerId);
			}
			else
			{
				System.out.println("Product with product id :"+customerId + " does not exists");
			}
			break;	
		case 6:
			System.out.println("Please enter employee id to delete : ");
			int employeeId = sc.nextInt();
			
			if(employeedao.isEmployeeExists(employeeId))
			{
				boolean resproduct = employeedao.deleteEmployee(employeeId);
				System.out.println(resproduct + " deleted successfully :"+employeeId);
			}
			else
			{
				System.out.println("Product with product id :"+employeeId + " does not exists");
			}
			break;	
		case 7:
			System.out.println("----Thanks For Using My Banking App-----");
			System.exit(0);
			break;		
		
		}
		
	}}
	
	
	public Customer acceptCustomerDetails() {
		System.out.println("Please enter customer id : ");
		int customerId = sc.nextInt();
		System.out.println("Please enter customer name : ");
		String customerName = sc.next();
		System.out.println("Please enter password: ");
		String password = sc.next();
		System.out.println("Please enter account number : ");
		int accountNumber = sc.nextInt();
		System.out.println("Please enter amount: ");
		int amount = sc.nextInt();
		System.out.println("Please enter phone numbert: ");
		int phoneNo = sc.nextInt();
		System.out.println("Please enter gender: ");
		String gender = sc.next();
		System.out.println("Please enter address: ");
		String address = sc.next();

		Customer customer = new Customer(customerId, customerName, password, accountNumber, phoneNo, gender, address);
		return customer;
	}
	
	
	public Employee acceptEmployeeDetails() {
		System.out.println("Please enter employee id : ");
		int employeeId = sc.nextInt();
		System.out.println("Please enter employee name : ");
		String employeeName = sc.next();
		System.out.println("Please enter password: ");
		String password = sc.next();
		System.out.println("Please enter joining date : ");
		int joiningDate = sc.nextInt();
		System.out.println("Please enter phone number: ");
		int phoneNo = sc.nextInt();
		System.out.println("Please enter gender: ");
		String gender = sc.next();
		System.out.println("Please enter department: ");
		String department = sc.next();
		System.out.println("Please enter address: ");
		String address = sc.next();

		Employee employee = new Employee(employeeId, employeeName, password, joiningDate, phoneNo, gender, department, address);
		return employee;
	}
	
	public Employee employeeLoginDetails() {
		System.out.println("Please enter your employee id : ");
		int employeeId = sc.nextInt();
		System.out.println("Please enter password: ");
		String password = sc.next();
		Employee employee = new Employee(employeeId, password);
		return employee;
		
	}
	
	public Customer customerLoginDetails() {
		System.out.println("Please enter your customer id : ");
		int customerId = sc.nextInt();
		System.out.println("Please enter password: ");
		String password = sc.next();
		Customer customer = new Customer(customerId, password);
		return customer;
		
	}
	
	
	
}
