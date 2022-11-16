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
import com.bms.entity.BankManager;
import com.bms.entity.BankUser;
import com.bms.service.BankManagerService;

@RestController
public class BankMangerController { // controller class for bank manager

	// using service interfaces for accessing jpa repository indirectly
	@Autowired
	BankManagerService mngServ;

	// saving entity into the db
	@PostMapping("/manager/createManager")
	public ResponseEntity<BankManager> createManager(@Valid @RequestBody BankManager mng) {

		// saving entity
		return new ResponseEntity<BankManager>(mngServ.createManager(mng), HttpStatus.CREATED);
	}

	// for fetching user account details
	@GetMapping("/manager/fetchAllUsers")
	public ResponseEntity<List<BankUser>> fetchAllUsers(@RequestParam String username, @RequestParam String password) {

		// fetching entity details
		return new ResponseEntity<List<BankUser>>(mngServ.fetchAllUsers(username, password), HttpStatus.OK);
	}

	// for fetching employees account details
	@GetMapping("/manager/fetchAllEmployees")
	public ResponseEntity<List<BankEmployee>> fetchAllEmployees(@RequestParam String username, @RequestParam String password) {

		// fetching entity details
		return new ResponseEntity<List<BankEmployee>>(mngServ.fetchAllEmployees(username, password), HttpStatus.OK);
	}

	// for updating BankManager account details
	@PutMapping("/manager/changePassword")
	public ResponseEntity<BankManager> changePassword(@RequestParam String username, @RequestParam String password, @RequestBody BankManager newMng) {

		// updating values and returning updated entity
		return new ResponseEntity<BankManager>(mngServ.changePassword(username, password, newMng), HttpStatus.OK);
	}

	// for deleting existing manager account
	@DeleteMapping("/manager/deactivateAccount")
	public ResponseEntity<String> deactivateAccount(@RequestParam String username, @RequestParam String password) {

		// deleting account
		mngServ.deactivateAccount(username, password);
		return new ResponseEntity<String>("Account has been deleted successfully!", HttpStatus.OK);
	}

	// for deleting existing user account
	@DeleteMapping("/manager/deactivateUser")
	public ResponseEntity<String> deactivateUser(@RequestParam String username, @RequestParam String password, @RequestParam long accountNo) {

		// deleting account
		mngServ.deactivateUser(username, password, accountNo);
		return new ResponseEntity<String>("Account has been deleted successfully!", HttpStatus.OK);
	}

	// for deleting existing user account
	@DeleteMapping("/manager/deactivateEmployee")
	public ResponseEntity<String> deactivateEmployee(@RequestParam String username, @RequestParam String password, @RequestParam String empUsername) {

		// deleting account
		mngServ.deactivateEmployee(username, password, empUsername);
		return new ResponseEntity<String>("Account has been deleted successfully!", HttpStatus.OK);
	}

}
