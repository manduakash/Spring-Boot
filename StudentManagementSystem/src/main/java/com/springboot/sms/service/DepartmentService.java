package com.springboot.sms.service;

import java.util.List;

import com.springboot.sms.entity.Student;
import com.springboot.sms.entity.Department;

//business logic class for admin
public interface DepartmentService { // service class

	// creating department
	Department createDepartment(Department department);

	// fetching all students
	List<Student> fetchStudents();

	// fetching alunmni by its id
	Student fetchStudentByRoll(Long alroll);
	
	// fetching students by department name
	List<Student> fetchStudentByDname(String dname);
} 
