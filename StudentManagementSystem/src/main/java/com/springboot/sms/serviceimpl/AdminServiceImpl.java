package com.springboot.sms.serviceimpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.sms.entity.Admin;
import com.springboot.sms.entity.Student;
import com.springboot.sms.entity.Department;
import com.springboot.sms.repository.AdminRepository;
import com.springboot.sms.repository.StudentRepository;
import com.springboot.sms.repository.DepartmentRepository;
import com.springboot.sms.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService { // service implementation class

	// autowiring the entity repositories to use JpaRespository methods
	@Autowired
	private DepartmentRepository deptRepo;
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public Admin createAdmin(Admin admin) {
		// saving admin details using save() of JpaRepository
		return adminRepo.save(admin);
	}

	@Override
	public List<Student> fetchStudents() {
		// fetching student details based on id using findById() of JpaRepository
		return studentRepo.findAll();
	}

	@Override
	public List<Department> fetchDepartments() {
		// fetching departments details based on id using findAll() of JpaRepository
		return deptRepo.findAll();
	}

	@Override
	public Student fetchStudentByRoll(Long roll) {
		// fetching student detail based on id using findById() of JpaRepository
		return studentRepo.findById(roll).orElseThrow(() -> new EntityNotFoundException("Student is not exist"));

	}

	@Override
	public Admin changePassword(String username, Admin admin) {
		// fetching admin by id
		Admin newAdmin = adminRepo.findById(username)
				.orElseThrow(() -> new EntityNotFoundException("Admin not updated"));

		// updating value
		newAdmin.setAdpassword(admin.getAdpassword());
		// saving updated value
		adminRepo.save(newAdmin);
		// returning updated entity
		return newAdmin;
	}

	@Override
	public void deleteAdmin(String username) {
		// deleting admin by id
		adminRepo.deleteById(username);
	}

	@Override
	public void deleteStudent(Long roll) {
		// deleting student by id
		studentRepo.deleteById(roll);
	}

}
