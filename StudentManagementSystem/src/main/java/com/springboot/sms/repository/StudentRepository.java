package com.springboot.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.sms.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	// custom crud method
	@Query("FROM Student WHERE did = :did")
	List<Student> fetchStudentByDid(int did);
}
