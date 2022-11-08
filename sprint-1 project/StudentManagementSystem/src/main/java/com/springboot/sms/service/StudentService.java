package com.springboot.sms.service;

import java.util.List;

import com.springboot.sms.entity.Student;

//business logic class for alumni
public interface StudentService { // service class

	// creating alumni
	Student createStudent(Student student);

	// fetching all alumnis
	List<Student> fetchStudents();

	// fetching alunmni by its id
	Student fetchStudentByRoll(Long alroll);

	// updating existing alumni details
	Student changePassword(long alroll, Student student);
}
