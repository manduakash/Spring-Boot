package com.springboot.sms.service;

import java.util.List;

import com.springboot.sms.entity.Admin;
import com.springboot.sms.entity.Student;
import com.springboot.sms.entity.Department;

//business logic class for admin
public interface AdminService { // service class

	// creating admin
	Admin createAdmin(Admin admin);

	// fetching all students
	List<Student> fetchStudents();

	// fetching all departments
	List<Department> fetchDepartments();

	// fetching alunmni by its id
	Student fetchStudentByRoll(Long alroll);

	// updating entity
	Admin changePassword(String username, Admin admin);

	// delete by username
	void deleteAdmin(String username);

	// delete by roll no.
	void deleteStudent(Long roll);

}
