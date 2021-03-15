package com.revature.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


import com.revature.models.Employee;
import com.revature.respositories.EmployeeDAO;
import com.revature.respositories.EmployeeDAOImpl;
import com.revature.services.EmployeeService;
import com.revature.services.ManagerService;

public class ServiceTest {
	
//	@Test
//	void testAccountDAOImplBalance() throws AccountNotFoundException, DatabaseConnectionException {
//		EmployeeDAOImpl accountDAOImpl = new EmployeeDAOImpl();
//		assert (accountDAOImpl.getBalance(22)) != null;
//	}
//	@Test
//	void testBalanceService() throws AccountNotFoundException, DatabaseConnectionException {
//		BalanceService balanceService = new BalanceService();
//		assert (balanceService.getBalance(22)) != null;
//		
//	}
//	@Test
//	void testPullApplicationService() throws AccountNotFoundException, DatabaseConnectionException {
//		PullApplicationService pullApplicationService = new PullApplicationService();
//		assert (pullApplicationService.getApplications()) != null;
//	
//	}
//	@Test 
//	void testViewTransactionsService() throws DatabaseConnectionException, AccountNotFoundException {
//	ViewTransactionsService viewTransactionsService = new ViewTransactionsService();
//	assert (viewTransactionsService.viewTransactions()) != null;
//		
//	}
//	@Test
//	void testEmployeeLoginService() throws DatabaseConnectionException, AccountNotFoundException, EmployeeNotFoundException {
//		EmployeeLoginService employeeLoginService = new EmployeeLoginService();
//		assert (employeeLoginService.lookforUNPW("Agent007", "L2kill")) != null;
//
//	}
	
	@SuppressWarnings("static-access")
	@Test
	void testFindRequests()  {
	ManagerService findAllRequestsTest = new ManagerService();
	assert(findAllRequestsTest.findAllRequests(10)) != null;
	
	}
	
	@Test
	void testfindAllResolved()   {
	ManagerService viewResolved = new ManagerService();
	assert (viewResolved.findAllR()) != null;
	
	
	}
	@Test
	void testEmployeeAllService()    {
	EmployeeService listAllEmployees = new EmployeeService();
	assert (listAllEmployees.findAll()) != null;

	}
	@Test
	void testEmployeeDAOImpl()  {
		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
	assert (employeeDAOImpl.findAllresolved(1000)) != null;
		
	}
	@Test
	 void testEmployeeDAO() {
	Employee employee = new Employee();
	 employee.getId();
	assert(employee.getId()==(0));
	
	
	}
	
}

