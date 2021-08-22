package com.revature.bms.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bms.model.Customer;
import com.revature.bms.model.Employee;

public class EmployeeDAOImplTest {
	private EmployeeDAO employeedao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		employeedao = new EmployeeDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		employeedao=null;
	}

	@Test
	public void testAddEmployee() {
		int employeeIdToTest = -999;
		Employee addedEmployee = new Employee(employeeIdToTest,"tt","kk",55,54,"tt","rr","uu");
		employeedao.addEmployee(addedEmployee);
		Employee retrievedEmployee = employeedao.getEmployeerById(-999);
		assertEquals(addedEmployee, retrievedEmployee);
		employeedao.deleteEmployee(employeeIdToTest);
	}

	@Test
	public void testUpdateDetails() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetEmployeerById() {
		int employeeIdToTest = -999;
		Employee addedEmployee = new Employee(employeeIdToTest,"tt","kk",55,54,"tt","rr","uu");
		employeedao.addEmployee(addedEmployee);
		employeedao.getEmployeerById(-999);
		Employee retrievedEmployee = employeedao.getEmployeerById(-999);
		assertEquals( addedEmployee, retrievedEmployee);
		employeedao.deleteEmployee(employeeIdToTest);

	}


	@Test
	public void testViewDetails() {
		int employeeIdToTest = -999;
		List<Employee> originalEmployee1 = employeedao.ViewDetails();
		employeedao.addEmployee(new Employee(employeeIdToTest,"tt","kk",55,54,"tt","rr","uu"));
		List<Employee> originalEmployee2 = employeedao.ViewDetails();
		assertEquals(originalEmployee2.size(), originalEmployee1.size() + 1);
		employeedao.deleteEmployee(employeeIdToTest);
	}

	@Test
	public void testCheckUserEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmployeeExists() {
		fail("Not yet implemented");
	}

}
