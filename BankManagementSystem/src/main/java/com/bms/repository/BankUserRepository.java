package com.bms.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bms.entity.BankUser;

@Repository
public interface BankUserRepository extends JpaRepository<BankUser, Long> {

	// custom bank user crud method
	BankUser findByAccountNoAndPin(long accountNo, int pin);
	
	@Modifying
	@Transactional
	void deleteByAccountNoAndPin(long accountNo, int pin);

}
