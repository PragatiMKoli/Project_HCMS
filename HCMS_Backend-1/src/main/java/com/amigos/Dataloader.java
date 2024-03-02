package com.amigos;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.amigos.entities.Departments;
import com.amigos.entities.Employees;
import com.amigos.entities.Roles;
import com.amigos.service.DepartmentsService;
import com.amigos.service.EmployeesService;
import com.amigos.service.RolesService;

@Component
public class Dataloader implements CommandLineRunner{

	@Autowired
	private EmployeesService employeesService;
	@Autowired
	private DepartmentsService departmentsService;
	@Autowired
	private RolesService rolesService;
	
	@Override
	public void run(String... args) throws Exception {
		Roles roles = new Roles();
		roles.setRoleName("Manager");
		roles.setDescription("Manager Description");
		rolesService.addRole(roles);
		
		Roles roles2 = new Roles();
		roles2.setRoleName("Software Dev");
		roles2.setDescription("Software Dev Description");
		rolesService.addRole(roles2);
		
		Departments d1=new Departments();
		d1.setDepartmentName("IT");
		d1.setDescription("IT Description");
		departmentsService.addDepartment(d1);
		
		Departments d2=new Departments();
		d2.setDepartmentName("HR");
		d2.setDescription("HR Desc");
		departmentsService.addDepartment(d2);
		
		Employees emp1 = new Employees();
		emp1.setFirstName("Mahidra");
		emp1.setLastName("Dhoni");
		emp1.setGender("M");
		emp1.setEmail("abc@gmail.com");
		emp1.setDateOfBirth(LocalDate.of(1996, 5,15));
		emp1.setAddress("Pune");
		emp1.setBankAccountNumber("245335964");
		emp1.setEmergencyContactName("Sham");
		emp1.setEmergencyContactPhone("693587412");
		emp1.setEmploymentStatus("Active");
		emp1.setMaritalStatus("Married");
		emp1.setEmploymentStartDate(LocalDate.of(2009,04,22));
		emp1.setEmploymentEndDate(null);
		emp1.setNationalId("1234567894");
		emp1.setPhone("1456237");
		emp1.setPosition("Software Manager");
		emp1.setRole(roles);
		emp1.setSalary(new BigDecimal("102000.0"));
		emp1.setSkillSet("Java,SpringBoot,AWS,Servlet");
		emp1.setManager(null);
		emp1.setDepartment(d1);
		
		Employees emp2 = new Employees();
		emp2.setFirstName("Rohit");
		emp2.setLastName("Sharma");
		emp2.setGender("M");
		emp2.setDateOfBirth(LocalDate.of(1990, 5, 15));
		emp2.setEmail("abc@gmail.com");
		emp2.setPhone("1234567890");
		emp2.setAddress("Mumbai");
		emp2.setNationalId("112343");
		emp2.setMaritalStatus("Single");
		emp2.setEmergencyContactName("Ritika");
		emp2.setEmergencyContactPhone("9087654321");
		emp2.setPosition("Software Developer");
		emp2.setSkillSet("Java , Spring Boot");
		emp2.setEmploymentStartDate(LocalDate.of(2020, 1, 1));
		emp2.setEmploymentEndDate(null);
		emp2.setSalary(new BigDecimal("80000.0"));
		emp2.setEmploymentStatus("ACTIVE");
		emp2.setBankAccountNumber("36758793465");
		emp2.setManager(emp1);
		emp2.setDepartment(d2);
		emp2.setRole(roles2);
		
		employeesService.addEmployee(emp1);
		employeesService.addEmployee(emp2);

		
	}

}
