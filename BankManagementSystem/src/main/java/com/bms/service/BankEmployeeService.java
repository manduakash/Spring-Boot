package com.bms.service;

import java.util.List;

import com.bms.entity.BankEmployee;
import com.bms.entity.BankUser;

public interface BankEmployeeService {

	// for creating new Employee account
	BankEmployee createEmp(BankEmployee emp);

	// for fetching employee account details
	List<BankUser> fetchAllUsers(String username, String password);

	// for updating Employee account details
	BankEmployee changePassword(String username, String password, BankEmployee emp);

	// for deleting existing Employee account
	void deactivateAccount(String username, String password);

}
