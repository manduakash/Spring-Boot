package com.bms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "User_Details")
@NoArgsConstructor
@AllArgsConstructor
public class BankUser {

	// bank properties

	@Id
	@Column(name = "accountNo", length = 10, nullable = false, unique = true)
	//@NotBlank(message = "account-number should not be blank")
	//@Size(min = 10, max = 10, message = "account-number size should be 10")
	@Digits(integer = 10, fraction = 0)
	@Positive(message = "account-number should be positive number")
	private long accountNo;

	@Column(name = "accountHolder", length = 25, nullable = false)
	@NotBlank(message = "account holder name should not be blank")
	@Size(min = 3, max = 25, message = "account holder name size should be minimum 3 and max 25 letters.")
	private String accountHolder;

	@Column(name = "accountType", length = 7, nullable = false)
	@NotBlank(message = "account-type should not be blank")
	@Size(max = 7, message = "account-type size should be less than 7 letters")
	private String accountType;

	@Column(name = "branch", length = 15, nullable = false)
	@NotBlank(message = "branch-name should not be blank")
	@Size(max = 15, message = "branch-name size should be less than 15 letters")
	private String branch;

	@Column(name = "pin", length = 4, nullable = false)
	//@NotEmpty(message = "pin should not be empty")
	//@Size(min = 4, max = 4, message = "pin size should be 10")
	@Digits(integer = 4, fraction = 0)
	@Positive(message = "pin should be positive number")
	private int pin;

	@Column(name = "email", length = 25, nullable = false, unique = true)
	@NotBlank(message = "email should not be blank")
	@Size(min = 4, max = 25, message = "email size should be less than 25 letters")
	@Email(message = "invalid email")
	private String email;

	@Column(name = "contact", length = 10, nullable = false, unique = true)
	//@NotBlank(message = "contact-number should not be blank")
	//@Size(min = 10, max = 10, message = "contact number size should be 10")
	@Digits(integer = 10, fraction = 0)
	@Positive(message = "contact number should be positive number")
	private long contact;

	@Column(name = "balance", length = 12, nullable = false)
	//@NotBlank(message = "balance should not be blank")
	@Digits(integer = 10, fraction = 2)
	@PositiveOrZero(message = "balance should be positive number or zero")
	private double balance;
}
