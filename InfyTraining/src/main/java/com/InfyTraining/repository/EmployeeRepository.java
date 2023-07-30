package com.InfyTraining.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.InfyTraining.entity.Employee;



public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	@Query("SELECT e from Employee e Where e.employeeName = :employeeName")
	public Employee getEmployeeByEmployeeName(@Param("employeeName") String employeeName);
	
}
