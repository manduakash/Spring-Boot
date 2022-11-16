package com.bms.servicetest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bms.entity.BankEmployee;
import com.bms.entity.BankUser;
import com.bms.repository.BankEmployeeRepository;
import com.bms.repository.BankManagerRepository;
import com.bms.repository.BankUserRepository;
import com.bms.service.BankEmployeeService;

@SpringBootTest
public class BankEmployeeTest {

	@MockBean
	BankEmployeeRepository empRepo;
	@MockBean
	BankManagerRepository mngRepo;
	@MockBean
	BankUserRepository userRepo;

	@Autowired
	BankEmployeeService empServ;

//--------------------------------------------------------------------------------------------------

	// testing create employee
	@Test
	public void createEmployeeTest() {

		BankEmployee emp = new BankEmployee();
		emp.setFname("employee1");
		emp.setLname("singh");
		emp.setUsername("employee1");
		emp.setPassword("employee1");
		Mockito.when(empRepo.save(emp)).thenReturn(emp);

		// testing with service
		assertThat(empServ.createEmp(emp)).isEqualTo(emp);

	}

//--------------------------------------------------------------------------------------------------

	// testing fetchAllUsers with employee privilage
	@Test
	public void fetchAllUsersTest() {

		// creating mock users and saving to mock db for testing
		BankUser user1 = new BankUser();
		user1.setAccountNo(1111111111);
		user1.setAccountHolder("user1");
		user1.setAccountType("saving");
		user1.setBranch("user1pur");
		user1.setBalance(1000);
		user1.setContact(1111111111);
		user1.setEmail("user1@gmail.com");
		user1.setPin(1111);
//		Mockito.when(userRepo.save(user1)).thenReturn(user1);

		BankUser user2 = new BankUser();
		user2.setAccountNo(2222222222L);
		user2.setAccountHolder("user2");
		user2.setAccountType("saving");
		user2.setBranch("user2pur");
		user2.setBalance(2000);
		user2.setContact(2222222222L);
		user2.setEmail("user2@gmail.com");
		user2.setPin(2222);
//		Mockito.when(userRepo.save(user2)).thenReturn(user2);

		// storing into a list
		List<BankUser> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);

		// creating mock employee for validiating service method
		BankEmployee emp = new BankEmployee();
		emp.setFname("employee2");
		emp.setLname("singh");
		emp.setUsername("employee2");
		emp.setPassword("employee2");
		
		// fetching values
		Mockito.when(empRepo.findByUsernameAndPassword("employee2", "employee2")).thenReturn(emp);

		// using user repository to fetch all users
		Mockito.when(userRepo.findAll()).thenReturn(userList);

		// testing with service
		assertThat(empServ.fetchAllUsers(emp.getUsername(), emp.getPassword())).isEqualTo(userList);
	}
//--------------------------------------------------------------------------------------------------

	// testing changePassword() method for employee
	@Test
	public void changePasswordTest() {

		// creating mock employee for validiating service method
		BankEmployee emp = new BankEmployee();
		emp.setFname("employee3");
		emp.setLname("singh");
		emp.setUsername("employee3");
		emp.setPassword("employee3");

		// fetching values
		Mockito.when(empRepo.findByUsernameAndPassword("employee3", "employee3")).thenReturn(emp);

		// updated value entity
		BankEmployee updEmp = new BankEmployee();
		updEmp.setPassword("updatedOne");

		// updating value
		emp.setPassword(updEmp.getPassword());

		// saving updated value to db
		Mockito.when(empRepo.save(emp)).thenReturn(emp);

		// testing with service
		assertThat(empServ.changePassword("employee3", "employee3", updEmp)).isEqualTo(emp);
	}

//--------------------------------------------------------------------------------------------------
	// testing changePassword() method for employee
	@Test
	public void deactivateAccountTest() {

		// creating mock employee for validiating service method
		BankEmployee emp = new BankEmployee();
		emp.setFname("employee4");
		emp.setLname("singh");
		emp.setUsername("employee4");
		emp.setPassword("employee4");

		// making entity as optional
		Optional<BankEmployee> opt = Optional.of(emp);

		// fetching values
		Mockito.when(empRepo.existsById("employee4")).thenReturn(false);

		assertThat(empRepo.existsById(opt.get().getUsername())).isEqualTo(false);
	}

}
