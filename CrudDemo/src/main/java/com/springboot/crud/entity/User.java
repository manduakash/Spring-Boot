package com.springboot.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	private int uid;
	@Column(length=30, nullable=false)
	private String fname;
	
	@Column(length=30, nullable=false)
	@NotBlank(message="please enter firstname")
	private String lname;
	
	@Column(length=30, nullable=false, unique=true)
	@NotBlank(message="please enter lastname")
	@Email
	private String uname;
	
	@Column(length=11, nullable=false, unique=true)
	@NotBlank(message="please enter contact number")
	private long uphone;
	
}
