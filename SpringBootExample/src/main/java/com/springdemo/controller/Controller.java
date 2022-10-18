package com.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping(value = "/firstPage")
	public String get() {
		return "Welcome to my first live page...";
	}
}
