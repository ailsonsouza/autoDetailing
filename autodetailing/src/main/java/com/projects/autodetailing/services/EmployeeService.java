package com.projects.autodetailing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
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
	
	public Employee findById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee.orElseThrow(() -> new RuntimeException());
	}
	
	public Employee updateEmployee(Long id, Employee employeeUpdated) {
		if (employeeUpdated != null) {
			Employee employee = employeeRepository.getReferenceById(id);
			updateEmployee(employee, employeeUpdated);
			employeeRepository.save(employee);
			return employee;
		}else{
			throw new IllegalArgumentException("The update data cannot be null.");
		}
	}
	
	public void insert(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void deleteById(Long id) {
		try {
			employeeRepository.deleteById(id);			
		}catch(DataIntegrityViolationException e) {
			throw new RuntimeException (e.getMessage());
		}
	}
	
	
	

	private void updateEmployee(Employee employee, Employee employeeUpdated) {
		employee.setAddress(employeeUpdated.getAddress());
		employee.setName(employeeUpdated.getName());
		employee.setPhone(employeeUpdated.getPhone());
		employee.setSalary(employeeUpdated.getSalary());
	}
}
