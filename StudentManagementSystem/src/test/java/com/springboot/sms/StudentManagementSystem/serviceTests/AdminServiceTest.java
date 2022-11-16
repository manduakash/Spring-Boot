package com.springboot.sms.StudentManagementSystem.serviceTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springboot.sms.entity.Admin;
import com.springboot.sms.entity.Student;
import com.springboot.sms.entity.Department;
import com.springboot.sms.repository.AdminRepository;
import com.springboot.sms.repository.StudentRepository;
import com.springboot.sms.repository.DepartmentRepository;
import com.springboot.sms.service.AdminService;

@SpringBootTest
public class AdminServiceTest {

	@MockBean
	private DepartmentRepository deptRepo;
	@MockBean
	private StudentRepository studentRepo;
	@MockBean
	private AdminRepository adminRepo;

	@Autowired
	private AdminService adminServ;

	// testing Admin createAdmin()
	@Test
	public void testCreateAdmin() {

		// creating admin and setting values
		Admin admin1 = new Admin();
		admin1.setAdusername("akash");
		admin1.setAdname("akash");
		admin1.setAdpassword("akash");
		admin1.setAdemail("akash@gmail.com");

		// testing admin using Jpa repository method
		Mockito.when(adminRepo.save(admin1)).thenReturn(admin1);
		// testing admin using admin service method
		assertThat(adminServ.createAdmin(admin1)).isEqualTo(admin1);
	}

	// testing admin fetchStudents()
	@Test
	public void testFetchStudents() {

		// creating admin and setting values
		Student alm1 = new Student();
		alm1.setRoll(1234567891L);
		alm1.setPassword("akash1");
		alm1.setName("akash1 singh");
		alm1.setAddress("bihar");
		alm1.setPhone(6202734731L);
		alm1.setEmail("manduakash1@gmail.com");
		alm1.setPassyear(2022);

		// creating another student and setting values
		Student alm2 = new Student();
		alm2.setRoll(123456782L);
		alm2.setPassword("akash2");
		alm2.setName("akash2 singh");
		alm2.setAddress("bihar");
		alm2.setPhone(6202734732L);
		alm2.setEmail("manduakash2@gmail.com");
		alm2.setPassyear(2022);

		// creating student list and storing students into this list
		List<Student> alms = new ArrayList<>();
		alms.add(alm1);
		alms.add(alm2);

		// testing student using Jpa repository method
		Mockito.when(studentRepo.findAll()).thenReturn(alms);
		// testing student using student service method
		assertThat(adminServ.fetchStudents()).isEqualTo(alms);
	}

	// testing admin fetchDepartments()
	@Test
	public void testFetchDepartments() {

		// creating department and setting values
		Department dept1 = new Department();
		dept1.setDname("IT1");
		dept1.setDhead("akash1");
		deptRepo.save(dept1);

		// creating another department and setting values
		Department dept2 = new Department();
		dept1.setDname("IT2");
		dept1.setDhead("akash2");
		deptRepo.save(dept2);

		List<Department> depts = new ArrayList<>();
		depts.add(dept1);
		depts.add(dept2);

		// testing admin using Jpa repository method
		Mockito.when(deptRepo.findAll()).thenReturn(depts);
		// testing admin using admin service method
		assertThat(adminServ.fetchDepartments()).isEqualTo(depts);
	}

	// testing admin fetchStudentByRoll()
	@Test
	public void testFetchStudentByRoll() {

		// creating admin and setting values
		Student alm1 = new Student();
		alm1.setRoll(1234567893L);
		alm1.setPassword("akash3");
		alm1.setName("akash3 singh");
		alm1.setAddress("bihar");
		alm1.setPhone(6202734733L);
		alm1.setEmail("manduakash3@gmail.com");
		alm1.setPassyear(2022);

		// testing admin using Jpa repository method
		Mockito.when(studentRepo.findById(1234567893L)).thenReturn(Optional.of(alm1));
		// testing admin using admin service method
		assertThat(adminServ.fetchStudentByRoll(1234567893L)).isEqualTo(alm1);
	}

	// testing admin changePassword()
	@Test
	public void testChangePassword() {
		// creating admin and setting values
		Admin admin1 = new Admin();
		admin1.setAdusername("akash1");
		admin1.setAdname("akash1");
		admin1.setAdpassword("akash1");
		admin1.setAdemail("akash1@gmail.com");

		Optional<Admin> adminOpt = Optional.of(admin1);
		Admin adminUpdt = adminOpt.get();

		// finding admin by id
		Mockito.when(adminRepo.findById("akash1")).thenReturn(adminOpt);

		// updating password
		adminUpdt.setAdpassword("updatedPass");

		// saving updated value
		Mockito.when(adminRepo.save(adminUpdt)).thenReturn(adminUpdt);

		// testing with service
		assertThat(adminServ.changePassword("akash1", adminUpdt)).isEqualTo(adminUpdt);

	}

	// testing admin deleteAdmin()
	@Test
	public void testDeleteAdmin() {

		// creating admin and setting values
		Admin admin1 = new Admin();
		admin1.setAdusername("akash1");
		admin1.setAdname("akash1");
		admin1.setAdpassword("akash1");
		admin1.setAdemail("akash1@gmail.com");

		// optinal
		Optional<Admin> opt = Optional.of(admin1);

		// testing admin using Jpa repository method
		Mockito.when(adminRepo.existsById("akash1")).thenReturn(false);
		// testing admin using admin service method
		assertThat(adminRepo.existsById(opt.get().getAdusername()));
	}

	// testing Student deleteStudent()
	@Test
	public void testDeleteStudent() {

		// creating alumni and setting values
		Student student = new Student();
		student.setRoll(1234567890L);
		student.setPassword("akash");
		student.setName("akash singh");
		student.setAddress("bihar");
		student.setPhone(6202734730L);
		student.setEmail("manduakash@gmail.com");
		student.setPassyear(2022);

		// optinal
		Optional<Student> opt = Optional.of(student);

		// testing Student using Jpa repository method
		Mockito.when(studentRepo.existsById(1234567890L)).thenReturn(false);
		// testing Student using existsById method
		assertThat(studentRepo.existsById(opt.get().getRoll()));
	}

}
