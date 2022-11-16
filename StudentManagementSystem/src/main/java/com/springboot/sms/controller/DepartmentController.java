package com.springboot.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.sms.entity.Student;
import com.springboot.sms.entity.Department;
import com.springboot.sms.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;

	// save department detail in db table using rest api PostMapping
	@PostMapping("/department/saveDepartment")
	public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department) {

		return new ResponseEntity<Department>(deptService.createDepartment(department), HttpStatus.CREATED);
	}

	// fetching department details from db
	@GetMapping("/department/getStudents")
	public ResponseEntity<List<Student>> getStudents() {

		return new ResponseEntity<List<Student>>(deptService.fetchStudents(), HttpStatus.OK);
	}
	
	// fetching students by id
	@GetMapping("/department/getStudents/{roll}")
	public ResponseEntity<Student> getStudentByRoll(@PathVariable("roll") Long roll){
		return new ResponseEntity<Student>(deptService.fetchStudentByRoll(roll), HttpStatus.OK);
	}
	
	// fetching students by department name
	@GetMapping("/department/getStudentByDname/{dname}")
	public ResponseEntity<List<Student>> getStudentByDname(@PathVariable("dname") String dname){
		return new ResponseEntity<List<Student>>(deptService.fetchStudentByDname(dname), HttpStatus.OK);
	}
}
