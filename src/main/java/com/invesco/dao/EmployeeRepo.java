package com.invesco.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.invesco.domain.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	List<Employee> findByDepartment(String department);
	List<Employee> findByEidGreaterThan(Integer eid);
	@Query("FROM Employee WHERE eid>?1 ORDER BY ename DESC")
	List<Employee>findByEidSorted(Integer eid);
}