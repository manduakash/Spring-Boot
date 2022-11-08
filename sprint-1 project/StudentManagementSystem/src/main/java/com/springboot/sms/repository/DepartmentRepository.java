package com.springboot.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.sms.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	// custom crud method
	Department findByDname(String dname);
	
}
