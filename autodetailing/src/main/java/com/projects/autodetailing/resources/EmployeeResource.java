package com.projects.autodetailing.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projects.autodetailing.entities.Employee;
import com.projects.autodetailing.services.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeResource {
	
	private final EmployeeService employeeService;
	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public ResponseEntity<List<Employee>> findAll(){
		List<Employee> allEmployees = employeeService.findAll();
		return ResponseEntity.ok().body(allEmployees);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Long id){
		Employee employee = employeeService.findById(id);
		return ResponseEntity.ok().body(employee);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
		Employee employeeUpdated = employeeService.updateEmployee(id, employee);
		return ResponseEntity.ok().body(employeeUpdated);
	}
	
	@PostMapping
	public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee){
		employeeService.insert(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();
		return ResponseEntity.created(uri).body(employee);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		employeeService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
