package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.model.Department;
import com.test.model.Employee;
import com.test.model.EmployeeDetails;
import com.test.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;
	
	@RequestMapping(value="/")
	public String ApiTest() {
		return "index";	
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> saveDep(@RequestBody Department dep){
		String responseEntity =empService.create(dep);
		 ResponseEntity<String> response = new ResponseEntity<String>(responseEntity,
                 HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public List<EmployeeDetails> getAllEmployee(){
		List<EmployeeDetails> response =empService.getEmployees();
		return response;
	}
	
	@RequestMapping(value="/listById",method=RequestMethod.GET)
	@ResponseBody
	public List<Employee> getAllEmployeeById(){
		List<Employee> response =empService.getEmployeesById();
		return response;
	}
}
