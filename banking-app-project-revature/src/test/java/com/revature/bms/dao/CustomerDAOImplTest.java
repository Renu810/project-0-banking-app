package com.revature.bms.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bms.model.Customer;





public class CustomerDAOImplTest {
	private CustomerDAO customerdao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 customerdao = new CustomerDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		customerdao=null;
	}

	@Test
	public void testAddCustomer() {
		int customerIdToTest = -999;
		Customer addedCustomer = new Customer(customerIdToTest, "abc" , "a", 120, 12, 123, "ab", "ccdd" );
		customerdao.addCustomer(addedCustomer);
		Customer retrievedCustomer = customerdao.getCuatomerById(-999);
		assertEquals(addedCustomer, retrievedCustomer);
		customerdao.deleteCustomer(customerIdToTest);
	}

	@Test
	public void testDeposit() {
		fail("Not yet implemented");
	}

	@Test
	public void testWithdraw() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewbalance() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateDetails() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetCuatomerById() {
		int customerIdToTest = -999;
		Customer addedCustomer = new Customer(customerIdToTest, "abc" , "a", 120, 12, 123, "ab", "ccdd");
		customerdao.addCustomer(addedCustomer);
		customerdao.getCuatomerById(-999);
		Customer retrievedCustomer = customerdao.getCuatomerById(-999);
		assertEquals( addedCustomer, retrievedCustomer);
		customerdao.deleteCustomer(customerIdToTest);

	}

	@Test
	public void testViewAllDetails() {
		int customerIdToTest = -999;
		List<Customer> originalCustomer1 = customerdao.ViewAllDetails();
		customerdao.addCustomer(new Customer(customerIdToTest, "abc" , "a", 120, 12, 123, "ab", "ccdd"));
		List<Customer> originalCustomer2 = customerdao.ViewAllDetails();
		assertEquals(originalCustomer2.size(), originalCustomer1.size() + 1);
		customerdao.deleteCustomer(customerIdToTest);
	}

	@Test
	public void testCheckUserCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsCustomerExists() {
		fail("Not yet implemented");
	}

}
