package com.seveneleven.employeeService.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seveneleven.employeeService.model.Employee;
import com.seveneleven.employeeService.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@GetMapping("")
	public List<Employee> getAllEmployees() {

		LOGGER.info("Start");
		
		return employeeService.getAllEmployees();
	}

	@GetMapping("/id/{id}")
	public Employee getEmployeeById(@PathVariable long id) {

		LOGGER.info("Start");
		
		return employeeService.getEmployeesById(id);
	}

	@GetMapping("/designation/{designation}")
	public List<Employee> getEmployeesByDesignation(@PathVariable String designation) {

		LOGGER.info("Start");
		
		return employeeService.getAllEmployeesByDesignation(designation);
	}

	@GetMapping("/netsalary")
	public long getAllEmployeesSalary() {

		LOGGER.info("Start");

		long sum = (employeeService.getAllEmployees().stream().map(emp -> Long.parseLong(emp.getSalary()))
				.collect(Collectors.toList())).stream().mapToLong(i -> i).sum();
		return sum;
	}
	
	@Async
	@GetMapping("/salary/{start}/{end}")
	public List<Employee> getEmployeeBySalaryRange(@PathVariable String start , @PathVariable String end){
		
		LOGGER.info("Start");
		
		return employeeService.getEmployeeBySalaryRange(start, end);
	}

	@PutMapping("/add")
	public Employee addEmployees(@RequestBody Employee employee) {

		LOGGER.info("Start");
		
		return employeeService.addEmployees(employee);
	}

	@PostMapping("/update")
	public Employee updateEmployees(@RequestBody Employee employee) {
		
		LOGGER.info("Start");
		
		return employeeService.updateEmployees(employee);
	}

	@DeleteMapping("/id/{id}")
	public String deleteEmployeeById(@PathVariable long id) {
		
		LOGGER.info("Start");

		return employeeService.deleteEmployeesById(id);
	}

	@DeleteMapping("/designation/{designation}")
	public String deleteAllEmployeeByDesignation(@PathVariable String designation) {
		
		LOGGER.info("Start");

		return employeeService.deleteEmployeesByDesignation(designation);
	}

}
