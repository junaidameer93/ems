package com.ems.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.model.Employee;
import com.ems.projections.EmployeeWithManager;
import com.ems.repository.EmployeeRepository;
import com.ems.service.api.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Employee> findById(Integer id) {
		return repository.findById(id);
	}

	public Optional<EmployeeWithManager> findByFirstName(String firstName) {
		return repository.findByFirstName(firstName);
	}

	public Optional<Employee> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<EmployeeWithManager> searchEmployeeWithManager(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
