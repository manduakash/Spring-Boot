package com.springboot.singleentiy.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pid", length= 5, nullable=false, unique=true)
	private int pid;
	
	@Column(name="productName", length= 20, nullable=false)
	@NotBlank(message="product name should not be null")
	@Size(min=4, max=20, message="product name size should be within 20")
	private String productName;
	
	@Column(name="productType", length= 15, nullable=false)
	@NotBlank(message="product type should not be null")
	@Size(min=4, max=15, message="product type size should be within 15")
	private String productType;
	
	@Column(name="orderDate", nullable=false)
	@NotNull(message="order date should not be null")
	private Date orderDate;
	
	@Column(name="deliveryDate", nullable=false)
	@NotNull(message="delivery date should not be null")
	private Date deliveryDate;
}
