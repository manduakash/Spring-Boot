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
import com.springboot.sms.service.DepartmentService;

@SpringBootTest
public class DepartmentServiceTest { // department service test class

	@MockBean
	private DepartmentRepository deptRepo;
	@MockBean
	private StudentRepository studentRepo;

	@Autowired
	private DepartmentService deptServ;

	// testing department createDepartment()
	@Test
	public void testCreateDepartment() {

		// creating department object
		Department dept = new Department();
		dept.setDname("IT");
		dept.setDhead("akash");

		// creating student and setting values
		Student alm1 = new Student();
		alm1.setRoll(1234567890L);
		alm1.setPassword("akash");
		alm1.setName("akash singh");
		alm1.setAddress("bihar");
		alm1.setPhone(6202734730L);
		alm1.setEmail("manduakash@gmail.com");
		alm1.setPassyear(2022);

		// creating another student and setting values
		Student alm2 = new Student();
		alm2.setRoll(234567891L);
		alm2.setPassword("akash1");
		alm2.setName("akash1 singh");
		alm2.setAddress("bihar");
		alm2.setPhone(6202734731L);
		alm2.setEmail("manduakash1@gmail.com");
		alm2.setPassyear(2022);

		// creating student list and storing students into this list
		List<Student> alms = new ArrayList<>();
		alms.add(alm1);
		alms.add(alm2);

		// setting student list into the department object
		dept.setStudent(alms);

		// testing department using Jpa repository method
		Mockito.when(deptRepo.save(dept)).thenReturn(dept);
		// testing departmetn using department service method
		assertThat(deptServ.createDepartment(dept)).isEqualTo(dept);
	}

	// testing department fetchStudents()
	@Test
	public void testFetchStudents() {

		// creating student and setting values
		Student alm1 = new Student();
		alm1.setRoll(1234567892L);
		alm1.setPassword("akash2");
		alm1.setName("akash2 singh");
		alm1.setAddress("bihar");
		alm1.setPhone(6202734732L);
		alm1.setEmail("manduakash2@gmail.com");
		alm1.setPassyear(2022);

		// creating another student and setting values
		Student alm2 = new Student();
		alm2.setRoll(123456783L);
		alm2.setPassword("akash3");
		alm2.setName("akash3 singh");
		alm2.setAddress("bihar");
		alm2.setPhone(6202734733L);
		alm2.setEmail("manduakash3@gmail.com");
		alm2.setPassyear(2022);

		// creating student list and storing students into this list
		List<Student> alms = new ArrayList<>();
		alms.add(alm1);
		alms.add(alm2);

		// testing department using Jpa repository method
		Mockito.when(studentRepo.findAll()).thenReturn(alms);
		// testing departmetn using department service method
		assertThat(deptServ.fetchStudents()).isEqualTo(alms);
	}

	// testing department fetchStudentByRoll()
	@Test
	public void testFetchStudentByRoll() {

		// creating student and setting values
		Student alm1 = new Student();
		alm1.setRoll(1234567894L);
		alm1.setPassword("akash4");
		alm1.setName("akash4 singh");
		alm1.setAddress("bihar");
		alm1.setPhone(6202734734L);
		alm1.setEmail("manduakash4@gmail.com");
		alm1.setPassyear(2022);

		// testing department using Jpa repository method
		Mockito.when(studentRepo.findById(1234567894L)).thenReturn(Optional.of(alm1));
		// testing departmetn using department service method
		assertThat(deptServ.fetchStudentByRoll(1234567894L)).isEqualTo(alm1);
	}

}
