package com.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.entity.BankManager;

@Repository
public interface BankManagerRepository extends JpaRepository<BankManager, String> {

	// custom manager crud method
	BankManager findByUsernameAndPassword(String username, String password);
	
	BankManager findByFname(String Fname);
}
