package com.bms.service;

import java.util.List;

import com.bms.entity.BankEmployee;
import com.bms.entity.BankManager;
import com.bms.entity.BankUser;

public interface BankManagerService {

	// for creating new manager account
	BankManager createManager(BankManager manager);

	// for fetching all users account details
	List<BankUser> fetchAllUsers(String username, String password);

	// for fetching all employees account details
	List<BankEmployee> fetchAllEmployees(String username, String password);

	// for updating manager account details
	BankManager changePassword(String username, String password, BankManager manager);

	// for deleting existing manager account
	void deactivateAccount(String username, String password);

	// for deleting existing user account
	void deactivateUser(String username, String password, long accountNo);

	// for deleting existing employee account
	void deactivateEmployee(String username, String password, String empUsername);

}
