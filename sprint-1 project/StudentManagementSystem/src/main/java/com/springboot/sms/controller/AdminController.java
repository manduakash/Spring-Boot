package com.springboot.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.sms.entity.Admin;
import com.springboot.sms.entity.Student;
import com.springboot.sms.entity.Department;
import com.springboot.sms.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	// save admin detail in db table using rest api PostMapping
	@PostMapping("/admin/saveAdmin")
	public ResponseEntity<String> saveAdmin(@Valid @RequestBody Admin admin) {

		adminService.createAdmin(admin);
		return new ResponseEntity<String>("Admin account has been created successfully!", HttpStatus.CREATED);
	}

	// fetching student details from db
	@GetMapping("/admin/getStudents")
	public ResponseEntity<List<Student>> getStudents() {

		return new ResponseEntity<List<Student>>(adminService.fetchStudents(), HttpStatus.OK);
	}

	// fetching department details from db
	@GetMapping("/admin/getDepartments")
	public ResponseEntity<List<Department>> getDepartments() {

		return new ResponseEntity<List<Department>>(adminService.fetchDepartments(), HttpStatus.OK);
	}

	// fetching students by id
	@GetMapping("/admin/getStudents/{roll}")
	public ResponseEntity<Student> getStudentByRoll(@PathVariable("roll") Long roll) {
		return new ResponseEntity<Student>(adminService.fetchStudentByRoll(roll), HttpStatus.OK);
	}

	// update admin details in db table using rest api PutMapping based on id
	@PutMapping("/admin/updateAdmin/{adusername}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("adusername") String adusername, @RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.changePassword(adusername, admin), HttpStatus.OK);
	}

	// delete admin details in db table using rest api DeleteMapping based on id
	@DeleteMapping("/admin/deleteAdmin/{adusername}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("adusername") String adusername) {
		adminService.deleteAdmin(adusername);
		return new ResponseEntity<String>("Admin deleted Successfully", HttpStatus.OK);
	}

	// delete student details in db table using rest api DeleteMapping based on id
	@DeleteMapping("/admin/deleteStudent/{roll}")
	public ResponseEntity<String> deleteStudent(@PathVariable("roll") Long roll) {
		adminService.deleteStudent(roll);
		return new ResponseEntity<String>("Student deleted Successfully", HttpStatus.OK);
	}
}
