package com.springboot.crud.service;

import java.util.List;

import com.springboot.crud.entity.User;

//abstract method for performing CRUD on user entity
public interface UserService {

	//saving details of user
	User saveUser(User user);
	
	//fetting all details of user
	List<User> getAllUser();
	
	//getting details of user based on uid
	User getUserById(int uid);
	
	//fetching and updating user detail
	User updateUserById(User user, int uid);
	
	//fetching and deleting user 
	void deleteUserById(int uid);
}
