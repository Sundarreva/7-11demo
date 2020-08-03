package com.seveneleven.employeeService.repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seveneleven.employeeService.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	public List<Employee> findAllByDesignation(String designation);
	
	public void deleteAllByDesignation(String designation);
	
	public List<Employee> findAllBySalaryBetween(String start, String end);

}
