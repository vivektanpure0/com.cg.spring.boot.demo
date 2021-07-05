package com.cg.spring.boot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService service;

	@GetMapping("/emp") // endpoint , API
	public Employee getEmployee() {
		LOG.info("emp");
		return service.findEmployeeById(101);
	}

	@GetMapping("/getemp/{anyStringValue}")
	public Employee getEmployeeById(@PathVariable("anyStringValue") int eid) {
		LOG.info("getemp");
		return service.findEmployeeById(eid);
	}

	@GetMapping("/getall")
	public List<Employee> getAllEmps() {
		LOG.info("getAllEmps");
		return service.getAllEmployees();
	}
	
	  @PostMapping("/addemp")
	    public Employee addEmp(@RequestBody Employee emp) {
	        LOG.info("addEmp");
	        return service.addEmployee(emp);
	    }
	  
	  @PutMapping("/updatemp")
	    public Employee updateEmp(@RequestBody Employee emp) {
	        LOG.info("addEmp");
	        return service.updateEmployee(emp);
	    }
	 
	  @DeleteMapping("/updatemp/{eid}")
	    public int deleteEmp(@PathVariable("eid") int eid) {
	        LOG.info("deleteEmp");
	        return service.deleteEmployee(eid);
	    }

	/**
	 * Try the below code only after you are comfortable with basic spring boot
	 * concepts
	 */

//	@RequestMapping("/getemp/{eid}")
//	public Employee getEmployeeById(@PathVariable("eid") int eid) {
//		LOG.info("empemp");
//
//		return service.findEmployeeById(eid);
//	}

	@GetMapping("/getThisEmp/{eid}")
	public ResponseEntity<Employee> getThisEmp(@PathVariable("eid") int eid) {
		Employee emp = service.getEmployeeById(eid);
		if (emp == null) {
			LOG.error("Not a valid employee id.");
			return null;
		}

		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

//creating a get mapping that retrieves all the Employee detail from the database
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		return service.getAllEmployees();
	}

//creating a get mapping that retrieves the detail of a specific Employee
	@GetMapping("/getEmployee/{eid}")
	private Employee getEmployee(@PathVariable("eid") int eid) {
		return service.getEmployeeById(eid);
	}

	@GetMapping("/getEmpByName/{ename}")
	private List<Employee> getEmployee(@PathVariable("ename") String ename) {
		return service.getEmployeeByName(ename);
	}

	// creating a delete mapping that deletes a specified Employee
	@DeleteMapping("/deleteEmployee/{eid}")
	private void deleteEmployee(@PathVariable("eid") int eid) {
		service.delete(eid);
	}

//creating post mapping that post the Employee detail in the database
	@PostMapping("/saveEmployee")
	private int saveEmployee(@RequestBody Employee employee) {
		service.saveOrUpdate(employee);
		return employee.getEid();
	}

//creating put mapping that updates the Employee detail
	@PutMapping("/updateEmployee")
	private Employee updateEmployee(@RequestBody Employee Employee) {
		service.saveOrUpdate(Employee);
		return Employee;
	}

}