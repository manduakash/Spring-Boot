package com.springboot.singleentiy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.singleentiy.entity.ProductOrder;

@Repository
public interface ProductRepository extends JpaRepository<ProductOrder, Integer>{

}
