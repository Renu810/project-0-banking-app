package com;

import java.util.List;
import java.util.Scanner;

import com.revature.bms.dao.CustomerDAO;
import com.revature.bms.dao.CustomerDAOImpl;
import com.revature.bms.dao.EmployeeDAO;
import com.revature.bms.dao.EmployeeDAOImpl;
import com.revature.bms.model.Customer;
import com.revature.bms.model.Employee;

public class CustomerLogin {
//	BankingApp bankingapp = new BankingApp();
	Scanner sc = new Scanner(System.in);
	Customer customer = new Customer();
	CustomerDAO customerdao = new CustomerDAOImpl();
	boolean result;
	int result1;

	public void afterCustomerLogin() {

		while (true) {
			System.out.println("####### Welcome Customer  #######");
			System.out.println("1.Deposite Money ");
			System.out.println("2.Withdraw Money ");
//			System.out.println("3.Update Your Details ");
			System.out.println("4.View Your Details ");
			System.out.println("5.E X I T ");
			System.out.println("Enter your choice : ");
			int choice1 = sc.nextInt();
			switch (choice1) {
			case 1:
				System.out.println("Enter the id..");
				int customerId = sc.nextInt();
				System.out.println("Enter the amount to be deposite..");
				int amount = sc.nextInt();
//				System.out.println(amount);
//				System.out.println(customerId);
				result = customerdao.Deposit(amount, customerId);
				System.out.println(result);

				if (result)
					System.out.println("#Customer Id : " + customerId + " , amount Deposited successfully");
				else
					System.out.println("#Customer Id  : " + customerId + ", amount not Deposited successfully");

				break;
			case 2:
				System.out.println("Enter the id..");
				int customerId1 = sc.nextInt();
				System.out.println("Enter the amount to withdraw..");
				int amount1 = sc.nextInt();
//				System.out.println(amount1);
//				System.out.println(customerId1);
				result = customerdao.Withdraw(amount1, customerId1);
				System.out.println(result);

				if (result)
					System.out.println("#Customer Id : " + customerId1 + " , amount withdraw successfully");
				else
					System.out.println("#Customer Id  : " + customerId1 + ", amount not withdraw successfully");
				break;
//			case 3:
//				System.out.println("check your balance here");
//				System.out.println("enter yout cuatomerID :");
//				int customerId3 = sc.nextInt();
//				result1 = customerdao.viewbalance(customerId3);
//				System.out.println(result1);
//				System.out.println("Your Account balance  is :" + result1);
//				break;

			case 3:
				System.out.println("Wecome to update  section , " + "please  enter details to  update ##");
				customer = acceptCustomerDetails();
				result = customerdao.updateDetails(customer);
				if (result)
					System.out.println("#Customer Id : " + customer.getCustomerId() + " , updated successfully");
				else
					System.out.println("#Customer Id  : " + customer.getCustomerId() + ", not updated successfully");
				break;
			case 4:
				List<Customer> customers = customerdao.ViewAllDetails();
				System.out.println("View Your Details Here.. ##");
				System.out.println(customers);
				break;

			case 5:
				System.out.println("----Thanks For Using My Banking App-----");
				System.exit(0);
				break;	

			}
		}
	}

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
}
