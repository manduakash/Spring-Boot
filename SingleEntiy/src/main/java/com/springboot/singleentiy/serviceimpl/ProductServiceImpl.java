package com.springboot.singleentiy.serviceimpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.singleentiy.entity.ProductOrder;
import com.springboot.singleentiy.repository.ProductRepository;
import com.springboot.singleentiy.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService { // product service implementation class

	// autowiring the entity repositories to use JpaRespository methods
	@Autowired
	private ProductRepository pRepo;

	@Override
	public ProductOrder addProduct(ProductOrder p) {
		// saving product details using save() of JpaRepository
		return pRepo.save(p);
	}

	@Override
	public ProductOrder getProductById(int pid) {
		// fetching product detail based on id using findById() of JpaRepository
		return pRepo.findById(pid).orElseThrow(() -> new EntityNotFoundException("Product is not exist"));

	}

	@Override
	public List<ProductOrder> getAllProducts() {
		// fetching product details based on id using findAll() of JpaRepository
		return pRepo.findAll();
	}

	@Override
	public ProductOrder changeProductName(int pid, ProductOrder p) {
		// fetching product by id
		ProductOrder newProduct = pRepo.findById(pid)
				.orElseThrow(() -> new EntityNotFoundException("Product not updated"));

		// updating value
		newProduct.setProductName(p.getProductName());;
		// saving updated value
		pRepo.save(newProduct);
		// returning updated entity
		return newProduct;
	}

	@Override
	public void removeProduct(int pid) {
		// deleting product by id
		pRepo.deleteById(pid);
	}

}
