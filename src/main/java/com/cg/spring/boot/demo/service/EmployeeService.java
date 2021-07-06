package com.cg.spring.boot.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.EmployeeNotFoundException;
import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository repository;

//	public Employee findEmployeeById(int eid) {
//		LOG.info("findEmployeeById");
//		return repository.findById(eid).get();
//	}
	
	public Employee findEmployeeById(int eid) {
		LOG.info("findEmployeeById");
		Employee emp = repository.findById(eid).get();
		if (emp != null)
			return emp;
		else
			throw new EmployeeNotFoundException();
	}
	

	public List<Employee> findEmployeeByEname(String ename) {
		LOG.info("findEmployeeByEname");
		return repository.findByEname(ename);
	}

	public List<Employee> findEmployeeBySalary(double salary) {
		LOG.info("findEmployeeBySalary");
//		return repository.findBySalary(salary);
//		return repository.findBySalaryLessThan(salary);
		return repository.findBySalaryGreaterThan(salary);
	}

	public List<Employee> getAllEmployees() {
		LOG.info("getAllEmployees");
		return repository.findAll();
	}

	public Employee addEmployee(Employee emp) {
		LOG.info("addEmployee");
		return repository.save(emp);
	}

	public Employee updateEmployee(Employee emp) {
		LOG.info("updateEmployee");
		return repository.save(emp);
	}

	public int deleteEmployee(int eid) {
		LOG.info("deleteEmployee");
		repository.deleteById(eid);
		return eid;
	}

	/**
	 * Try the below code only after you are comfortable with basic spring boot
	 * concepts
	 */

	// getting all Employee record by using the method findaAll() of CrudRepository
//	public List<Employee> getAllEmployees() {
//		List<Employee> employee = new ArrayList<Employee>();
//		repository.findAll().forEach(employee1 -> employee.add(employee1));
//		return employee;
//	}

//	// getting a specific record by using the method findById() of CrudRepository
//	public Employee getEmployeeById(int id) {
//		// logic
//		try {
//			return repository.findById(id).get();
//		} catch (NoSuchElementException nse) {
//			LOG.error("Not a valid employee id");
//
//			return null;
//		} catch (Exception ex) {
//			// LOG.info();
//			return null;
//		}
//	}
//
//	public List<Employee> getEmployeeByName(String ename) {
//		return repository.findEmployeeByEname(ename);
//	}
//
//	// saving a specific record by using the method save() of CrudRepository
//	public void saveOrUpdate(Employee employee) {
//		repository.save(employee);
//	}
//
//	// updating a record
//	public void update(Employee employee, int eid) {
//		repository.save(employee);
//	}
//
//	// deleting a specific record by using the method deleteById() of CrudRepository
//	public void delete(int id) {
//		repository.deleteById(id);
//	}

}