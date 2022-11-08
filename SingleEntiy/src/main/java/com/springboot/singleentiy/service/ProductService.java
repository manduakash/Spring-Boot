package com.springboot.singleentiy.service;

import java.util.List;

import com.springboot.singleentiy.entity.ProductOrder;

public interface ProductService {	//service decleration class
	
	//creating procuct
	ProductOrder addProduct(ProductOrder p);
	
	//getting product by id
	ProductOrder getProductById(int pid);
	
	//getting all products
	List<ProductOrder> getAllProducts();
	
	//updating product detail by id
	ProductOrder changeProductName(int pid, ProductOrder p);
	
	//deleting product by id
	void removeProduct(int pid);
}
