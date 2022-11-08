package com.springboot.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.sms.entity.Student;
import com.springboot.sms.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	// save student detail in db table using rest api PostMapping
	@PostMapping("/student/saveStudent")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {

		return new ResponseEntity<Student>(studentService.createStudent(student), HttpStatus.CREATED);
	}

	// fetching student details from db
	@GetMapping("/student/getStudents")
	public ResponseEntity<List<Student>> getStudents() {
		return new ResponseEntity<List<Student>>(studentService.fetchStudents(), HttpStatus.OK);
	}

	// fetching students by id
	@GetMapping("/student/getStudent/{roll}")
	public ResponseEntity<Student> getStudentByRoll(@PathVariable("roll") Long roll) {
		return new ResponseEntity<Student>(studentService.fetchStudentByRoll(roll), HttpStatus.OK);
	}

	// update student details in db table using rest api PutMapping based on id
	@PutMapping("/student/updateStudent/{roll}")
	public ResponseEntity<Student> updateStudent(@PathVariable("roll") Long roll, @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.changePassword(roll, student), HttpStatus.OK);
	}

}
