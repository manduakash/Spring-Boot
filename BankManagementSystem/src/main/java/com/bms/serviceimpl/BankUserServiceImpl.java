package com.bms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.entity.BankUser;
import com.bms.exception.GlobalException;
import com.bms.repository.BankUserRepository;
import com.bms.service.BankUserService;

@Service
public class BankUserServiceImpl implements BankUserService { // businesslogic class for BankUser

	// using repository interface
	@Autowired
	BankUserRepository userRepo;

//-------------------------------------------------------------------------------------------	

	// method for saving bank user
	@Override
	public BankUser createAccount(BankUser user) {

		// creating user a/c and saving into the DB
		return userRepo.save(user);
	}
//-------------------------------------------------------------------------------------------	

	// method for getting user details
	@Override
	public String balanceInquiry(long accountNo, int pin) {

		// finding user with a/c no. and pin
		BankUser user = userRepo.findByAccountNoAndPin(accountNo, pin);

		try {
			// null checking
			if (user == null)
				new GlobalException("Invalid account number or pin");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "user '" + user.getAccountHolder() + "' has " + user.getBalance() + " INR. in his "
				+ user.getAccountType() + " A/c.";
	}
//-------------------------------------------------------------------------------------------	

	// method for updating user a/c. details
	@Override
	public String deposite(long accountNo, int pin, BankUser newUser) {

		// finding user with a/c. no. and pin
		BankUser user = userRepo.findByAccountNoAndPin(accountNo, pin);

		try {
			// null checking
			if (user == null)
				new GlobalException("Invalid account number or pin");

			// checking existing balance before deposite
			if (user.getBalance() > 100000000000L) // I have setted the limit of user a/c. upto 100 billion
				new GlobalException("Limit reached, unable to deposite at this moment!");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// storing account balance before updating
		double oldBalance = user.getBalance();

		// updating balance
		user.setBalance(user.getBalance() + newUser.getBalance());

		// saving changes into the DB
		userRepo.save(user);

		return "Old balance " + oldBalance + " INR." + "\nDeposite amount  " + newUser.getBalance() + " INR."
				+ "\nUser '" + user.getAccountHolder() + "' has " + user.getBalance()
				+ " INR. current balance in his A/c.";

	}
//-------------------------------------------------------------------------------------------	

	// method for updating user a/c. details
	@Override
	public String withdrawal(long accountNo, int pin, BankUser newUser) {

		// finding user with a/c no. and pin
		BankUser user = userRepo.findByAccountNoAndPin(accountNo, pin);

		try {
			// null checking
			if (user == null)
				throw new GlobalException("Invalid account number or pin");

			// checking existing balance before withdraw
			if ((user.getBalance() - newUser.getBalance()) < 0)
				throw new GlobalException("Insufficient balance for withdraw");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// storing account balance before updating
		double oldBalance = user.getBalance();

		// updating balance
		user.setBalance(user.getBalance() - newUser.getBalance());

		// saving changes into the DB
		userRepo.save(user);

		return "Old balance " + oldBalance + " INR." + "\nWithrawal amount  " + newUser.getBalance() + " INR."
				+ "\nUser '" + user.getAccountHolder() + "' has " + user.getBalance()
				+ " INR. current balance in his A/c.";
	}
//-------------------------------------------------------------------------------------------	

	// method for updating user a/c. details
	@Override
	public BankUser changePin(long accountNo, int pin, BankUser newUser) {

		// finding user with a/c. no. and pin
		BankUser user = userRepo.findByAccountNoAndPin(accountNo, pin);

		try {
			// null checking
			if (user == null)
				new GlobalException("Invalid account number or pin");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// updating pin
		user.setPin(newUser.getPin());

		// saving changes into the DB and return that entity
		return userRepo.save(user);
	}
//-------------------------------------------------------------------------------------------	

	// method for deleting user a/c.
	@Override
	public void deactivateAccount(long accountNo, int pin) {

		// finding user with a/c. no. and pin
		BankUser user = userRepo.findByAccountNoAndPin(accountNo, pin);

		try {
			// null checking
			if (user == null)
				new GlobalException("Invalid account number or pin");

		} catch (Exception e) {
			e.printStackTrace();
		}

		userRepo.deleteByAccountNoAndPin(accountNo, pin);
	}
//-------------------------------------------------------------------------------------------	

}
