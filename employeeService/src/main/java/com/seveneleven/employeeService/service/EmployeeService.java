package com.seveneleven.employeeService.service;

import java.util.List;

import com.seveneleven.employeeService.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeesById(long id);
	
	public List<Employee> getAllEmployeesByDesignation(String designation);
	
	public Employee updateEmployees(Employee employee);
	
	public Employee addEmployees(Employee employee);
	
	public String deleteEmployeesById(long id);
	
	public String deleteEmployeesByDesignation(String designation);
	
	public List<Employee> getEmployeeBySalaryRange(String start, String end);

}
