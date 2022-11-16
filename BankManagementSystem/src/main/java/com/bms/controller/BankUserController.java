package com.bms.controller;

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

import com.bms.entity.BankUser;
import com.bms.service.BankUserService;

@RestController
public class BankUserController { // controller class for bank user

	// using service interfaces for accessing jpa repository indirectly
	@Autowired
	BankUserService userServ;

	@PostMapping("/user/createAccount")
	public ResponseEntity<BankUser> createAccount(@Valid @RequestBody BankUser user) {

		// saving entity into the db
		return new ResponseEntity<BankUser>(userServ.createAccount(user), HttpStatus.CREATED);
	}

	@GetMapping("/user/balanceInquiry")
	public ResponseEntity<String> balanceInquiry(@RequestParam long accountNo, @RequestParam int pin) {

		// fetching entity details
		return new ResponseEntity<String>(userServ.balanceInquiry(accountNo, pin), HttpStatus.OK);
	}

	@PutMapping("/user/deposite")
	public ResponseEntity<String> deposite(@RequestParam long accountNo, @RequestParam int pin,
			@RequestBody BankUser user) {

		// updating values and returning updated entity values
		return new ResponseEntity<String>(userServ.deposite(accountNo, pin, user), HttpStatus.OK);
	}

	@PutMapping("/user/withdrawal")
	public ResponseEntity<String> withdrawal(@RequestParam long accountNo, @RequestParam int pin,
			@RequestBody BankUser user) {

		// updating values and returning updated entity values
		return new ResponseEntity<String>(userServ.withdrawal(accountNo, pin, user), HttpStatus.OK);
	}

	@PutMapping("/user/changePin")
	public ResponseEntity<BankUser> changePin(@RequestParam long accountNo, @RequestParam int pin,
			@RequestBody BankUser user) {

		// updating values and returning updated entity
		return new ResponseEntity<BankUser>(userServ.changePin(accountNo, pin, user), HttpStatus.OK);
	}

	@DeleteMapping("/user/deactivateAccount")
	public ResponseEntity<String> deactivateAccount(@RequestParam long accountNo, @RequestParam int pin) {

		// for deleting existing user account
		userServ.deactivateAccount(accountNo, pin);
		return new ResponseEntity<String>("Account has been deleted successfully!", HttpStatus.OK);
	}

}
