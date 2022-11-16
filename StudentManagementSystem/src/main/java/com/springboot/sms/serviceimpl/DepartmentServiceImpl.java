package com.springboot.sms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.sms.entity.Student;
import com.springboot.sms.entity.Department;
import com.springboot.sms.exception.EntityNotFoundException;
import com.springboot.sms.repository.StudentRepository;
import com.springboot.sms.repository.DepartmentRepository;
import com.springboot.sms.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService { // service implementation class

	// autowiring the entity repositories to use JpaRespository methods
	@Autowired
	private DepartmentRepository deptRepo;
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Department createDepartment(Department department) {
		// saving department details using save() of JpaRepository
		return deptRepo.save(department);
	}

	@Override
	public List<Student> fetchStudents() {
		// fetching student details based on id using findById() of JpaRepository
		return studentRepo.findAll();
	}

	@Override
	public Student fetchStudentByRoll(Long alroll) {
		// fetching student detail based on id using findById() of JpaRepository
		return studentRepo.findById(alroll).orElseThrow(() -> new EntityNotFoundException("Student is not exist"));
	}

	@Override
	public List<Student> fetchStudentByDname(String dname) {
		// fetching students by department name
		Department dept = deptRepo.findByDname(dname);
		if (dept != null) {
			return dept.getStudent();
		} else
			return null;
	}

}
