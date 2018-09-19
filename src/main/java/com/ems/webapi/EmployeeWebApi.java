package com.ems.webapi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Employee;
import com.ems.projections.EmployeeWithManager;
import com.ems.service.api.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeWebApi {

	@Autowired
	private EmployeeService service;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> addNewEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = service.save(employee);
		if (savedEmployee == null) {
			return new ResponseEntity<String>("Not Saved", HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Optional<Employee> employee = service.findById(id);
		if (employee.isPresent()) {
			return new ResponseEntity<Employee>(employee.get(), HttpStatus.OK);
		}
		return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "firstname/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> findByFirstName(@PathVariable String name) {
		Optional<EmployeeWithManager> employee = service.findByFirstName(name);
		if (employee.isPresent()) {
			return new ResponseEntity<EmployeeWithManager>(employee.get(), HttpStatus.OK);
		}
		return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
	}
}
