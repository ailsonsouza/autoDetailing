package com.projects.autodetailing.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.autodetailing.entities.Employee;
import com.projects.autodetailing.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	

}
