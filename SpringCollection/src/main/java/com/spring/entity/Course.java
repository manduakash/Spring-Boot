package com.spring.entity;

import java.util.Iterator;
import java.util.List;

public class Course {

	// Entities
	private String cname;
	private int cduration;
	private String ctrainer;
	private List<String> students;

	// build a constructor with parameter 
	public Course(String cname, int cduration, String ctrainer, List<String> students) {
		super();
		this.cname = cname;
		this.cduration = cduration;
		this.ctrainer = ctrainer;
		this.students = students;
	}

	// Method to display details
	public void show() {
		System.out.println(cname+" "+cduration+" "+ctrainer);
		System.out.println("Student List: ");
		Iterator<String> itr = students.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
