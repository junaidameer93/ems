package com.ems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ems.model.Employee;
import com.ems.projections.EmployeeWithManager;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query("SELECT new com.ems.model.Employee(e.firstName, e.lastName, e.email, e.mobileNo) FROM Employee e WHERE e.empId=?1")
	Optional<Employee> searchEmployee(Integer id);
	
	Optional<EmployeeWithManager> findByFirstName(String firstName);

}
