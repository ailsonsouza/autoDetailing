package com.projects.autodetailing.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.autodetailing.entities.Employee;
import com.projects.autodetailing.services.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeResource {
	
	@Autowired
	public EmployeeService employeeService;
	
	
	public ResponseEntity<List<Employee>> findAll(){
		List<Employee> allEmployees = employeeService.findAll();
		return ResponseEntity.ok().body(allEmployees);
	}

}
