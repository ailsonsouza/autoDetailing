package com.projects.autodetailing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.autodetailing.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
