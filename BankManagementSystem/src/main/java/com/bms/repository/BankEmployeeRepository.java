package com.bms.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bms.entity.BankEmployee;

@Repository
public interface BankEmployeeRepository extends JpaRepository<BankEmployee, String> {

	// custom employee crud method
	BankEmployee findByUsernameAndPassword(String username, String password);
	
	@Modifying
	@Transactional
	void deleteByUsernameAndPassword(String username, String password);
}
