package com;

import java.util.List;
import java.util.Scanner;

import com.revature.bms.dao.CustomerDAO;
import com.revature.bms.dao.CustomerDAOImpl;
import com.revature.bms.dao.EmployeeDAO;
import com.revature.bms.dao.EmployeeDAOImpl;
import com.revature.bms.model.Employee;




public class EmployeeLogin {
	Scanner sc =new Scanner(System.in);
	Employee employee =new Employee();
	EmployeeDAO employeedao = new EmployeeDAOImpl();
	 boolean result;
	public void afterEmployeeLogin() {
		while(true) {
		System.out.println("1.Update Your Details ");
		System.out.println("2.View Your Details ");
		System.out.println("5.E X I T ");
	     System.out.println("Enter your choice : ");
			int choice1 = sc.nextInt();
			switch (choice1) {		
			case 1:
				System.out
				.println("Wecome to update  section , "
						+ "please  enter details to  update ##");
				employee=acceptEmployeeDetails();
//				System.out.println("######Login As a Employee..."+employee);
				result = employeedao.updateDetails(employee);
//				System.out.println(result);
				if (result)
					System.out.println(
							"#Employee Id : " + employee.getEmployeeId() + " , updated successfully");
				else
					System.out.println(
							"#Employee Id  : " + employee.getEmployeeId() + ", not updated successfully");

				
				break;
			case 2:
				List<Employee> employees = employeedao.ViewDetails();
				System.out.println("View Your Details Here.. ##");
				System.out.println(employees);
				break;
			case 5:
				System.out.println("----Thank You-----");
				
				System.exit(0);
				break;	
				
				

	          }
		}
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
	
}