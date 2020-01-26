package com.test.service;

import java.util.List;

import com.test.model.Department;
import com.test.model.Employee;
import com.test.model.EmployeeDetails;

public interface EmpService {

	String create(Department dep);
	List<EmployeeDetails> getEmployees();
	List<Employee> getEmployeesById();
}
