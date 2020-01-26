package com.test.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.EmpDao;
import com.test.model.Department;
import com.test.model.Employee;
import com.test.model.EmployeeDetails;

@Repository
@Transactional
public class EmpDaoImpl implements EmpDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Department create(Department dep) {
		// TODO Auto-generated method stub
		currentSession().save(dep);
		return dep;
	}

	public List<EmployeeDetails> getEmployees() {
		// TODO Auto-generated method stub
		String hql = "select emp.name,dep.deptName,addr.streetNumber,addr.city,"
				+ "dep.employeeCount from Department dep left join dep.employee emp" + "left join emp.address addr";

   		Query query = currentSession().createQuery(hql);
		/* query.setParameter("id", 2); */
		List<EmployeeDetails> emps = new ArrayList<EmployeeDetails>();
		List<Object[]> empList = query.list();
		for (Object[] objects : empList) {
			EmployeeDetails empDetails = new EmployeeDetails();
			empDetails.setName((String) objects[0]);
			empDetails.setDeptName((String) objects[1]);
			empDetails.setStreetNumber((String) objects[2]);
			empDetails.setCity((String) objects[3]);
			empDetails.setEmployeeCount((Long) objects[4]);
			emps.add(empDetails);
		}

		return emps;
	}

	public List<Employee> getEmployeesById() {
		// TODO Auto-generated method stub
		String hql = "from Employee where id in (:id)";
		Query query=currentSession().createQuery(hql);
		query.setParameter("id",1);
		List<Employee> list=query.list();
		return list;
	}

}
