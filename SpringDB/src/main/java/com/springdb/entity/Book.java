package com.springdb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_details")
public class Book {
	
	/**
	 * @param bid
	 * @param bname
	 * @param bauthor
	 * @param btype
	 * @param bprice
	 */
	public Book(String bname, String bauthor, String btype, double bprice) {
		
		this.bname = bname;
		this.bauthor = bauthor;
		this.btype = btype;
		this.bprice = bprice;
	}
	
	public Book() {
		super();
	}

	public int getBid() {
		return bid;
	}

	public String getBname() {
		return bname;
	}

	public String getBauthor() {
		return bauthor;
	}

	public String getBtype() {
		return btype;
	}

	public double getBprice() {
		return bprice;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public void setBprice(double bprice) {
		this.bprice = bprice;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bid;
	
	@Column(length = 30, nullable = false)
	private String bname;
	
	@Column(length = 30, nullable = false)
	private String bauthor;
	
	@Column(length = 30, nullable = false)
	private String btype;
	
	@Column(length = 10, nullable = false)
	private double bprice;

	
	
	
	
}
