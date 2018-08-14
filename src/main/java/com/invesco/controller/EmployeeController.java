package com.invesco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invesco.dao.EmployeeRepo;
import com.invesco.domain.Employee;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@GetMapping("/")
	public String home() {		
		return "home.jsp";
	}
	
//	@PostMapping("/addEmployee")
//	public String addEmployee(Employee employee) {
//		employeeRepo.save(employee);
//		return "home.jsp";
//	}
	
	@PostMapping(path="/employee",consumes={"application/xml"})
	public Employee saveEmployee(@RequestBody Employee employee) {
		employeeRepo.save(employee);
		return employee;
	}
	
//	@GetMapping("/getEmployee")
//	public ModelAndView getEmployee(@RequestParam Integer eid) {
//		ModelAndView mv=new ModelAndView("showEmployee.jsp");
//		Employee employee=employeeRepo.findById(eid).orElse(new Employee());
//		System.out.println(employeeRepo.findByDepartment("Research"));
//		System.out.println(employeeRepo.findByEidGreaterThan(2));
//		System.out.println(employeeRepo.findByEidSorted(2));
//		mv.addObject(employee);
//		return mv;
//	}
	
 	@GetMapping(path="/employee")//,produces= {"application/xml"})
	public List<Employee> getAlians() {
		return employeeRepo.findAll();
	}
	
	@GetMapping("/employee/{eid}")
	public Optional<Employee> getEmployeeById(@PathVariable("eid") Integer eid ) {
		return employeeRepo.findById(eid);
	}

	@DeleteMapping("/employee/{eid}")
	public String deleteEmployee(@PathVariable Integer eid) {
		Employee employee = employeeRepo.getOne(eid);
		employeeRepo.delete(employee);
		return "deleted record for "+eid;
	}	
	
	@PutMapping(path="/employee")
	public Employee saveOrUpdateEmployee(@RequestBody Employee employee) {
		employeeRepo.save(employee);
		return employee;
	}
}