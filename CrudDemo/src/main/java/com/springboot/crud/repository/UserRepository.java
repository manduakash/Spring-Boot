package com.springboot.crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.entity.User;

//abstract method for performing CRUD on user entity
public interface UserRepository extends JpaRepository<User,Integer>{
	
	//Customize CRUD operations
}
