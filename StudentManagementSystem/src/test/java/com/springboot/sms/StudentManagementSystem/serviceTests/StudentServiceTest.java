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

import com.springboot.sms.entity.Student;
import com.springboot.sms.entity.Department;
import com.springboot.sms.repository.StudentRepository;
import com.springboot.sms.repository.DepartmentRepository;
import com.springboot.sms.service.StudentService;

@SpringBootTest
public class StudentServiceTest { // student service test class

	@MockBean
	private DepartmentRepository deptRepo;
	@MockBean
	private StudentRepository studentRepo;

	@Autowired
	private StudentService studentServ;

	// testing Student createStudent()
	@Test
	public void testCreateDepartment() {

		// creating student and setting values
		Student alm1 = new Student();
		alm1.setRoll(1234567890L);
		alm1.setPassword("akash");
		alm1.setName("akash singh");
		alm1.setAddress("bihar");
		alm1.setPhone(6202734730L);
		alm1.setEmail("manduakash@gmail.com");
		alm1.setPassyear(2022);

		Department dept = new Department();
		dept.setDname("IT");
		dept.setDhead("akash");
		
		alm1.setDepartment(dept);
		
		// testing Student using Jpa repository method
		Mockito.when(studentRepo.save(alm1)).thenReturn(alm1);
		// testing Student using Student service method
		assertThat(studentServ.createStudent(alm1)).isEqualTo(alm1);
	}

	// testing student fetchStudents()
	@Test
	public void testFetchStudents() {

		// creating student and setting values
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
		assertThat(studentServ.fetchStudents()).isEqualTo(alms);
	}

	// testing student fetchStudentByRoll()
	@Test
	public void testFetchStudentByRoll() {

		// creating student and setting values
		Student alm1 = new Student();
		alm1.setRoll(1234567893L);
		alm1.setPassword("akash3");
		alm1.setName("akash3 singh");
		alm1.setAddress("bihar");
		alm1.setPhone(6202734733L);
		alm1.setEmail("manduakash3@gmail.com");
		alm1.setPassyear(2022);

		// testing student using Jpa repository method
		Mockito.when(studentRepo.findById(1234567893L)).thenReturn(Optional.of(alm1));
		// testing student using student service method
		assertThat(studentServ.fetchStudentByRoll(1234567893L)).isEqualTo(alm1);
	}

	// testing student changePassword()
	@Test
	public void testChangePassword() {

		// creating student and setting values
		Student alm1 = new Student();
		alm1.setRoll(1234567894L);
		alm1.setPassword("akash4");
		alm1.setName("akash4 singh");
		alm1.setAddress("bihar");
		alm1.setPhone(6202734734L);
		alm1.setEmail("manduakash4@gmail.com");
		alm1.setPassyear(2022);
		
		Optional<Student> almOpt = Optional.of(alm1);
		Student almUpdt = almOpt.get();
		
		Mockito.when(studentRepo.findById(1234567894L)).thenReturn(almOpt);
		
		// updating value
		almUpdt.setPassword("updatedpass");
		
		// saving updated values into db
		Mockito.when(studentRepo.save(almUpdt)).thenReturn(almUpdt);

		// testing student using student service method
		assertThat(studentServ.changePassword(1234567894L, almUpdt)).isEqualTo(almUpdt);
	}
}
