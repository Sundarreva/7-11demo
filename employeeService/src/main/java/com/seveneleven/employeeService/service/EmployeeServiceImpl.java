package com.seveneleven.employeeService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.employeeService.model.Employee;
import com.seveneleven.employeeService.repositroy.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		
		LOGGER.info("Start");
		
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee getEmployeesById(long id) {
		
		LOGGER.info("Start");
		
		return employeeRepository.findById(id).get();
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployeesByDesignation(String designation) {
		
		LOGGER.info("Start");

		return employeeRepository.findAllByDesignation(designation);
	}

	@Override
	@Transactional
	public Employee updateEmployees(Employee employee) {
		
		LOGGER.info("Start");

		return employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public Employee addEmployees(Employee employee) {
		
		LOGGER.info("Start");

		return employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public String deleteEmployeesById(long id) {
		
		LOGGER.info("Start");

		employeeRepository.deleteById(id);
		return "Deleted Successfully";
	}

	@Override
	@Transactional
	public String deleteEmployeesByDesignation(String designation) {
		
		LOGGER.info("Start");
		
		employeeRepository.deleteAllByDesignation(designation);
		return "Deleted Successfully";
	}

	@Override
	@Transactional
	public List<Employee> getEmployeeBySalaryRange(String start, String end) {
		
		LOGGER.info("Start");
		
		return employeeRepository.findAllBySalaryBetween(start, end);
		
	}


}
