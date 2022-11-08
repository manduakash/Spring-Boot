package com.springboot.singleentiy.controller;

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

import com.springboot.singleentiy.entity.ProductOrder;
import com.springboot.singleentiy.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService pServ;
	
	@PostMapping("/product/addProduct")
	public ResponseEntity<ProductOrder> addProduct(@Valid @RequestBody ProductOrder p) {
		return new ResponseEntity<ProductOrder>(pServ.addProduct(p), HttpStatus.OK);
	}
	
	@GetMapping("/product/getProductById/{pid}")
	public ResponseEntity<ProductOrder> getProductById(@PathVariable int pid) {
		return new ResponseEntity<ProductOrder>(pServ.getProductById(pid), HttpStatus.OK);
	}
	
	@GetMapping("/product/getAllProducts")
	public ResponseEntity<List<ProductOrder>> getAllProducts() {
		return new ResponseEntity<List<ProductOrder>>(pServ.getAllProducts(), HttpStatus.OK);
	}
	
	@PutMapping("/product/changeProductName/{pid}")
	public ResponseEntity<ProductOrder> changeProductName(@PathVariable int pid, @RequestBody ProductOrder p) {
		return new ResponseEntity<ProductOrder>(pServ.changeProductName(pid,p), HttpStatus.OK);
	}
	
	@DeleteMapping("/product/removeProduct/{pid}")
	public ResponseEntity<String> removeProduct(@PathVariable int pid) {
		pServ.removeProduct(pid);
		return new ResponseEntity<String>("Product order has been removed!",HttpStatus.OK);
	}
	
	
	

}
