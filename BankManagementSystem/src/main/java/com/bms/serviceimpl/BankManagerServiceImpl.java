package com.bms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.entity.BankEmployee;
import com.bms.entity.BankManager;
import com.bms.entity.BankUser;
import com.bms.exception.GlobalException;
import com.bms.repository.BankEmployeeRepository;
import com.bms.repository.BankManagerRepository;
import com.bms.repository.BankUserRepository;
import com.bms.service.BankManagerService;

@Service
public class BankManagerServiceImpl implements BankManagerService { // bank manager business logic class

	// using JPA crud operation with help of repository interfaces
	@Autowired
	BankUserRepository userRepo;
	@Autowired
	BankEmployeeRepository empRepo;
	@Autowired
	BankManagerRepository managerRepo;

//---------------------------------------------------------------------------------------------------	
	// method for saving manager into the db
	@Override
	public BankManager createManager(BankManager manager) {

		// saving into db 
		return managerRepo.save(manager);
	}
//---------------------------------------------------------------------------------------------------	
	
	//method for getting all users
	@Override
	public List<BankUser> fetchAllUsers(String username, String password) {

		try {
			// null checking
			if(managerRepo.findByUsernameAndPassword(username, password) == null)
				throw new GlobalException("Invalid manager credentials");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		// fetching all users
		return userRepo.findAll();

	}
//---------------------------------------------------------------------------------------------------	

	// method for getting all employees
	@Override
	public List<BankEmployee> fetchAllEmployees(String username, String password) {

		try {
			// null checking
			if(managerRepo.findByUsernameAndPassword(username, password) == null)
				throw new GlobalException("Invalid manager credentials");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		// fetching all employees
		return empRepo.findAll();
	}
//---------------------------------------------------------------------------------------------------	

	// method for updating password
	@Override
	public BankManager changePassword(String username, String password, BankManager newManager) {

		BankManager fetchedManager = managerRepo.findByUsernameAndPassword(username, password);

		try {
			// null checking
			if (managerRepo.findByUsernameAndPassword(username, password) == null)
				throw new GlobalException("Invalid manager credentials");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// updating value
		fetchedManager.setPassword(newManager.getPassword());

		// saving the updated value into the db
		return managerRepo.save(fetchedManager);
	}
//---------------------------------------------------------------------------------------------------	

	// method for deleting manager a/c.
	@Override
	public void deactivateAccount(String username, String password) {

		try {
			// null checking
			if (managerRepo.findByUsernameAndPassword(username, password) == null)
				throw new GlobalException("Invalid manager credentials");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// deleting manager a/c.
		managerRepo.deleteById(username);
	}
//---------------------------------------------------------------------------------------------------	
	
	// method for deleting bank user 
	@Override
	public void deactivateUser(String username, String password, long accountNo) {

		try {
			// null checking
			if (managerRepo.findByUsernameAndPassword(username, password) == null)
				throw new GlobalException("Invalid manager credentials");

		} catch (Exception e) {
			e.printStackTrace();
		}
		// deleting user a/c.
		userRepo.deleteById(accountNo);
	}
//---------------------------------------------------------------------------------------------------	

	// method for deleting employee
	@Override
	public void deactivateEmployee(String managerUsername, String managerPassword, String empUsername) {

		try {
			// null checking
			if (managerRepo.findByUsernameAndPassword(managerUsername, managerPassword) == null)
				throw new GlobalException("Invalid manager credentials");

		} catch (Exception e) {
			e.printStackTrace();
		}
		// deleting employee
		empRepo.deleteById(empUsername);
	}
//---------------------------------------------------------------------------------------------------	
}
