package com.test.dao;

import java.util.List;

import com.test.model.Department;
import com.test.model.Employee;
import com.test.model.EmployeeDetails;

public interface EmpDao {

	Department create(Department department);
	List<EmployeeDetails> getEmployees();
	List<Employee> getEmployeesById();
    
}
