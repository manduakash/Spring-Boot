package com.springboot.sms.serviceimpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.sms.entity.Department;
import com.springboot.sms.entity.Student;
import com.springboot.sms.repository.DepartmentRepository;
import com.springboot.sms.repository.StudentRepository;
import com.springboot.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;
	@Autowired
	DepartmentRepository deptRepo;

	@Override
	public Student createStudent(Student student) {
		// saving student details using save() of JpaRepository
		Department dept = new Department();
		Department fetchDept = deptRepo.findByDname(student.getDepartment().getDname());
		if (fetchDept == null) {
			dept.setDname(student.getDepartment().getDname());
			dept.setDhead(student.getDepartment().getDhead());
			deptRepo.save(dept);
			student.setDepartment(dept);
		}else {
			student.setDepartment(fetchDept);
		}
		return studentRepo.save(student);
	}

	@Override
	public List<Student> fetchStudents() {
		// fetching student details based on id using findById() of JpaRepository
		return studentRepo.findAll();
	}

	@Override
	public Student changePassword(long roll, Student student) {
		// fetching student by id
		Student newStudent = studentRepo.findById(roll)
				.orElseThrow(() -> new EntityNotFoundException("Student not updated"));

		// updating value
		newStudent.setPassword(student.getPassword());
		// saving updated value
		studentRepo.save(newStudent);
		// returning updated entity
		return newStudent;
	}

	@Override
	public Student fetchStudentByRoll(Long alroll) {
		// fetching student detail based on id using findById() of JpaRepository
		return studentRepo.findById(alroll).orElseThrow(() -> new EntityNotFoundException("Student is not exist"));

	}

}
