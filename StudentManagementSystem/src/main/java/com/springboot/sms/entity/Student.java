package com.springboot.sms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Student {

	//roll no. validation
	@Id
	@Column(name="roll", length=10, nullable=false, unique=true)
	@NotNull(message="{stdnt.roll.null_Check}")
	@Digits(integer = 10, fraction = 0, message="{stdnt.roll.digits_check}")
	@Positive(message="{stdnt.roll.positive_check}")
	private Long roll;

	//password validation
	//@JsonIgnore
	@Column(name="student_password", length = 25, nullable = false)
	@NotNull(message="{stdnt.pass.null_Check}")
	@Size(min=5, max=25, message="{stdnt.pass.size_check}")
	private String password;

	//name validation
	@Column(name="student_name", length = 20, nullable = false)
	@NotNull(message="{stdnt.name.null_Check}")
	@Size(min=3, max=20, message="{stdnt.name.size_check}")
	private String name;

	//address validation
	@Column(name="student_address", length = 30, nullable = false)
	@NotNull(message="{stdnt.address.null_Check}")
	@Size(min=4, max=30, message="{stdnt.address.size_check}")
	private String address;

	//phone validation
	@Column(name="student_phone", length = 10, nullable = false)
	@NotNull(message="{stdnt.phone.null_Check}")
	@Digits(integer = 10, fraction = 0, message="{stdnt.phone.digits_check}")
	@Positive(message="{stdnt.phone.positive_check}")
	private Long phone;

	//email validation
	@Column(name="student_email", length = 25, nullable = false, unique = true)
	@NotNull(message="{stdnt.email.null_Check}")
	@Size(min=11, max=25, message="{stdnt.email.size_check}")
	@Email(message = "{stdnt.email.pattern_check}")
	private String email;

	//YOP validation
	@Column(name="student_passyear", length = 4, nullable = false)
	@NotNull(message="{stdnt.yop.null_Check}")
	@Digits(integer = 4, fraction = 0, message="{stdnt.yop.digits_check}")
	@Positive(message="{stdnt.yop.positive_check}")
	private Integer passyear;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "did")
	private Department department;
}
