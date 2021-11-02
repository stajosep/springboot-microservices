package com.oracle.hr;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HrResource {

	public HrResource() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	List<Employee> employees = Arrays.asList(
			new Employee("1","Staphy", "Joseph", ""),
			new Employee("2","Jerin", "Joseph", ""),
			new Employee("3","Shazin", "Ahmed", ""),
			new Employee("4","Yasmine", "Ibrahim", "")
			);
	
	@RequestMapping("/employees")
	public EmployeeList getEmployees() {
		EmployeeList employeeList = new EmployeeList();
		employeeList.setEmployees(employees);
		return employeeList;
		
	}
	
	@RequestMapping("/employees/{id}")
	public Employee getEmployeesById(@PathVariable("id")String id) {
		Employee e = employees.stream().filter(employee -> employee.getId().equals(id)).findAny().orElse(null);
		return e;
	}
	

}
