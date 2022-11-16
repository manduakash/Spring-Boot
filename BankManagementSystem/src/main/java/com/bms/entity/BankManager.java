package com.bms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Bank_Manager_Details")
@NoArgsConstructor
@AllArgsConstructor
public class BankManager {

	// Bank Manager properties

	@Id
	@Column(name = "username", length = 15, nullable = false, unique = true)
	@NotBlank(message = "username should not be blank")
	@Size(min = 4, max = 15, message = "username size should be minimum 4 and max 15 letters.")
	private String username;

	@Column(name = "fname", length = 10, nullable = false)
	@NotBlank(message = "first-name should not be blank")
	@Size(min = 3, max = 10, message = "first-name size should be minimum 3 and max 10 letters.")
	private String fname;

	@Column(name = "lname", length = 10, nullable = false)
	@NotBlank(message = "last-name should not be blank")
	@Size(min = 3, max = 10, message = "last-name size should be minimum 3 and max 10 letters.")
	private String lname;

	@Column(name = "password", length = 15, nullable = false)
	@NotBlank(message = "password should not be blank")
	@Size(min = 4, max = 15, message = "password size should be minimum 4 and max 15 letters.")
	private String password;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "manager" , fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<BankEmployee> employee;

}
