package com.bms.service;

import com.bms.entity.BankUser;

public interface BankUserService {
	
	// for creating new user account
	BankUser createAccount(BankUser user);
	
	// for fetching user account details
	String balanceInquiry(long accountNo, int pin) ;
	
	// for updating user account details
	String deposite(long accountNo , int pin, BankUser user) ;
	
	// for updating user account details
	String withdrawal(long accountNo, int pin, BankUser user) ;

	// for updating user account details
	BankUser changePin(long accountNo, int pin, BankUser user) ;

	// for deleting existing user account
	void deactivateAccount(long accountNo, int pin) ;
}
