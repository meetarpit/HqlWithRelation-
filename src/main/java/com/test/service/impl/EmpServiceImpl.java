package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.EmpDao;
import com.test.model.Department;
import com.test.model.Employee;
import com.test.model.EmployeeDetails;
import com.test.service.EmpService;

@Service
@Transactional
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpDao empDao;
	
	public String create(Department dep) {
		// TODO Auto-generated method stub
		if(dep.getDeptId()==0) {
			empDao.create(dep);
			return "Data Saved Succefully";
		}
		else {
			empDao.create(dep);
			return "Data Saved Succefully";
		}
	
	}

	public List<EmployeeDetails> getEmployees() {
		// TODO Auto-generated method stub
		return empDao.getEmployees();
	}

	public List<Employee> getEmployeesById() {
		// TODO Auto-generated method stub
		return empDao.getEmployeesById();
	}

}
