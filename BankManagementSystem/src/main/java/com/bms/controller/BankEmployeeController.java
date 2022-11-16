package com.bms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bms.entity.BankEmployee;
import com.bms.entity.BankUser;
import com.bms.service.BankEmployeeService;

@RestController
public class BankEmployeeController { // controller class for bank employee

	// using service interfaces for accessing jpa repository indirectly
	@Autowired
	BankEmployeeService empServ;

	// saving entity into the db
	@PostMapping("/employee/createEmp")
	public ResponseEntity<BankEmployee> createEmp(@Valid @RequestBody BankEmployee emp) {

		// saving entity
		return new ResponseEntity<BankEmployee>(empServ.createEmp(emp), HttpStatus.CREATED);
	}

	// for fetching employee account details
	@GetMapping("/employee/fetchAllUsers")
	public ResponseEntity<List<BankUser>> fetchAllUsers(@RequestParam String username, @RequestParam String password) {

		// fetching entity details
		return new ResponseEntity<List<BankUser>>(empServ.fetchAllUsers(username, password), HttpStatus.OK);
	}

	// for updating Employee account details
	@PutMapping("/employee/changePassword")
	public ResponseEntity<BankEmployee> changePassword(@RequestParam String username, @RequestParam String password,
			@RequestBody BankEmployee emp) {

		// updating values and returning updated entity
		return new ResponseEntity<BankEmployee>(empServ.changePassword(username, password, emp), HttpStatus.OK);
	}

	// for deleting existing Employee account
	@DeleteMapping("/employee/deactivateAccount")
	public ResponseEntity<String> deactivateAccount(@RequestParam String username, @RequestParam String password) {

		// for deleting existing employee account
		empServ.deactivateAccount(username, password);
		return new ResponseEntity<String>("Account has been deleted successfully!", HttpStatus.OK);
	}

}
