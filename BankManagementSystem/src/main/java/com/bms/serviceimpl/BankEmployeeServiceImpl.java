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
import com.bms.service.BankEmployeeService;

@Service
public class BankEmployeeServiceImpl implements BankEmployeeService { // business logic for bank employee

	// using repository interface
	@Autowired
	BankEmployeeRepository empRepo;
	@Autowired
	BankUserRepository userRepo;
	@Autowired
	BankManagerRepository mngRepo;

//----------------------------------------------------------------------------------------------------	

	// saving new employee into the db
	@Override
	public BankEmployee createEmp(BankEmployee emp) {

		// null checking
		if (emp.getManager() != null) {
			// fetching manager by its first name
			BankManager fetchManager = mngRepo.findByFname(emp.getManager().getFname());
			// saving manager to employee if it exists
			emp.setManager(fetchManager);
		}
		
		// creating employee a/c and saving into the DB
		return empRepo.save(emp);
	}
//----------------------------------------------------------------------------------------------------	

	// getting all users with help of employee privilage
	@Override
	public List<BankUser> fetchAllUsers(String username, String password) {
		try {
			// null checking
			if (empRepo.findByUsernameAndPassword(username, password) == null) {
				throw new GlobalException("Invalid employee username or password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// retuning list of users after validating employee username and password
		return userRepo.findAll();
	}
//----------------------------------------------------------------------------------------------------	

	// updating employee password
	@Override
	public BankEmployee changePassword(String username, String password, BankEmployee newEmp) {

		// finding employee with username and password
		BankEmployee emp = empRepo.findByUsernameAndPassword(username, password);

		try {
			// null checking
			if (empRepo.findByUsernameAndPassword(username, password) == null)
				throw new GlobalException("Invalid employee username or password");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// updating password
		emp.setPassword(newEmp.getPassword());

		// saving changes into the DB and return that entity
		return empRepo.save(emp);
	}
//----------------------------------------------------------------------------------------------------	

	// deleting the employee account
	@Override
	public void deactivateAccount(String username, String password) {

		try {
			// null checking
			if (empRepo.findByUsernameAndPassword(username, password) == null)
				throw new GlobalException("Invalid employee username or password");
		} catch (Exception e) {
			e.printStackTrace();
		}

		empRepo.deleteByUsernameAndPassword(username, password);
	}
//----------------------------------------------------------------------------------------------------	
}
