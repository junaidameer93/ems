package com.ems.service.api;

import java.util.Optional;

import com.ems.model.Employee;
import com.ems.projections.EmployeeWithManager;

public interface EmployeeService {

	Employee save(Employee employee);
	
	Optional<Employee> findById(Integer id);
	
	Optional<Employee> findByEmail(String email);
	
	Optional<EmployeeWithManager> findByFirstName(String firstName);
}
